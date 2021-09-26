package com.thiago.marsexplore.navigation;

public enum CardinalPoint {

	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String letter;
	
	private CardinalPoint(String letter) {
		this.letter = letter;
	}
	
	public String getLetter() {
		return this.letter;
	}
}
