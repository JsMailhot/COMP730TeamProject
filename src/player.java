import java.util.ArrayList;
/** <pre>
 * A player has many characteristics.
 * Example of creating a default player:
 * 	<code>player default_player = new player();</code>	// create a default player
 * </pre> */
public class player extends actor {
	/** <pre>
	 * Default player that takes no parameters
	 * Example of creating a default player that takes no parameters:
	 * <code>	player example_player = new player();</code>	// create new player object
	 * </pre> */
	public player()
	{
		super();
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Simple player that takes one parameter
	 * Example of creating a complex player that takes one parameter:
	 * <code>	player example_player = new player(new ArrayList<item>());</code>	// create new player object
	 * </pre> */
	public player(ArrayList<item> items)
	{
		super(items);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items)
	{
		super(gold, items);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats)
	{
		super(gold, items, Stats);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player");</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type)
	{
		super(gold, items,Stats, type);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name");</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name)
	{
		super(gold, items, Stats, type, name);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc");</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc)
	{
		super(gold, items, Stats, type, name, desc);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null);</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem)
	{
		super(gold, items, Stats, type, name, desc, droppedItem);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0);</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0, new weapon());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold, primary);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0, new weapon(), null);</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold, primary, secondary);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0, new weapon(), null, new armor());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary, armor Armor)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold, primary, secondary, Armor);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0, new weapon(), null, new armor(), new misc());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary, armor Armor, misc ring)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold, primary, secondary, Armor, ring);
		questList = new ArrayList<quest>();
	}
	/** <pre>
	 * Complex player that takes several parameters
	 * Example of creating a complex player that takes several parameters:
	 * <code>	player example_player = new player(0, new ArrayList<item>(), new stats(), "player", "player name", "player desc", null, 0, new weapon(), null, new armor(), new misc(), new ArrayList<quest>());</code>	// create new player object
	 * </pre> */
	public player(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary, armor Armor, misc ring, ArrayList<quest> questList)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold, primary, secondary, Armor, ring);
		this.questList = questList;
	}
	/** <pre>
	 * Boolean determining if the player has died
	 * Example of defining ifDie:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>inventoryPlayer.ifDie = true;</code>	// set the ifDie to a boolean value
	 * </pre> */
	Boolean ifDie = false;
	/** <pre>
	 * A list of quests belonging to the player
	 * Example of defining questList:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>inventoryPlayer.questList = new ArrayList<quest>();</code>	// set the questList to a new ArrayList<quest> variable
	 * </pre> */
	ArrayList<quest> questList;
}