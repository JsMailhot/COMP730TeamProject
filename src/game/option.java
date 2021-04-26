package game;
/** <pre>
 * Generic option abstract class which holds that basic requirements for an option
 * Example of extending using this abstract class:
 * <code>	public class newOption extends option {</code>	// declare the extension
 * 	<code>	public newOption() {</code>	// declare constructor for class
 * 	<code>		super();</code>	# call super method
 * 	<code>		optionType = "type verb";</code>	// define super variables
 * 	<code>		optionVariable = new newOptionVariable();</code>	// define new option variables
 * 	<code>	}</code>
 * 	<code>}</code>
 * </pre> */
public abstract class option {
	/** <pre>
	 * What the player player sees as the option
	 * Example of defining optionText:
	 * <code>	optionText = "{type} {focus}";</code>	// string in variable format
	 * 	<code>optionText = "[verb] [noun]";</code>	// string in structure format
	 * 	<code>optionText = "(interact with) (key)";</code>	// string in sentence format
	 * </pre> */
	public String optionText = "Do Nothing";
	/** <pre>
	 * What type this option is
	 * Example of defining optionType:
	 * <code>	optionType = "interact with key";</code>	// 'interact with' is the type
	 * 	<code>optionType = "talk to shop keep";</code>	// 'talk to' is the type
	 * 	<code>optionType = "attack the bandit";</code>	// 'attack' is the type
	 * </pre> */
	public String optionType = "Do";
	/** <pre>
	 * What the option is directed at
	 * Example of defining optionFocus:
	 * <code>	optionFocus = "interact with key";</code>	// 'key' is the focus
	 * 	<code>optionFocus = "talk to shop keep";</code>	// 'shop keep' is the focus
	 * 	<code>optionFocus = "attack the bandit";</code>	// 'the bandit' is the focus
	 * </pre> */
	public String optionFocus = "Nothing";
	@Override
	public String toString()
	{
		return optionText;
	}
}