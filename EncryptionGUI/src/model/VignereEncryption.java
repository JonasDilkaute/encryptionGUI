package model;

import java.util.stream.Stream;

/**
 * Class that contains methods to encrypt and decrypt with the vigenere encryption.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class VignereEncryption implements SymmetricEncryptor {

	private char[] key;
	
	/**
	 * Creates new VignereEncryptio with given key
	 * @param key the key
	 */
	public VignereEncryption(char[] key) {
		setKey(key);
	}
	
	/**
     * Encrypts a plain Uppercase using vigenere encryption. 
     * Uses the key specified by setKey.
     * @param plain the plain text
     * @return the encrypted text
     */
	@Override
	public String encrypt(String plain) {
		char[] text = plain.toCharArray();
		char[] encryptedText = new char[text.length];
		SymmetricEncryptor.check(text);
		
		for(int i=0; i<text.length; i++) {			
			int pos = text[i] -65;
			encryptedText[i] = (char) ((pos + key[i % key.length]- 65)%26 + 65);
		}
		return new String(encryptedText);
	}
	
	/**
	 * Encrypts a plain Uppercase using vigenere encryption with the given key. 
	 * @param plain the plain text
	 * @param key the key
	 * @return the encrypted text
	 */
	public String encrypt(String text, char[] key) {
		setKey(key);
		return encrypt(text);
	}
	
	/**
	 * Encrypts a plain Uppercase using vigenere encryption with the given key. 
	 * @param plain the plain text
	 * @param key the key
	 * @return the encrypted text
	 */
	public String encrypt(String text, String key) {
		return encrypt(text, key.toCharArray());
	}

	/**
     * Decrypts a encrypted Uppercase text using vigenere encryption. 
     * Uses the key specified by setKey.
     * @param encrypted the encrypted text
     * @return the decrypted text
     */
	@Override
	public String decrypt(String encrypted) {
		char[] text = encrypted.toCharArray();
		char[] decryptedText = new char[text.length];
		SymmetricEncryptor.check(text);
		
		for(int i=0; i<text.length; i++) {
			int keypos =key[i%key.length] -65;
			decryptedText[i] = (char) ((text[i]-keypos <65) ? text[i]-keypos+26:text[i]-keypos);
		}
		return new String(decryptedText);
	}
	
	/**
	 * Decrypts a encrypted Uppercase text using vigenere encryption with the given key. 
	 * @param encrypted the encrypted text
	 * @param key the key
	 * @return the decrypted text
	 */
	public String decrypt(String text, char[] key) {
		setKey(key);
		return decrypt(text);
	}
	
	/**
	 * Decrypts a encrypted Uppercase text using vigenere encryption with the given key. 
	 * @param encrypted the encrypted text
	 * @param key the key
	 * @return the decrypted text
	 */
	public String decrypt(String text, String key) {
		return decrypt(text, key.toCharArray());
	}
	
	public String convert(String text) {
		if(text != null && !text.isBlank()) {
			text.replaceAll("ä", "ae");
			text.replaceAll("ö", "oe");
			text.replaceAll("ü", "ue");
		}
		return text;
	}

	/**
	 * gets the key
	 * @return the key
	 */
	public char[] getKey() {
		return key;
	}

	/**
	 * sets the key
	 * @param key the key
	 */
	public void setKey(char[] key) {
		SymmetricEncryptor.check(key);
		this.key = key;
	}
}
