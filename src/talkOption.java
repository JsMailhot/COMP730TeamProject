/** <pre>
 * The option type for prompting the player to make decisions in a conversation with another actor such as a shop keep.
 * Example of creating a default talkOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>room example_room = new room();</code>	// create new room (or use existing)
 * 	<code>example_room.roomOptions.choicePick.add(new talkOption());</code>	// add talkOption to room
 * 	<code>out.println(example_room.roomOptions.choicePick.get(0).toString());</code> // print talkOption (index may vary)
 * Returns:	"talk with nothing"
 * Example of creating a complex talkOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * <code>	talkOption talk_example = new talkOption("shop keep", "retail".toCharArray());</code> // create new talkOption (or use existing)
 * 	<code>out.println(talk_example.toString());</code> // print talkOption
 * Returns:	"trade with shop keep"
 * </pre> */
public class talkOption extends option {
	/** <pre>
	 * Default option evaluates to talking to nothing about nothing specific
	 * Example of generating a default talkOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>talkOption talk = new talkOption();</code>	// simply generate a new object as a talkOption variable
	 * 	<code>out.println(talk.toString());</code>	// print talk
	 * Returns:	"talk to nothing"
	 * </pre> */
	public talkOption()
	{
		super();
		optionType = "talk to";
		optionFocus = "nothing";
		optionText = optionType + " " + optionFocus;
		isRetail = false;
		isQuest = false;
		isDialog = true;
	}
	/** <pre>
	 * Complex option evaluates to talking to a focus with specified parameters
	 * Example of generating a complex talkOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>talkOption talk = new talkOption("shop keep", "retail".toCharArray());</code>	// generate a new talkOption variable with the respective parameters
	 * 	<code>out.println(talk.toString());</code>	// print talk
	 * Returns:	"trade with shop keep"
	 * </pre> */
	public talkOption(String optionFocus, char... is)
	{
		super();
		if(is == null)
		{
			//	what do we do when we are given nothing?
			isDialog = true;
			optionType = "talk with";
		}
		else if(is.toString().toLowerCase() == "retail")
		{
			isRetail = true;
			optionType = "trade with";
		}
		else if(is.toString().toLowerCase() == "quest")
		{
			isQuest = true;
			optionType = "help";
		}
		else if(is.toString().toLowerCase() == "dialog")
		{
			isDialog = true;
			optionType = "talk with";
		}
		else
		{
			//	what do we do when we are given garbage?
			isDialog = true;
			optionType = "talk with";
		}
		
		this.optionFocus = optionFocus;
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Boolean for determening if this option involves buying or selling items
	 * Example of an option involving buying items being printed:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>talkOption talk = new talkOption("shop keep", "retail".toCharArray());</code>	// generate a new talkOption variable with the respective parameters
	 * 	<code>out.println(talk.toString());</code>	// print talk
	 * Returns:	"trade with shop keep"
	 * </pre> */
	Boolean isRetail = false;
	/** <pre>
	 * Boolean for determening of this option involves a quest
	 * Example of an option involving a quest being printed:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>talkOption talk = new talkOption("the quest giver", "quest".toCharArray());</code>	// generate a new talkOption variable with the respective parameters
	 * 	<code>out.println(talk.toString());</code>	// print talk
	 * Returns:	"help the quest giver"
	 * </pre> */
	Boolean isQuest = false;
	/** <pre>
	 * Boolean for determening of this option involves only dialogue
	 * Example of an option involving only dialogue being printed:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>talkOption talk = new talkOption("adventurer", "dialog".toCharArray());</code>	// generate a new talkOption variable with the respective parameters
	 * 	<code>out.println(talk.toString());</code>	// print talk
	 * Returns:	"talk with the adventurer"
	 * </pre> */
	Boolean isDialog = false;
}