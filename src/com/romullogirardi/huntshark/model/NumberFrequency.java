package com.romullogirardi.huntshark.model;


public class NumberFrequency implements Comparable<NumberFrequency> {
	
	//ATTRIBUTES
	private int number;
	private int frequency;
	
	//CONSTRUCTOR
	public NumberFrequency(int number, int frequency) {
		this.number = number;
		this.frequency = frequency;
	}
	
	//GETTERS AND SETTERS
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	//OTHER METHODS
	@Override
	public int compareTo(NumberFrequency otherNumberFrequency) {
		if(frequency> otherNumberFrequency.getFrequency()) {
			return -1;
		}
		else if(frequency < otherNumberFrequency.getFrequency()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}