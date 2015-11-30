public class Courses {
    private String name;
    private Book courseBook;
    private int HP;
    private String question;
    private String[] questAlt;


    public Courses(String name ,Book courseBook ,int HP ,String question ,String[] questAlt) {
        this.name = name;
        this.courseBook = courseBook;
        this.HP = HP;
	this.question = question;
	this.questAlt = questAlt;
    }

        public Courses(String name ,Book courseBook ,int HP) {
        this.name = name;
        this.courseBook = courseBook;
        this.HP = HP;
    }

    public Book getCourseBook() {
	return courseBook;
    }

    public String toString() {
	return name;
    }
}
