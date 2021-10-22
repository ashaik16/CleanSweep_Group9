package com.group9.cleansweep.controlsystem;

public class Tile {
	
	public String surfaceType;
	public int dirtAmount;
	
	boolean isChargingStation;
	
	boolean visited;
	
	public Tile rightNext;
	public Tile leftNext;
	public Tile topNext;
	public Tile bottomNext;
	public String id;
	public Boolean isObstacle;
	
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





}
