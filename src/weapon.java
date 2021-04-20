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
	 * Default weapon evaluates to nothing
	 * Example of generating a default weapon variable to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon default_weapon = new weapon();</code>	// simply generate a new object as a weapon variable
	 * 	<code>out.println(default_weapon.toString());</code>	// print default_weapon
	 * Returns:	"nothing"
	 * </pre> */
	public weapon()
	{
		super();
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword");</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName)
	{
		super(itemName);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right");</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc)
	{
		super(itemName, itemDesc);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities)
	{
		super(itemName, itemDesc, qualities);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", "weapon");</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, String category)
	{
		super(itemName, itemDesc, category);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats(), "weapon");</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities, String category)
	{
		super(itemName, itemDesc, qualities, category);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats(), "weapon", 0);</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities, String category, int price)
	{
		super(itemName, itemDesc, qualities, category, price);
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, char... is)
	{
		super(itemName, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, char... is)
	{
		super(itemName, itemDesc, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats(), "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities, char... is)
	{
		super(itemName, itemDesc, qualities, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", "weapon", "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, String category, char... is)
	{
		super(itemName, itemDesc, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats(), "weapon", "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities, String category, char... is)
	{
		super(itemName, itemDesc, qualities, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex weapon evaluates to sword
	 * Example of creating a complex weapon to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>weapon complex_weapon = new weapon("sword", "just right", new stats(), "weapon", 0, "counters".toCharArray());</code>	// create a complex weapon
	 * 	<code>out.println(complex_weapon.toString());</code>	// print complex_weapon
	 * Returns:	"defensive sword"
	 * </pre> */
	public weapon(String itemName, String itemDesc, stats qualities, String category, int price, char... is)
	{
		super(itemName, itemDesc, qualities, category, price, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("counters"))
			{
				canCounter = true;
				this.itemName = "defensive "+itemName;
			}
		}
	}
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
}