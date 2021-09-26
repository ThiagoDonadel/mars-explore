package com.thiago.marsexplore.navigation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardinalPointDescriptor {
	
	private CardinalPoint point;
	private CardinalPoint rightPoint;
	private CardinalPoint leftPoint;
	private MoveDirection moveDirection;
	
}
