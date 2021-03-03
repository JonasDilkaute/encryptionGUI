package model;

import java.math.BigInteger;

/**
 * Class that represents a RSA private key.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class PrivateKey {

	
	
	private BigInteger d;
	private BigInteger n;
    private String owner;
    
    
    /**
     * Creates a new PrivateKey
     * @param d d
     * @param n d
     * @param owner the owner
     */
	public PrivateKey(BigInteger d, BigInteger n,  String owner) {
		this.d = d;
		this.owner = owner;
		this.n = n;
		
	}
	
	/**
	 * gets the owner
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * gets D
	 * @return D
	 */
	public BigInteger getD() {
		return d;
	}
	
	/**
	 * gets N
	 * @return N
	 */
	public BigInteger getN() {
		return n;
	}

}
