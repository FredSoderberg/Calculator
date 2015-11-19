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
	this.backpack = new Backpack();
	this.inRoom = inRoom;
    }




    private class Backpack {
	private int space = 10;
	private int freeSpace;
	private ArrayList<Items> items;
    }

    private Backpack () {
	freespace = space;
	items = new ArrayList<Items>();
    }
    
    private void addItem(Items item) {
	items.add(item);
    }

    private void removeItem(Items item) {
	items.remove(item);
    }




    
    public void moveTo(Room newRoom) {
	currentRoom = newRoom;
    }

    public void pickUp(Items item) {
	inventory.addItem(item);
    }

    public void drop(Items item){
	inventory.removeItem(item);
    }
    public Room whichRoom(){
	return room;
    }

}
