/** <pre>
 * The option type for prompting the player to make decisions to interact with something.
 * Example of creating a default interactOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>room example_room = new room();</code>	// create new room (or use existing)
 * 	<code>example_room.roomOptions.choicePick.add(new interactOption());</code>	// add interactOption to room
 * 	<code>out.println(example_room.roomOptions.choicePick.get(0).toString());</code> // print interactOption (index may vary)
 * Returns:	"interact with nothing"
 * Example of creating a complex interactOption that takes an item and printing its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>item interact_item = new item("door");</code>	// create new item object
 * 	<code>interactOption interact = new interactOption(interact_item);</code> // create new interactOption (or use existing)
 * 	<code>out.println(interact.toString());</code> // print interactOption
 * Returns:	"interact with the door"
 * </pre> */
public class interactOption extends option {
	/** <pre>
	 * Default option evaluates to interacting with nothing
	 * Example of generating a default interactOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>interactOption interact = new interactOption();</code>	// simply generate a new object as a interactOption variable
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"interact with the nothing"
	 * </pre> */
	public interactOption()
	{
		super();
		optionType = "interact with the";
		optionFocus = "nothing";
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Complex option that evaluates to interacting with an item
	 * Example of creating a complex interactOption that takes an item and printing its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("door");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "".toCharArray());</code> // create new interactOption (or use existing)
	 * 	<code>out.println(interact_item.toString());</code> // print interact_item
	 * Returns:	"interact with the door"
	 * </pre> */
	public interactOption(item interactItem, char... is)
	{
		super();
		if(is == null)
		{
			//	what do we do when we are given nothing?
			optionType = "interact with the";
		}
		else if(new String(is).toLowerCase() == "pickupable")
		{
			isPickupable = true;
			optionType = "pick up the";
		}
		else if(new String(is).toLowerCase() == "unlockable")
		{
			isUnlockable = true;
			optionType = "unlock the";
		}
		else if(new String(is).toLowerCase() == "movable")
		{
			isMoveable = true;
			optionType = "move the";
		}
		else if(new String(is).toLowerCase() == "equipable")
		{
			isEquipable = true;
			optionType = "equip the";
		}
		else if(new String(is).toLowerCase() == "consumable")
		{
			isConsumable = true;
			optionType = "consume the";
		}
		else if(new String(is).toLowerCase() == "destroyable")
		{
			isDestructable = true;
			optionType = "destroy the";
		}
		else
		{
			//	what do we do when we are given garbage?
			optionType = "interact with the";
		}
		optionFocus = interactItem.itemName;
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving putting something into the players inventory:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("key");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "pickupable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"pick up the key"
	 * </pre> */
	Boolean isPickupable = false;
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving unlocking something:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("chest");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "unlockable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"unlock the chest"
	 * </pre> */
	Boolean isUnlockable = false;
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving moving something:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("debris");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "moveable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"move the debris"
	 * </pre> */
	Boolean isMoveable = false;
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving equipping something:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("magic ring");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "equipable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"equip the magic ring"
	 * </pre> */
	Boolean isEquipable = false;
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving consuming someting:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("health potion");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "consumable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"consume the health potion"
	 * </pre> */
	Boolean isConsumable = false;
	/** <pre>
	 * Boolean that determines if what is being interacted with can be put into the players inventory
	 * Example of an option involving destroying something:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item interact_item = new item("door");</code>	// create new item object
	 * 	<code>interactOption interact = new interactOption(interact_item, "destroyable".toCharArray());</code>	// generate a new interactOption variable with the respective parameters
	 * 	<code>out.println(interact.toString());</code>	// print interact
	 * Returns:	"destroy the door"
	 * </pre> */
	Boolean isDestructable = false;
}