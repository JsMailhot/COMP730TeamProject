package game;
import java.util.ArrayList;

public class playerOptions {
	
	public playerOptions()
	{
		choicePick = new ArrayList<option>();
	}
	
	public playerOptions(ArrayList<option> choicePick)
	{
		this.choicePick = choicePick;
	}
	
	ArrayList<option> choicePick;
	
	public int pickOption() {
		return 0;
		
	}
	public item getItem(item testItem) {
		return testItem;
		
	}
	public int getGold() {
		return 0;
		
	}
	

}