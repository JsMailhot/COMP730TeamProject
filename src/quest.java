/** <pre>
 * A quest is an objective for the player to complete for a reward.
 * Example of creating a default quest:
 * <code>	quest default_quest = new quest();</code>	// create a default quest
 * </pre> */
public class quest {
	/** <pre>
	 * Default quest does not require any specific variables
	 * Example of creating a default quest:
	 * <code>	quest default_quest = new quest();</code>	// create a default quest
	 * </pre> */
	public quest()
	{
		questName = "Default Quest Name";
		questDesc = "Default Quest Desc";
		questLocation = "Default Quest Locaiton";
		questRewardItem = null;
		questRewardGold = 0;
	}
	/** <pre>
	 * Simple quest that takes one parameter
	 * Example of creating a simple quest:
	 * <code>	quest default_quest = new quest("Default Quest Name");</code>	// create a default quest
	 * </pre> */
	public quest(String questName)
	{
		this.questName = questName;
		questDesc = "Default Quest Desc";
		questLocation = "Default Quest Locaiton";
		questRewardItem = null;
		questRewardGold = 0;
	}
	/** <pre>
	 * Complex quest that takes several parameters
	 * Example of creating a complex quest:
	 * <code>	quest default_quest = new quest("Default Quest Name", "Default Quest Desc");</code>	// create a default quest
	 * </pre> */
	public quest(String questName, String questDesc)
	{
		this.questName = questName;
		this.questDesc = questDesc;
		questLocation = "Default Quest Locaiton";
		questRewardItem = null;
		questRewardGold = 0;
	}
	/** <pre>
	 * Complex quest that takes several parameters
	 * Example of creating a complex quest:
	 * <code>	quest default_quest = new quest("Default Quest Name", "Default Quest Desc", "Default Quest Location");</code>	// create a default quest
	 * </pre> */
	public quest(String questName, String questDesc, String questLocation)
	{
		this.questName = questName;
		this.questDesc = questDesc;
		this.questLocation = questLocation;
		questRewardItem = null;
		questRewardGold = 0;
	}
	/** <pre>
	 * Complex quest that takes several parameters
	 * Example of creating a complex quest:
	 * <code>	quest default_quest = new quest("Default Quest Name", "Default Quest Desc", "Default Quest Location", null);</code>	// create a default quest
	 * </pre> */
	public quest(String questName, String questDesc, String questLocation, item questRewardItem)
	{
		this.questName = questName;
		this.questDesc = questDesc;
		this.questLocation = questLocation;
		this.questRewardItem = questRewardItem;
		questRewardGold = 0;
	}
	/** <pre>
	 * Complex quest that takes several parameters
	 * Example of creating a complex quest:
	 * <code>	quest default_quest = new quest("Default Quest Name", "Default Quest Desc", "Default Quest Location", 0);</code>	// create a default quest
	 * </pre> */
	public quest(String questName, String questDesc, String questLocation, int questRewardGold)
	{
		this.questName = questName;
		this.questDesc = questDesc;
		this.questLocation = questLocation;
		questRewardItem = null;
		this.questRewardGold = questRewardGold;
	}
	/** <pre>
	 * The name (id) of the quest
	 * Example of a questName:
	 * <code>	questName = "Default Quest Name";</code>	// set questName to a new string
	 * </pre> */
	String questName;
	/** <pre>
	 * The description of the quest
	 * Example of a questDesc:
	 * <code>	questDesc = "Default Quest Desc";</code>	// set questDesc to a new string
	 * </pre> */
	String questDesc;
	/** <pre>
	 * The name of the room where the quest is
	 * Example of a questLocation:
	 * <code>	questLocation = "Default Quest Location";</code>	// set questLocation to a new string
	 * </pre> */
	String questLocation;
	/** <pre>
	 * The item reward of the quest (optional)
	 * Example of a questRewardItem:
	 * <code>	questRewardItem = null;</code>	// set questRewardItem to a new item
	 * </pre> */
	item questRewardItem;
	/** <pre>
	 * The gold reward of the quest (optional)
	 * Example of a questRewardGold:
	 * <code>	questRewardGold = 0;</code>	// set questRewardGold to a new int
	 * </pre> */
	int questRewardGold;
	/** <pre>
	 * The completion status of the quest
	 * Example of a isComplete:
	 * <code>	isComplete = false;</code>	// set questName to a new boolean
	 * </pre> */
	Boolean isComplete = false;
}