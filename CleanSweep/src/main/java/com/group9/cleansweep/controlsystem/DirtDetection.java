package com.group9.cleansweep.controlsystem;

import java.util.Map;
import java.util.Random;

import com.group9.cleansweep.Enum.DirtAmountEnum;


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

	public void dirtDetectionProcess(FloorPlan floorPlan) {
		DirtDetection dirtDetecting= new DirtDetection();
		Map<String,Tile>floorPlanDirtMap=dirtDetecting.setRandomDirt(floorPlan);
		 for (Map.Entry<String,Tile> entry : floorPlanDirtMap.entrySet())
		 {
			 Tile tile=entry.getValue();
			 dirtDetecting.cleanDirt( tile);
			 System.out.println("-------------------------------");
			 System.out.println(" Moving to the next tile...");
			 System.out.println("-------------------------------");
		}
		 System.out.println("Tracking Cycle completed....\n ");
	
	 for (Map.Entry<String,Tile> entry : floorPlanDirtMap.entrySet())
	 {
		
           System.out.println("Key = " + entry.getKey() +
                          ", Dirt Amount = " + entry.getValue().dirtAmount);
	 }
		
		
	}
	public Map<String,Tile> setRandomDirt(FloorPlan floorPlan) {
		 Random random = new Random();
		 DirtAmountEnum randomDirtCapacityEnum;
		 DirtAmountEnum[]dirtCapacityEnum=DirtAmountEnum.values();
		 Map<String, Tile>floorPlanMap=floorPlan.getFloorPlanMap();
		 for (Map.Entry<String,Tile> entry : floorPlanMap.entrySet())
		 {
			 randomDirtCapacityEnum=dirtCapacityEnum[random.nextInt(dirtCapacityEnum.length)];
			 entry.getValue().setDirtAmount(randomDirtCapacityEnum.getDirtPerFloorType());

		 }
		return floorPlanMap;
	}

	public void cleanDirt(Tile tile) {
		int dirtAmount=tile.dirtAmount;
		int dirtCount=tile.dirtAmount;
		System.out.println("Total Dirt Amount of tile " + tile.id+": "+tile.dirtAmount);
		for(int i=dirtAmount; i>=0;i--)
		{
		if(tile.dirtAmount==0)
		{
			System.out.println("Tile "+tile.id+" is completely clean \n ");
			break;
		}
		else
		{
			System.out.println("Cleaning tile: "+tile.id);
			dirtCount--;
			tile.setDirtAmount(dirtCount);
			System.out.println("Cuurent Dirt Amount of " + tile.id+" : "+dirtCount);
		}
		}
	}
	
}
