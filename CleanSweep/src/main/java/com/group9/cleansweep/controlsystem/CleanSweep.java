package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

public class CleanSweep {

	/*
	 * floor plan to get all tiles or get start tile Navigation object move to next
	 * tile - return new tile Dirt Detection object is capacity full? >=4 if full ->
	 * emptyDirtTank clean dirt stuff
	 * 
	 * Power Management object
	 * 
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
	int iteration = 0;

	public void doWork() {
		FloorPlan floorPlan = new FloorPlan();

		while (true) {
			//Finds the first tile in the floor plan to CleanSweep to start with
			try {
				Tile targetTile = floorPlan.getTile(iteration);

				//Find starting tile dirt amount
				if (powerManagement.getCurrentUnitOfCharge() > 100) {
					dirtDetection.cleanDirt(targetTile);
					powerManagement.setCurrentUnitOfCharge(powerManagement.getCurrentUnitOfCharge()
							- powerManagement.getUnitOfCharge(targetTile.getSurfaceType()));
				}
				//After cleaning and reducing battery, set visited to true
				targetTile.setVisited(true);

				iteration++;
			}
			catch(NullPointerException e) {
				System.out.println(e);
				break;
			}
		}
		//If iteration >= 1, navigate to first tile available (check top, then right, then bottom, then left) that is not visited.
		//If iteration >= 1 AND all 4 sensors are blocked, stop cleaning
		//If iteration >= 1 AND all 4 tiles are visited, find a tile that is not visited.

		// System.out.println("We are doing work in the Clean sweep");
		//dirtDetectionProcess(floorPlan);
	}

//	public void dirtDetectionProcess(FloorPlan floorPlan) {
//		DirtDetection dirtDetecting = new DirtDetection();
//		dirtDetecting.dirtDetectionProcess(floorPlan);
//	}
}