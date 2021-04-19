/** <pre>
 * The option type for prompting the player to make decisions on moving in the cardinal directions.
 * Example of creating a default moveOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>room example_room = new room();</code>	// create new room (or use existing)
 * 	<code>example_room.roomOptions.choicePick.add(new moveOption());</code>	// add moveOption to room
 * 	<code>out.println(example_room.roomOptions.choicePick.get(0).toString());</code> // print moveOption (index may vary)
 * Returns:	"move north"
 * Example of creating a complex moveOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>moveOption talk_example = new moveOption("south", true);</code> // create new moveOption (or use existing)
 * 	<code>out.println(talk_example.toString());</code> // print moveOption
 * Returns:	"south blocked"
 * </pre> */
public class moveOption extends option {
	/** <pre>
	 * Default option evaluates to moving north
	 * Example of generating a default moveOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>moveOption move = new moveOption();</code>	// simply generate a new object as a moveOption variable
	 * 	<code>out.println(move.toString());</code>	// print talk
	 * Returns:	"move north"
	 * </pre> */
	public moveOption()
	{
		super();
		optionType = "move";
		optionFocus = "north";
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Complex option evaluates to moving in a direction that may be blocked
	 * Example of generating a complex moveOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>moveOption move = new moveOption("south", true);</code>	// generate a new moveOption variable with the respective parameters
	 * 	<code>out.println(move.toString());</code>	// print talk
	 * Returns:	"south blocked"
	 * </pre> */
	public moveOption(String Direction, boolean isBlocked)
	{
		super();
		this.isBlocked = isBlocked;
		optionType = "move";
		optionFocus = Direction.toLowerCase();
		if(isBlocked)
		{
			optionText = optionFocus + " blocked";
		}
		else
		{
			optionText = optionType + " " + optionFocus;
		}
	}
	/** <pre>
	 * Boolean for determening if this direction is blocked by something
	 * Example of a blocked direction being printed:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>moveOption move = new moveOption("south", true);</code>	// generate a new moveOption variable with the respective parameters
	 * 	<code>out.println(move.toString());</code>	// print talk
	 * Returns:	"south blocked"
	 * </pre> */
	boolean isBlocked = false;
}