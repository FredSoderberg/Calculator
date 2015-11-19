public class Plan {
    ArrayList<Room> classRoom;
    Arraylist<Room> hallway;

    public void addClassRoom(Room classRoom) {
	this.classRoom.add(classRoom);
    }
    public void addhallway(Room hallway) {
	this.hallway.add(hallway);
    }
    public Room searchFor(String room){
	for (Room thisRoom : classRoom){
	    if (thisRoom.isyourName(room)){
		    return thisRoom;
		}
	}
	for (Room thishallway : hallway){
	    if(thisHallway.isyourName(Hallway)){
		return thisHallway;
	    }
	}
	System.out.println("Room not found");
	return classRoom.get(0);
    }
}
    
	
    
    
	
