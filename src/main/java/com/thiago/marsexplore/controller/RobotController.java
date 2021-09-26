package com.thiago.marsexplore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.marsexplore.navigation.Terrain;
import com.thiago.marsexplore.robot.Robot;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

	@GetMapping("/{command}")
	public String receiveMoveCommand(@PathVariable String command) {
		Terrain terrain = Terrain.builder().northLimit(4).eastLimit(4).build();
		Robot robot = new Robot(terrain);
		return robot.explore(command);
	}

}
