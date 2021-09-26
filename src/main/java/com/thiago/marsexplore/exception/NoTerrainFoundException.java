package com.thiago.marsexplore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoTerrainFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTerrainFoundException() {
		super("No terrain to explore. Be sure to tell to the robot what whe should explore!!");
	}
	
}
