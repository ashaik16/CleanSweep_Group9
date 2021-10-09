package Model;

import lombok.Getter;
import lombok.Setter;

public class DirtDetection {

	@Getter
	private final int totalDirtCapacity = 50;
	@Getter
	@Setter
	private int dirtCount;
	@Getter
	@Setter
	private int unitOfDirt;
	@Getter
	@Setter
	private int totalDirtCollected;
	@Getter
	@Setter
	private boolean isDirtCapacityFull = false;

}
