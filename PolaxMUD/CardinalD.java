public  class CardinalD {
    private String direction;
    private int value;

    public CardinalD (String dir) {
	direction = dir;
	switch (dir){
	case "North": value = 0;
	    break;
	case "East": value = 1;
	    break;
	case "South": value = 2;
	    break;
	case "West": value = 3;
	    break;
	}
    }

    public CardinalD (int value){
	this.value = value;
	switch (value){
	case 0: direction = "North";
	    break;
	case 1: direction = "East";
	    break;
	case 2: direction = "South";
	    break;
	case 3: direction = "West";
	    break;
	}
	    
    }

    public int getValue() {
	return value;
    }

    public String getDirection() {
	return direction;
    }
}
    

