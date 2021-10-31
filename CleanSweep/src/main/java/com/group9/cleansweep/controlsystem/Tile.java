package com.group9.cleansweep.controlsystem;


import com.google.gson.annotations.Expose;

public class Tile {
	@Expose private String id;
	@Expose private String surfaceType;
	@Expose private Boolean isObstacle;
	@Expose private int dirtAmount;
	@Expose private boolean isChargingStation;
	@Expose private boolean visited;
	@Expose private String rightID;
	@Expose private String leftID;
	@Expose private String topID;
	@Expose private String bottomID;

	
	Tile() {
		this.id = null;
		this.surfaceType = null;
		this.dirtAmount = 0;
		this.isChargingStation = false;
		this.isObstacle = false;
		this.visited = false;
		this.rightID = null;
		this.leftID = null;
		this.topID = null;
		this.bottomID = null;
	}

	public String[] getSurroundingTileID(){
		return new String[]{rightID, leftID, topID, bottomID};
	}

	public void setSurfaceType(String surfaceType){
		this.surfaceType = surfaceType;
	}

	public void setLeftNext(String leftNext){
		leftID = leftNext;
	}

	public void setRightNext(String rightTile){
		rightID = rightTile;
	}

	public void setTopNext(String topNext){
		topID = topNext;
	}

	public void setBottomNext(String bottomNext){
		bottomID = bottomNext;
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

	public String getRightNext() {
		return rightID;
	}

	public String getLeftNext() {
		return leftID;
	}

	public String getTopNext() {
		return topID;
	}

	public String getBottomNext() {
		return bottomID;
	}

	public String getId() {
		return id;
	}

	public Boolean getObstacle() {
		return isObstacle;
	}


}
