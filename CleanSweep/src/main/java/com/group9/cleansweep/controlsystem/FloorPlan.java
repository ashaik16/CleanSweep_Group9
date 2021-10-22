package com.group9.cleansweep.controlsystem;

//import netscape.javascript.JSObject;

import java.util.*;

import com.group9.cleansweep.Enum.FloorPlanTypeEnum;

import lombok.Getter;

public class FloorPlan {
	//this keeps track of all the tiles in a room String is the ID of the tile
	private final Map<String, Tile> roomLayout;
	private Map<String, Boolean> tileVisitedMap;
	private final String[] floortypes = {"BARE_FOOT", "LOW_PILE_CARPET", "HIGH_PILE_CARPET"};
	private final Boolean[] isObstacle = {true, false};

	@Getter
	FloorPlanTypeEnum floorPlanType;

	public FloorPlan(){
		this.roomLayout = new HashMap<>();
		buildGenericFloorPlan();
		System.out.println("something");
	}

	public Map<String, Tile> getFloorPlanMap(){
		return roomLayout;
	}

//	public ArrayList<String> getRoomTiles(String roomID){
//		return roomLayout.get(roomID);
//	}

//	public void addTileToRoom(String roomID, String tile){
//		ArrayList<String> tempList = roomLayout.get(roomID);
//		tempList.add(tile);
//		roomLayout.put(roomID, tempList);
//	}

//	public String addNewRoom(){
//		String roomID = UUID.randomUUID().toString();
//		ArrayList<String> roomTiles = new ArrayList<>();
//		roomLayout.put(roomID, roomTiles);
//		return roomID;
//	}

	public void buildGenericFloorPlan(){
		Random random = new Random();
		String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
		//these loops create the tiles and add them to the map
		for(int i = 0; i < 7; i++){
			String letter = alpha[i];
			for(int j = 1; j <= 7; j++ ){
				Tile tempTile = new Tile();
				//setting tile to random floor type declared at top of class
				tempTile.setSurfaceType(floortypes[random.nextInt(floortypes.length)]);
				//tile is randomly an obstacle or not
				tempTile.setIsObstacle(isObstacle[random.nextInt(isObstacle.length)]);
				String tempID = letter + j;
				tempTile.setID(tempID);
				roomLayout.put(tempTile.id, tempTile);
			}
		}
		//these loops go and attempt to get all the tiles in all directions catches the out of bounds and ignores it
		for(int z = 0; z < 7; z++){
			Tile tempTile;
			String letter = alpha[z];
			for(int x = 1; x <= 7; x++ ){
				//try getting the top tile above target
				try{
					String targetTile = letter + x;
					tempTile = roomLayout.get(targetTile);
					String tileAbove = alpha[z-1] + x;
					Tile upTile = roomLayout.get(tileAbove);
					tempTile.setTopNext(upTile);
				} catch(Exception e){
					//ignore
				}
				//try getting the bottom tile above target
				try{
					String targetTile = letter + x;
					tempTile = roomLayout.get(targetTile);
					String tileBelow = alpha[z+1] + x;
					Tile bottomTile = roomLayout.get(tileBelow);
					tempTile.setBottomNext(bottomTile);
				} catch(Exception e){
					//ignore
				}
				//try getting the right tile above target
				try{
					String targetTile = letter + x;
					tempTile = roomLayout.get(targetTile);
					String tileRight = letter + (x+1);
					Tile rightTile = roomLayout.get(tileRight);
					tempTile.setRightNext(rightTile);
				} catch(Exception e){
					//ignore
				}
				//try getting the left tile above target
				try{
					String targetTile = letter + x;
					tempTile = roomLayout.get(targetTile);
					String tileLeft = letter + (x-1);
					Tile leftTile = roomLayout.get(tileLeft);
					tempTile.setLeftNext(leftTile);
				} catch(Exception e){
					//ignore
				}
			}
		}
		//get tile g3 in order to make it the the charging station
		Tile chargingStation = roomLayout.get("g3");
		chargingStation.setChargingStation(true);
	}

	public void removeRoom(String roomID){
		roomLayout.remove(roomID);
	}

//	public void loadFloorPlan(JSObject floorPlan){
//		// add logic based on the JSON file that is sent
//	}
}
