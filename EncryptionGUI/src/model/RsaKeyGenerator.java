package model;

import java.math.BigInteger;
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
	private BigInteger en;
	private BigInteger e;
	private BigInteger d;
	private BigInteger one = new BigInteger("1");
	private int SIZE = 400;
	
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
		en = p.subtract(one);
		en = en.multiply(q.subtract(one));
	
	    while (true) {
	    	e = new BigInteger(2 * SIZE, rand);
	    
	    	if (en.gcd(e).compareTo(one) == 0 && e.compareTo(en) != 1 && e.compareTo(one) != -1) {
	    		
	    		break;
	    		
	    	}
	    }
	    
	    d = e.modInverse(en);
		
		privateKey = new PrivateKey(d,  n, owner);
		publicKey = new PublicKey(e, n, owner);
		 
		  return new RsaKeySet(privateKey, publicKey);
		 
	}
	
  
		
}
