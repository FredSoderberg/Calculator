
public class Symbolic {
    
    public Symbolic() {
    }
}

public static Sexpr sin(Sexpre arg) {
    if (arg.isConstant())
	return new Constant(Math.sin(arg.getValue()));
    else
	reurn new Sin(arg);
}
public static Sexpr cos(..) {
}
