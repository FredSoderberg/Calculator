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
    
    public int getVolume(){
	return volume;
    }

}
