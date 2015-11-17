package symbolic;

public abstract class Binary extends Sexpr{
    Sexpr left;
    Sexpr right;

    public Binary() {
    }

    public String toString() {
	return "("+left+" "+getName()+" "+right+")";
    }
}
