package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.languagetool.JLanguageTool;
import org.languagetool.language.GermanyGerman;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.SuggestedReplacement;
import org.languagetool.rules.RuleMatch.Type;

public class AutoCorrector {
	private JLanguageTool langTool;
	public AutoCorrector() {
		langTool = new JLanguageTool(new GermanyGerman());
	}
	
	public Map<String, List<SuggestionData>> getSuggestions (String text) {
		Map<String, List<SuggestionData>> list = new HashMap<String, List<SuggestionData>>();
		List<RuleMatch> matches = new ArrayList<>();
		try {
			matches =langTool.check(text.toLowerCase());
		} catch (IOException e) {		
			e.printStackTrace();
		}
		for(RuleMatch match: matches) {
			if(match.getType() == Type.UnknownWord && 
		    		  match.getMessage().equalsIgnoreCase("Möglicher Tippfehler gefunden.")) {
				String subString = text.substring(match.getFromPos(), match.getToPos());
				List<SuggestionData> suggestions =filterSuggestions(match.getSuggestedReplacementObjects(), subString);
				list.put(subString, suggestions);
			} 
		}
		return list;
	}
	
	private List<SuggestionData> filterSuggestions(List<SuggestedReplacement> suggestions, String subText) {
		subText = subText.toLowerCase();
		int minDistance = -1;
		List<SuggestionData> filteredSuggestions = new ArrayList<>();
		for(SuggestedReplacement s : suggestions) {
			String replacement = s.getReplacement();
			//remove "Umlaute" from suggestions
			PermutationUtils.prepareText(replacement);
			  //make sure to include only suggestions that match the word length and suggestion is not just lower/upper writing
	    	  if(replacement.length() == subText.length() ) {
	    		
	    		  replacement =replacement.toLowerCase();  		  
	    		  int distance =calculateDistance(subText, replacement);
	    		  minDistance = Math.min(minDistance, distance);
	    		  filteredSuggestions.add(new SuggestionData(replacement, subText, distance));
	    	  }	  
	      }
		
		//sort by distance
		filteredSuggestions.sort(Comparator.comparing(SuggestionData::getDistance));
		
		return filteredSuggestions.size() >6 ? filteredSuggestions.subList(0, 5): filteredSuggestions;

		
	}

	static int calculateDistance(String x, String y) {
	    int[][] dp = new int[x.length() + 1][y.length() + 1];

	    for (int i = 0; i <= x.length(); i++) {
	        for (int j = 0; j <= y.length(); j++) {
	            if (i == 0) {
	                dp[i][j] = j;
	            }
	            else if (j == 0) {
	                dp[i][j] = i;
	            }
	            else {
	                dp[i][j] = min(dp[i - 1][j - 1] 
	                 + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
	                  dp[i - 1][j] + 1, 
	                  dp[i][j - 1] + 1);
	            }
	        }
	    }

	    return dp[x.length()][y.length()];
	}
	
	public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
	
	public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
}
