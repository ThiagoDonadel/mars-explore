package com.thiago.marsexplore.navigation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * Holds the current location of the robot
 * @author thiago.donadel
 *
 */
@Data
@AllArgsConstructor
public class Coordinate {

	private int x;
	private int y;
	private CardinalPoint facing; 

	public String printLocation() {
		String location = "(%s,%s,%s)";
		return String.format(location, this.x, this.y, this.facing.getLetter());
	}

	/**
	 * Get the x or y value based on the current facing direction
	 * @return
	 */
	public int getFacingAxisValue() {
		if (facing == CardinalPoint.NORTH || facing == CardinalPoint.SOUTH)
			return y;
		else
			return x;
	}

	/**
	 * Set the x or y value based on the current facing direction
	 * @param value
	 */
	public void setFacingAxisValue(int value) {
		if (facing == CardinalPoint.NORTH || facing == CardinalPoint.SOUTH)
			this.y = value;
		else
			this.x = value;
	}
	
	public void reset() {
		this.x = 0;
		this.y = 0;
		this.facing = CardinalPoint.NORTH;
	}

}
