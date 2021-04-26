import java.util.ArrayList;

public class enemy extends actor {
	/** <pre>
	 * Default enemy does not require any specified variables
	 * Example of creating a default enemy:
	 * <code>	enemy example_enemy = new enemy(new ArrayList<item>());</code>	// create new enemy object
	 * </pre>*/
	public enemy()
	{
		super();
	}
	/** <pre>
	 * Complex enemy that takes one parameter
	 * Example of creating a complex enemy that takes one parameter:
	 * <code>	enemy example_enemy = new enemy(new ArrayList<item>());</code>	// create new enemy object
	 * </pre> */
	public enemy(ArrayList<item> items)
	{
		super(items);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>());</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items)
	{
		super(gold, items);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats());</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats)
	{
		super(gold, items, Stats);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats(), "enemy");</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats, String type)
	{
		super(gold, items,Stats, type);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats(), "enemy", "enemy name");</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats, String type, String name)
	{
		super(gold, items, Stats, type, name);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats(), "enemy", "enemy name", "enemy desc");</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc)
	{
		super(gold, items, Stats, type, name, desc);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats(), "enemy", "enemy name", "enemy desc", null);</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem)
	{
		super(gold, items, Stats, type, name, desc, droppedItem);
	}
	/** <pre>
	 * Complex enemy that takes several parameters
	 * Example of creating a complex enemy that takes several parameters:
	 * <code>	enemy example_enemy = new enemy(0, new ArrayList<item>(), new stats(), "enemy", "enemy name", "enemy desc", null, 0);</code>	// create new enemy object
	 * </pre> */
	public enemy(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold);
	}
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int block() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String taunt() {
		// TODO Auto-generated method stub
		return null;
	}
	

}