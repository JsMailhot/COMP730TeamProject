import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class tests {
	stats test_stats;					// int healthPool, int attack, int defense, int expCap, int expCurrent
	quest test_quest;					// String questName, String questDesc, String questLocation, int questRewardGold
	misc test_misc_item;				// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	weapon test_weapon_item;			// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	armor test_armor_item;				// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	player test_player;					// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, ArrayList<quest> questList
	enemy test_enemy;					// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold
	npc test_npc;						// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, String greeting
	room test_room;						// String nameRoom, String nameDesc, int roomX, int roomY, ArrayList<option> roomOptions, ArrayList<actor> actorList, ArrayList<item> itemList
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		test_quest = new quest("Test Quest", "Test Quest Description", "Test Quest Location", 100);
		test_misc_item = new misc("Test Misc", "Test Misc Description", new stats(5,5,5,0,0), "Misc", 50, "consumable, quest".toCharArray());
		test_weapon_item = new weapon("Test Weapon", "Test Weapon Description", new stats(0,20,5,0,0), "Armor", 50, "counters".toCharArray());
		test_armor_item = new armor("Test Armor", "Test Armor Description", new stats(0,0,5,0,0), "Armor", 50, "enchanted".toCharArray());
		test_player = new player(100, new ArrayList<item>(), new stats(), "Player", new JPanel(), "Test Player Description", null, 50, test_weapon_item, test_misc_item, test_armor_item, test_misc_item, new ArrayList<quest>());
		test_player.name.setName("Test Player");
		test_enemy = new enemy(100, new ArrayList<item>(), new stats(), "Enemy", new JPanel(), "Test Enemy Description", null, 50, test_weapon_item, test_misc_item, test_armor_item, test_misc_item);
		test_enemy.name.setName("Test Enemy");
		test_npc = new npc(100, new ArrayList<item>(), new stats(), "NPC", new JPanel(), "Test NPC Descripton", null, 50, test_weapon_item, test_misc_item, test_armor_item, test_misc_item, "HEY THERE!", test_quest);
		test_npc.name.setName("Test NPC");
		test_room = new room("Test Room", "Test Room Flavor Text", 0, 0, new ArrayList<option>(), new ArrayList<actor>(), new ArrayList<item>());
		
	}

	@Test
	@DisplayName("Building rooms should be easy")
	void fill_room()
	{
		test_npc.items.add(test_misc_item);
		System.out.println("Filling a room only takes a few steps\n");
		room test_room_copy = new room(test_room);
		test_room.addItem(test_misc_item);
		test_room.addItem(test_weapon_item);
		test_room.addItem(test_armor_item);
		test_room.addActor(test_player);
		test_room.addActor(test_enemy);
		test_room.addActor(test_npc);
		assertTrue(test_room.itemList.size() > test_room_copy.itemList.size(), "Adding items is easy");
		assertTrue(test_room.actorList.size() > test_room_copy.actorList.size(), "Adding actors is easy");
		assertTrue(test_room.roomOptions.size() > test_room_copy.roomOptions.size(), "Adding options is super easy");
		System.out.println("test_room items:");
		for(item o : test_room.itemList)
		{
			System.out.println(o.toString());
		}
		System.out.println("\ntest_room actors:");
		for(actor o : test_room.actorList)
		{
			System.out.println(o.toString());
		}
		System.out.println("\ntest_room options:");
		for(option o : test_room.roomOptions)
		{
			System.out.println(o.toString());
		}
	}
	@Test
	@DisplayName("Player should be able to complete quests")
	void quest_complete() {
		System.out.println("Player can acquire quests from npcs\n");
		test_room.addItem(test_misc_item);
		test_room.addItem(test_weapon_item);
		test_room.addItem(test_armor_item);
		test_room.addActor(test_player);
		test_room.addActor(test_enemy);
		test_room.addActor(test_npc);
		System.out.print("player quests(before):");
		for(quest q : ((player) test_room.actorList.get(0)).questList)
		{
			System.out.println(q.questName);
		}
		System.out.println("\n\nroom options(before):");
		for(option o : test_room.roomOptions)
		{
			System.out.println(o.optionText);
		}
		assertTrue(((player) test_room.actorList.get(0)).questList.size() == 0, "Player should have no quests");
		for(int i = 0; i < test_room.roomOptions.size(); i++)
		{
			if(test_room.roomOptions.get(i).optionText.contains("get quest from"))
			{
				test_room.selectOption(((talkOption) test_room.roomOptions.get(i)));
			}
		}
		assertTrue(((player) test_room.actorList.get(0)).questList.size() > 0, "Player should have no quests");
		System.out.println("\n\nplayer quests(after):");
		for(quest q : ((player) test_room.actorList.get(0)).questList)
		{
			System.out.println(q.questName);
		}
		System.out.println("\n\nroom options(after):");
		for(option o : test_room.roomOptions)
		{
			System.out.println(o.optionText);
		}
	}
	@Test
	@DisplayName("Weapon can counter strike")
	void weapon_counter() {
		System.out.println("Weapons can be defensive (return damage)\n");
		assertTrue(test_weapon_item.canCounter, "Weapon should have the canCounter set to true");
		System.out.print("weapon information:\nname: " + test_weapon_item.itemName 
				+ "\ndescription: " + test_weapon_item.itemDesc
				+ "\nqualities: " + test_weapon_item.qualities.toString()
				+ "\ncategory: " + test_weapon_item.category
				+ "\nprice: " + test_weapon_item.price
				+ "\nusable: " + test_weapon_item.isUsable
				+ "\nquest: " + test_weapon_item.isQuest
				+ "\nbroken: " + test_weapon_item.isBroken
				+ "\ncounters: " + test_weapon_item.canCounter
				+ "\n");
	}
	@Test
	@DisplayName("Armor can be enchanted")
	void armor_enchant() {
		System.out.println("Armor can be enchanted (extra block)\n");
		assertTrue(test_armor_item.isEnchanted, "Weapon should have the canCounter set to true");
		System.out.print("armor information:\nname: " + test_armor_item.itemName 
				+ "\ndescription: " + test_armor_item.itemDesc
				+ "\nqualities: " + test_armor_item.qualities.toString()
				+ "\ncategory: " + test_armor_item.category
				+ "\nprice: " + test_armor_item.price
				+ "\nusable: " + test_armor_item.isUsable
				+ "\nquest: " + test_armor_item.isQuest
				+ "\nbroken: " + test_armor_item.isBroken
				+ "\nenchanted: " + test_armor_item.isEnchanted
				+ "\n");
	}
	@Test
	@DisplayName("Misc items can be consumable")
	void misc_consumable() {
		System.out.println("Misc items can be consumed (heal damage)\n");
		assertTrue(test_misc_item.isConsumable, "Weapon should have the canCounter set to true");
		System.out.print("misc information:\nname: " + test_misc_item.itemName 
				+ "\ndescription: " + test_misc_item.itemDesc
				+ "\nqualities: " + test_misc_item.qualities.toString()
				+ "\ncategory: " + test_misc_item.category
				+ "\nprice: " + test_misc_item.price
				+ "\nusable: " + test_misc_item.isUsable
				+ "\nquest: " + test_misc_item.isQuest
				+ "\nbroken: " + test_misc_item.isBroken
				+ "\nconsumable: " + test_misc_item.isConsumable
				+ "\n");
	}
	@Test
    @DisplayName("Attacking an enemy alters their current health")
	void player_attack() {
		System.out.print("Attacking an enemy alters their current health\n\nenemy information (before attack):\nhealth: " + test_enemy.health
				+ "\nattack: " + test_enemy.attack() + "\nblock: " + test_enemy.block()
				+ "\n\nplayer information (before attack):\nhealth:" + test_player.health 
				+ "\nattack: " + test_player.attack() + "\nblock: " + test_player.block() + "\n\n");
		assertEquals(test_enemy.health, test_enemy.Stats.healthPool, "Enemy health should be at maximum");
		int damage_dealt = test_player.attack(test_enemy);
		assertEquals(test_enemy.health, test_enemy.Stats.healthPool - (test_player.attack() - test_enemy.block()), "Enemy health should have lowered");
		System.out.print("damage dealt: " + damage_dealt + "\n\nenemy information (after attack):\nhealth: " + test_enemy.health
				+ "\nattack: " + test_enemy.attack() + "\nblock: " + test_enemy.block()
				+ "\n\nplayer information (after attack):\nhealth:" + test_player.health 
				+ "\nattack: " + test_player.attack() + "\nblock: " + test_player.block() + "\n");
	}
//	@Test
//	@DisplayName("Taunting an enemy ...")
//	void player_taunt()
//	{
//	}
	@Test
    @DisplayName("Buying an item moves the item between inventories in exchange for gold")
	void player_buy() {
		System.out.println("NPCs can buy items from the player (or any actor)\n");
		test_player.items.add(test_misc_item);
		test_player.items.add(test_weapon_item);
		test_player.items.add(test_armor_item);
		System.out.println("Player(before purchase)\nGold: "+ test_player.gold + "\nItems:");
		for(item i : test_player.items)
		{
			System.out.println(i.toString());
		}
		System.out.println("\nNPC(before purchase)\nGold: " + test_npc.gold + "\nItems:");
		for(item i : test_npc.items)
		{
			System.out.println(i.toString());
		}
		assertEquals(test_player.items.size(), 3,"Player should have three items in their inventory");
		assertEquals(test_player.gold, 100, "Player should have 100 gold");
		assertEquals(test_npc.items.size(), 0,"NPC should have zero items in their inventory");
		assertEquals(test_npc.gold, 100, "NPC should have 100 gold");
		
		test_npc.buy(test_player, test_misc_item);
		test_npc.buy(test_player, 0);
		
		assertEquals(test_player.items.size(), 1,"Player should have one item in their inventory");
		assertEquals(test_player.gold, 200, "Player should have 200 gold");
		assertEquals(test_npc.items.size(), 2,"NPC should have two items in their inventory");
		assertEquals(test_npc.gold, 0, "NPC should have 0 gold");
		System.out.println("\nPlayer(after purchase)\nGold: " + test_player.gold + "\nItems:");
		for(item i : test_player.items)
		{
			System.out.println(i.toString());
		}
		System.out.println("\nNPC(after purchase)\nGold: " + test_npc.gold + "\nItems:");
		for(item i : test_npc.items)
		{
			System.out.println(i.toString());
		}
	}	
	@Test
    @DisplayName("Selling an item moves the item between inventories in exchange for gold")
	void player_sell() {
		System.out.println("NPCs can sell items to the player (or any actor)\n");
		test_npc.items.add(test_misc_item);
		test_npc.items.add(test_weapon_item);
		test_npc.items.add(test_armor_item);
		System.out.println("Player(before sale)\nGold: "+ test_player.gold + "\nItems:");
		for(item i : test_player.items)
		{
			System.out.println(i.toString());
		}
		System.out.println("\nNPC(before sale)\nGold: " + test_npc.gold + "\nItems:");
		for(item i : test_npc.items)
		{
			System.out.println(i.toString());
		}
		
		assertEquals(test_npc.items.size(), 3,"NPC should have three items in their inventory");
		assertEquals(test_npc.gold, 100, "NPC should have 100 gold");
		assertEquals(test_player.items.size(), 0,"Player should have zero items in their inventory");
		assertEquals(test_player.gold, 100, "Player should have 100 gold");
		
		test_npc.sell(test_player, test_misc_item);
		test_npc.sell(test_player, 0);
		
		assertEquals(test_npc.items.size(), 1,"NPC should have one item in their inventory");
		assertEquals(test_npc.gold, 200, "NPC should have 200 gold");
		assertEquals(test_player.items.size(), 2,"Player should have two items");
		assertEquals(test_player.gold, 0, "Player should have 0 gold");
		System.out.println("\nPlayer(after sale)\nGold: "+ test_player.gold + "\nItems:");
		for(item i : test_player.items)
		{
			System.out.println(i.toString());
		}
		System.out.println("\nNPC\nGold(after sale): " + test_npc.gold + "\nItems:");
		for(item i : test_npc.items)
		{
			System.out.println(i.toString());
		}
	}
}
