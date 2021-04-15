package model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class that generates a new pair of public and private key
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class RsaKeyGenerator {

	String owner;
	private PrivateKey privateKey;
	private PublicKey publicKey;
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phiN;
	private BigInteger e;
	private BigInteger d;
	private BigInteger one = new BigInteger("1");
	private BigInteger zero = new BigInteger("0");
	private int SIZE = 8;
	
	/**
	 * Generates a new RsaKeySet with key size 400
	 * @param owner the owner
	 * @return the new KeySet
	 */
	public RsaKeySet generateRsaKeySet(String owner) {
		
		Random rand = new Random();
		p = new BigInteger(SIZE, 15, rand);
		q = new BigInteger(SIZE, 15, rand);
		n = p.multiply(q);
		phiN = p.subtract(one);
		phiN = phiN.multiply(q.subtract(one));
	
	    while (true) {
	    	e = new BigInteger(2 * SIZE, rand);
	    
	    	if (phiN.gcd(e).compareTo(one) == 0 && e.compareTo(phiN) != 1 && e.compareTo(one) != -1) {
	    		
	    		break;
	    		
	    	}
	    }
	    
	  
	    d = modInverse(phiN, e);
	    
	    System.out.println("p: " + p);
	    System.out.println("q: " + q);
	    System.out.println("n:"+ " = " + p + " * " + q + " = " + n );
	    System.out.println("phiN:"+ " = (" + p + " - 1) * (" + q + " - 1) = " + phiN );
	    System.out.println("d:"+ d);
	    
	    System.out.println("[Public Key] ("+ e + ", " + n + ")");
	    System.out.println("[Private Key] ("+ d + ", " + n + ")");
	    
		privateKey = new PrivateKey(d,  n, owner);
		publicKey = new PublicKey(e, n, owner);
		 
		  return new RsaKeySet(privateKey, publicKey);
		 
	}
	
	
	private BigInteger modInverse(BigInteger phiN,BigInteger e) {
		//variables for the normal euklid algorithm
		List<BigInteger> phiNList = new ArrayList<>();
		List<BigInteger> eList = new ArrayList<>();
		//q does not mean the prime factor from the start, means the factor for e: phiN = e * q + r 
		List<BigInteger> qList = new ArrayList<>();
		List<BigInteger> rList = new ArrayList<>();
				
		//variables for the extended euklid algorithm
		/*
		List<BigInteger> kList = new ArrayList<>();
		List<BigInteger> dList = new ArrayList<>();
		*/
		
		BigInteger q = BigInteger.ZERO;
		BigInteger r = BigInteger.ZERO;
		BigInteger tmpPhiN = phiN;
		BigInteger tmpE = e;
		
		//normal euklid algorithm
		do {
			phiNList.add(tmpPhiN);
			eList.add(tmpE);
			
			q = tmpPhiN.divide(tmpE);
			r = tmpPhiN.subtract(q.multiply(tmpE));
			qList.add(q);
			rList.add(r);
			
			tmpPhiN = tmpE;
			tmpE = r;
		} while (!rList.get(rList.size()-1).equals(zero));
		
		//extended euklid algorithm
		BigInteger k = BigInteger.ZERO;
		BigInteger oldK = BigInteger.ZERO;
		BigInteger d = BigInteger.ONE;
		
		//loop the lists backwards from i where r =1 (list.size()-2)
		for(int i=phiNList.size()-2; i>=0; i--) {
			//store the value of k
			oldK = k;	
			//replace k with the d from the previous loop
			k = d;
			//calculate d as: d = oldK - q (from this loop) * d
			d = oldK.subtract(qList.get(i).multiply(d));
		}
		
		//throw k away, use d and check if d is negative
		if (d.compareTo(BigInteger.ZERO) < 0) {
			//if d is negative, make it positive: d + phiN
			d = d.add(phiN);
		}	
		return d;
	}
	
  
		
}
