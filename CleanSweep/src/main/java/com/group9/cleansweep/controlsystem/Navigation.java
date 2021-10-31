package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

public class Navigation {
	// this is where the stack/queue would be for tiles that have been visited
	// need a method that returns boolean for is cleaning done
	@Getter
	@Setter
	private boolean isVisited = false;
	@Getter
	@Setter
	private boolean isTrackingCycleComplete = false;
	//print moved up one cell
	//print moved left one cell
	//print attempting to move up one cell
	//print obstacle detected one cell up
	//print attempting to move left one cell
	//print moved left one cell
	//return left Tile object

	public boolean isCleaningComplete(){
		return isTrackingCycleComplete();
	}

	public Tile getFirstTile(FloorPlan floorPlan){
		return floorPlan.getFirstTile();
	}
}
