package game;
import java.util.ArrayList;
/** <pre>
 * A simple implementation for storing item objects and holding a gold value inside an actor.
 * Example of extending using this abstract class:
 * <code>	public class hasInventory extends inventory {</code>	// declare the extension
 * 	<code>	public hasInventory() {</code>	// declare constructor for class
 * 	<code>		super();</code>	# call super method
 * 	<code>		gold = 0;</code>	// define super variables
 * 	<code>		name = new newName();</code>	// define new option variables
 * 	<code>	}</code>
 * 	<code>}</code>
 * </pre> */
public abstract class inventory {
	/** <pre>
	 * Default inventory does not require any specified variables
	 * Example of generating a default inventory inside extended class:
	 * <code>	super();</code>	// simply call super!
	 * </pre> */
	public inventory() {
		this.items = new ArrayList<item>();
		this.gold = 0;
	}
	/** <pre>
	 * Complex inventory only requires an integer variable
	 * Example of generating a complex inventory inside extended class:
	 * <code>	super(100);</code>	// call super with the variable
	 * </pre> */
	public inventory(int gold) {
		this.items = new ArrayList<item>();
		this.gold = gold;
	}
	/** <pre>
	 * Complex inventory only requires an ArrayList<item> variable
	 * Example of generating a complex inventory inside extended class:
	 * <code>	super(new ArrayList<item>());</code>	// call super with the variable
	 * </pre> */
	public inventory(ArrayList<item> items) {
		this.items = items;
		this.gold = 0;
	}
	/** <pre>
	 * Complex inventory requires an integer and an ArrayList<item> variable
	 * Example of generating a complex inventory inside extended class:
	 * <code>	super(100, new ArrayList<item>());</code>	// call super with the variables
	 * </pre> */
	public inventory(int gold, ArrayList<item> items) {
		this.items = items;
		this.gold = gold;
	}
	/** <pre>
	 * A list of items belonging to the inventory
	 * Example of defining items:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>inventoryPlayer.items = new ArrayList<item>();</code>	// set the items to a new ArrayList<item> variable
	 * </pre> */
	ArrayList<item> items;
	/** <pre>
	 * A list of items belonging to the inventory
	 * Example of defining items:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>inventoryPlayer.gold = 0</code>	// set the gold to a new integer variable
	 * </pre> */
	int gold;
	/** <pre>
	 * Function that removes an item from the inventory
	 * Example of calling dropItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("stick");</code>	// generate a new item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.dropItem(inventoryItem);</code>	// drop the item
	 * </pre> */
	public item dropItem(item toBeDropped) {
		if(items.contains(toBeDropped))
		{
			items.remove(toBeDropped);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeDropped;
	}
	/** <pre>
	 * Function that removes an item from the inventory
	 * Example of calling dropItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("stick");</code>	// generate a new item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.dropItem(0);</code>	// drop the item
	 * </pre> */
	public item dropItem(int toBeDropped) {
		item toBeDroppedItem = null;
		if(items.size() - 1 >= toBeDropped && !items.get(toBeDropped).isQuest)
		{
			toBeDroppedItem = items.get(toBeDropped);
			items.remove(toBeDropped);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeDroppedItem;
	}
	/** <pre>
	 * Function that uses an item in the inventory
	 * Example of calling useItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("apple", "consumable".toCharArray());</code>	// generate a new complex item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.useItem(inventoryItem);</code>	// use the item
	 * </pre> */
	public item useItem(item toBeUsed) {
		if(items.contains(toBeUsed) && toBeUsed.isUsable)
		{
			items.remove(toBeUsed);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeUsed;
	}
	/** <pre>
	 * Function that uses an item in the inventory
	 * Example of calling useItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("apple", "consumable".toCharArray());</code>	// generate a new complex item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.useItem(0);</code>	// use the item
	 * </pre> */
	public item useItem(int toBeUsed) {
		item toBeUsedItem = null;
		if(items.size() - 1 >= toBeUsed && items.get(toBeUsed).isUsable)
		{
			toBeUsedItem = items.get(toBeUsed);
			items.remove(toBeUsed);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeUsedItem;
	}
	/** <pre>
	 * Function that equips an item in the inventory
	 * Example of calling useItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("stick", "equip".toCharArray());</code>	// generate a new complex item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.useItem(inventoryItem);</code>	// use the item
	 * </pre> */
	public item equipItem(item toBeEquipt) {
		if(items.contains(toBeEquipt))
		{
			items.remove(toBeEquipt);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeEquipt;
	}
	/** <pre>
	 * Function that equips an item in the inventory
	 * Example of calling equipItem:
	 * <code>	player inventoryPlayer = new player();</code>	// generate a player
	 * 	<code>item inventoryItem = new item("stick", "equip".toCharArray());</code>	// generate a new complex item
	 * 	<code>inventoryPlayer.items.add(inventoryItem);</code>	// add an item to the player inventory
	 * 	<code>inventoryPlayer.equipItem(0);</code>	// use the item
	 * </pre> */
	public item equipItem(int toBeEquipt) {
		item toBeEquiptItem = null;
		if(items.size() - 1 >= toBeEquipt)
		{
			toBeEquiptItem = items.get(toBeEquipt);
			items.remove(toBeEquipt);
		}
		else
		{
			//	what to we do when we are given garbage?
		}
		return toBeEquiptItem;
	}
	/** <pre>
	 * Function that closes the inventory UI
	 * </pre> */
	public void closeInvenotry	() {
		
	}
}