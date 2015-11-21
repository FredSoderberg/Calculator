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

    public Avatar(){
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

}
