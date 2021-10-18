package java.com.group9.cleansweep.Model;

import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import java.com.group9.cleansweep.Enum.FloorPlanTypeEnum;

import lombok.Getter;

public class FloorPlan {
	//this keeps track of all the tiles in a room
	private final Map<String, ArrayList<String>> roomLayout;

	@Getter
	FloorPlanTypeEnum floorPlanType;

	public FloorPlan(){
		this.roomLayout = new HashMap<>();
	}

	public ArrayList<String> getRoomTiles(String roomID){
		return roomLayout.get(roomID);
	}

	public void addTileToRoom(String roomID, String tile){
		ArrayList<String> tempList = roomLayout.get(roomID);
		tempList.add(tile);
		roomLayout.put(roomID, tempList);
	}

	public String addNewRoom(){
		String roomID = UUID.randomUUID().toString();
		ArrayList<String> roomTiles = new ArrayList<>();
		roomLayout.put(roomID, roomTiles);
		return roomID;
	}

	public void removeRoom(String roomID){
		roomLayout.remove(roomID);
	}

	public void loadFloorPlan(JSObject floorPlan){
		// add logic based on the JSON file that is sent
	}
}
