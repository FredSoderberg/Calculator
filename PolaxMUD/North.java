public class North extends CardinalD {

    @Override
    public int hashCode() {
        return 0;
    }

        @Override
    public boolean equals(Object o) {
        return (o instanceof North);
    }

    public CardinalD getOpp() {
	    return new South();
    }
    
    public String toString() {
        return "north";
    }
    
}
