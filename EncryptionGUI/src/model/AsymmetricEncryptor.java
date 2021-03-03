package model;

/**
 * Interface for all Asymmetric Encryptions
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public interface AsymmetricEncryptor extends Encryptor {

	/**
	 * Encrypts the text using the public key
	 * @param text the text, only numbers accepted
	 * @param publicKey the publicKey
	 * @return the encrypted text 
	 */
	String encrypt(String text, PublicKey publicKey);
	
	/**
	 * Decrypts the text using the public key
	 * @param text the text, only numbers accepted
	 * @param publicKey the publicKey
	 * @return the decrypted text 
	 */
	String decrypt(String text, PrivateKey privateKey);
}
