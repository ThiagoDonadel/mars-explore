package com.thiago.marsexplore.navigation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Terrain {

	@Builder.Default
	private int northLimit = 0;
	@Builder.Default
	private int southLimit = 0;
	@Builder.Default
	private int eastLimit = 0;
	@Builder.Default
	private int westLimit = 0;

	public boolean inBounds(CardinalPoint direction, int position) {
		if (direction == CardinalPoint.NORTH || direction == CardinalPoint.SOUTH)
			return position >= southLimit && position <= northLimit;
		else
			return position >= westLimit && position <= eastLimit;
	}

}
