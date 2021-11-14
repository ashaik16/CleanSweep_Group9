package com.group9.sensor_simulator;

import java.util.Map;
import java.util.Random;

import com.group9.cleansweep.FloorPlan;
import com.group9.cleansweep.Tile;
import com.group9.sensor_simulator.Enum.DirtAmountEnum;

public class FloorTypeSimulator {
	private final String[] floorTypes = {"BARE_FOOT", "LOW_PILE_CARPET", "HIGH_PILE_CARPET"};
	private Random random;

	FloorTypeSimulator(){
		random = new Random();
	}

	public String getRandomFloorType(){
		return floorTypes[random.nextInt(floorTypes.length)];
	}


}
