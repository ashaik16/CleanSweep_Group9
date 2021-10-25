package com.group9.cleansweep.controlsystem;

public class Tile {

	private String surfaceType;
	private int dirtAmount;

	private boolean isChargingStation;

	private boolean visited;

	private Tile rightNext;
	private Tile leftNext;
	private Tile topNext;
	private Tile bottomNext;
	private String id;
	private Boolean isObstacle;
	
	Tile() {
		this.id = null;
		this.surfaceType = null;
		this.leftNext = null;
		this.rightNext = null;
		this.topNext = null;
		this.bottomNext = null;
		this.dirtAmount = 0;
		this.isChargingStation = false;
		this.isObstacle = false;
		this.visited = false;
	}

	public void setSurfaceType(String surfaceType){
		this.surfaceType = surfaceType;
	}

	public void setLeftNext(Tile leftNext){
		this.leftNext = leftNext;
	}

	public void setRightNext(Tile rightTile){
		rightNext = rightTile;
	}

	public void setTopNext(Tile topNext){
		this.topNext = topNext;
	}

	public void setBottomNext(Tile bottomNext){
		this.bottomNext = bottomNext;
	}

	public void setDirtAmount(int dirtAmount){
		this.dirtAmount = dirtAmount;
	}

	public void setChargingStation(Boolean isChargingStation){
		this.isChargingStation = isChargingStation;
	}

	public void setIsObstacle(Boolean isObstacle){
		this.isObstacle = isObstacle;
	}

	public void setID(String id){
		this.id = id;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}


	public String getSurfaceType() {
		return surfaceType;
	}

	public int getDirtAmount() {
		return dirtAmount;
	}

	public boolean isChargingStation() {
		return isChargingStation;
	}

	public boolean isVisited() {
		return visited;
	}

	public Tile getRightNext() {
		return rightNext;
	}

	public Tile getLeftNext() {
		return leftNext;
	}

	public Tile getTopNext() {
		return topNext;
	}

	public Tile getBottomNext() {
		return bottomNext;
	}

	public String getId() {
		return id;
	}

	public Boolean getObstacle() {
		return isObstacle;
	}


}
