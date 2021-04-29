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
		type = "Defualt Type".toLowerCase();
		name = "Default Name".toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Simple actor that takes one parameter
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(new ArrayList<item>);</code>	// simply call super!
	 * </pre>*/
	public actor(ArrayList<item> items)
	{
		super(items);
		Stats = new stats();
		type = "Defualt Type".toLowerCase();
		name = "Default Name".toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items)
	{
		super(gold, items);
		Stats = new stats();
		type = "Defualt Type".toLowerCase();
		name = "Default Name".toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>(), new stats());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats)
	{
		super(gold, items);
		this.Stats = Stats;
		type = "Defualt Type".toLowerCase();
		name = "Default Name".toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		name = "Default Name".toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		desc = "Default Desc".toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc");</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		droppedItem = null;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null);</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		droppedGold = 0;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0);</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
		primary = null;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0, new weapon());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
		this.primary = primary;
		secondary = null;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0, new weapon(), null);</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
		this.primary = primary;
		this.secondary = secondary;
		Armor = null;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0, new weapon(), null, new armor());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary, armor Armor)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
		this.primary = primary;
		this.secondary = secondary;
		this.Armor = Armor;
		ring = null;
	}
	/** <pre>
	 * Complex actor that takes several parameters
	 * Example of generating a complex actor inside extended class:
	 * <code>	super(0, new ArrayList<item>, new stats(), "actor type", "actor name", "actor desc", null, 0, new weapon(), null, new armor(), new misc());</code>	// simply call super!
	 * </pre>*/
	public actor(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, weapon primary, item secondary, armor Armor, misc ring)
	{
		super(gold, items);
		this.Stats = Stats;
		this.type = type.toLowerCase();
		this.name = name.toLowerCase();
		this.desc = desc.toLowerCase();
		this.droppedItem = droppedItem;
		this.droppedGold = droppedGold;
		health = Stats.healthPool;
		this.primary = primary;
		this.secondary = secondary;
		this.Armor = Armor;
		this.ring = ring;
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
	 * The primary weapon the actor is wielding
	 * Example of defining primary:
	 * <code>	primary = 0;</code>
	 * </pre> */
	weapon primary;
	/** <pre>
	 * The secondary weapon / armor / misc the actor is wielding
	 * Example of defining secondary:
	 * <code>	secondary = 0;</code>
	 * </pre> */
	item secondary;
	/** <pre>
	 * The armor the actor is wearing
	 * Example of defining Armor:
	 * <code>	Armor = 0;</code>
	 * </pre> */
	armor Armor;
	/** <pre>
	 * The ring the actor is wearing
	 * Example of defining ring:
	 * <code>	ring = 0;</code>
	 * </pre> */
	misc ring;
	/** <pre>
	 * The function that returns the actors attack damage
	 * Example of using the attack function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int attack()
	{
		int damage = Stats.attack;
		if(primary != null)
		{
			damage = damage + primary.qualities.attack;
		}
		if(secondary != null)
		{
			damage = damage + secondary.qualities.attack;
		}
		if(ring != null)
		{
			damage = damage + ring.qualities.attack;
		}
		return damage;
	}
	/** <pre>
	 * The function called when this actor makes an attack on another actor
	 * Example of using the attack function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int attack(actor target)
	{	// add up damage
		int damage = attack() - target.block(this);	//	subtract target block
		if(target.health > damage)
		{//	didn't kill target
			target.health = target.health - damage;
		}
		else
		{
			damage = target.health;
			target.health = 0;
		}
		return damage;
	}
	/** <pre>
	 * The function that returns the actors block damage
	 * Example of using the block function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int block()
	{
		int damage = Stats.defense;
		if(primary != null && primary.canCounter)
		{
			damage = damage + primary.qualities.defense;
		}
		if(secondary != null)
		{
			damage = damage + secondary.qualities.defense;
		}
		if(Armor != null)
		{
			damage = damage + (Armor.qualities.defense * ((Armor.isEnchanted ? 1 : 0) * 2));
		}
		if(ring != null)
		{
			damage = damage + ring.qualities.defense;
		}
		return damage;
	}
	/** <pre>
	 * The function called when this actor blocks another actors attack
	 * Example of using the block function:
	 * <code>	</code>
	 * 	<code></code>
	 * 	<code></code>
	 * </pre> */
	public int block(actor target)
	{	// add up block
		if(primary != null && primary.canCounter)
		{//	primary can counter (return damage)
			if(target.health >= primary.qualities.defense)
			{//	didn't kill target
				target.health = target.health - primary.qualities.defense;
			}
			else
			{
				target.health = 0;
			}
		}
		return block();
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
	@Override
	public String toString()
	{
		return name.toLowerCase();
	}
}