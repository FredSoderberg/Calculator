import java.util.Scanner;

abstract class Main {
    public static void main(String[] args) {
	boolean quit = false;
	boolean success = true;
	
	ArrayList<Courses> doneCourses = new ArrayList<Courses>();
	Room room = new Room();
	Plan plan = new Plan();
	Avatar avatar = new Avatar(doneCourses, room);

	while(!quit) {
	    if (success) {
		System.out.println(avtar.whichRoom())
	    }
	
	
	Scanner in = new Scanner(System.in);
	String a;
	a = in.nextLine();
	System.out.println(a);
	String[] words = a.split(" ");

	for (String word : words)
	    {
		System.out.println(word);
	    }
	
    switch(word[0]) {
    case go: success = avatar.go(word[1]);
	break;
      
    default: "wrong input, try again!";
    }
    }
    }
    
    public boolean go(String direction) {
	Room currRoom = avatar.whichRoom();
	switch(direction) {
	case "north": direction = 0;
	    break;
	case "east": direction = 1;
	    break;
	case "south": direction = 2;
	    break;
	case "west": direction = 3;
	    break;
	deafault: System.out.println("Not a acceptable direction")
		return false;
	}
	if (currRoom.isExit(direction) && !currRoom.isLocked(direction)){
	    String roomTo = currRoom.nameOf(direction);
	    Room newRoom = plan.searchFor(roomTo);
	    avatar.moveTo(newRoom);
	    
    }
}

