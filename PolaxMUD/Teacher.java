public class Teacher extends Creatures {
    private Courses course;
    
    public Teacher(String name, Courses course) {
        super(name);
        this.course = course;
    }

    public void talkWith() {
        System.out.println("I am a teacher for " + course + ".");
    }
}
