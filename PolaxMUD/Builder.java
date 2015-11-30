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
    private ArrayList<Courses> courseList;
    private ArrayList<Book> bookList;
    
    public Builder(String classRooms,String courses,String books) {
	this.classRooms = new File(classRooms);
	this.courses = new File(courses);
	this.books = new File(books);
	this.plane = new Plane();
	this.courseList = new ArrayList<Courses>();
	this.bookList = new ArrayList<Book>();
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

    public void createBooks() {
	try {
	    Scanner scan = new Scanner(this.books);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");
		Book newBook = new Book(parse[0],
					parse[1],
					Integer.valueOf(parse[2]),
					Integer.valueOf(parse[3]));
		bookList.add(newBook);
	    }
    	scan.close();
	}
    	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
    
    public void createCourses() {
	try {
	    Scanner scan = new Scanner(this.courses);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");
		Book courseBook = null;
		for (Book book : bookList) {
		    if(book.equals(parse[1])) courseBook = book;
		}
		Courses newCourse = new Courses(parse[0],
						courseBook,
						Integer.valueOf(parse[2]));
		courseList.add(newCourse);
	    }
    	scan.close();
	}
    	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public void addTeachers() {
	ArrayList<Room> classRooms = plane.getClassRooms();
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	for (Courses course : courseList) {
	    System.out.println("Skapar " + course);
	    Teacher newTeacher = new Teacher(course+" teacher",course);
	    teacherList.add(newTeacher);
	}
	for (int i = 0; i < classRooms.size(); i++) {
	    if(i < teacherList.size()) {
		System.out.println("test!");
		classRooms.get(i).addCreature(teacherList.get(i));
	    }
	    else {
		return;
	    }
	}
    }

    public void addStudents() {
	
    }

    public void addKeys() {
	int amountOfLocked = 0;
	try {
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String[] parse = scan.nextLine().split(";");
		for (int i = 5; i < 9; i++) {
		    if(parse[i].equals("False")) amountOfLocked++;
		}
	
	    }
	    scan.close();
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	int numKeysToCreate = (int) Math.round((amountOfLocked/2) * 1.5);
	while(numKeysToCreate>0){
	    for (Room classRoom : plane.getClassRooms()) {
		if (numKeysToCreate > 0){
		    numKeysToCreate--;
		    classRoom.addItem(new Key());
		}
		else{
		    return;
		}
	    }
	    for (Room hallway : plane.getHallways()) {
		if (numKeysToCreate > 0){
		    numKeysToCreate--;
		    hallway.addItem(new Key());
		}
		else{
		    return;
		}
	    }
	}
    }
    

    private ArrayList<CardinalD> createDirTable(){
	ArrayList<CardinalD> directions = new ArrayList<CardinalD>();
	directions.add(new North());
	directions.add(new East());
	directions.add(new South());
	directions.add(new West());
	return directions;
    }
    
    public Plane getFinishedPlane() {
	return plane;
    }

}
