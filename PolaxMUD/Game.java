import java.util.*;

public class Game {
    
    public static void main(String[] args) {
	boolean quit = false;
	boolean success = true;
      
	Builder newBuild = new Builder("Classrooms.txt","Courses.txt","Books.txt");


	newBuild.createRooms();
	newBuild.linkRooms();
	newBuild.addKeys();
	newBuild.createBooks();
	newBuild.createCourses();
	newBuild.addTeachers();

	
	Plane gamePlane = newBuild.getFinishedPlane();
	ArrayList<Courses> doneCourses = new ArrayList<Courses>();
	Avatar avatar = new Avatar(doneCourses,gamePlane.getStartingPoint());

	Scanner userInput = new Scanner(System.in);
	
	while(!quit) {
	    if (success) {
		System.out.print("\033[2J\033[;H");
		System.out.println("\n\n\n\n\n\n\n\nYour current HP is: "+avatar.getHP()+"\n"+avatar.whichRoom());
	    }
	    String input = userInput.nextLine();
	    success = whatToDo(input, avatar);
	}
    }
    
    
    public static boolean whatToDo(String input, Avatar avatar) {
	String[] commands = input.split(" ");
	try{
	    String nextCommand = commands[1];
	}
	catch (Exception e) {
	    System.out.println("Please Specify more then '"+commands[0]+"', try again!");
	    return false;
	}
	try{
	    CardinalD newDir = new North();
	    switch (commands[0]) {
	    case "go": newDir = getCardinalD(commands[1]);
		return avatar.actionMove(newDir);
	    case "pickup":
		return avatar.actionPickup(commands[1]);
	    case "unlock":newDir = getCardinalD(commands[1]);
		return avatar.actionUnlock(newDir);
	    case "drop":
		return avatar.actionDrop(commands[1]);
	    case "talk":
		return avatar.actionTalkTo(commands[1]);
	    default: System.out.println("Not a valid command, try again!");
		return false;
	    }
	}
	catch (Exception e){
	    return false;
	}
    }

    public static CardinalD getCardinalD(String dir) throws Exception{
	CardinalD newDir;
	switch(dir) {
	case "north": newDir = new North();
	    break;
	case "east": newDir = new East();
	    break;
	case "south": newDir = new South();
	    break;
	case "west": newDir = new West();
	    break;
	default: System.out.println("Not a acceptable direction");
	    throw new Exception();
	}
	return newDir;
    }

}
