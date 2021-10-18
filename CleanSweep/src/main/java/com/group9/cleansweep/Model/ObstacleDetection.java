package java.com.group9.cleansweep.Model;

import lombok.Getter;
import lombok.Setter;

public class ObstacleDetection {

	enum ObstacleType {
		UNKNOWN, OPEN, OBSTACLE, STAIRS
	}

	@Getter
	@Setter
	public ObstacleType isObstacleDetected;
}
