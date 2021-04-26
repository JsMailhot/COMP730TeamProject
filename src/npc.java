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
	 * <code>	npc example_npc = new npc(new ArrayList<item>());</code>	// create new npc object
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
	public int buy() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int sell() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String talk() {
		// TODO Auto-generated method stub
		return greeting;
	}
	public void closeNPCDialog() {
		
	}
	

}