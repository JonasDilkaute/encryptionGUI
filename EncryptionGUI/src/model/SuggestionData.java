package model;

public class SuggestionData {
	
	private String suggestion, mistake;
	private int distance;
	
	public SuggestionData(String suggestion, String mistake, int distance) {
		this.distance = distance;
		this.mistake = mistake;
		this.suggestion = suggestion;
		
	}
	/**
	 * @return the suggestion
	 */
	public String getSuggestion() {
		return suggestion;
	}
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @return the mistake
	 */
	public String getMistake() {
		return mistake;
	}
	
	

}
