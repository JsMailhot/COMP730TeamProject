/** <pre>
 * A weapon item adds to the stats of the wielder.
 * Example of creating a default weapon to print its itemName:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>weapon default_weapon = new weapon();</code>	// create a default weapon
 * 	<code>out.println(default_weapon.toString());</code>	// print default_weapon
 * Returns:	"fists"
 * </pre> */
 public class weapon extends item {
	/** <pre>
	 * Default option evaluates to fists
	 * Example of generating a default weapon variable to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon default_weapon = new weapon();</code>	// simply generate a new object as a weapon variable
	 * 	<code>out.println(default_weapon.toString());</code>	// print default_weapon
	 * Returns:	"fists"
	 * </pre> */
	public weapon()
	{
		itemName = "fists";
	}
	/** <pre>
	 * Complex option that evaluates to sword
	 * Example of generating a complex weapon variable to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon sword_weapon = new weapon("sword");</code>	// generate a new sword weapon
	 * 	<code>out.println(sword_weapon.toString());</code>	// print sword_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, char... is)
	{
		if(itemName == null)
		{
			//	what do we do when we are given nothing?
			itemName = "fists";
		}
		else if(itemName.toLowerCase() == "equip")
		{
			isEquip = true;
			this.itemName = "equipt "+itemName;
		}
		else if(itemName.toLowerCase() == "counters")
		{
			canCounter = true;
			this.itemName = "defensive "+itemName;
		}
		else if(itemName.toLowerCase() == "broken")
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
	 * Boolean that determines if the weapon is equipped
	 * Example of a weapon that is equipped:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player weapon_player = new player();</code>	// create a player
	 * 	<code>weapon_player.items.add(new weapon("sword", "equip".toCharArray()));</code>	// add weapon to player
	 * 	<code>out.println(weapon_player.items[0].toString());</code>	// print weapon (index may vary)
	 * Returns:	"equipt sword"
	 * </pre> */
	Boolean isEquip = false;
	/** <pre>
	 * Boolean that determines if the weapon can counter
	 * Example of a weapon that can counter:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player weapon_player = new player();</code>	// create a player
	 * 	<code>weapon_player.items.add(new weapon("sword", "counters".toCharArray()));</code>	// add weapon to player
	 * 	<code>out.println(weapon_player.items[0].toString());</code>	// print weapon (index may vary)
	 * Returns:	"defensive sword"
	 * </pre> */
	Boolean canCounter = false;
	/** <pre>
	 * Boolean that determines if the weapon is broken
	 * Example of a weapon that is broken:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player weapon_player = new player();</code>	// create a player
	 * 	<code>weapon_player.items.add(new weapon("sword", "broken".toCharArray()));</code>	// add weapon to player
	 * 	<code>out.println(weapon_player.items[0].toString());</code>	// print weapon (index may vary)
	 * Returns:	"broken sword"
	 * </pre> */
	Boolean isBroken = false;
}