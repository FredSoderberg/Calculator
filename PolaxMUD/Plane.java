import java.util.ArrayList;
import java.util.HashMap;

public class Plane {
    private ArrayList<Room> classRoom;
    private ArrayList<Room> hallway;

    public Plane () {
	classRoom = new ArrayList<Room>();
	hallway = new ArrayList<Room>();
    }

    public void addClassRoom(Room classRoom) {
	this.classRoom.add(classRoom);
    }
    
    public void addHallway(Room hallway) {
	this.hallway.add(hallway);
    }

    public ArrayList<Room> getClassRooms(){
	return classRoom;
    }

    public ArrayList<Room> getHallways(){
	return hallway;
    }
    
    public Room getStartingPoint() {
	return hallway.get(0);
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
    
	
    
    
	
