import java.util.ArrayList;
/** <pre>
 * Generic actor abstract class that holds the basic requirements for an actor.
 * Example of extending using this abstract class:
 * <code>	public class newActor extends actor {</code>	// declare the extension
 * 	<code>	public hasInventory() {</code>	// declare constructor for class
 * 	<code>		super();</code>	# call super method
 * 	<code>		health = 1;</code>	// define super variables
 * 	<code>		name = new newName();</code>	// define new option variables
 * 	<code>	}</code>
 * 	<code>}</code>
 * </pre> */
public abstract class actor extends inventory {
	/** <pre>
	 * Default actor does not require any specified variables
	 * Example of generating a default actor inside extended class:
	 * <code>	super();</code>	// simply call super!
	 * </pre>*/
	public actor()
	{
		super();
		Stats = new stats();
		health = Stats.healthPool;
		type = "Defualt Type";
		name = "Default Name";
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(new ArrayList<item>);</code>	// simply call super!
	 * </pre>*/
	public actor(ArrayList<item> items)
	{
		super(items);
		Stats = new stats();
		type = "Defualt Type";
		name = "Default Name";
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items)
	{
		super(gold, items);
		Stats = new stats();
		type = "Defualt Type";
		name = "Default Name";
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>(), new stats());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats)
	{
		super(gold, items);
		this.Stats = Stats;
		type = "Defualt Type";
		name = "Default Name";
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type;
		name = "Default Name";
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type;
		this.name = name;
		desc = "Default Desc";
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type;
		this.name = name;
		this.desc = desc;
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null);</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type;
		this.name = name;
		this.desc = desc;
		this.droppedItem = droppedItem;
		droppedGold = 0;
		health = Stats.healthPool;
	}
	/** <pre>
	 * Complex actor does not require any specified variables
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0);</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type;
		this.name = name;
		this.desc = desc;
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
	}
	/** <pre>
	 * The base statistics of the actor that will be used in determining rolls
	 * Example of defining stats:
	 * <code>	</code>	// default stats
	 * 	<code></code>	// complex stats
	 * 	<code></code>	// returning stats
	 * </pre> */
	stats Stats;
	/** <pre>
	 * The type of actor this object is
	 * Example of defining type:
	 * <code>	type = "npc";</code>	// for npcs
	 * 	<code>type = "enemy";</code>	// for enemies
	 * 	<code>type = "player";</code>	// for players
	 * </pre> */
	String type;
	/** <pre>
	 * The name of actor for this object
	 * Example of defining name:
	 * <code>	type = "example name"</code>
	 * </pre> */
	String name;
	/** <pre>
	 * The description of actor for this object
	 * Example of defining desc:
	 * <code>	type = "example description"</code>
	 * </pre> */
	String desc;
	/** <pre>
	 * The item dropped when this actor dies
	 * Example of defining droppedItem:
	 * <code>	droppedItem = new item();</code>
	 * </pre> */
	item droppedItem;
	/** <pre>
	 * The gold dropped when this actor dies
	 * Example of defining droppedGold:
	 * <code>	droppedGold = 0;</code>
	 * </pre> */
	int droppedGold;
	/** <pre>
	 * The current health of this actor
	 * Example of defining health:
	 * <code>	health = Stats.healthPool;</code>	// set to full health
	 * 	<code>health = 1;</code>	// set to static health
	 * 	<code>health = 0;</code>	// set to dead
	 * </pre> */
	int health;
	/** <pre>
	 * The function called when this actor makes an attack on another actor
	 * Example of using the attack() function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int attack()
	{
		return Stats.attack;
	}
	/** <pre>
	 * The function called when this actor blocks another actors attack
	 * Example of using the block() function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int block()
	{
		return Stats.defense;
	}
	/** <pre>
	 * The function called when this actor taunts another actor
	 * Example of using the taunt() function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public String taunt()
	{
		return "taunt";
	}
}