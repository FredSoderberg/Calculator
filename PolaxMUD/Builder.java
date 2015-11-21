import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
	try{

	    //	    Scanner scan = new Scanner(this.classRooms).useDelimiter(";");
	    Scanner scan = new Scanner(this.classRooms);
	    while(scan.hasNextLine()){
		String out = scan.nextLine();
		String[] parse = out.split(";");		
		String newName = parse[0];
		Room newRoom = new Room(newName);
		System.out.println("Creating: " + parse[0]);
	    }
	    
	    scan.close();
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public void createHallways(Plane plane) {
	
    }
}
