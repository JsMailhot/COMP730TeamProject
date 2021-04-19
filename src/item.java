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
	 * The price base price for an item (doesn't account for buy / sell modifiers)
	 * Example of defining price:
	 * <code>	price = -1;</code>	// negative is the same as zero
	 * 	<code>price = 1;</code>	// lowest price value
	 * 	<code>price = 999;</code>	// highest price value
	 * </pre> */
	int price = 0;
	/** <pre>
	 * The name of the item displayed to the player
	 * Example of defining itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>itemName = "Door";</code>	// case doesn't affect what the player sees
	 * 	<code>out.println(itemName.toString());</code>	// because toString converts to lower case
	 * Returns:	"door"
	 * </pre> */
	String itemName = "Nothing";
	/** <pre>
	 * The flavor text description of the item
	 * Example of defining itemDesc:
	 * 	<code>itemDesc = "A thing that does a thing maybe sometimes";</code>	// flavor text
	 * </pre> */
	String itemDesc = "Empty";
	/** <pre>
	 * The stats of the item
	 * Example of defining qualities:
	 * 	<code>qualities = new stats();</code>	// default stats
	 * </pre> */
	stats qualities = new stats();
	/** <pre>
	 * The flavor text description of the item
	 * Example of defining category:
	 * 	<code>category = "Weapon";</code>	// weapon category
	 * 	<code>category = "Armor";</code>	// armor category
	 * 	<code>category = "Misc";</code>	// misc category
	 * </pre> */
	String category = "All";
	/** <pre>
	 * Boolean that determines if the item is equipped
	 * Example of a item that is equipped:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player item_player = new player();</code>	// create a player
	 * 	<code>item_player.items.add(new item("sword", "equip".toCharArray()));</code>	// add item to player
	 * 	<code>out.println(item_player.items[0].toString());</code>	// print item (index may vary)
	 * Returns:	"equipt sword"
	 * </pre> */
	Boolean isEquip = false;
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
	@Override
	public String toString()
	{
		return itemName.toLowerCase();
	}
}