package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;


public class PermutationEncryption implements SymmetricEncryptor {

	private List<Character> key;
	private Character[] f = {'E','N','I','S','R','A','T','D','H','U','L','C','G','M','O','B','W','F','K','Z','P','V','J','Y', 'X', 'Q'};
	private Character[] startF = {'D', 'S', 'I', 'W'}; 
	//private Character[] startF = {'D', 'S', 'I'};
	private Character[] endF = {'N', 'E', 'R', 'T', 'S'};
	//private Character[] endF = {'N', 'E'};
 	public PermutationEncryption(List<Character> key) {
		setKey(key);
	}
	
	
	@Override
	public String encrypt(String text) {
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			text =text.replaceAll("Ä", "AE");
			text =text.replaceAll("Ü", "UE");
			text =text.replaceAll("Ö", "OE");
			String newText = "";
			char[] array = text.toCharArray();
			for(int i=0; i< array.length; i++) {
				int c = (int) array[i] - 65;
				if(c >= 0 && c< 26) {					
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
				if(c >= 0 && c< 26) {
					char newChar =(char) (key.indexOf(array[i]) +65);
					//fail safe if key does not contain all characters 
					newChar = newChar < 65 ? 'A': newChar;
					newText = newText+ newChar;
				} else {
					newText = newText + array[i];
				}
				
				
			}
			return newText;
		}
		return null;
	}
	
	public List<Pair<Character,Integer>> endfrequency(String text) {
		List<Pair<Character,Integer>> list = new ArrayList<>();
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			char[] array = text.toCharArray();
			Character endChar = null;
			for(int i=0; i< array.length; i++) {
				if(array[i]==' ' && endChar != null) {			
						list = addCount(list, endChar);
						endChar = null;
				} else {
					int c = (int) array[i] - 65;
					
					if(c >= 0 && c< 26) {
						endChar = array[i];
					} 
				}				
		}
			System.out.println("-----End -freqency-----");
			for(Pair<Character,Integer> p: list) {
				System.out.println("Buchstabe " + p.getKey()+" " + p.getValue());
			}
			
		return list;
	}
		return null;
	} 

	
	public void swapLetters(Character a, Character b) {
		int positionA = key.indexOf(a);
		int positionB = key.indexOf(b);
		
		if(positionA != -1 && positionB != -1) {
			key.set(positionA, b);
			key.set(positionB, a);
			System.out.println("swapped");
		}	
	}
	
	public List<Pair<Character,Integer>> startfrequency(String text) {
		List<Pair<Character,Integer>> list = new ArrayList<>();
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			char[] array = text.toCharArray();
			boolean space = true;
			for(int i=0; i< array.length; i++) {
				if(array[i]==' ') {
					space = true;
				} else {
					int c = (int) array[i] - 65;
					
					if(space && c >= 0 && c< 26) {
						list = addCount(list, array[i]);
					} 
					space = false;
				}
				
		}
			System.out.println("-----Start-freqency-----");
			for(Pair<Character,Integer> p: list) {
				System.out.println("Buchstabe " + p.getKey()+" " + p.getValue());
			}
			
		return list;
	}
		return null;
	} 

	public List<Pair<Character,Integer>> frequency(String text) {
		List<Pair<Character,Integer>> list = new ArrayList<>();
		if(text!= null && !text.isBlank()) {
			text = text.toUpperCase();
			char[] array = text.toCharArray();
			for(int i=0; i< array.length; i++) {
				int c = (int) array[i] - 65;
				if(c >= 0 && c< 26) {
					list = addCount(list, array[i]);
				} 
		}
			System.out.println("-----freqency-----");
			for(Pair<Character,Integer> p: list) {
				System.out.println("Buchstabe " + p.getKey()+" " + p.getValue());
			}
			
			
		return list;
	}
		return null;
	}
	
	public List<Character> estimateKey(String text) {
		List<Pair<Character,Integer>> list = frequency(text);
		List<Character> ekey = new ArrayList<Character>();
		for(int i=0; i<26;i++) {
			ekey.add((char) (65+i));
		}
		Collections.sort(list, Comparator.comparing(p->p.getValue()));
		Collections.reverse(list);
		for(int i=0; i<list.size();i++) {
			Character a = f[i];
			int pa = a - 65;
			ekey.set(pa, list.get(i).getKey());
			System.out.println("Postion: " + pa +  "Key "+ list.get(i).getKey());
		}
		
		List<Pair<Character,Integer>> startFrequency = startfrequency(text);
		Collections.sort(startFrequency, Comparator.comparing(p->p.getValue()));
		Collections.reverse(startFrequency);
		
		for(int i=0; i<startF.length;i++) {
			Character a = startF[i];
			int pa = a - 65;
			Character dummy =ekey.get(pa);
			int pc =ekey.indexOf(startFrequency.get(i).getKey());
			ekey.set(pa, startFrequency.get(i).getKey());
			ekey.set(pc, dummy);
			System.out.println("Postion: " + pa +  "Key "+ startFrequency.get(i).getKey());
		}
		
		List<Pair<Character,Integer>> endFrequency = endfrequency(text);
		Collections.sort(endFrequency, Comparator.comparing(p->p.getValue()));
		Collections.reverse(endFrequency);
		
		for(int i=0; i<endF.length;i++) {
			Character a = endF[i];
			int pa = a - 65;
			Character dummy =ekey.get(pa);
			int pc =ekey.indexOf(endFrequency.get(i).getKey());
			ekey.set(pa, endFrequency.get(i).getKey());
			ekey.set(pc, dummy);
			System.out.println("Postion: " + pa +  "Key "+ endFrequency.get(i).getKey());
		}
		
		
		System.out.println("---------ekey---------");
		for(Character c: ekey) {
			System.out.print(c +", ");
		}
		System.out.println("---------------------");
		return ekey;
	}
	
	private static List<Pair<Character,Integer>> addCount(List<Pair<Character,Integer>> list,Character c) {
		for(int i=0; i<list.size(); i++) {
			Pair<Character,Integer> p = list.get(i);
			if(p.getKey().equals(c)) {
				int count = p.getValue() + 1;
				list.set(i, new Pair<Character,Integer>(c,count));
				return list;
			} 
		}
		list.add(new Pair<Character,Integer>(c,1));
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
