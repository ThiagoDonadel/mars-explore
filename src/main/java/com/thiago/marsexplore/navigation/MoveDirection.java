package com.thiago.marsexplore.navigation;

public enum MoveDirection {
	
	FORWARD(1), BACKWARD(-1);
	
	private int modifier;
	
	private MoveDirection(int modifier) {
		this.modifier = modifier;
	}

	public int getModifier() {
		return this.modifier;
	}
}
