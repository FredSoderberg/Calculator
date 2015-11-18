package symbolic;
import java.util.*;
import java.text.*;

public abstract class Sexpr{

   public Sexpr() {
   }

    public abstract String getName();
    
    public double getValue() {
    }
    public int priority() {
    }
    public boolean isConstant() {
    }
    public abstract Sexpr eval();

    public static void main(String[] args) {
	Parser p = new Parser();
	Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
	
	while (true) {
	    //    try {
		System.out.print("? ");
		Sexpr e = p.statement();
		System.out.println("Inläst uttryck: " + e);  // För kontroll
		System.out.println(e.eval(variables));
		return;
	        // } catch () {
		
	    }
    }
}



