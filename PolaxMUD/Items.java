public abstract class Items {
    private String name;
    private int volume;

    public Items(String itemName, int litres) {
	name = itemName;
	volume = litres;
    }

    public String getName() {
	return name;
    }
    
    public int getVolume() {
	return volume;
    }

    public boolean equals(Items item) {
	return name == item.getName();
    }

    public String toString() {
	return name;
    }

}
