import java.util.*;

class Game {
    private static Avatar avatar;
    private static Plane plane;


    public Game(){
	avatar = new Avatar();
	plane = new Plane();
    }
    
    public static void main(String[] args) {
	boolean quit = false;
	boolean success = true;
	Builder newBuild = new Builder("Classrooms.txt","Classrooms.txt","Classrooms.txt");
	newBuild.createClassRooms(plane);
	Game newGame = new Game();
	Scanner input = new Scanner(System.in);
	
	while(!quit) {
	    if (success) {
		System.out.println(avatar.whichRoom());
	    }
	
	
	    
	    System.out.println("Printing input: ");
	    String a = input.nextLine();
	    System.out.println(a);
	    
	    String[] words = a.split(" ");
	    
	    switch (words[0]) {
	    case "go": success = newGame.go(words[1]);
		break;
	    default: System.out.println("wrong input, try again!");
		success = false;
	    }
	}
    }
    
    
    public boolean go(String direction) {
	Room currRoom = avatar.whichRoom();
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
	}
	if(currRoom.isExit(newDir) && currRoom.isUnlocked(newDir)){
	    Room newRoom = currRoom.getAdjacentRoom(newDir);
	    avatar.moveTo(newRoom);
	    return true;
	}
	return false;
    }
}
