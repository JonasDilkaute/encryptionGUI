package model;

/**
 * Interface for all symmetrical encryptions.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public interface SymmetricEncryptor extends Encryptor {

	public String encrypt(String text);
	public String decrypt(String text);
	
	public String encrypt(String text, String code);
	public String decrypt(String text, String code);
	
	/**
	 * Checks whether the text is null or empty
	 * @param text the text
	 * @throws IllegalArgumentException
	 */
	static void check(char[] text) throws IllegalArgumentException{
		if(text == null || text.length<1) {
			throw new IllegalArgumentException();
		}
	}
		
	
 }
