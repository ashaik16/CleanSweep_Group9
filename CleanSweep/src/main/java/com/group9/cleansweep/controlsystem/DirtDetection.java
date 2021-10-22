package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

public class DirtDetection {

	@Getter
	//private final int maxDirtLevel =4;
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

	//private randomDirt() -> random between 0-maxDirtLevel
	// dirt number reduces from capacity
	//public detect dirt
	//public clean dirt(int dirtNum)
		//loop print statement
	//call power management to subtract power for cleaning
	//public boolean isDirtFull()
		//print please change dirt tank
	//public void emptyDirtTank()
		//totalDirtCapcity = 50;

}
