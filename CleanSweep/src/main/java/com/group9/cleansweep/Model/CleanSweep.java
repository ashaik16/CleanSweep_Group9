package com.group9.cleansweep.Model;

import lombok.Getter;
import lombok.Setter;

import com.group9.cleansweep.Model.FloorPlan;

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
