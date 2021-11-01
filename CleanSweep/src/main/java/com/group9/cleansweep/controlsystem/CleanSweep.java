package com.group9.cleansweep.controlsystem;

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

		DirtDetection dirtDetection = new DirtDetection();
		dirtDetection.setRandomDirt(floorPlan);

		Navigation navigation = new Navigation(floorPlan);

//		String currentTileId = navigation.currentPos.getId();
		Tile startingTile = navigation.currentPos;
		Tile currentTile = startingTile;
		while (true) {
			currentTile = navigation.currentPos;
			dirtDetection.cleanDirt(currentTile);
			if (currentTile.getDirtAmount() == 0) {
				currentTile.setVisited(true);
			}
			else {
				System.out.println("Dirt is probably full.  Stopping work.");
				return;
			}

			if(navigation.isObstacleTop(currentTile).equals(true)) {
				if(navigation.isObstacleRight(currentTile).equals(true)) {
					if(navigation.isObstacleBottom(currentTile).equals(true)) {
						if(navigation.isObstacleLeft(currentTile).equals(true)) {
							System.out.println("Blocked on all sides.  Stopping cleaning.");
							navigation.setTrackingCycleComplete(false);
							break;
						}
						else {
							navigation.traverseLeft(currentTile);
						}
					}
					else {
						navigation.traverseBottom(currentTile);
					}
				}
				else navigation.traverseRight(currentTile);
			}
			else navigation.traverseTop(currentTile);

		}
//		dirtDetectionProcess(floorPlan);
//		floorPlan.writeFloorPlanToFile();
	}

	public void doWorkFromFile(String fileLocation){
		FloorPlan floorPlan = new FloorPlan();
		floorPlan.convertFileToFloorplan("src/main/java/com/group9/cleansweep/controlsystem/FloorPlanFile/SampleFloor.json");
		DirtDetection dirtDetection = new DirtDetection();
		dirtDetectionProcess(floorPlan);

	}

	public void dirtDetectionProcess(FloorPlan floorPlan) {
		DirtDetection dirtDetection = new DirtDetection();
		dirtDetection.dirtDetectionProcess(floorPlan);
	}
}