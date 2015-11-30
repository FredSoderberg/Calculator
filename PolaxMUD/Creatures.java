public abstract class Creatures {
    private String name;
    
    public Creatures(String newName) {
	name = newName;
    }
    public abstract void talkWith();
    
    public String getName() {
        return this.name;
    }
}
