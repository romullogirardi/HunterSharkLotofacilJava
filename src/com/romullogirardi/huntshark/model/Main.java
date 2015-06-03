package com.romullogirardi.huntshark.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import com.romullogirardi.huntshark.model.ContestManager.State;

public class Main {
	
	//Collection which stores the 10 best GameStrategies
	private static ArrayList<GameStrategy> bestGameStrategies = new ArrayList<GameStrategy>();
	
	public static void main(String[] args) throws IOException {

//		//Computing best results to combinations considering all past contests
//		System.out.println("Computando combinações considerando todos os concursos passados...");
//		bestGameStrategies = new ArrayList<>();
//		ContestManager.getInstance().populateContests();
//		System.out.println("RANKING DAS COMBINAÇÕES CONSIDERANDO TODOS OS CONCURSOS PASSADOS:");
//		for(GameStrategy gameStrategy : bestGameStrategies) 
//			System.out.println(gameStrategy.toString());
//		System.out.println();

		//Computing best results to combinations considering a part of past contests
		int increment = 10;
//		for(int index = 10; index <= 1000; index += increment) {
		for(int index = 800; index <= 1000; index += increment) {
			if(index >= 100) {
				increment = 100;
			}
			System.out.println("Computando combinações considerando os " + index + " concursos passados...");
			bestGameStrategies = new ArrayList<>();
			ContestManager.newInstance();
			ContestManager.getInstance().setState(State.PART);
			ContestManager.getInstance().setContestsPartition(index);
			ContestManager.getInstance().populateContests();
			System.out.println("RANKING DAS COMBINAÇÕES DIRETAS CONSIDERANDO OS " + index + " CONCURSOS PASSADOS:");
			for(GameStrategy gameStrategy : bestGameStrategies) 
				System.out.println(gameStrategy.toString());
			System.out.println();
		}

		//Executing iterations in intervals to discover the best 10 gameStrategies
//		int interval = 10000;
//		int index = 1;
//		long numberOfIterations = 0;
//		do {
//			if(numberOfIterations != 0) {
//				System.out.println("Computando iteração " + index + "/" + numberOfIterations + ", de " + (index - 1) * interval + " a " + index * interval);
//			}
//			ContestManager.newInstance(); 
//			ContestManager.getInstance().initializeGameStrategiesByCombinationsGenerator((index - 1) * interval, index * interval);
//			ContestManager.getInstance().populateContests();
//			System.out.println("RANKING DE ESTRATÉGIAS APÓS A " + index + "ª ITERAÇÃO:");
//			for(GameStrategy gameStrategy : bestGameStrategies) {
//				System.out.println(gameStrategy.toString());
//			}
//			System.out.println();
//			index++;
//			if(numberOfIterations == 0) {
//				numberOfIterations = (Math.abs(ContestManager.getInstance().getCombinationsGenerator().c(ContestManager.N, ContestManager.K) / interval)) + 1;
//			}
//		} while (index <= numberOfIterations);
		
//		//Executing a specific group of gameStrategies in production
//		int[] indexes1 = {2, 3, 4, 5, 7, 10, 12, 13, 16, 17, 18, 19, 21, 23, 24};
//		int[] indexes2 = {2, 5, 6, 7, 8, 9, 10, 14, 15, 16, 18, 19, 20, 21, 23};
//		int[] indexes3 = {0, 2, 3, 4, 7, 11, 12, 13, 14, 16, 17, 18, 20, 21, 22};
//		int[] indexes4 = {0, 3, 5, 6, 8, 11, 12, 13, 14, 16, 17, 18, 20, 21, 23} ;
//		Vector<GameStrategy> gameStrategies = new Vector<GameStrategy>();
//		gameStrategies.add(new GameStrategy(indexes1));
//		gameStrategies.add(new GameStrategy(indexes2));
//		gameStrategies.add(new GameStrategy(indexes3));
//		gameStrategies.add(new GameStrategy(indexes4));
//		ContestManager.getInstance().setGameStrategies(gameStrategies);
//		ContestManager.getInstance().setState(State.PART);
//		ContestManager.getInstance().setContestsPartition(30);
//		ContestManager.getInstance().setProduction(true);
//		ContestManager.getInstance().populateContests();
	}
	
	public static void addToBestGameStrategies(ArrayList<GameStrategy> gameStrategies) {
		bestGameStrategies.addAll(gameStrategies);
		Collections.sort(bestGameStrategies);
		ArrayList<GameStrategy> temp = new ArrayList<>();
		for(int index = 0; index < 10; index++) {
			temp.add(bestGameStrategies.get(index));
		}
		bestGameStrategies = temp;
	}
}