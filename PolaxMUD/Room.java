public class Room {
    
    private String name;
    private String[] room;
    private String[] locked;
    private ArrayList<Creatures> creatures;
    private ArrayList<Items> items;

    public Room(String name, String[] room, String[] locked, ArrayList<Creatures> creatures, ArrayList<Items> items) {
	this.name = name;
	this.room = room;
	this.locked = locked;
	this.creatures = creatures;
	this.items = items;
    }
    public Room() {
    }
    public boolean isExit(int direction) {
	if (room[direction] =! 'x'){
	    return true;
	}
	return false; 
    }
	/**	switch(direction) {
	case "north": if (room[0] =! 'x')
		return true;
	case "east": if (room[1] =! 'x')
		return true;
	case "south": if (room[2] =! 'x')
		return true;
	case "west": if (room[3] =! 'x')
		return true;
	deafault: return false;
	}
    }
	*/
    public boolean isLocked(int direction) {
	if (locked[direction] =! "true") {
	    return true;
	}
	return false;
    }
    public String nameOf(int direction) {
	return room[direction];
    }
    public boolean isyourName(String roomName) {
	return roomName == name; 
    }
    public String toString() {
	String ret = "You stand in room" + name "\n\n";
	for (

return ret;
    }
    
}
