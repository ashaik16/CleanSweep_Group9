package com.group9.cleansweep.controlsystem;

import com.group9.cleansweep.FloorPlan;
import com.group9.cleansweep.Tile;
import com.group9.sensor_simulator.FloorTypeSimulator;


public class CleanSweep {

	/*
	 * floor plan to get all tiles or get start tile Navigation object move to next
	 * tile - return new tile Dirt Detection object is capacity full? >=4 if full ->
	 * emptyDirtTank clean dirt stuff
	 * 
	 * Power Management object
	 * 
	 */

	public CleanSweep(){


	}

	public void doWork() {
		FloorPlan floorPlan = new FloorPlan();
		floorPlan.buildGenericFloorPlan();
		Navigation navigation = new Navigation(floorPlan);
		DirtDetection dirtDetection = new DirtDetection();
		dirtDetection.setRandomDirt(floorPlan);
		PowerManagement powerManagement = new PowerManagement();
		Tile currentTile = new Tile();


		//while (true) {

//		while (true) {
			Tile tempTile = currentTile;
			currentTile = navigation.currentPos;
			//***dirtDetectionProcess needs to take in a tile instead***

			dirtDetectionProcess(tempTile, currentTile);
			currentTile = navigation.traverseTop(currentTile);
			//Insert battery check logic here:

			//This will check if all 4 directions become blocked somehow.
			if (currentTile.equals(null))
				return;
			//If you navigate to a new tile and it is visited, check to see if ALL tiles are visited.
			if (currentTile.isVisited()) {
				navigation.setIgnoreIsVisited(true);
				//If all tiles visited, check cycle completion first
				if (navigation.isCycleComplete()) {
					floorPlan.writeFloorPlanToFile();
					return;
				}
				//If not all tiles visited, try checking all other tiles for unvisited
				else {
					System.out.println("Cycle is not yet complete.  Checking adjacent tiles.");
					currentTile = navigation.traverseTop(currentTile);
					//If all adjacent tiles are still visited, stop the loop and go back to the charging station to try again later.
					if(currentTile.isVisited()) {
						System.out.println("All nearby tiles have been visited.  Starting over from charging station");
						//Insert navigation back to charging station here:
						return;
					}
				}
			}
		}
	//}

//	public void doWorkFromFile(String fileLocation){
//		FloorPlan floorPlan = new FloorPlan();
//		floorPlan.convertFileToFloorplan("src/main/java/com/group9/cleansweep/controlsystem/FloorPlanFile/SampleFloor.json");
//		DirtDetection dirtDetection = new DirtDetection();
//		dirtDetectionProcess(floorPlan);
//
//	}

	public void dirtDetectionProcess(Tile previousTile, Tile currentTile) {
		DirtDetection dirtDetection = new DirtDetection();
		dirtDetection.dirtDetectionProcess(previousTile, currentTile);
	}
}