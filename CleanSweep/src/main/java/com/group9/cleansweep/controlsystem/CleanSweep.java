package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

public class CleanSweep {

	/*
	floor plan to get all tiles or get start tile
	Navigation object
		move to next tile - return new tile
	Dirt Detection object
		is capacity full? >=4
		if full -> emptyDirtTank
		clean dirt stuff

	Power Management object

	 */

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

	public void doWork(){
		FloorPlan floorPlan = new FloorPlan();
	
		//System.out.println("We are doing work in the Clean sweep");
		dirtDetectionProcess(floorPlan);
	}
	
	public void dirtDetectionProcess(FloorPlan floorPlan) {
		DirtDetection dirtDetecting= new DirtDetection();
		dirtDetecting.dirtDetectionProcess(floorPlan);
}
}