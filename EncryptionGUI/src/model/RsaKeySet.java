package model;

/**
 * Class that contains public and private key
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class RsaKeySet {

	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	/**
	 * Creates a new RsaKeySet
	 * @param privateKey the RSA privateKey
	 * @param publicKey the RSA publicKey
	 */
	public RsaKeySet(PrivateKey privateKey, PublicKey publicKey ) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}
	
	/**
	 * gets the RSA private Key
	 * @return the private key
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
		
	}
	
	/**
	 * gets the RSA public Key
	 * @return the public key
	 */
	public PublicKey getPublicKey() {
		return publicKey;
		
	}
}
