public abstract class actor extends inventory {
	int health = 1;
	String type = "Defualt Type";
	stats Stats = new stats();
	String name = "Default Name";
	String desc = "Default Desc";
	item droppedItem = null;
	int droppedGold = 0;
	public int attack()
	{
		return Stats.attack;
	}
	public int block()
	{
		return Stats.defense;
	}
	public String taunt()
	{
		return "taunt";
	}
}