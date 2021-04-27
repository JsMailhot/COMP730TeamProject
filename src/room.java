import java.util.ArrayList;
/** <pre>
 * A room with many properties.
 * Example of creating a default room:
 * <code>	room example_room = new room();</code>	// create a default room
 * </pre> */
public class room {
	/** <pre>
	 * Default room does not require any specified variables
	 * Example of generating a default room:
	 * <code>	room default_room = new room();</code>	// simply generate a room object
	 * </pre> */
	public room()
	{
		nameRoom = "Default Room";
		nameDesc = "Default Room Flavor Text";
		roomX = 0;
		roomY = 0;
		roomOptions = new playerOptions();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Simple room with the require variable
	 * Example of generating a simple room:
	 * <code>	room default_room = new room("Default Room");</code>	// generate a room object with one parameter
	 * </pre>*/
	public room(String nameRoom)
	{
		this.nameRoom = nameRoom;
		nameDesc = "Default Room Flavor Text";
		roomX = 0;
		roomY = 0;
		roomOptions = new playerOptions();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text");</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		roomX = 0;
		roomY = 0;
		roomOptions = new playerOptions();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0);</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		roomOptions = new playerOptions();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new playerOptions());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, playerOptions roomOptions)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new playerOptions(), new ArrayList<actor>());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, playerOptions roomOptions, ArrayList<actor> actorList)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		this.actorList = actorList;
		itemList = new ArrayList<item>();
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new playerOptions(), new ArrayList<actor>(), new ArrayList<item>());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, playerOptions roomOptions, ArrayList<actor> actorList, ArrayList<item> itemList)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		this.actorList = actorList;
		this.itemList = itemList;
	}
	/** <pre>
	 * The name of the room (ID)
	 * Example of defining nameRoom:
	 * <code>	room room_nameRoom = new room();</code>	// generate a room
	 * 	<code>room_nameRoom.nameRoom = "Default Room";</code>	// set the nameRoom to a String value
	 * </pre> */
	String nameRoom;
	/** <pre>
	 * The description of the room
	 * Example of defining nameDesc:
	 * <code>	room room_nameDesc = new room();</code>	// generate a room
	 * 	<code>room_nameDesc.nameDesc = "Default Room Flavor Text";</code>	// set the nameDesc to a String value
	 * </pre> */
	String nameDesc;
	/** <pre>
	 * The X vertex (location) of the room
	 * Example of defining roomX and roomY:
	 * <code>	room room_roomXroomY = new room();</code>	// generate a room
	 * 	<code>room_roomXroomY.roomX = 0;</code>	// set the roomX to a integer value
	 * 	<code>room_roomXroomY.roomY = 0;</code>	// set the roomY to a integer value
	 * </pre> */
	int roomX;
	/** <pre>
	 * The Y vertex (location) of the room
	 * Example of defining roomX and roomY:
	 * <code>	room room_roomXroomY = new room();</code>	// generate a room
	 * 	<code>room_roomXroomY.roomX = 0;</code>	// set the roomX to a integer value
	 * 	<code>room_roomXroomY.roomY = 0;</code>	// set the roomY to a integer value
	 * </pre> */
	int roomY;
	/** <pre>
	 * The options available in the room
	 * Example of defining roomOptions:
	 * <code>	room room_roomOptions = new room();</code>	// generate a room
	 * 	<code>room_roomXroomY.roomOptions = new playerOptions();</code>	// set the roomOptions to a new playerOptions value
	 * </pre> */
	playerOptions roomOptions;
	/** <pre>
	 * The actors in the room
	 * Example of defining actorList:
	 * <code>	room room_actorList = new room();</code>	// generate a room
	 * 	<code>room_roomXroomY.actorList = new ArrayList<actor>();</code>	// set the roomOptions to a new ArrayList<actor> value
	 * </pre> */
	ArrayList<actor> actorList;
	/** <pre>
	 * The items (armor, weapons, misc) in the room
	 * Example of defining itemList:
	 * <code>	room room_itemList = new room();</code>	// generate a room
	 * 	<code>room_roomXroomY.itemList = new ArrayList<item>();</code>	// set the itemList to a new ArrayList<item> value
	 * </pre> */
	ArrayList<item> itemList;
}