package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;


public class PermutationEncryption implements SymmetricEncryptor {

	private List<Character> key;
	private Character[] h = {'E','N','I','S','R','A','T','D','H','U','L','C','G','M','O','B','W','F','K','Z','P','V','J','Y', 'X', 'O'};
	
	public PermutationEncryption(List<Character> key) {
		setKey(key);
	}
	
	
	@Override
	public String encrypt(String text) {
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			String newText = "";
			char[] array = text.toCharArray();
			for(int i=0; i< array.length; i++) {
				int c = (int) array[i] - 65;
				if(c >= 0 && c<= 26) {					
					newText = newText + key.get(c);
				} else {
					newText = newText + array[i];
				}		
			}
			return newText;
		}
		return null;
	}

	@Override
	public String decrypt(String text) {
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			String newText = "";
			char[] array = text.toCharArray();
			for(int i=0; i< array.length; i++) {
				int c = (int) array[i] - 65;
				if(c >= 0 && c<= 26) {
					newText = newText+ (char) (key.indexOf(array[i]) +65);
				} else {
					newText = newText + array[i];
				}
				
				
			}
			return newText;
		}
		return null;
	}

	public List<Pair<Character,Integer>> frequency(String text) {
		List<Pair<Character,Integer>> list = new ArrayList<>();
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			String newText = "";
			char[] array = text.toCharArray();
			for(int i=0; i< array.length; i++) {
				int c = (int) array[i] - 65;
				if(c >= 0 && c<= 26) {
					addCount(list, array[i]);
				} 
		}
			for(Pair p: list) {
				System.out.println("Buchstabe " + p.getKey()+" " + p.getValue());
			}
			
		return list;
	}
		return null;
	}
	
	public List<Character> estimateKey(String text) {
		List<Pair<Character,Integer>> list = frequency(text);
		List<Character> ekey = new ArrayList<Character>();
		Collections.sort(list, Comparator.comparing(p->p.getValue()));
		for(int i=0; i<list.size();i++) {
			Character a = h[i];
			int pa = a - 65;
			ekey.set(pa, list.get(i).getKey());
		}
		return ekey;
	}
	
	private static List<Pair<Character,Integer>> addCount(List<Pair<Character,Integer>> list,Character c) {
		for(int i=0; i<list.size(); i++) {
			Pair<Character,Integer> p = list.get(i);
			if(p.getKey().equals(c)) {
				int count = p.getValue() + 1;
				list.set(i, new Pair(p.getKey(),count));
				return list;
			} 
		}
		Pair<Character,Integer> newP =new Pair(c,1);
		list.add(newP);
		return list;
	}
	
	@Override
	public String encrypt(String text, String code) {
		return encrypt(text);
	}

	@Override
	public String decrypt(String text, String code) {
		return decrypt(text);
	}
	
	public void setKey(List<Character> key) {
		this.key = key;
	}
	
	public List<Character> getKey() {
		return key;
	}

}
