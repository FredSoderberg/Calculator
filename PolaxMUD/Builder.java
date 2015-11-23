import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Builder {
    private File classRooms;
    private File courses;
    private File books;
    private Plane plane;
    
    public Builder(String classRooms,String courses,String books) {
	this.classRooms = new File(classRooms);
	this.courses = new File(courses);
	this.books = new File(books);
	plane = new Plane();
    }

    public void createRooms() {
	try {
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");
		
		ArrayList<String> keyHoles = new ArrayList<String>();
		for (int i = 5; i < 9; i++) keyHoles.add(parse[i]);
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

    public void linkRooms(){
	try {
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");

		ArrayList<CardinalD> directions = createDirTable();
		HashMap<CardinalD,Room> adjacentRooms = new HashMap<CardinalD,Room>();

		for (int i = 1; i < 5; i++) {
		    if(!parse[i].equals("X")){
			Room addRoom = plane.searchFor(parse[i]);
			adjacentRooms.put(directions.get(i-1), addRoom);
		    }
		}
		plane.searchFor(parse[0]).addAdjacentRooms(adjacentRooms);
	    }
	    scan.close();
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
    
    private HashMap<CardinalD,Boolean> createKeyHoles(ArrayList<String> keyHoles) {
	ArrayList<CardinalD> directions = createDirTable();
	HashMap<CardinalD,Boolean> retList = new HashMap<CardinalD,Boolean>();
	
	for (int i = 0; i < 4; i++) {
	    if(keyHoles.get(i).equals("False")){
		retList.put(directions.get(i),false);
	    }
	    else if (keyHoles.get(i) == "True"){
		retList.put(directions.get(i),true);
	    }
	}
	return retList;
    }

    private ArrayList<CardinalD> createDirTable(){
	ArrayList<CardinalD> directions = new ArrayList<CardinalD>();
	directions.add(new CardinalD(0));
	directions.add(new CardinalD(1));
	directions.add(new CardinalD(2));
	directions.add(new CardinalD(3));
	return directions;
    }
    
    public Plane getFinishedPlane() {
	return plane;
    }

}
