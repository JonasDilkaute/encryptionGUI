package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class PermutationKey {
	
	private final int KEYSIZE = 26;
	//map.key = plain-text char / map.value = the the encrypted char
	private Map<Character, Character> key = new HashMap<>();
	
	public PermutationKey() {
		Map<Character, Character> key = new HashMap<>();
		for(int i=0; i<26;i++) {
			key.put((char) (65+i), (char) (65+i));
		}
		setKey(key);	
	}
	
	public Character getEncryptedOfPlain(Character plainKey) {
		return key.get(plainKey);
	}
	
	public Character getPlainOfEncrypted(Character encryptedCharacter) {
		return getKeyByValue(key, encryptedCharacter);
	}
	
	/**
	 * replaces so that the plain key points to the encryptedCharacter
	 * @param encryptedCharacter
	 * @param plainCharacter
	 */
	public void replace(Character plainKey, Character encryptedCharacter) {
		Character keyOfEncrypted = getKeyByValue(key, encryptedCharacter);
		Character characterOfKey = key.get(plainKey);
		
		if(characterOfKey == null || keyOfEncrypted ==null) {
			throw new IllegalArgumentException("plain key or encryptedCharacter arr not fitting");
		} else if(
			!key.replace(keyOfEncrypted, encryptedCharacter, characterOfKey) ||
			!key.replace(plainKey, characterOfKey, encryptedCharacter)) {
				throw new IllegalArgumentException("Key is corrupted");
		}			
	}
	
	/**
	 * swaps the position of two encrypted characters
	 * @param a
	 * @param b
	 */
	public void swapLetters(Character a, Character b) {
		Character aKey = getKeyByValue(key, a);
		Character bKey = getKeyByValue(key, a);
		if(aKey ==null || bKey ==null) {
			throw new IllegalArgumentException("encrypted characters are not contained in the key");
		}
		if(!key.replace(aKey, a, b) || !key.replace(bKey, b, a)) {
			throw new IllegalArgumentException("Key is corrupted");
		}
		
		
	}
	
	public PermutationKey(Map<Character, Character> key) {
		setKey(key);
	}

	/**
	 * @return the key
	 */
	public Map<Character, Character> getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Map<Character, Character> key) {
		if(key != null && key.size() == KEYSIZE && isValidKey(key)) {
			this.key = key;
		} else {
			throw new IllegalArgumentException("KEY must be valid");
		}	
	}
	
	private boolean isValidKey(Map<Character, Character> key) {
		Collection<Character> valuesList = key.values();
		Set<Character> valuesSet = new HashSet<Character>(key.values());
		return valuesList.size()==valuesSet.size();
	}
	
	private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}

}
