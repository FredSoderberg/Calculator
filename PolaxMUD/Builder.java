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
    Plane plane;
    
    public Builder(String classRooms,String courses,String books) {
	this.classRooms = new File(classRooms);
	this.courses = new File(courses);
	this.books = new File(books);
	plane = new Plane();
    }

    public void createClassRooms() {
	try {
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");
		
		ArrayList<String> keyHoles = new ArrayList<String>();
		for (int i = 4; i < 9; i++) keyHoles.add(parse[i]);
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

    private HashMap<CardinalD,Boolean> createKeyHoles(ArrayList<String> keyHoles) {
	ArrayList<CardinalD> directions = new ArrayList<CardinalD>();
	directions.add(new North());
	directions.add(new East());
	directions.add(new South());
	directions.add(new West());
	HashMap<CardinalD,Boolean> retList = new HashMap<CardinalD,Boolean>();
	
	for (int i = 0; i < 4; i++) {
	    if(keyHoles.get(i) == "false"){
		retList.put(directions.get(i),false);
	    }
	    else if (keyHoles.get(i) == "true"){
		retList.put(directions.get(i),true);
	    }
	}
	System.out.println(retList.size());
	return new HashMap<CardinalD,Boolean>();
    }

    public Plane getFinishedPlane() {
	return plane;
    }

}

