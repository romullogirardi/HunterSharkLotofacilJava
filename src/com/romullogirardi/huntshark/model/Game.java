package com.romullogirardi.huntshark.model;

import java.util.ArrayList;

public class Game {

	//ATTRIBUTES
	private ArrayList<Integer> numbers = new ArrayList<>();
	private int points = -1;
	private float investment = Constants.GAME_PRIZE;
	private float reward = 0;
	
	//CONSTRUCTOR
	public Game(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	//GETTERS AND SETTERS
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
	
	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public float getInvestment() {
		return investment;
	}
	
	public float getReward() {
		return reward;
	}
	
	public void setReward(float reward) {
		this.reward = reward;
	}
}