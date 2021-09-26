package com.thiago.marsexplore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.thiago.marsexplore.exception.InvalidCommandException;
import com.thiago.marsexplore.exception.InvalidLocationException;
import com.thiago.marsexplore.exception.NoTerrainFoundException;
import com.thiago.marsexplore.navigation.Terrain;
import com.thiago.marsexplore.robot.Robot;

@SpringBootTest
public class RobotTests {
	
	private static Terrain terrain;
	
	@BeforeAll
	public static void initializeTerrain() {
		terrain = Terrain.builder().northLimit(4).eastLimit(4).build();
	}
	
	@Test
	public void moveLeft() {
		Robot robot = new Robot(terrain);
		assertEquals("(0,2,W)", robot.explore("MML"));		
	}
	
	@Test
	public void moveAndRotate() {
		Robot robot = new Robot(terrain);
		assertEquals("(2,0,S)", robot.explore("MMRMMRMM"));		
	}
	
	@Test
	public void coverAllTerrain() {
		Robot robot = new Robot(terrain);
		assertEquals("(4,4,N)", robot.explore("RMMMMLMLMMMMRMRMMMMLMLMMMMRMRMMMML"));		
	}
	
	@Test
	private void invalidCommand( ) {
		Robot robot = new Robot(terrain);
		assertThrows(InvalidCommandException.class, () -> robot.explore("AAA"));
	}
	
	@Test
	public void outOfBoundNorth() {
		Robot robot = new Robot(terrain);
		assertThrows(InvalidLocationException.class, () -> robot.explore("MMMMMMMMMMMMMMMMMMMMMMMM"));
	}
	
	@Test
	public void outOfBoundSouth() {
		Robot robot = new Robot(terrain);
		assertThrows(InvalidLocationException.class, () -> robot.explore("RRM"));
	}
	
	@Test
	public void outOfBoundWest() {
		Robot robot = new Robot(terrain);
		assertThrows(InvalidLocationException.class, () -> robot.explore("LM"));
	}
	
	@Test
	public void outOfBoundEast() {
		Robot robot = new Robot(terrain);
		assertThrows(InvalidLocationException.class, () -> robot.explore("RMMMMM"));
	}
	
	@Test
	public void noTerrainFound() {
		Robot robot = new Robot();
		assertThrows(NoTerrainFoundException.class, () -> robot.explore("RMMMMM"));
	}
	
	@Test
	public void moveOnIrregularTerrain() {
		Terrain irregularTerrain = Terrain.builder().northLimit(6).southLimit(-1).eastLimit(2).westLimit(-2).build();
		Robot robot = new Robot(irregularTerrain);		
		assertEquals("(0,-1,W)", robot.explore("LLMR"));
		assertEquals("(-2,-1,N)", robot.explore("MMR"));
		assertEquals("(-2,6,E)", robot.explore("MMMMMMMR"));
		assertEquals("(2,6,S)", robot.explore("MMMMR"));
	}

}
