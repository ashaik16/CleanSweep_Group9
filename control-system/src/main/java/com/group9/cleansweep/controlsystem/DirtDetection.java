package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import com.group9.cleansweep.FloorPlan;
import com.group9.cleansweep.Tile;
import com.group9.sensor_simulator.DirtSensor;

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
	private int totalDirtCollected = 0;
	@Getter
	@Setter
	private boolean isDirtCapacityFull = false;
	@Getter
	@Setter
	private boolean isMinimumPowerCapacityReached = false;
	private static DirtDetection dirtDetecting = new DirtDetection();
	

	public boolean dirtDetectionProcess(Tile previousTile, Tile currentTile) {

		PowerManagement powerManagement=new PowerManagement();

			int dirtAmount=currentTile.getDirtAmount();
		
			dirtDetecting.cleanDirt(currentTile);
			
			isMinimumPowerCapacityReached=powerManagement.powerManagementProcess(previousTile,currentTile,dirtAmount);
			
			if(isMinimumPowerCapacityReached)
				return true;
			else


//			else
//				break;
		
		if (!dirtDetecting.isDirtCapacityFull && !(isMinimumPowerCapacityReached))
			System.out.println("Tracking Cycle completed....\n ");
		System.out.println("\nCurrent Dirt Amount per tile:\n");

			System.out.println("Key = " + currentTile + ", Dirt Amount = " + currentTile.getDirtAmount());


			return false;
	}

	public Map<String, Tile> setRandomDirt(FloorPlan floorPlan) {
		
//		Random random = new Random();
//		DirtAmountEnum randomDirtCapacityEnum;
//		DirtAmountEnum[] dirtCapacityEnum = DirtAmountEnum.values();
		//Map<String, Tile> floorPlanMap = floorPlan.getFloorPlanMap();
//		
//		for (Map.Entry<String, Tile> entry : floorPlanMap.entrySet()) {
//			randomDirtCapacityEnum = dirtCapacityEnum[random.nextInt(dirtCapacityEnum.length)];
//			entry.getValue().setDirtAmount(randomDirtCapacityEnum.getDirtPerFloorType());
//
//		}
		DirtSensor dirtSensor=new DirtSensor();
		return dirtSensor.setRandomDirt(floorPlan);
	}

	public void cleanDirt(Tile tile) {
		int dirtAmount = tile.getDirtAmount();
		dirtCount = tile.getDirtAmount();
		System.out.println("Total Dirt Amount of tile " + tile.getId() + ": " + tile.getDirtAmount());
		
		for (int i = dirtAmount; i >= 0; i--) {
			if (tile.getDirtAmount() == 0) {
				System.out.println("Tile " + tile.getId() + " is completely clean \n ");
				break;
			} else {
				System.out.println("Cleaning tile: " + tile.getId());
				dirtCount--;
				totalDirtCollected++;
				isDirtCapacityFull = checkIfDirtCapacityFull(totalDirtCollected);

				if (isDirtCapacityFull) {
					StatusCheck statusCheck = new StatusCheck();
					System.out.println("----------------------------------------");
					statusCheck.setStatus("\nClean Sweep Dirt Capacity Full !!!!\n");
					System.out.println("Please empty the dirt tank !!!");
					System.out.println("-----------------------------------------");
					emptyDirtTank();
			
				}
				
				tile.setDirtAmount(dirtCount);
				System.out.println("Current Dirt Amount of " + tile.getId() + " : " + dirtCount);
			}

		}

	}

	public void emptyDirtTank() {
		totalDirtCollected = 0;

		System.out.println("Dirt tank emptied!! Clean sweep is ready to vacuum again..");
	}

	public boolean checkIfDirtCapacityFull(int totalDirtCollected) {

		return totalDirtCollected >= totalDirtCapacity ? true : false;
	}

}
