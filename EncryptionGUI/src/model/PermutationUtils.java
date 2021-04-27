package model;

public class PermutationUtils {
	
	public static void prepareText(String text) {
		text =text.replaceAll("Ä", "AE");
		text =text.replaceAll("Ü", "UE");
		text =text.replaceAll("Ö", "OE");
	}

}
