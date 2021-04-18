/** <pre>
 * A misc item can be pretty much anything.
 * Example of creating a default misc to print its itemName:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>misc default_misc = new misc();</code>	// create a default misc
 * 	<code>out.println(default_misc.toString());</code>	// print default_misc
 * Returns:	"stick"
 * </pre> */
public class misc extends item {
	/** <pre>
	 * Default misc evaluates to stick
	 * Example of creating a default misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc default_misc = new misc();</code>	// create a default misc
	 * 	<code>out.println(default_misc.toString());</code>	// print default_misc
	 * Returns:	"stick"
	 * </pre> */
	public misc()
	{
		super();
		itemName = "stick";
	}
	/** <pre>
	 * Complex misc evaluates to rock
	 * Example of creating a default misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"rock"
	 * </pre> */
	public misc(String itemName, char... is)
	{
		super();
		if(itemName == null)
		{
			//	what do we do when we are given nothing?
			itemName = "stick";
		}
		else if(is.toString().toLowerCase() == "equip")
		{
			isEquip = true;
			this.itemName = "equipt "+itemName;
		}
		else if(is.toString().toLowerCase() == "consumable")
		{
			isConsumable = true;
			this.itemName = "edible "+itemName;
		}
		else if(is.toString().toLowerCase() == "throwable")
		{
			isThrowable = true;
			this.itemName = "projectile "+itemName;
		}
		else if(is.toString().toLowerCase() == "broken")
		{
			isBroken = true;
			this.itemName = "broken "+itemName;
		}
		else
		{
			//	what do we do when we are given garbage?
			this.itemName = itemName;
		}
	}
	/** <pre>
	 * Boolean that determines if the misc can be consumed
	 * Example of an misc that is enchanted:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player misc_player = new player();</code>	// create a player
	 * 	<code>misc_player.items.add(new misc("rock", "consumable".toCharArray()));</code>	// add misc to player
	 * 	<code>out.println(misc_player.items[0].toString());</code>	// print misc (index may vary)
	 * Returns:	"edible rock"
	 * </pre> */
	Boolean isConsumable;
	/** <pre>
	 * Boolean that determines if the misc can be thrown
	 * Example of an misc that is enchanted:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player misc_player = new player();</code>	// create a player
	 * 	<code>misc_player.items.add(new misc("rock", "throwable".toCharArray()));</code>	// add misc to player
	 * 	<code>out.println(misc_player.items[0].toString());</code>	// print misc (index may vary)
	 * Returns:	"projectile rock"
	 * </pre> */
	Boolean isThrowable;
}