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
	 * Default armor evaluates to nothing
	 * Example of creating a default armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor default_armor = new armor();</code>	// create a default armor
	 * 	<code>out.println(default_armor.toString());</code>	// print default_armor
	 * Returns:	"nothing"
	 * </pre> */
	public armor()
	{
		super();
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants");</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName)
	{
		super(itemName);
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop");</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName, String itemDesc)
	{
		super(itemName, itemDesc);
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities)
	{
		super(itemName, itemDesc, qualities);
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", "armor");</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, String category)
	{
		super(itemName, itemDesc, category);
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats(), "armor");</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities, String category)
	{
		super(itemName, itemDesc, qualities, category);
	}
	/** <pre>
	 * Complex armor evaluates to pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats(), "armor", 0);</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities, String category, int price)
	{
		super(itemName, itemDesc, qualities, category, price);
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, char... is)
	{
		super(itemName, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, char... is)
	{
		super(itemName, itemDesc, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats(), "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities, char... is)
	{
		super(itemName, itemDesc, qualities, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", "armor", "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, String category, char... is)
	{
		super(itemName, itemDesc, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats(), "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities, String category, char... is)
	{
		super(itemName, itemDesc, qualities, category, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
		}
	}
	/** <pre>
	 * Complex armor evaluates to enchanted pants
	 * Example of creating a complex armor to print its itemName:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>armor complex_armor = new armor("pants", "required to shop", new stats(), 0, "enchanted".toCharArray());</code>	// create a complex armor
	 * 	<code>out.println(complex_armor.toString());</code>	// print complex_armor
	 * Returns:	"enchanted pants"
	 * </pre> */
	public armor(String itemName, String itemDesc, stats qualities, String category, int price, char... is)
	{
		super(itemName, itemDesc, qualities, category, price, is);
		if(is == null)
		{
			//	what do we do when we are given nothing?
		}
		else
		{
			if(is.toString().toLowerCase().contains("enchanted"))
			{
				isEnchanted = true;
				this.itemName = "enchanted "+itemName;
			}
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