package game;
/** <pre>
 * The option type for prompting the player to make decisions to attack.
 * Example of creating a default attackOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>room example_room = new room();</code>	// create new room (or use existing)
 * 	<code>example_room.roomOptions.choicePick.add(new attackOption());</code>	// add attackOption to room
 * 	<code>out.println(example_room.roomOptions.choicePick.get(0).toString());</code> // print attackOption (index may vary)
 * Returns:	"attack nothing"
 * Example of creating a complex attackOption to print its optionText:
 * <code>	import static java.lang.System.out;</code>	// import print method
 * 	<code>enemy enemy_imp = new enemy("imp");</code>	// generate a new enemy imp
 * 	<code>attackOption attack = new attackOption(enemy_imp);</code>	// generate a new attackOption variable with the respective parameters
 * 	<code>out.println(attack.toString());</code> // print attack
 * Returns:	"attack goblin"
 * </pre> */
public class attackOption extends option {
	/** <pre>
	 * Default option evaluates to attacking nothing
	 * Example of generating a default attackOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>attackOption attack = new attackOption();</code>	// simply generate a new object as a attackOption variable
	 * 	<code>out.println(attack.toString());</code>	// print attack
	 * Returns:	"attack nothing"
	 * </pre> */
	public attackOption()
	{
		super();
		optionType = "attack";
		optionFocus = "nothing";
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Complex option evaluates to attack an enemy imp
	 * Example of generating a complex attackOption variable to print its optionText:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>enemy enemy_imp = new enemy("imp");</code>	// generate a new enemy imp
	 * 	<code>attackOption attack = new attackOption(enemy_imp);</code>	// generate a new attackOption variable with the respective parameters
	 * 	<code>out.println(attack.toString());</code>	// print attack
	 * Returns:	"attack imp"
	 * </pre> */
	public attackOption(actor attackFocus)
	{
		super();
		if(attackFocus == null)
		{
			//	what do we do when we are given nothing?
			optionFocus = "nothing";
		}
		else
		{
			optionFocus = attackFocus.name;
		}
		optionType = "attack";
		optionText = optionType + " " + optionFocus;
	}
	/** <pre>
	 * Actor that is the focus of the attack
	 * Example of an option involving attacking an enemy imp being printed:
	 * <code>	import static java.lang.System.out;</code>	// import print method
	 * 	<code>enemy enemy_imp = new enemy("imp");</code>	// generate a new enemy imp
	 * 	<code>attackOption attack = new attackOption(enemy_imp);</code>	// generate a new attackOption variable with the respective parameters
	 * 	<code>out.println(attack.toString());</code>	// print attack
	 * Returns:	"attack imp"
	 * </pre> */
	actor attackFocus = null;
}