package model;

import java.math.BigInteger;

/**
 * Class that represents a RSA public key.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class PublicKey {
	
    private BigInteger e;
    private BigInteger n;
    private String owner;
    
    /**
     * Creates a new PublicKey.
     * @param e e
     * @param n e
     * @param owner the owner
     */
	public PublicKey(BigInteger e, BigInteger n, String owner ) {
		this.e = e;
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
	 * gets e
	 * @return e
	 */
	public BigInteger getE() {
		return e;
	}
	
	/**
	 * gets n
	 * @return n
	 */
	public BigInteger getN() {
		return n;
		
	}
	
	
	
}
