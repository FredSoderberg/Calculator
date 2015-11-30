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

    public void UnlockKeyHole(CardinalD dir) {
	keyHoles.replace(dir,true);
    }

    public void UnlockBothKeyHoles(CardinalD dir) {
	this.UnlockKeyHole(dir);
	Room oppositeRoom = this.getAdjacentRoom(dir);
	oppositeRoom.UnlockKeyHole(dir.getOpp());
    }
    
    public void addAdjacentRooms(HashMap<CardinalD, Room> adjacentRooms) {
	this.adjacentRooms = adjacentRooms;
    }

    public void addCreature(Creatures creatures) {
	this.creatures.add(creatures);
    }

    public void addItem(Items itemToAdd) {
	items.add(itemToAdd);
    }

    public void removeItem(Items itemToRemove) {
	for (Items item : items) {
	    if(item.equals(itemToRemove)) {
		items.remove(item);
		return;
	    }
	}
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

    public boolean hasGot(Items itemToFind) {
	for (Items item : items) {
	    if(item.equals(itemToFind)) return true;
	}
	return false;
    }

    public Items getItem(Items itemToFind) {
	for (Items item : items) {
	    if (item.equals(itemToFind)) {
		return item;
	    }
	}
	assert(true);
	return null;
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
	
	String ret =
	    "You stand in " + name + "\n"
	    + "\nIn the room there is:\n" + occupants + localItems
	    + "\nThe exits are:\n" + exits;
	return ret;
    }
    
}
