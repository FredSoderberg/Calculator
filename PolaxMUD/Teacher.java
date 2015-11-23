public class Teacher extends Creature {
    private Courses course;
    private Questions question;
    
    public Teacher(String name, Courses course, Questions question) {
        super(name);
        this.course = course;
        this.question = question;
    }
}
