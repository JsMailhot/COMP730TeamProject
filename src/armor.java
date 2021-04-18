/** <pre>
 * An armor item adds to the stats of the wearer.
 * Example of creating a default armor to print its itemName:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>armor default_armor = new armor();</code>	// create a default armor
 * 	<code>out.println(default_armor.toString());</code>	// print default_armor
 * Returns:	"pants"
 * </pre> */
public class armor extends item {
	/** <pre>
	 * Default armor evaluates to pants
	 * Example of creating a default armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor default_armor = new armor();</code>	// create a default armor
	 * 	<code>out.println(default_armor.toString());</code>	// print default_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor()
	{
		super();
		itemName = "pants";
	}
	/** <pre>
	 * Complex armor evaluates to shirt
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("shirt", "".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"shirt"
	 * </pre> */
	public armor(String itemName, char... is)
	{
		super();
		if(itemName == null)
		{
			//	what do we do when we are given nothing?
			itemName = "pants";
		}
		else if(is.toString().toLowerCase() == "equip")
		{
			isEquip = true;
			this.itemName = "equipt "+itemName;
		}
		else if(is.toString().toLowerCase() == "enchanted")
		{
			isEnchanted = true;
			this.itemName = "enchanted "+itemName;
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
	 * Boolean that determines if the armor is enchanted
	 * Example of an armor that is enchanted:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player armor_player = new player();</code>	// create a player
	 * 	<code>armor_player.items.add(new armor("shirt", "enchanted".toCharArray()));</code>	// add armor to player
	 * 	<code>out.println(armor_player.items[0].toString());</code>	// print armor (index may vary)
	 * Returns:	"enchanted shirt"
	 * </pre> */
	Boolean isEnchanted;
}