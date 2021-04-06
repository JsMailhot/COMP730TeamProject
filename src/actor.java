public interface actor {
	int health = 1;
	String type = "Defualt Type";
	stats Stats = new stats();
	String name = "Default Name";
	String desc = "Default Desc";
	item droppedItem = null;
	int droppedGold = 0;
	public int attack();
	public int block();
	public String taunt();
	

}