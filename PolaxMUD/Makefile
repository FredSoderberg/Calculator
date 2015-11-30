JFLAGS = -g
JUNITTEST = org.junit.runner.JUnitCore
CLASSPATH =.:junit-4.10.jar:hamcrest-core-1.3.jar
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Avatar.java\
	Book.java\
	Builder.java\
	CardinalD.java\
	Courses.java\
	Creatures.java\
	East.java\
	Game.java\
	Items.java\
	Key.java\
	North.java\
	Plane.java\
	Room.java\
	South.java\
	Student.java\
	Teacher.java\
	West.java




default: classes

classes: $(CLASSES:.java=.class)

test: all
	java -cp $(CLASSPATH) $(JUNITTEST) TestAll

doc: all
	javadoc -d docs

clean:
	rm -f *.class
	rm -rf documentation
	rm -f *.java~
	rm -f *#
