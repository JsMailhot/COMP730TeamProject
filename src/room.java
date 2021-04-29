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
		roomOptions = new ArrayList<option>();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
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
		roomOptions = new ArrayList<option>();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room room_generator = new room();</code>	// create a default room
	 * 	<code>room new_room = room_generator.</code>	// create a Simple misc
	 * </pre>*/
	public room(room room)
	{
		nameRoom = "Default Room";
		nameDesc = "Default Room Flavor Text";
		roomX = 0;
		roomY = 0;
		roomOptions = new ArrayList<option>();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
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
		roomOptions = new ArrayList<option>();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
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
		roomOptions = new ArrayList<option>();
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new ArrayList<option>());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, ArrayList<option> roomOptions)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		actorList = new ArrayList<actor>();
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new ArrayList<option>(), new ArrayList<actor>());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, ArrayList<option> roomOptions, ArrayList<actor> actorList)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		this.actorList = actorList;
		itemList = new ArrayList<item>();
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
	}
	/** <pre>
	 * Complex room with the require variables
	 * Example of generating a complex room:
	 * <code>	room default_room = new room("Default Room", "Default Room Flavor Text", 0, 0, new ArrayList<option>(), new ArrayList<actor>(), new ArrayList<item>());</code>	// generate a room object with a few parameters
	 * </pre>*/
	public room(String nameRoom, String nameDesc, int roomX, int roomY, ArrayList<option> roomOptions, ArrayList<actor> actorList, ArrayList<item> itemList)
	{
		this.nameRoom = nameRoom;
		this.nameDesc = nameDesc;
		this.roomX = roomX;
		this.roomY = roomY;
		this.roomOptions = roomOptions;
		this.actorList = actorList;
		this.itemList = itemList;
		if(!roomOptions.contains(moveNorth))
		{
			roomOptions.add(moveNorth);
		}
		if(!roomOptions.contains(moveEast))
		{
			roomOptions.add(moveEast);
		}
		if(!roomOptions.contains(moveSouth))
		{
			roomOptions.add(moveSouth);
		}
		if(!roomOptions.contains(moveWest))
		{
			roomOptions.add(moveEast);
		}
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
	 * 	<code>room_roomOptions.roomOptions = new ArrayList<option>();</code>	// set the roomOptions to a new ArrayList<option> value
	 * </pre> */
	ArrayList<option> roomOptions;
	/** <pre>
	 * The actors in the room
	 * Example of defining actorList:
	 * <code>	room room_actorList = new room();</code>	// generate a room
	 * 	<code>room_room_actorList.actorList = new ArrayList<actor>();</code>	// set the roomOptions to a new ArrayList<actor> value
	 * </pre> */
	ArrayList<actor> actorList;
	/** <pre>
	 * The items (armor, weapons, misc) in the room
	 * Example of defining itemList:
	 * <code>	room room_itemList = new room();</code>	// generate a room
	 * 	<code>room_itemList.itemList = new ArrayList<item>();</code>	// set the itemList to a new ArrayList<item> value
	 * </pre> */
	ArrayList<item> itemList;
	private moveOption moveNorth = new moveOption("north", false);
	private moveOption moveEast = new moveOption("east", false);
	private moveOption moveSouth = new moveOption("south", false);
	private moveOption moveWest = new moveOption("west", false);
	/** <pre>
	 * The function for adding an actor (and all that entails) to the actorList
	 * Example of using addActor:
	 * <code>	player example_player = new player();</code>	// generate a player
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addActor(example_player);</code>	// add the actor to the room
	 * </pre> */
	public void addActor(player target)
	{
		actorList.add(target);
	}
	/** <pre>
	 * The function for adding an actor (and all that entails) to the actorList
	 * Example of using addActor:
	 * <code>	npc example_npc = new npc();</code>	// generate a npc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addActor(example_npc);</code>	// add the actor to the room
	 * </pre> */
	public void addActor(npc target)
	{
		actorList.add(target);
		if(target.health > 0)
		{
			attackOption attack_target = new attackOption(target);
			roomOptions.add(attack_target);
			talkOption talk_target = new talkOption(target, "dialog".toCharArray());
			roomOptions.add(talk_target);
		}
		if(target.health > 0 && (target.items.size() > 0 || target.gold > 0))
		{
			talkOption talk_target = new talkOption(target, "retail".toCharArray());
			roomOptions.add(talk_target);
		}
		if(target.Quest != null)
		{
			talkOption talk_target = new talkOption(target, "dialog quest".toCharArray());
			roomOptions.add(talk_target);
		}
		for(item i : target.items)
		{
			if(i.isQuest)
			{
				talkOption talk_target = new talkOption(target, "retail quest".toCharArray());
				roomOptions.add(talk_target);
				return;
			}
		}
	}
	/** <pre>
	 * The function for adding an actor (and all that entails) to the actorList
	 * Example of using addActor:
	 * <code>	enemy example_player = new enemy();</code>	// generate a enemy
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addActor(example_enemy);</code>	// add the actor to the room
	 * </pre> */
	public void addActor(enemy target)
	{
		actorList.add(target);
		if(target.health > 0)
		{
			attackOption attack_target = new attackOption(target);
			roomOptions.add(attack_target);
		}
	}
	/** <pre>
	 * The function for adding an item (and all that entails) to the itemList
	 * Example of using addItem:
	 * <code>	misc example_misc = new misc();</code>	// generate a misc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_misc);</code>	// add the item to the room
	 * </pre> */
	public void addItem(misc target)
	{
		itemList.add(target);
		if(target.isConsumable)
		{
			interactOption interact_target = new interactOption(target, "consumable".toCharArray());
			roomOptions.add(interact_target);
		}
		if(!target.isThrowable && !target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "movable".toCharArray());;
			roomOptions.add(interact_target);
		}
		else
		{
			interactOption interact_target = new interactOption(target, "destroyable".toCharArray());;
			roomOptions.add(interact_target);
		}
		if(target.isThrowable || target.isConsumable || target.isUsable)
		{
			interactOption interact_target = new interactOption(target, "pickupable".toCharArray());;
			roomOptions.add(interact_target);
		}
		if(!target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "equipable".toCharArray());
			roomOptions.add(interact_target);
		}
		if(target.isUsable && target.isQuest && !target.isConsumable && !target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "unlockable".toCharArray());;
			roomOptions.add(interact_target);
		}
	}
	/** <pre>
	 * The function for adding an item (and all that entails) to the itemList
	 * Example of using addItem:
	 * <code>	weapon example_weapon = new weapon();</code>	// generate a weapon
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_weapon);</code>	// add the item to the room
	 * </pre> */
	public void addItem(weapon target)
	{
		itemList.add(target);
		if(!target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "pickupable".toCharArray());;
			roomOptions.add(interact_target);
		}
		else
		{
			interactOption interact_target = new interactOption(target, "destroyable".toCharArray());;
			roomOptions.add(interact_target);
		}
		if(!target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "equipable".toCharArray());
			roomOptions.add(interact_target);
		}
	}
	/** <pre>
	 * The function for adding an item (and all that entails) to the itemList
	 * Example of using addItem:
	 * <code>	armor example_armor = new armor();</code>	// generate a armor
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_armor);</code>	// add the item to the room
	 * </pre> */
	public void addItem(armor target)
	{
		itemList.add(target);
		if(!target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "pickupable".toCharArray());;
			roomOptions.add(interact_target);
		}
		else
		{
			interactOption interact_target = new interactOption(target, "destroyable".toCharArray());;
			roomOptions.add(interact_target);
		}
		if(!target.isBroken)
		{
			interactOption interact_target = new interactOption(target, "equipable".toCharArray());
			roomOptions.add(interact_target);
		}
	}
	/** <pre>
	 * The function for selecting an option
	 * Example of using selectOption:
	 * <code>	npc example_npc = new npc("shop keep");</code>	// generate a npc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_npc);</code>	// add the npc to the room
	 * 	<code>example_room.selectOption(example_room.roomOptions.get(0));</code>	// select the option
	 * </pre> */
	public void selectOption(talkOption target)
	{
		if(roomOptions.contains(target))
		{
			//	put conversation code here
			if(target.isQuest && target.isRetail)
			{
				
			}
			else if(target.isQuest && target.isDialog)
			{
				quest npc_quest = null;
				for(int i = 0; i < actorList.size(); i++)
				{
					if(npc_quest == null && target.optionText.contains(actorList.get(i).name.toLowerCase()))
					{
						npc_quest = ((npc) actorList.get(i)).Quest;
						i = 0;
					}
					if(npc_quest != null && actorList.get(i).type.toLowerCase().contains("player") && !((player) actorList.get(i)).questList.contains(npc_quest))
					{
						((player) actorList.get(i)).questList.add(npc_quest);
					}
				}
				roomOptions.remove(target);
			}
			if(target.isQuest)
			{
				
			}
		}
	}
	/** <pre>
	 * The function for selecting an option
	 * Example of using selectOption:
	 * <code>	misc example_misc = new misc("chest");</code>	// generate a misc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_misc);</code>	// add the misc to the room
	 * 	<code>example_room.selectOption(example_room.roomOptions.get(0));</code>	// select the option
	 * </pre> */
	public room selectOption(moveOption target)
	{
		if(roomOptions.contains(target))
		{
			room new_room;
			if(target.optionText.contains("north"))
			{
				new_room = new room("", "",this.roomX, this.roomY+1);
			}
			else if(target.optionText.contains("east"))
			{
				new_room = new room("", "",this.roomX+1, this.roomY);
			}
			else if(target.optionText.contains("south"))
			{
				new_room = new room("", "",this.roomX, this.roomY-1);
			}
			else
			{
				new_room = new room("", "",this.roomX-1, this.roomY+1);
			}
			return selectOption(new_room);
		}
		return null;
	}
	/** <pre>
	 * The function for selecting an option
	 * Example of using selectOption:
	 * <code>	room example_room = new room();</code>	// generate an room
	 * 	<code>room example_room2 = new room();</code>	// generate an room
	 * 	<code>example_room.selectOption(example_room2);</code>	// select the option
	 * </pre> */
	public room selectOption(room target)
	{
		int player_index = 0;
		for(int i = 0; i < this.actorList.size(); i++)
		{
			if(this.actorList.get(i).type.contains("player"))
			{
				player_index = i;
			}
		}
		target.actorList.add(this.actorList.get(player_index));
		this.actorList.remove(player_index);
		return target;
	}
	/** <pre>
	 * The function for selecting an option
	 * Example of using selectOption:
	 * <code>	npc example_npc = new npc("shop keep");</code>	// generate a npc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_npc);</code>	// add the npc to the room
	 * 	<code>example_room.selectOption(example_room.roomOptions.get(0));</code>	// select the option
	 * </pre> */
	public void selectOption(attackOption target)
	{
		if(roomOptions.contains(target))
		{
			//	put battle code here
		}
	}
	/** <pre>
	 * The function for selecting an option
	 * Example of using selectOption:
	 * <code>	misc example_misc = new misc("chest");</code>	// generate a misc
	 * 	<code>room example_room = new room();</code>	// generate an room
	 * 	<code>example_room.addItem(example_misc);</code>	// add the misc to the room
	 * 	<code>example_room.selectOption(example_room.roomOptions.get(0));</code>	// select the option
	 * </pre> */
	public void selectOption(interactOption target)
	{
		if(roomOptions.contains(target))
		{
			//	put interaction code here
		}
	}
}