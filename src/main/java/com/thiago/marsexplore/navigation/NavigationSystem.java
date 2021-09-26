package com.thiago.marsexplore.navigation;

import java.util.HashMap;

/**
 * The Navigation System is the component responsible for holding navigation
 * information to help the robot to move in mars terrain
 * 
 * @author thiago.donadel
 *
 */
public class NavigationSystem {

	private HashMap<CardinalPoint, CardinalPointDescriptor> cardinalMap;


	public NavigationSystem() {
		cardinalMap = new HashMap<CardinalPoint, CardinalPointDescriptor>();
		cardinalMap.put(CardinalPoint.NORTH, buildNorthDescriptor());
		cardinalMap.put(CardinalPoint.SOUTH, buildSouthDescriptor());
		cardinalMap.put(CardinalPoint.EAST, buildEastDescriptor());
		cardinalMap.put(CardinalPoint.WEST, buildWestDescriptor());
	}

	private CardinalPointDescriptor buildNorthDescriptor() {
		return CardinalPointDescriptor.builder().point(CardinalPoint.NORTH).moveDirection(MoveDirection.FORWARD)
				.leftPoint(CardinalPoint.WEST).rightPoint(CardinalPoint.EAST).build();
	}

	private CardinalPointDescriptor buildSouthDescriptor() {
		return CardinalPointDescriptor.builder().point(CardinalPoint.SOUTH).moveDirection(MoveDirection.BACKWARD)
				.leftPoint(CardinalPoint.EAST).rightPoint(CardinalPoint.WEST).build();
	}

	private CardinalPointDescriptor buildEastDescriptor() {
		return CardinalPointDescriptor.builder().point(CardinalPoint.EAST).moveDirection(MoveDirection.FORWARD)
				.leftPoint(CardinalPoint.NORTH).rightPoint(CardinalPoint.SOUTH).build();
	}

	private CardinalPointDescriptor buildWestDescriptor() {
		return CardinalPointDescriptor.builder().point(CardinalPoint.WEST).moveDirection(MoveDirection.BACKWARD)
				.leftPoint(CardinalPoint.SOUTH).rightPoint(CardinalPoint.NORTH).build();
	}

	/**
	 * Get the move direction for a cardinal point
	 * @param point 
	 * @return
	 */
	public MoveDirection getCardinalDirection(CardinalPoint point)  {
		return this.cardinalMap.get(point).getMoveDirection();
	}
	
	/**
	 * Get the cardinal point on the left of the specified cardinal point
	 * @param point
	 * @return
	 */
	public CardinalPoint getCardinalPointToLeft(CardinalPoint point) {
		return this.cardinalMap.get(point).getLeftPoint();
	}
	
	/**
	 * Get the cardinal point on the right of the specified cardinal point
	 * @param point
	 * @return
	 */
	public CardinalPoint getCardinalPointToRight(CardinalPoint point) {
		return this.cardinalMap.get(point).getRightPoint();
	}

}
