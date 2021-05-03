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
	 * Default misc evaluates to nothing
	 * Example of creating a default misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc default_misc = new misc();</code>	// create a default misc
	 * 	<code>out.println(default_misc.toString());</code>	// print default_misc
	 * Returns:	"nothing"
	 * </pre> */
	public misc()
	{
		super();
	}
	/** <pre>
	 * Simple misc evaluates to key
	 * Example of creating a Simple misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc Simple_misc = new misc("key");</code>	// create a Simple misc
	 * 	<code>misc Simple_misc2 = new misc(Simple_misc);</code>	// create a Simple misc
	 * 	<code>out.println(Simple_misc2.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(misc misc)
	{
		super(misc);
		if(misc.isConsumable)
		{
			isConsumable = true;
			this.itemName = "edible "+itemName;
		}
		if(misc.isThrowable)
		{
			isThrowable = true;
			this.itemName = "projectile "+itemName;
		}
	}
	/** <pre>
	 * Simple misc evaluates to key
	 * Example of creating a Simple misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>item Simple_item = new item("key");</code>	// create a Simple item
	 * 	<code>misc Simple_misc = new misc(Simple_item);</code>	// create a Simple misc
	 * 	<code>out.println(Simple_misc.toString());</code>	// print Simple_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(item item)
	{
		super(item);
	}
	/** <pre>
	 * Simple misc evaluates to key
	 * Example of creating a Simple misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc Simple_misc = new misc("key");</code>	// create a Simple misc
	 * 	<code>out.println(Simple_misc.toString());</code>	// print Simple_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName)
	{
		super(itemName);
	}
	/** <pre>
	 * Complex misc evaluates to key
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("key", "opens a door");</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName, String itemDesc)
	{
		super(itemName, itemDesc);
	}
	/** <pre>
	 * Complex misc evaluates to key
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("key", "opens a door", new stats());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities)
	{
		super(itemName, itemDesc, qualities);
	}
	/** <pre>
	 * Complex misc evaluates to key
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("key", "opens a door", "misc");</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName, String itemDesc, String category)
	{
		super(itemName, itemDesc, category);
	}
	/** <pre>
	 * Complex misc evaluates to key
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("key", "opens a door", new stats(), "misc");</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities, String category)
	{
		super(itemName, itemDesc, qualities, category);
	}
	/** <pre>
	 * Complex misc evaluates to key
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("key", "opens a door", new stats(), "misc", 0);</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"key"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities, String category, int price)
	{
		super(itemName, itemDesc, qualities, category, price);
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, char... is)
	{
		super(itemName, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
		}
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "do not eat", "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, String itemDesc, char... is)
	{
		super(itemName, itemDesc, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
		}
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "do not eat", new stats(), "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities, char... is)
	{
		super(itemName, itemDesc, qualities, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
		}
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "do not eat", "misc", "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, String itemDesc, String category, char... is)
	{
		super(itemName, itemDesc, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
		}
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "do not eat", new stats(), "misc", "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities, String category, char... is)
	{
		super(itemName, itemDesc, qualities, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
		}
	}
	/** <pre>
	 * Complex misc evaluates to edible rock
	 * Example of creating a complex misc to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>misc complex_misc = new misc("rock", "do not eat", new stats(), "misc", 0, "consumable".toCharArray());</code>	// create a complex misc
	 * 	<code>out.println(complex_misc.toString());</code>	// print complex_misc
	 * Returns:	"edible rock"
	 * </pre> */
	public misc(String itemName, String itemDesc, stats qualities, String category, int price, char... is)
	{
		super(itemName, itemDesc, qualities, category, price, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(new String(is).toLowerCase().contains("consumable"))
			{
				isConsumable = true;
				this.itemName = "edible " + this.itemName;
			}
			if(new String(is).toLowerCase().contains("throwable"))
			{
				isThrowable = true;
				this.itemName = "projectile " + this.itemName;
			}
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
	Boolean isConsumable = false;
	/** <pre>
	 * Boolean that determines if the misc can be thrown
	 * Example of an misc that is enchanted:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>player misc_player = new player();</code>	// create a player
	 * 	<code>misc_player.items.add(new misc("rock", "throwable".toCharArray()));</code>	// add misc to player
	 * 	<code>out.println(misc_player.items[0].toString());</code>	// print misc (index may vary)
	 * Returns:	"projectile rock"
	 * </pre> */
	Boolean isThrowable = false;

}	
