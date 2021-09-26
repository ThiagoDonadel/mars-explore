package com.thiago.marsexplore.robot;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.regex.Pattern;

import com.thiago.marsexplore.exception.InvalidCommandException;
import com.thiago.marsexplore.exception.InvalidLocationException;
import com.thiago.marsexplore.exception.NoTerrainFoundException;
import com.thiago.marsexplore.navigation.CardinalPoint;
import com.thiago.marsexplore.navigation.Coordinate;
import com.thiago.marsexplore.navigation.NavigationSystem;
import com.thiago.marsexplore.navigation.Terrain;

import lombok.Setter;

public class Robot {

	private Coordinate location;
	private NavigationSystem navigationSystem;
	@Setter
	private Terrain exploreTerrain;

	public Robot() {
		location = new Coordinate(0, 0, CardinalPoint.NORTH);
		navigationSystem = new NavigationSystem();
	}	
	
	public Robot(Terrain terrain) {
		this();
		this.exploreTerrain = terrain;
	}

	/**
	 * Commands the robot to explore the terrain.
	 * 
	 * @param command A valid movement command
	 * @param terrain The terrain to explore
	 * @return
	 */
	public String explore(String command) {
		
		if(exploreTerrain == null)
			throw new NoTerrainFoundException();

		command = command.toUpperCase();
		if (!Pattern.matches("^[LRM]+$", command))
			throw new InvalidCommandException();
		
		CharacterIterator commandIterator = new StringCharacterIterator(command);

		while (commandIterator.current() != CharacterIterator.DONE) {
			if (commandIterator.current() == 'M') {
				this.walk();
			} else {
				this.rotate(commandIterator.current());
			}
			commandIterator.next();
		}

		return location.printLocation();
	}

	private void rotate(char direction) {

		if (direction == 'L')
			this.location.setFacing(navigationSystem.getCardinalPointToLeft(this.location.getFacing()));
		else
			this.location.setFacing(navigationSystem.getCardinalPointToRight(this.location.getFacing()));
	}

	private void walk() {

		int nextPosition = location.getFacingAxisValue()
				+ this.navigationSystem.getCardinalDirection(this.location.getFacing()).getModifier();

		if (!this.exploreTerrain.inBounds(this.location.getFacing(), nextPosition))
			throw new InvalidLocationException();

		this.location.setFacingAxisValue(nextPosition);

	}

}
