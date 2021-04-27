import java.util.ArrayList;
/** <pre>
 * A npc has many characteristics.
 * Example of creating a default npc:
 * 	<code>npc default_npc = new npc();</code>	// create a default npc
 * </pre> */
public class npc extends actor {
	/** <pre>
	 * Default npc does not require any specified variables
	 * Example of creating a default npc:
	 * <code>	npc example_npc = new npc();</code>	// create new npc object
	 * </pre>*/
	public npc()
	{
		super();
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes one parameter
	 * Example of creating a complex npc that takes one parameter:
	 * <code>	npc example_npc = new npc(new ArrayList<item>());</code>	// create new npc object
	 * </pre> */
	public npc(ArrayList<item> items)
	{
		super(items);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>());</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items)
	{
		super(gold, items);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats());</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats)
	{
		super(gold, items, Stats);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc");</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type)
	{
		super(gold, items,Stats, type);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc", "npc name");</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type, String name)
	{
		super(gold, items, Stats, type, name);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc", "npc name", "npc desc");</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc)
	{
		super(gold, items, Stats, type, name, desc);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc", "npc name", "npc desc", null);</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem)
	{
		super(gold, items, Stats, type, name, desc, droppedItem);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc", "npc name", "npc desc", null, 0);</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold);
		greeting = "Default Greeting";
	}
	/** <pre>
	 * Complex npc that takes several parameters
	 * Example of creating a complex npc that takes several parameters:
	 * <code>	npc example_npc = new npc(0, new ArrayList<item>(), new stats(), "npc", "npc name", "npc desc", null, 0, "HEY THERE!");</code>	// create new npc object
	 * </pre> */
	public npc(int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, String greeting)
	{
		super(gold, items, Stats, type, name, desc, droppedItem, droppedGold);
		this.greeting = greeting;
	}
	/** <pre>
	 * The greeting the npc uses
	 * Example of defining greeting:
	 * <code>	player greetingPlayer = new player();</code>	// generate a player
	 * 	<code>greetingPlayer.greeting = "Hey there!";</code>	// set the greeting to a new string variable
	 * </pre> */
	String greeting;
	/** <pre>
	 * The function for purchasing an item from another actor
	 * Example of buying an item:
	 * <code>	npc example_npc = new npc();</code>	// generate a npc
	 * 	<code>player example_player = new player();</code>	// generate a player
	 * 	<code>misc example_misc = new misc("Misc Item", "Misc Desc", new stats(0,0,0,0,0), "Misc", 50);</code>	// generate an item
	 * 	<code>example_player.items.add(example_misc);</code>	// add the item to the player
	 * 	<code>example_npc.buy(example_player, example_misc);</code>	// buy the item from the player
	 * </pre> */
	public int buy(actor target, item toBePurchased) {
		if(target.items.contains(toBePurchased) && gold >= toBePurchased.price)
		{
			gold = gold - toBePurchased.price;
			target.gold = target.gold + toBePurchased.price;
			items.add(toBePurchased);
			target.items.remove(toBePurchased);
		}
		return gold;
	}
	/** <pre>
	 * The function for purchasing an item from another actor
	 * Example of buying an item:
	 * <code>	npc example_npc = new npc();</code>	// generate a npc
	 * 	<code>player example_player = new player();</code>	// generate a player
	 * 	<code>misc example_misc = new misc("Misc Item", "Misc Desc", new stats(0,0,0,0,0), "Misc", 50);</code>	// generate an item
	 * 	<code>example_player.items.add(example_misc);</code>	// add the item to the player
	 * 	<code>example_npc.buy(example_player, 0);</code>	// buy the item from the player (index may vary)
	 * </pre> */
	public int buy(actor target, int toBePurchased) {
		if(target.items.size() > toBePurchased && target.items.contains(target.items.get(toBePurchased)) && gold >= target.items.get(toBePurchased).price)
		{
			gold = gold - target.items.get(toBePurchased).price;
			target.gold = target.gold + target.items.get(toBePurchased).price;
			items.add(target.items.get(toBePurchased));
			target.items.remove(toBePurchased);
		}
		return gold;
	}
	/** <pre>
	 * The function for selling an item to another actor
	 * Example of selling an item:
	 * <code>	npc example_npc = new npc();</code>	// generate a npc
	 * 	<code>player example_player = new player();</code>	// generate a player
	 * 	<code>misc example_misc = new misc("Misc Item", "Misc Desc", new stats(0,0,0,0,0), "Misc", 50);</code>	// generate an item
	 * 	<code>example_npc.items.add(example_misc);</code>	// add the item to the player
	 * 	<code>example_npc.sell(example_player, 0);</code>	// sell the item to the player (index may vary)
	 * </pre> */
	public int sell(actor target, item toBePurchased) {
		if(items.contains(toBePurchased) && target.gold >= toBePurchased.price)
		{
			target.gold = target.gold - toBePurchased.price;
			gold = gold + toBePurchased.price;
			target.items.add(toBePurchased);
			items.remove(toBePurchased);
		}
		return gold;
	}
	/** <pre>
	 * The function for selling an item to another actor
	 * Example of selling an item:
	 * <code>	npc example_npc = new npc();</code>	// generate a npc
	 * 	<code>player example_player = new player();</code>	// generate a player
	 * 	<code>misc example_misc = new misc("Misc Item", "Misc Desc", new stats(0,0,0,0,0), "Misc", 50);</code>	// generate an item
	 * 	<code>example_npc.items.add(example_misc);</code>	// add the item to the player
	 * 	<code>example_npc.sell(example_player, 0);</code>	// sell the item to the player (index may vary)
	 * </pre> */
	public int sell(actor target, int toBePurchased) {
		if(items.size() > toBePurchased && items.contains(items.get(toBePurchased)) && gold >= items.get(toBePurchased).price)
		{
			target.gold = target.gold - items.get(toBePurchased).price;
			gold = gold + items.get(toBePurchased).price;
			target.items.add(items.get(toBePurchased));
			items.remove(toBePurchased);
		}
		return gold;
	}
	public String talk() {
		// TODO Auto-generated method stub
		return greeting;
	}
	public void closeNPCDialog() {
		
	}
}