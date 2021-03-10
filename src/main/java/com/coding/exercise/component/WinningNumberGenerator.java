package com.coding.exercise.component;

import java.util.Random;

public class WinningNumberGenerator {
	// comma delimited number combination
	
	public static String generateNumberCombination(Integer numberOfCombination) {
		Random r = new Random();
		
		String combination = "";
		for(int i = 0; i < numberOfCombination; i++) {
			combination =
				combination
				+ (r.nextInt(numberOfCombination) + 1)
				+ ",";
		}
		
		return combination;
	}

}
