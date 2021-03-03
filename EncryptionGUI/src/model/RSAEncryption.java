package model;

import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * Class to encrypt and decrypt numbers using RSA.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class RSAEncryption implements AsymmetricEncryptor {
	
	@Override
	public String encrypt(String text, PublicKey publicKey) {	
		return Rsacrypter.encrypt(new BigInteger(text), publicKey).toString();
		
		
	}

	@Override
	public String decrypt(String text, PrivateKey privateKey) {		
		return Rsacrypter.decrypt(new BigInteger(text), privateKey).toString();
	}
	
	/**
	 * Converts plain text string to BigInteger
	 * @param string the plain text
	 * @return the BigInteger
	 */
	public  BigInteger stringToBigInteger(String string){	    
		return new BigInteger(string.getBytes(Charset.forName("UTF-16")));

	}
	
	/**
	 * Converts BigInteger to plain string
	 * @param bigInteger the BigInteger
	 * @return the plain text
	 */ 
	public String bigIntegerToString(BigInteger bigInteger) {
		return new String(bigInteger.toByteArray(),Charset.forName("UTF-16"));
	}

}
