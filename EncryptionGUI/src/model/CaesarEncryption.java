package model;

/**
 * Class that contains methods to encrypt and decrypt with the caesar encryption.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class CaesarEncryption implements SymmetricEncryptor {
	
	private int key;
	
	/**
	 * Creates new CaesarEncrption with given key
	 * @param key the key
	 */
    public CaesarEncryption(int key) {
    	setKey(key);	
	}
    
    /**
     * Encrypts a plain Uppercase using caesar encryption. 
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
			encryptedText[i] = (char) ((pos + key)%26 + 65);
		}
		return new String(encryptedText);
	}
	
	/**
	 * Encrypts a plain Uppercase using caesar encryption with the given key. 
	 * @param plain the plain text
	 * @param key the key
	 * @return the encrypted text
	 */
	public String encrypt(String plain, int key) {
		setKey(key);
		return encrypt(plain);		
	}
	
	/**
	 * Encrypts a plain Uppercase using caesar encryption with the given key. 
	 * @param plain the plain text
	 * @param key the key
	 * @return the encrypted text
	 */
	public String encrypt(String plain, String key) {
		return encrypt(plain, Integer.parseInt(key));
	}
	
	/**
     * Decrypts a encrypted Uppercase text using caesar encryption. 
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
			decryptedText[i] = (char) ((text[i]-key <65) ? text[i]-key+26:text[i]-key);
		}
		return new String(decryptedText);
	}
	
	/**
	 * Decrypts a encrypted Uppercase text using caesar encryption with the given key. 
	 * @param encrypted the encrypted text
	 * @param key the key
	 * @return the decrypted text
	 */
	public String decrypt(String encrypted, int key) {
		setKey(key);
		return decrypt(encrypted);
	}
	
	/**
	 * Decrypts a encrypted Uppercase text using caesar encryption with the given key. 
	 * @param encrypted the encrypted text
	 * @param key the key
	 * @return the decrypted text
	 */
	public String decrypt(String encrypted, String key) {
		return decrypt(encrypted, Integer.parseInt(key));
	}

	/**
	 * gets the key
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * sets the key. Must not < 0 or > 26.
	 * @param key the key
	 */
	public void setKey(int key) {
		if(key <0 || key > 26) {
			throw new IllegalArgumentException();
		}
		this.key = key;
	}

}
