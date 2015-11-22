import java.util.*;

public class Game {
    
    public static void main(String[] args) {
	boolean quit = false;
	boolean success = true;
	
	Builder newBuild = new Builder("Classrooms.txt","Classrooms.txt","Classrooms.txt");
	newBuild.createClassRooms(plane);

	

	Scanner userInput = new Scanner(System.in);
	
	while(!quit) {
	    if (success) {
		System.out.println(avatar.whichRoom());
	    }
	    String input = userInput.nextLine();
	    success = newGame.whatToDo(input);
	}
    }
    
    
    public boolean whatToDo(String input) {
	String[] commands = input.split(" ");
	try{
	    String newCommand = commands[0];
	    
	    switch (newCommand) {
	    case "go":
		return this.go(commands[1]);
	    default: System.out.println("Not a valid command, try again!");
		return false;
	    }
	}
	catch (Exception e) {
	    System.out.println("Please Specify more then '"+commands[0]+"', try again!");
	    return false;

	}
    }
    
    public boolean go(String direction) {
	Room currRoom = avatar.whichRoom();
	CardinalD newDir;
	System.out.printf(direction);
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
