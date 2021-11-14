package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import com.group9.cleansweep.Tile;
import com.group9.sensor_simulator.ObstacleSimulator;

import lombok.Setter;

import java.util.Map;
import java.util.Stack;
import com.group9.cleansweep.FloorPlan;
public class Navigation {
	// this is where the stack/queue would be for tiles that have been visited
	// need a method that returns boolean for is cleaning done
	Stack<Tile> visited;
	Tile currentPos = new Tile();
	FloorPlan floorPlan;
	private Boolean ignoreIsVisited = false;

	Map<String, Tile> floorPlanMap;

	public Navigation(FloorPlan floorPlan) {
		this.visited = new Stack<>();
		this.floorPlan = floorPlan;
		this.floorPlanMap = floorPlan.getFloorPlanMap();

		// Assuming charging station is start
		// set current position to the charging station

		for(Map.Entry<String, Tile> entry : floorPlanMap.entrySet()){
			if(entry.getValue().isChargingStation()) {
				currentPos = entry.getValue();
				currentPos.setRightNext(currentPos.getRightNext());
				currentPos.setLeftNext(currentPos.getLeftNext());
				currentPos.setTopNext(currentPos.getTopNext());
				currentPos.setBottomNext((currentPos.getBottomNext()));
			}
		}
	}

	public Tile traverse(Tile target){
		// always start with top and move through the other methods
		return traverseTop(target);
	}

	private Tile traverseTop(Tile target) {
		if (isObstacleTop(target) && target.getTopNext().isVisited()) {
			return traverseRight(target);
		}
		else if (isObstacleTop(target)){
				return traverseRight(target);
		}
		else {
			target.setVisited(true);
			System.out.println("Traversed up from tile " +  target.getId() + " to tile " + target.getTopNext().getId() + ".");
			return target.getTopNext();
		}
	}

	private Tile traverseRight(Tile target) {
		if (isObstacleRight(target) && target.getRightNext().isVisited()){
			return traverseBottom(target);
		}
		else if (isObstacleRight(target)){
			return traverseBottom(target);
		}
		else {
			target.setVisited(true);
			System.out.println("Traversed right from tile " + target.getRightNext().getId() + " to tile " + target.getId() + ".");
			return target.getRightNext();
		}
	}

	private Tile traverseBottom(Tile target){
		if (isObstacleBottom(target) && target.getBottomNext().isVisited()){
			return traverseLeft(target);
		}
		else if (isObstacleBottom(target)){
			return traverseLeft(target);
		} else{
			target.setVisited(true);
			System.out.println("Traversed down from tile " + target.getBottomNext().getId() + " to tile " + target.getId() + ".");
			return target.getBottomNext();
		}
	}

	private Tile traverseLeft(Tile target) {
		if (isObstacleLeft(target) && target.getLeftNext().isVisited()){
			return traverseRight(target);
		} else if(isObstacleLeft(target)){
			System.out.println("Clean Sweep encountered an obstacle on all sides.  Stopping.");
			return target;
		} else {
			target.setVisited(true);
			System.out.println("Traversed down from tile " + target.getLeftNext().getId() + " to tile " + target.getId() + ".");
			return target.getLeftNext();
		}
	}

	private boolean isIgnoreIsVisited() {
		// TODO Auto-generated method stub
		return false;
	}

	private Boolean isObstacleRight(Tile currentPos) {
//		currentPos.getRightNext().setIsObstacle(ObstacleSimulator.getInstance().getRandomObstacle());
		if(currentPos.getRightNext().getObstacle()) {
			System.out.println("Detected tile " + currentPos.getRightNext().getId() + " as obstacle to the right.");
			return true;
		} else return false;
	}

	private Boolean isObstacleLeft(Tile currentPos) {
//		currentPos.getLeftNext().setIsObstacle(ObstacleSimulator.getInstance().getRandomObstacle());
		if(currentPos.getLeftNext().getObstacle()) {
			System.out.println("Detected tile " + currentPos.getLeftNext().getId() + " as obstacle to the left.");
			return true;
		} else return false;
	}

	private Boolean isObstacleTop(Tile currentPos) {
//		currentPos.getTopNext().setIsObstacle(ObstacleSimulator.getInstance().getRandomObstacle());
		if(currentPos.getTopNext().getObstacle()) {
			System.out.println("Detected tile " + currentPos.getTopNext().getId() + " as obstacle above.");
			return true;
		} else {
			return false;
		}
	}

	private Boolean isObstacleBottom(Tile currentPos) {
//		currentPos.getBottomNext().setIsObstacle(ObstacleSimulator.getInstance().getRandomObstacle());
		if(currentPos.getBottomNext().getObstacle()) {
			System.out.println("Detected tile " + currentPos.getBottomNext().getId() + " as obstacle below.");
			return true;
		} else return false;
	}



    // TODO: go back to power station
	//  keep iterating back through stack, traversing back to charging station
	// Still need to figure out algorithm for it
	private void backToChargingStation() {

	}




	public boolean isCycleComplete() {
		Tile checkTile = new Tile();
		Tile[] allTiles = floorPlan.getFloorPlanMap().values().toArray(new Tile[floorPlan.getFloorPlanMap().values().size()]);
		for (int i = 0; i < allTiles.length; ) {
			checkTile = allTiles[i];
			if (checkTile.isVisited())
				continue;
			else
				return false;
		}
		return true;
	}

	public void resetIgnoreIsVisited(){
		ignoreIsVisited = false;
	}

	public void setIgnoreIsVisited(boolean b) {
		// TODO Auto-generated method stub
		
	}



	// vv Done vv

	//print moved up one cell
	//print moved left one cell
	//print attempting to move up one cell
	//print obstacle detected one cell up
	//print attempting to move left one cell
	//print moved left one cell
	//return left Tile object
}
