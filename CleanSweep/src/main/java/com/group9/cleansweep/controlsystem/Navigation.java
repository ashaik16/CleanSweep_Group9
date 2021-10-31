package com.group9.cleansweep.controlsystem;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Locale;

public class Navigation {
	// this is where the stack/queue would be for tiles that have been visited
	// need a method that returns boolean for is cleaning done
	private LinkedList<Tile> visitedTiles;
	private FloorPlan floorPlan;
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

	public Navigation(FloorPlan floorPlan){
		visitedTiles = new LinkedList<>();
		this.floorPlan = floorPlan;
	}

	public boolean isCleaningComplete(){
		return isTrackingCycleComplete();
	}

	public Tile getFirstTile(){
		return floorPlan.getFirstTile();
	}

	public Tile getNextTile(Tile currentTile){
		visitedTiles.add(currentTile);
		if(canMoveToNextTile(currentTile, "UP")){
			System.out.println("Moving up one tile");
			return floorPlan.getTile(currentTile.getTopNext());
		} else if( canMoveToNextTile(currentTile, "RIGHT")){
			System.out.println("Moving right one tile");
			return floorPlan.getTile(currentTile.getRightNext());
		} else if(canMoveToNextTile(currentTile, "DOWN")){
			System.out.println("Moving down right tile");
			return floorPlan.getTile(currentTile.getBottomNext());
		} else if(canMoveToNextTile(currentTile, "LEFT")){
			System.out.println("Moving down left tile");
			return floorPlan.getTile(currentTile.getLeftNext());
		}
		return currentTile;
	}

	private Tile findOpenTile(Tile tile){
		
		return tile;
	}

	private Boolean canMoveToNextTile(Tile currentTile, String direction){
		Tile targetTile;
		try{
			switch(direction.toUpperCase(Locale.ROOT)) {
				case "UP":
					System.out.println("Attempting to move up one tile");
					targetTile = floorPlan.getTile(currentTile.getTopNext());
					if(!visitedTiles.contains(targetTile) && !targetTile.getObstacle()){
						return true;
					} else if(targetTile.getObstacle()){
						System.out.println("Obstacle detected!");
					}
					break;
				case "DOWN":
					System.out.println("Attempting to move up down tile");
					targetTile = floorPlan.getTile(currentTile.getBottomNext());
					if(!visitedTiles.contains(targetTile) && !targetTile.getObstacle()){
						return true;
					} else if(targetTile.getObstacle()){
						System.out.println("Obstacle detected!");
					}
					break;
				case "RIGHT":
					System.out.println("Attempting to move up right tile");
					targetTile = floorPlan.getTile(currentTile.getRightNext());
					if(!visitedTiles.contains(targetTile) && !targetTile.getObstacle()){
						return true;
					} else if(targetTile.getObstacle()){
						System.out.println("Obstacle detected!");
					}
					break;
				case "LEFT":
					System.out.println("Attempting to move up left tile");
					targetTile = floorPlan.getTile(currentTile.getLeftNext());
					if(!visitedTiles.contains(targetTile) && !targetTile.getObstacle()){
						return true;
					} else if(targetTile.getObstacle()){
						System.out.println("Obstacle detected!");
					}
					break;
			}
		} catch (Exception e){
			return false;
		}
		return true;
	}
}
