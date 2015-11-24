public class West extends CardinalD {

    @Override
    public int hashCode() {
        return 3;
    }

        @Override
    public boolean equals(Object o) {
        return (o instanceof West);
    }
    
    public String toString() {
        return "west";
    }
    
}
