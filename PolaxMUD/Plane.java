import java.util.ArrayList;
import java.util.HashMap;

public class Plane {
    private ArrayList<Room> classRoom;
    private ArrayList<Room> hallway;

    public void addClassRoom(Room classRoom) {
	this.classRoom.add(classRoom);
    }
    public void addhallway(Room hallway) {
	this.hallway.add(hallway);
    }
    public Room searchFor(String room){
	for (Room thisRoom : classRoom){
	    if (thisRoom.isYourName(room)){
		    return thisRoom;
		}
	}
	for (Room thisHallway : hallway){
	    if(thisHallway.isYourName(room)){
		return thisHallway;
	    }
	}
	System.out.println("Room not found");
	return classRoom.get(0);
    }
}
    
	
    
    
	
