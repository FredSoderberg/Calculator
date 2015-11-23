import java.util.*;

public class Game {
    
    public static void main(String[] args) {
	boolean quit = false;
	boolean success = true;
      
	Builder newBuild = new Builder("Classrooms.txt","Classrooms.txt","Classrooms.txt");
	newBuild.createRooms();
	newBuild.linkRooms();
	Plane gamePlane = newBuild.getFinishedPlane();
	ArrayList<Courses> doneCourses = new ArrayList<Courses>();
	Avatar avatar = new Avatar(doneCourses,gamePlane.getStartingPoint());

	Scanner userInput = new Scanner(System.in);
	
	while(!quit) {
	    if (success) {
		System.out.println(avatar.whichRoom());
	    }
	    String input = userInput.nextLine();
	    success = whatToDo(input, avatar);
	}
    }
    
    
    public static boolean whatToDo(String input, Avatar avatar) {
	String[] commands = input.split(" ");
	try{
	    String newCommand = commands[0];
	    
	    switch (newCommand) {
	    case "go":
		return avatar.moveAvatar(commands[1]);
	    default: System.out.println("Not a valid command, try again!");
		return false;
	    }
	}
	catch (Exception e) {
	    System.out.println("Please Specify more then '"+commands[0]+"', try again!");
	    return false;

	}
    }
    

}
