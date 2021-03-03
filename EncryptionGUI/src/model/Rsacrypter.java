package model;

import java.math.BigInteger;

/**
 * Class that contains methods to encrypt and decrypt using RSA.
 * @author Jonas Dilkaute
 * @version 1.0
 *
 */
public class Rsacrypter {
	
	public static BigInteger encrypt(BigInteger text, PublicKey publicKey ) {
		return text.modPow(publicKey.getE(), publicKey.getN());
		
	}
	
	public static BigInteger decrypt(BigInteger text, PrivateKey privateKey) {
		return text.modPow(privateKey.getD(), privateKey.getN());
		
	}
}
