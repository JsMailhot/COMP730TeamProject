/** <pre>
 * Generic item abstract class which holds that basic requirements for an item
 * Example of extending using this abstract class:
 * <code>	public class newItem extends item {</code>	// declare the extension
 * 	<code>	public newItem() {</code>	// declare constructor for class
 * 	<code>		super();</code>	// call super method
 * 	<code>		itemName = "item name";</code>	// define super variables
 * 	<code>		itemVariable = new itemVariable();</code>	// define new item variables
 * 	<code>	}</code>
 * 	<code>}</code>
 * </pre> */
public abstract class item {
	/** <pre>
	 * Default item does not require any specified variables
	 * Example of generating a default item inside extended class:
	 * <code>	super();</code>	// simply call super!
	 * </pre> */
	public item()
	{
		itemName = "Nothing";
		itemDesc = "Empty";
		qualities = new stats();
		category = "All";
		price = 0;
	}
	/** <pre>
	 * Complex item only requires a string variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick");</code>	// call super with the variable
	 * </pre> */
	public item(String itemName)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		itemDesc = "Empty";
		qualities = new stats();
		category = "All";
		this.price = 0;
	}
	/** <pre>
	 * Complex item requires two string variables
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!");</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		qualities = new stats();
		category = "All";
		this.price = 0;
	}
	/** <pre>
	 * Complex item requires two string variables and a stats variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		category = "All";
		this.price = 0;
	}
	/** <pre>
	 * Complex item requires three string variables
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", "weapon");</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, String category)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		this.qualities = new stats();
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = 0;
	}
	/** <pre>
	 * Complex item requires three string variables and a stats variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats(), "weapon");</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities, String category)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = 0;
	}
	/** <pre>
	 * Complex item requires three string variables, a stats variable and an integer variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats(), "weapon", 0);</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities, String category, int price)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = price;
	}
	/** <pre>
	 * Complex item requires a string variable and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "broken".toCharArray());</code>	// call super with the variable
	 * </pre> */
	public item(String itemName, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		itemDesc = "Empty";
		qualities = new stats();
		category = "All";
		this.price = 0;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex item requires two string variables and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", "broken".toCharArray());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		qualities = new stats();
		category = "All";
		this.price = 0;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex item requires two string variables, a stats variable and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats(), "broken".toCharArray());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		category = "All";
		this.price = 0;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex item requires three string variables and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", "weapon", "broken".toCharArray());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, String category, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		this.qualities = new stats();
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = 0;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex item requires three string variables, a stats variable and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats(), "weapon", "broken".toCharArray());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities, String category, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = 0;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex item requires three string variables, a stats variable, an integer variable and a character array variable
	 * Example of generating a complex item inside extended class:
	 * <code>	super("stick", "whack!", new stats(), "weapon", 0, "broken".toCharArray());</code>	// call super with the variables
	 * </pre> */
	public item(String itemName, String itemDesc, stats qualities, String category, int price, char... is)
	{
		if(itemName == null)
		{
			this.itemName = "Nothing";
		}
		else
		{
			this.itemName = itemName;
		}
		if(itemDesc == null)
		{
			this.itemDesc = "Empty";
		}
		else
		{
			this.itemDesc = itemDesc;
		}
		if(qualities == null)
		{
			this.qualities = new stats();
		}
		else
		{
			this.qualities = qualities;
		}
		if(category == null)
		{
			category = "All";
		}
		else
		{
			this.category = category;
		}
		this.price = price;
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("broken"))
			{
				isBroken = true;
				this.itemName = "broken "+itemName;
			}
			if(is.toString().toLowerCase().contains("quest"))
			{
				isQuest = true;
				this.itemName = "quest "+itemName;
			}
			if(is.toString().toLowerCase().contains("usable"))
			{
				isUsable = true;
				this.itemName = "usable "+itemName;
			}
		}
	}
	/** <pre>
	 * The name of the item displayed to the player
	 * Example of defining itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>itemName = "Door";</code>	// case doesn't affect what the player sees
	 * 	<code>out.println(itemName.toString());</code>	// because toString converts to lower case
	 * Returns:	"door"
	 * </pre> */
	String itemName;
	/** <pre>
	 * The flavor text description of the item
	 * Example of defining itemDesc:
	 * 	<code>itemDesc = "A thing that does a thing maybe sometimes";</code>	// flavor text
	 * </pre> */
	String itemDesc;
	/** <pre>
	 * The stats of the item
	 * Example of defining qualities:
	 * 	<code>qualities = new stats();</code>	// default stats
	 * </pre> */
	stats qualities;
	/** <pre>
	 * The flavor text description of the item
	 * Example of defining category:
	 * 	<code>category = "Weapon";</code>	// weapon category
	 * 	<code>category = "Armor";</code>	// armor category
	 * 	<code>category = "Misc";</code>	// misc category
	 * </pre> */
	String category;
	/** <pre>
	 * The price base price for an item (doesn't account for buy / sell modifiers)
	 * Example of defining price:
	 * <code>	price = -1;</code>	// negative is the same as zero
	 * 	<code>price = 1;</code>	// lowest price value
	 * 	<code>price = 999;</code>	// highest price value
	 * </pre> */
	int price;
	/** <pre>
	 * Boolean that determines if the item is broken
	 * Example of a item that is broken:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player item_player = new player();</code>	// create a player
	 * 	<code>item_player.items.add(new item("sword", "broken".toCharArray()));</code>	// add item to player
	 * 	<code>out.println(item_player.items[0].toString());</code>	// print item (index may vary)
	 * Returns:	"broken sword"
	 * </pre> */
	Boolean isBroken = false;
	/** <pre>
	 * Boolean that determines if the item is related to a quest
	 * Example of a item that is related to a quest:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player item_player = new player();</code>	// create a player
	 * 	<code>item_player.items.add(new item("stick", "quest".toCharArray()));</code>	// add item to player
	 * 	<code>out.println(item_player.items[0].toString());</code>	// print item (index may vary)
	 * Returns:	"quest stick"
	 * </pre> */
	Boolean isQuest = false;
	/** <pre>
	 * Boolean that determines if the item is usable
	 * Example of a item that is usable:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player item_player = new player();</code>	// create a player
	 * 	<code>item_player.items.add(new item("key", "usable".toCharArray()));</code>	// add item to player
	 * 	<code>out.println(item_player.items[0].toString());</code>	// print item (index may vary)
	 * Returns:	"usable key"
	 * </pre> */
	Boolean isUsable = false;
	@Override
	public String toString()
	{
		return itemName.toLowerCase();
	}
}