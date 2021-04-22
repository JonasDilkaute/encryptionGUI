package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public Map<String, Map<Integer, String>> getSuggestions (String text) {
		Map<String, Map<Integer, String>> list = new HashMap<String, Map<Integer, String>>();
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
				Map<Integer, String> suggestions =filterSuggestions(match.getSuggestedReplacementObjects(), subString);
				list.put(subString, suggestions);
			}
		}
		return list;
	}
	
	private Map<Integer, String> filterSuggestions(List<SuggestedReplacement> suggestions, String subText) {
		subText = subText.toLowerCase();
		int minDistance = -1;
		Map<Integer, String> filteredSuggestions = new HashMap<>();
		for(SuggestedReplacement s : suggestions) {
	    	  if(s.getReplacement().length() == subText.length()) {
	    		
	    		  String replacement = s.getReplacement().toLowerCase();
	    		  int distance =calculateDistance(subText, replacement);
	    		  
	    		  minDistance = Math.min(minDistance, distance);
	    		  filteredSuggestions.put(distance, replacement);
	    	  }	  
	      }
		Map<Integer, String> sortedMap = 
			     filteredSuggestions.entrySet().stream()
			    .sorted(Entry.comparingByValue())
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                              (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
		
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
