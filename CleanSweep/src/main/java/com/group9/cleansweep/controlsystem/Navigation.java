package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Stack;

public class Navigation {
	// this is where the stack/queue would be for tiles that have been visited
	// need a method that returns boolean for is cleaning done
	Stack<Tile> visited;
	Tile currentPos;
	FloorPlan floorPlan = new FloorPlan();

	Map<String, Tile> floorPlanMap;

	public Navigation() {
		this.floorPlanMap = floorPlan.getFloorPlanMap();
		visited = new Stack<Tile>();
	}

	public Tile traverseRight(Tile target){
		currentPos.setRightNext(target);
		currentPos.setLeftNext(currentPos);
		currentPos.setTopNext(target.getTopNext());
		currentPos.setBottomNext(target.getBottomNext());
		target.setVisited(true);
		visited.push(target);
		return target;
	}

	// Assuming charging station is start

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
}
