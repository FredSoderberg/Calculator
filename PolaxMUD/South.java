public class South extends CardinalD {

    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof South);
    }

        public CardinalD getOpp() {
	return new North();
    }
    
    public String toString() {
        return "south";
    }
    
}
