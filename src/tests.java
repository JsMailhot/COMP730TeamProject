import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class tests {
	player test_player;		// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, ArrayList<quest> questList
	enemy test_enemy;		// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold
	npc test_npc;			// int gold, ArrayList<item> items, stats Stats, String type, String name, String desc, item droppedItem, int droppedGold, String greeting
	misc test_misc_item;	// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	weapon test_weapon_item;// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	armor test_armor_item;	// String itemName, String itemDesc, stats qualities, String category, int price, char... is
	stats test_stats;		// int healthPool, int attack, int defense, int expCap, int expCurrent
	
	@BeforeEach
	void setUp() throws Exception {
		test_player = new player(100, new ArrayList<item>(), new stats(), "Player", "Test Player", "Test Player Description", null, 50, new ArrayList<quest>());
		test_enemy = new enemy(100, new ArrayList<item>(), new stats(), "Enemy", "Test Enemy", "Test Enemy Description", null, 50);
		test_npc = new npc(100, new ArrayList<item>(), new stats(), "NPC", "Test NPC", "Test NPC Descripton", null, 50, "HEY THERE!");
		test_misc_item = new misc("Test Misc Item", "Test Misc Item Description", new stats(5,5,5,0,0), "Misc", 50, "edible".toCharArray());
		test_weapon_item = new weapon("Test Weapon Item", "Test Weapon Item Description", new stats(0,5,5,0,0), "Armor", 50, "counters".toCharArray());
		test_armor_item = new armor("Test Armor Item", "Test Armor Item Description", new stats(0,0,5,0,0), "Armor", 50, "enchanted".toCharArray());
	}
	
	@Test
    @DisplayName("Attacking an enemy alters their current health")
	void player_attack() {
		assertEquals(test_enemy.health, test_enemy.Stats.healthPool, "Enemy health should be at maximum");
		assertEquals(test_player.attack(test_enemy), (test_player.Stats.attack - test_enemy.Stats.defense), "Player should deal damage");
		assertEquals(test_enemy.health, test_enemy.Stats.healthPool - (test_player.Stats.attack - test_enemy.Stats.defense), "Enemy health should have lowered");
	}	
	@Test
    @DisplayName("Buying an item moves the item between inventories in exchange for gold")
	void player_buy() {
		test_player.items.add(test_misc_item);
		test_player.items.add(test_weapon_item);
		test_player.items.add(test_armor_item);
		
		assertEquals(test_player.items.size(), 3,"Player should have three items in their inventory");
		assertEquals(test_player.gold, 100, "Player should have 100 gold");
		assertEquals(test_npc.items.size(), 0,"NPC should have zero items in their inventory");
		assertEquals(test_npc.gold, 100, "NPC should have 100 gold");;
		
		test_npc.buy(test_player, test_misc_item);
		test_npc.buy(test_player, 0);
		
		assertEquals(test_player.items.size(), 1,"Player should have one item in their inventory");
		assertEquals(test_player.gold, 200, "Player should have 200 gold");
		assertEquals(test_npc.items.size(), 2,"NPC should have two items in their inventory");
		assertEquals(test_npc.gold, 0, "NPC should have 0 gold");;
	}	
	@Test
    @DisplayName("Selling an item moves the item between inventories in exchange for gold")
	void player_sell() {
		test_npc.items.add(test_misc_item);
		test_npc.items.add(test_weapon_item);
		test_npc.items.add(test_armor_item);
		
		assertEquals(test_npc.items.size(), 3,"NPC should have three items in their inventory");
		assertEquals(test_npc.gold, 100, "NPC should have 100 gold");
		assertEquals(test_player.items.size(), 0,"Player should have zero items in their inventory");
		assertEquals(test_player.gold, 100, "Player should have 100 gold");;
		
		test_npc.sell(test_player, test_misc_item);
		test_npc.sell(test_player, 0);
		
		assertEquals(test_npc.items.size(), 1,"NPC should have one item in their inventory");
		assertEquals(test_npc.gold, 200, "NPC should have 200 gold");
		assertEquals(test_player.items.size(), 2,"Player should have two items");
		assertEquals(test_player.gold, 0, "Player should have 0 gold");
	}
}
