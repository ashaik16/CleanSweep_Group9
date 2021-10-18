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
	
	Tile(String S) {
		this.surfaceType = S;
		this.leftNext = null;
		this.rightNext = null;
		this.topNext = null;
		this.bottomNext = null;
		this.dirtAmount = 0;
		this.isChargingStation = false;
		this.visited = false;
	}

}
