import java.util.Random;

public class Student extends Creatures {
    private String courseAnsw;
    private Book courseBook;
    private Courses courseComp;
    private Courses courseCurr;
    
    public Student(String name, Book courseBook, Courses courseComp, Courses courseCurr) {
        super(name);
	this.courseAnsw = courseAnsw;
        this.courseBook = courseBook;
        this.courseComp = courseComp;
        this.courseCurr = courseCurr;
    }

    public void addBook() {
	courseBook = courseCurr.getCourseBook();
    }

    public boolean gotBook() {
	if(courseBook != null) return true;
	return false;
    }

    public Courses getCourseCurr() {
	return courseCurr;
    }

    public boolean tradeWith() {
        if (!gotBook()) {
	     Random random = new Random();
	    int rand = random.nextInt(101);
            if (50 > rand) {
                System.out.println("Here take this book for " + courseComp + ".");
		addBook();
		return true;
            }
            else {
                System.out.println("The right answer in " + courseComp + " is " + courseAnsw +".");
		addBook();
		return true;
            }
        }
	System.out.println("I already have the book.... go away!");
        return false;
    } 
    
    public void talkWith() {
	if (gotBook()) {
	    System.out.println("Hi! i want the book for "+courseCurr+"! Gimme! and i have completed "+courseComp+"!");
	} else {
	    System.out.println("You again! get lost!");
	}
    }

    public String toString() {
	return "Student";
    }
}
