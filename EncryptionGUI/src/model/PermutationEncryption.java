package model;

import java.util.stream.Stream;

public class PermutationEncryption implements SymmetricEncryptor {

	private String key;
	
	public PermutationEncryption(String key) {
		setKey(key);
	}
	
	
	@Override
	public String encrypt(String text) {
		if(text!= null && !text.isBlank()) {
			//Stream.of(text.chars()).
		}
		return null;
	}

	@Override
	public String decrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encrypt(String text, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String text, String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

}
