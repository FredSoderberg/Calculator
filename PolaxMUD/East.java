public class East extends CardinalD {

    @Override
    public int hashCode() {
        return 2;
    }

        @Override
    public boolean equals(Object o) {
        return (o instanceof East);
    }

        public CardinalD getOpp() {
	return new West();
    }

    
    public String toString() {
        return "east";
    }
    
}
