package com.group9.cleansweep.controlsystem;

import com.group9.cleansweep.controlsystem.FloorPlan;

import lombok.Getter;
import lombok.Setter;

public class CleanSweep {

	@Getter
	private Long id;

	@Getter
	@Setter
	FloorPlan floorPlan;
	@Getter
	@Setter
	ObstacleDetection obstacleDetection;
	@Getter
	@Setter
	DirtDetection dirtDetection;
	@Getter
	@Setter
	Navigation navigation;
	@Getter
	@Setter
	PowerManagement powerManagement;
	

}
