public class Book extends Items {
    int year;
    String author;

    public Book(String name ,String author ,int year ,int litres) {
	super(name,litres);
	this.author = author;
	this.year = year;
    }
}
