package model;

import java.io.Serializable;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FrequencyData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleStringProperty key;
	private SimpleDoubleProperty frequency;
	private SimpleStringProperty letter;
	
	public FrequencyData(String key, String letter, double frequency) {
		this.frequency = new SimpleDoubleProperty(frequency);
		this.key = new SimpleStringProperty(key);
		this.letter = new SimpleStringProperty(letter);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key.get();
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key.set(key);
	}

	/**
	 * @return the frequency
	 */
	public double getFrequency() {
		return frequency.get();
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(double frequency) {
		this.frequency.set(frequency);
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter.get();
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(String letter) {
		this.letter.set(letter);
	}

}
