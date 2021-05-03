import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.System.out;
import javax.swing.JPanel;

public class startGameRooms {
	public static void main(String[] args) {
		new startGame();
	}
	public void startGame()
	{//	Simple implementation example of object oriented functionality
		
		//	generate rooms list with starting room
		ArrayList<room> rooms = new ArrayList<room>(Arrays.asList(
				new room("The Castle", "Where it all begins...")));
		//	create starting room with player
		rooms.get(0).addActor(new player(10,
				new ArrayList<item>(), new stats(25, 10, 5, 10, 0),
				"player", new JPanel(), "The one and only", null, 0,
				new weapon("Stick", "Just a stick", new stats(0, 5), "weapon"),
				null, new armor("T-shirt", "Keeping it simple",
						new stats(0,0,5), "armor")));
		//	add shop keep to starting room
		rooms.get(0).addActor(new npc(0, new ArrayList<item>(Arrays.asList(
				new weapon("Sword", "Mightier than the pen", new stats(0, 20),
						"weapon"),
				new misc("Potion", "Take a swig, do a jig", new stats(10),
						"misc"),
				new armor("Chainmail", "Better than a shirt",
						new stats(0, 0, 20), "armor"))),
				new stats(30, 30, 30, 0), "npc", new JPanel(), "Has the stuff",
				null, 10, new weapon("The sharp keeper", "Keeps the shop",
						new stats(0,100), "weapon"), null,
				new armor("The shop skirt", "Guards the shop keep",
						new stats(0,0,100), "armor"), null, "BUY MY STUFF",
				new quest("Defeat enemy", "Find a bad guy and beat them up",
						rooms.get(0).nameRoom, 10)));
		//	select option to get quest from npc
		rooms.get(0).selectOption((talkOption)rooms.get(0).roomOptions.get(6));
		//	select option to move (would generate random room)
		rooms.add(rooms.get(0).selectOption(
				(moveOption)rooms.get(0).roomOptions.get(0)));
		//	add enemy to new room (because it is not randomly generated)
		rooms.get(1).addActor(new enemy(0, null, new stats(10, 5, 5), "enemy",
				new JPanel(), "Evil!!!", new misc("Ring", "Shiny!",
						new stats(1,1,1), "misc"), 1, null, null, null, null));
		//	attack the enemy
		rooms.get(1).selectOption((attackOption)rooms.get(1).roomOptions.get(4));
		//	move back to starting room (to turn in quest)
		rooms.get(1).selectOption((moveOption)rooms.get(1).roomOptions.get(2));
		//	turn in quest
		rooms.get(0).selectOption((talkOption)rooms.get(0).roomOptions.get(6));
		//	the end!
	}
}