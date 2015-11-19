JCC = javac
JUNITTEST = org.junit.runner.JUnitCore
CLASSPATH =.:junit-4.10.jar:hamcrest-core-1.3.jar
JFLAGS = -g -ea

CLASSES = \
	Avatar.java




.SUFFIXES: .java .class

.java.class:
	$(JCC) $(JFLAGS) $*.java

default: classes

all: $(CLASSES:.java=.class)

test: all
	java -cp $(CLASSPATH) $(JUNITTEST) TestAll

doc: all
	javadoc -d docs

clean:
	rm -f *.class
	rm -rf documentation
	rm -f *.java~
	rm -f *#
