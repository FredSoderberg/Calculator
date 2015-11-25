import java.util.*;

public class Avatar {
    private ArrayList<Courses> doneCourses;
    private ArrayList<Courses> undoneCourses;
    private int HP;
    private Backpack inventory;
    private Room inRoom;

    public Avatar(ArrayList<Courses> doneCourses, Room inRoom) {
	this.doneCourses = doneCourses;
	this.undoneCourses = new ArrayList<Courses>();
	this.HP = 60;
	this.inventory = new Backpack();
	this.inRoom = inRoom;
    }

    private class Backpack {
	private int space = 10;
	private int freeSpace;
	private ArrayList<Items> items;
    

	private Backpack () {
	    freeSpace = this.space;
	    items = new ArrayList<Items>();
	}
    
	private void addItem(Items item) {
	    items.add(item);
	}

	private void removeItem(Items item) {
	    items.remove(item);
	}

	private boolean hasGot(Items item) {
	    for (Items itemInList : items) {
		if(itemInList.equals(item)) return true;
	    }
	    return false;
	}
    }

    public void moveTo(Room newRoom) {
	inRoom = newRoom;
    }

    public void pickUp(Items item) {
	inventory.addItem(item);
    }

    public void drop(Items item){
	inventory.removeItem(item);
    }
    public Room whichRoom(){
	return inRoom;
    }

    public boolean actionMove(CardinalD newDir) {
	if(inRoom.isExit(newDir) && inRoom.isUnlocked(newDir)){
	    System.out.printf("YAY!!!");
	    Room newRoom = inRoom.getAdjacentRoom(newDir);
	    this.moveTo(newRoom);
	    return true;
	}
	else if(inRoom.isExit(newDir) && !inRoom.isUnlocked(newDir)){
	    System.out.println("Sorry, the door is locked, use a key if you have one!");
	}
	else{
	    System.out.println("Not an exit!");
	}
	return false;
    }

    public boolean actionUnlock(CardinalD newDir) {
	//kolla ifall man har nyckel
	if(inventory.hasGot(new Key())) System.out.println("Jag HAR EN NYCKEL BIATCH!!!");
	//välja dörr
	//kolla om den finns
	//kolla om den är låst -.-
	//låsa upp specifik dörr
	//ta bort nyckeln
	return false;	
    }

    public boolean actionPickup(String item) {
	if(item.equals("key") && inRoom.hasGot(new Key())) {
	    Items keyToPickup = inRoom.getItem(new Key());
	    inRoom.removeItem(keyToPickup);
	    inventory.addItem(keyToPickup);
	    return true;
	}
	return false;
    }

}
