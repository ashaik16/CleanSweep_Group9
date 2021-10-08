package com.group9.cleansweep.Model;

import lombok.Getter;
import lombok.Setter;

public class ObstacleDetection {

	private enum Type {
		UNKOWN, OPEN, OBSTACLE, STAIRS
	}

	@Getter
	@Setter
	private boolean isObstacleDetected;
}
