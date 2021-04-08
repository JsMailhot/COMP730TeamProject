/**
 * Option prompting the player to start a conversation with another actor
 * Ex:	#	create a default talkOption and print its optionText
 * 		room example_room = new room();	<-	create new room (or use existing)
 * 		example_room.roomOptions.choicePick.add(new talkOption());	<- add talkOption to room
 * 		print(example_room.roomOptions.choicePick.get[0]); <- print talkOption (index may vary)
 * 		^	prints "talk with nothing"
 * Ex:	#	create a complex talkOption and print its optionText
 * 		talkOption talk_example = new talkOption("shop keep", "retail".toCharArray()); <- create new talkOption (or use existing)
 * 		print(talk_example); <- print talkOption
 * 		^	prints "trade with shop keep"
 * */
public class talkOption extends option {
	/**
	 * Default option evaluates to talking to nothing about nothing specific
	 * Ex:
	 * 		
	 * */
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
	/**
	 * Complex option evaluates to talking to a focus with specified parameters
	 * Ex:
	 * 		
	 * */
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
	/**
	 * 
	 * Ex:
	 * 		
	 * */
	Boolean isRetail = false;
	/**
	 * 
	 * Ex:
	 * 		
	 * */
	Boolean isQuest = false;
	/**
	 * 
	 * Ex:
	 * 		
	 * */
	Boolean isDialog = false;

}