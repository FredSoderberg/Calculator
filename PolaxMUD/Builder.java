import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Builder {
    File classRooms;
    File courses;
    File books;

    public Builder(String classRooms,String courses,String books) {
	this.classRooms = new File(classRooms);
	this.courses = new File(courses);
	this.books = new File(books);
    }

    public void createClassRooms(Plane plane) {
	try {
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");

		String keyHoles = "";
		for (int i = 4; i < 9; i++) keyHoles += parse[i];
		
		HashMap<CardinalD,Boolean> unlocks = createKeyHoles(keyHoles);
		Room newRoom = new Room(parse[0], unlocks);
		
		if(parse[0].startsWith("Hallway")){
		    System.out.println("Creating hallway: " + parse[0]);
		    plane.addHallway(newRoom);
		}
		else {
		    System.out.println("Creating classroom: " + parse[0]);
		    plane.addClassRoom(newRoom);
		}
	    }
	    scan.close();
	}
    	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    private HashMap<CardinalD,Boolean> createKeyHoles(String keyHoles) {
	return new HashMap<CardinalD,Boolean>();
    }

}

