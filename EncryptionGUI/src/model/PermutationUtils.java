package model;

public class PermutationUtils {
	
	public static void prepareText(String text) {
		text =text.replaceAll("�", "AE");
		text =text.replaceAll("�", "UE");
		text =text.replaceAll("�", "OE");
	}

}
