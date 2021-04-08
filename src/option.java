/**
 * Generic option abstract class which holds that basic requirements for an option
 * 
 * */
public abstract class option {
	/**
	 * What the player player sees as the option
	 * Ex:
	 * 		"{type} {focus}" <- string in variable format
	 * 		"[verb] [noun]" <- string in structure format
	 * 		"(interact with) (key)" <- string in sentence format
	 * */
	public String optionText = "Default Text";
	/**
	 * What type this option is
	 * Ex:
	 * 		"interact with key" <- 'interact with' is the type
	 * 		"talk to shop keep" <- 'talk to' is the type
	 * 		"attack the bandit" <- 'attack' is the type
	 * */
	public String optionType = "Default Type";
	/**
	 * What the option is directed at
	 * Ex:
	 * 		"interact with key" <- 'key' is the focus
	 * 		"talk to shop keep" <- 'shop keep' is the focus
	 * 		"attack the bandit" <- 'the bandit' is the focus
	 * */
	public String optionFocus = "Default Focus";
}