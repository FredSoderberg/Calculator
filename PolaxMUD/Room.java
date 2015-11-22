import java.util.*;

public class Room {
    private String name;
    private HashMap<CardinalD, Room> adjacentRooms;
    private HashMap<CardinalD, Boolean> keyHoles;
    private ArrayList<Creatures> creatures;
    private ArrayList<Items> items;

    public Room(String newName, HashMap<CardinalD,Boolean> unlocks) {
        name = newName;
	keyHoles = unlocks;
    }
    
    public Room(String newName, HashMap<CardinalD, Room> adjacentRooms, HashMap<CardinalD, Boolean> keyHoles) {
	this.name = newName;
	this.adjacentRooms = adjacentRooms;
	this.keyHoles = keyHoles;
    }
    
    public Room(String newName,HashMap<CardinalD, Room> adjacentRooms, HashMap<CardinalD, Boolean> keyHoles, ArrayList<Creatures> creatures, ArrayList<Items> items) {
	this.name = newName;
	this.adjacentRooms = adjacentRooms;
	this.keyHoles = keyHoles;
	this.creatures = creatures;
	this.items = items;
    }
    
    public Room() {
    }
    
    public boolean isExit(CardinalD dir) {
	return adjacentRooms.containsKey(dir);
    }
    
    public boolean isUnlocked(CardinalD dir) {
	return keyHoles.get(dir);
    }

    public Room getAdjacentRoom(CardinalD dir){
	return adjacentRooms.get(dir);
    }
   
    public boolean isYourName (String roomName) {
	return roomName == name; 
    }
    
    public String toString() {
	String ret = "You stand in room" + name + "\n\n";
	return ret;
    }
    
}
