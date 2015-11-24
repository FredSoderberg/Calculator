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

    public boolean moveAvatar(String direction) {
	Room currRoom = this.whichRoom();
	CardinalD newDir;
	switch(direction) {
	case "north": newDir = new North();
	    break;
	case "east": newDir = new East();
	    break;
	case "south": newDir = new South();
	    break;
	case "west": newDir = new West();
	    break;
	default: System.out.println("Not a acceptable direction");
	    return false;

	if(currRoom.isExit(newDir) && currRoom.isUnlocked(newDir)){
	    System.out.printf("YAY!!!");
	    Room newRoom = currRoom.getAdjacentRoom(newDir);
	    this.moveTo(newRoom);
	    return true;
	}
	else if(currRoom.isExit(newDir) && !currRoom.isUnlocked(newDir)){
	    System.out.println("Sorry, the door is locked, use a key if you have one!");
	}
	else{
	    System.out.println("Not an exit!");
	}
	return false;
    }

}
