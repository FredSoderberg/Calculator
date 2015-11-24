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
	adjacentRooms = new HashMap<CardinalD, Room>();
	creatures = new ArrayList<Creatures>();
	items = new ArrayList<Items>();
    }
    
    public Room() {
    }

    public boolean isExit(CardinalD dir) {
	return adjacentRooms.containsKey(dir);
    }
    
    public boolean isUnlocked(CardinalD dir) {
	return keyHoles.get(dir);
    }

    public void addAdjacentRooms(HashMap<CardinalD, Room> adjacentRooms) {
	this.adjacentRooms = adjacentRooms;
    }

    public void addCreatures(ArrayList<Creatures> creatures) {
	this.creatures = creatures;
    }

    public void addItems(ArrayList<Items> items) {
	this.items = items;
    }
    
    public Room getAdjacentRoom(CardinalD dir){
	return adjacentRooms.get(dir);
    }

    public String getName() {
	return name;
    }
   
    public boolean isYourName (String roomName) {
	return name.equals(roomName); 
    }
    
    public String toString() {

	String occupants = "";
	String localItems = "";
	String exits = "";
	for (Creatures creature : creatures) occupants += "a "+creature.getName()+"\n";
	for (Items currItem : items) localItems += "a "+currItem.getName()+"\n";
	for(CardinalD dir: adjacentRooms.keySet()){
            exits += dir  +" - "+ adjacentRooms.get(dir).getName();
	}
	
	String ret = "You stand in " + name + "\n"
	    + "\nIn the room there is:\n" + occupants + localItems
	    + "\nThe exits are:\n" + exits + "\n";
	return ret;
    }
    
}
