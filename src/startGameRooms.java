import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static java.lang.System.out;

public class startGameRooms {
//	Boolean enterGame;
	Container con;
	JPanel healthBarPanel, titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel, imagePanel, inputPanel, inventoryPanel, questPanel;
	JLabel titleScreenLabel, playerhpLabel, playerhplabelNumber, weaponLabel, weaponlabelName, imageLabel, nameLabel, playergoldLabel, playergoldlabelNumber;
	JButton startButton, musicButton, enterButton, inventoryButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5, questButton, questButton1, questButton2, questButton3, questButton4, questButton5;
	JTextArea mainTextArea;
	int playerHP, silverRing, gold, key;
	String weapon, position, text, inventoryStatus, questStatus;
	String clickSound, gameMusic, musicOnOff, cantuse;
	ImageIcon image;
	Font titleFont = new Font("Times New Roman", Font.BOLD, 82);
	Font normalFont = new Font("Times New Roman", Font.ITALIC, 24);
	JTextField jtf;
	List difficulty;
	JFrame window;
	ArrayList<JButton> optionButtons = new ArrayList<JButton>();
	InputHandler iHandler = new InputHandler();
	Music mu = new Music();
	SoundEffect se = new SoundEffect();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler invHandler = new InventoryHandler();
	QuestHandler qsHandler = new QuestHandler();
//	armor complex_armor = new armor("pants", "required to shop", new stats(), "enchanted".toCharArray()); // create a complex armor
//	quest NoQuest = new quest("Empty");
	quest frosttrollquest = new quest("Kill Frost Troll", "The local guard wants me to kill a \n frost troll that took his ring.");
//	
	int monsterHealth = 0;
	int monsterAttack = 0;
//	
//	quest[] quests = new quest[5];
//	SuperItem[] playerItem = new SuperItem[5];
	misc potion;
	misc berry;
//	Item_Empty empty = new Item_Empty();
	misc silverring;
//	
//	stats banditStats = new stats(20, 6, 2, 0, 0);
//	
//	
	enemy frostTroll = new enemy(0, new ArrayList<item>(), new stats(10, 3, 2, 0, 0), "Frost Troll", new JPanel(), "Frost Troll which is located in the coldest areas of the world",null, 2, new weapon());
	enemy wolf = new enemy(0, new ArrayList<item>(), new stats(15, 6, 2, 0, 0), "Frost Wolf", new JPanel(), "Frost Wolves roam the dense forests",null, 2, new weapon());

	//	enemy bandit = new enemy(0, new ArrayList<item>(), wolfStats, "Frost Wolf", "Wolf", "Frost Wolves roam the dense forests",null, 2, new weapon());
//	
//	
//	stats the_player.Stats = new stats(25, 5, 5, 0, 0);
//	player Player = new player(10, new ArrayList<item>(), the_player.Stats, "player", "playerName", "A young elf looking for adventure", null, 0, new weapon(), null, new armor(), null, new ArrayList<quest>());
//	
	weapon rustySword;
	weapon stickWeapon;
	Boolean enterGame;
	ArrayList<room> rooms;
	room starting_room;// generate a room object with a few parameters
	player the_player;
	npc base_npc;
	enemy base_enemy;
	int i, soundCue;
	
	
	public static void main(String[] args) {
		new startGame();
	}
	public startGameRooms() {
		frostTroll.name.setName("troll");
		wolf.name.setName("wolf");
		rooms = new ArrayList<room>();
//player example_player = new player(0, new ArrayList(), new stats(),
		//	"player", "player name", "player desc", null, 0,
		//	new weapon(), null, new armor(), new misc(), new ArrayList());
		// create new player object
//String nameRoom, String nameDesc, int roomX, int roomY,
		//	ArrayList<option> roomOptions, ArrayList<actor> actorList,
		//	ArrayList<item> itemList)
		starting_room = new room("the castle", "where it begins", 0, 0, new ArrayList<option>(), new ArrayList<actor>(), new ArrayList<item>());
		window = new JFrame();
		window.setSize(820, 850);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		con = window.getContentPane();

		titleScreenPanel = new JPanel();
		titleScreenPanel.setBounds(100, 100, 600, 150);
		titleScreenPanel.setBackground(Color.black);
		titleScreenLabel = new JLabel("EVERWINTER");
		titleScreenLabel.setForeground(Color.white);
		titleScreenLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("START");
		startButton.setFocusPainted(false);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);




		clickSound = ".//sound//button.wav";
		gameMusic = ".//sound//gamemusic.wav";

		musicOnOff = "off";




		titleScreenPanel.add(titleScreenLabel);
		startButtonPanel.add(startButton);

		con.add(titleScreenPanel);
		con.add(startButtonPanel);
		window.setVisible(true);

		
	}
	public void enterName() {
//player example_player = new player(0, new ArrayList(), new stats(),
		//	"player", new JPanel(), "player desc", null, 0,
		//	new weapon(), null, new armor(), new misc(), new ArrayList());
		// create new player object
//int gold, ArrayList<item> items, stats Stats, String type,
		//	JPanel name, String desc, item droppedItem, int droppedGold,
		//	weapon primary, item secondary, armor Armor, misc ring,
		//	ArrayList<quest> questList);
		the_player = new player(10, new ArrayList<item>(), new stats(20, 5), "player", new JPanel(), "A young elf looking for adventure", null, 0, new weapon(), null, new armor(), null, new ArrayList<quest>());
//enemy example_enemy = new enemy(0, new ArrayList(), new stats(), 
		//	"enemy", "enemy name", "enemy desc", null, 0, new weapon(),
		//	null, new armor(), new misc());
		// create new enemy object
//int gold, ArrayList<item> items, stats Stats, String type,
		//	String name, String desc, item droppedItem, int droppedGold,
		//	weapon primary, item secondary, armor Armor, misc ring)
		base_enemy = new enemy();
//npc example_npc = new npc(0, new ArrayList(), new stats(), "npc",
		//	"npc name", "npc desc", null, 0, new weapon(), null,
		//	new armor(), new misc(), "HEY THERE!", new Quest());
		// create new npc object
//int gold, ArrayList<item> items, stats Stats, String type,
		//	String name, String desc, item droppedItem, int droppedGold,
		//	weapon primary, item secondary, armor Armor, misc ring,
		//	String greeting, quest Quest)
		base_npc = new npc();
		titleScreenPanel.setVisible(false);
		startButtonPanel.setVisible(false);

		the_player.name.setBounds(150, 250, 500, 100);
		the_player.name.setBackground(Color.black);
		nameLabel = new JLabel("Please enter your name:");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(normalFont);
		the_player.name.add(nameLabel);
		con.add(the_player.name);

		inputPanel = new JPanel();
		inputPanel.setBounds(150, 450, 500, 50);
		inputPanel.setBackground(Color.black);
		inputPanel.setLayout(new GridLayout(1,2));

		jtf = new JTextField();
		inputPanel.add(jtf);

		enterButton = new JButton("ENTER");
		enterButton.setForeground(Color.black);
		enterButton.addActionListener(iHandler);
		inputPanel.add(enterButton);
		con.add(inputPanel);

	}
	public String enterDesc() {
		return "Desc";
	}
	public void generateRoom() {

	}
	public void playerInterface() {
		inputPanel.setVisible(false);
		the_player.name.setVisible(false);
		titleScreenPanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50, 500, 550, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea();
		mainTextArea.setBounds(0, 500, 550, 300);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		mainTextArea.setEditable(false);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(50, 300, 600, 200);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,2));
		con.add(choiceButtonPanel);

		room testroom = new room();


		ArrayList<room> roomList = new ArrayList<room>();
		player testPlayer = new player();
		testroom.actorList.add((actor)testPlayer);

		moveOption moveoption = new moveOption();
		attackOption attackoption = new attackOption();
		talkOption talkoption = new talkOption();
		interactOption interactoption = new interactOption();


//		testroom.roomOptions.choicePick.add(moveoption);
//		testroom.roomOptions.choicePick.add(attackoption);
//		testroom.roomOptions.choicePick.add(talkoption);
//		testroom.roomOptions.choicePick.add(interactoption);


		roomList.add(testroom);



		for (int i = 1; i <= 5; i++) {
		choice = new JButton("Here is the choice");
		choice.setBackground(Color.black);
		choice.setForeground(Color.white);
		choice.setFont(normalFont);
		choice.setFocusPainted(false);
		choice.addActionListener(choiceHandler);
		choice.setActionCommand("c" + i);
		choiceButtonPanel.add(choice);
		optionButtons.add(choice);
		}
		musicButton = new JButton("Music");
		musicButton.setFocusPainted(false);
		musicButton.addActionListener(choiceHandler);
		musicButton.setActionCommand("musicb");
		choiceButtonPanel.add(musicButton);
		
		inventoryButton = new JButton("[ Inventory ]");
		inventoryButton.setBackground(Color.white);
		inventoryButton.setForeground(Color.black);
		inventoryButton.setFont(normalFont);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(invHandler);
		inventoryButton.setActionCommand("inventoryButton");
		choiceButtonPanel.add(inventoryButton);
		
		questButton = new JButton("[ Quests ]");
		questButton.setBackground(Color.white);
		questButton.setForeground(Color.black);
		questButton.setFont(normalFont);
		questButton.setFocusPainted(false);
		questButton.addActionListener(qsHandler);
		questButton.setActionCommand("quests");
		choiceButtonPanel.add(questButton);
		
		

		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(0, 15, 800, 30);
		healthBarPanel.setBackground(Color.black);
		con.add(healthBarPanel);
		the_player.name.setFont(normalFont);
		the_player.name.setForeground(Color.white);
		healthBarPanel.add(the_player.name);
		playerhpLabel = new JLabel("  HP:");
		playerhpLabel.setFont(normalFont);
		playerhpLabel.setForeground(Color.white);
		healthBarPanel.add(playerhpLabel);
		playerhplabelNumber = new JLabel();
		playerhplabelNumber.setFont(normalFont);
		playerhplabelNumber.setForeground(Color.white);
		healthBarPanel.add(playerhplabelNumber);

		the_player.health = new JProgressBar(0, 25);
		the_player.health.setPreferredSize(new Dimension(200, 25));
		the_player.health.setBackground(Color.red);
		the_player.health.setForeground(Color.green);
		healthBarPanel.setPreferredSize(new Dimension(200, 30));
		healthBarPanel.setBackground(Color.red);
		healthBarPanel.setForeground(Color.green);
		healthBarPanel.add(healthBarPanel);
		weaponLabel =  new JLabel("  Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		healthBarPanel.add(weaponLabel);
		weaponlabelName = new JLabel();
		weaponlabelName.setFont(normalFont);
		weaponlabelName.setForeground(Color.white);
		healthBarPanel.add(weaponlabelName);
		
		playergoldLabel = new JLabel(" Gold:");
		playergoldLabel.setFont(normalFont);
		playergoldLabel.setForeground(Color.white);
		healthBarPanel.add(playergoldLabel);
		playergoldlabelNumber = new JLabel();
		playergoldlabelNumber.setFont(normalFont);
		playergoldlabelNumber.setForeground(Color.white);
		healthBarPanel.add(playergoldlabelNumber);

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(600, 600, 200, 200);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(5,1));
		con.add(inventoryPanel);
		
		questPanel = new JPanel();
		questPanel.setBounds(600, 600, 200, 200);
		questPanel.setBackground(Color.black);
		questPanel.setLayout(new GridLayout(5,1));
		con.add(questPanel);
		
		itemButton1 = new JButton();
		itemButton1.setBackground(Color.black);
		itemButton1.setForeground(Color.white);
		itemButton1.setFont(normalFont);
		itemButton1.setFocusPainted(false);
		itemButton1.addActionListener(invHandler);
		itemButton1.setActionCommand("item1");
		
		itemButton2 = new JButton();
		itemButton2.setBackground(Color.black);
		itemButton2.setForeground(Color.white);
		itemButton2.setFont(normalFont);
		itemButton2.setFocusPainted(false);
		itemButton2.addActionListener(invHandler);
		itemButton2.setActionCommand("item2");
		
		itemButton3 = new JButton();
		itemButton3.setBackground(Color.black);
		itemButton3.setForeground(Color.white);
		itemButton3.setFont(normalFont);
		itemButton3.setFocusPainted(false);
		itemButton3.addActionListener(invHandler);
		itemButton3.setActionCommand("item3");
		
		itemButton4 = new JButton();
		itemButton4.setBackground(Color.black);
		itemButton4.setForeground(Color.white);
		itemButton4.setFont(normalFont);
		itemButton4.setFocusPainted(false);
		itemButton4.addActionListener(invHandler);
		itemButton4.setActionCommand("item4");
		
		itemButton5 = new JButton();
		itemButton5.setBackground(Color.black);
		itemButton5.setForeground(Color.white);
		itemButton5.setFont(normalFont);
		itemButton5.setFocusPainted(false);
		itemButton5.addActionListener(invHandler);
		itemButton5.setActionCommand("item5");
		
		questButton1 = new JButton();
		questButton1.setBackground(Color.black);
		questButton1.setForeground(Color.white);
		questButton1.setFont(normalFont);
		questButton1.setFocusPainted(false);
		questButton1.addActionListener(qsHandler);
		questButton1.setActionCommand("quest1");
		
		questButton2 = new JButton();
		questButton2.setBackground(Color.black);
		questButton2.setForeground(Color.white);
		questButton2.setFont(normalFont);
		questButton2.setFocusPainted(false);
		questButton2.addActionListener(qsHandler);
		questButton2.setActionCommand("quest2");
		
		questButton3 = new JButton();
		questButton3.setBackground(Color.black);
		questButton3.setForeground(Color.white);
		questButton3.setFont(normalFont);
		questButton3.setFocusPainted(false);
		questButton3.addActionListener(qsHandler);
		questButton3.setActionCommand("quest3");
		
		questButton4 = new JButton();
		questButton4.setBackground(Color.black);
		questButton4.setForeground(Color.white);
		questButton4.setFont(normalFont);
		questButton4.setFocusPainted(false);
		questButton4.addActionListener(qsHandler);
		questButton4.setActionCommand("quest4");
		
		questButton5 = new JButton();
		questButton5.setBackground(Color.black);
		questButton5.setForeground(Color.white);
		questButton5.setFont(normalFont);
		questButton5.setFocusPainted(false);
		questButton5.addActionListener(qsHandler);
		questButton5.setActionCommand("quest5");
		
		inventoryPanel.add(itemButton1);
		inventoryPanel.add(itemButton2);
		inventoryPanel.add(itemButton3);
		inventoryPanel.add(itemButton4);
		inventoryPanel.add(itemButton5);
		inventoryPanel.setVisible(false);
		
		questPanel.add(questButton1);
		questPanel.add(questButton2);
		questPanel.add(questButton3);
		questPanel.add(questButton4);
		questPanel.add(questButton5);
		questPanel.setVisible(false);
	
		imagePanel = new JPanel();
		imagePanel.setBounds(50, 50, 600, 250);
		imagePanel.setBackground(Color.black);

		imageLabel = new JLabel();

		image = new ImageIcon(".//img//towngate.jpg");

		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);

		con.add(imagePanel);


		playerSetup();

	}
	public void playerSetup() {
		the_player.Stats.healthPool = 15;
		the_player.gold = 10;
		the_player.Stats.healthPool = 25;
		stickWeapon = new weapon("Stick", "A stick from the ground", new stats(0, 3, 0, 0), "weapon" , 2);
		weaponlabelName.setText(stickWeapon.toString());
		playerhplabelNumber.setText("" + the_player.Stats.healthPool);
		playergoldlabelNumber.setText("" + the_player.gold);
		the_player.primary = stickWeapon;
		inventoryStatus = "close";
		questStatus = "close";
		potion = new misc();
		berry = new misc();
		the_player.items.add(potion);
		the_player.items.add(berry);
		the_player.items.add(null);
		the_player.items.add(null);
		the_player.items.add(null);

		the_player.questList.add(null);
		the_player.questList.add(null);
		the_player.questList.add(null);
		the_player.questList.add(null);
		the_player.questList.add(null);
		
		castleGate();

	}
	

	public void castleGate() {
		image = new ImageIcon(".//img//towngate.jpg");
		imageLabel.setIcon(image);
		position = "castleGate";
		mainTextArea.setText("You are at the gate of the castle. \nA guard leans on a wall near you. \n\nWhat do you do?");
		optionButtons.get(0).setText("Move to the castle");
		optionButtons.get(1).setText("Attack guard");
		optionButtons.get(2).setText("Talk to guard");
		optionButtons.get(3).setText("Pick Berry");
		optionButtons.get(4).setText("Walk away from gate");
	}
	public void talkGuard() {
		position = "talkGuard";
		if (key == 1)
		{
			mainTextArea.setText("Guard: Hail Traveler, Welcome to the town of EverWinter!");
		}
		else {
			mainTextArea.setText("Guard: Hail Traveler,\nA Frost Troll has taken our city's priceless\nSilver Ring.\nIf you happen to see the troll\ntry to get the ring back for us would ya?\n(QUEST: Find Silver Ring!)");
			the_player.questList.set(0, frosttrollquest);
		}
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Your being dumb thinking\n you can win.\nGuard hits you hard. \n(Take 2 DMG)");
		the_player.Stats.healthPool = the_player.Stats.healthPool - 2;
		the_player.health.setValue(the_player.Stats.healthPool);
		playerhplabelNumber.setText(""+the_player.Stats.healthPool);
		if(the_player.Stats.healthPool < 0)
		{
			lose();
		}
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void pickBerry( ) {
		image = new ImageIcon(".//img//berry.jpg");
		imageLabel.setIcon(image);
		
		position = "pickBerry";
		int slotNumber = 0;
		while (the_player.items.get(slotNumber) != null && slotNumber <4) {
			slotNumber++;
		}
		if(the_player.items.get(slotNumber) == null) {
			mainTextArea.setText("You pick a Berry from a nearby bush.\n(You recieve a Berry!)");
			the_player.items.set(slotNumber, berry);
		}
		else if (the_player.items.get(slotNumber) != null) {
			mainTextArea.setText("You have too much stuff!");
		}
		
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void crossRoad() {
		image = new ImageIcon(".//img//crossroads.jpg");
		imageLabel.setIcon(image);

		position = "crossRoad";
		mainTextArea.setText("Walking away from the castle you find\n yourself at branching paths.\nGoing south leads back to the castle.");
		optionButtons.get(0).setText("Go North");
		optionButtons.get(1).setText("Go South");
		optionButtons.get(2).setText("Go East");
		optionButtons.get(3).setText("Go West");
		optionButtons.get(4).setText("Look at sky");
	}
	
	public void north() {
		image = new ImageIcon(".//img//overlook.jpeg");
		imageLabel.setIcon(image);
		position = "north";
		if (the_player.Stats.healthPool == the_player.Stats.healthPool) {
			the_player.Stats.healthPool = the_player.Stats.healthPool + 0;
			mainTextArea.setText("You find yourself at a overlook.\nYou take a moment to enjoy the view.\n(You have full health)\n "
					+ "You see a hidden path to the right which \nheads into the forest..");
		}
		else if (the_player.Stats.healthPool != the_player.Stats.healthPool) {
		the_player.Stats.healthPool = the_player.Stats.healthPool + 1;
		the_player.health.setValue(the_player.Stats.healthPool);
		mainTextArea.setText("You find yourself at an overlook.\nYou take a moment to enjoy the view.\n(HP healed by 1)\n"
		+ "You see a hidden path to the right which \nheads into the forest..");
		}
		playerhplabelNumber.setText(""+the_player.Stats.healthPool);
		optionButtons.get(0).setText("Go Back South");
		optionButtons.get(1).setText("Go On The Path");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void east() {
		position = "east";
		rustySword = new weapon("Rusty Sword", "An old rusty sword", new stats(0, 5, 0, 0, 0), "weapon", 5);
		if (the_player.primary == rustySword)
		{
			mainTextArea.setText("You find yourself at a large oak tree.");
		}
		else {
			mainTextArea.setText("You find yourself at a large oak tree.\n You find a Rusty Sword under the tree!\n(You obtain a Rusty Sword)\n");
			
			the_player.primary = rustySword; 
			weaponlabelName.setText(the_player.primary.itemName);
		}

		optionButtons.get(0).setText("Go South");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void sky() {
		image = new ImageIcon(".//img//sky.jpeg");
		imageLabel.setIcon(image);
		position = "sky";
		mainTextArea.setText("As you look up at the sky you can see smoke in the air to the North up in the trees...");
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	
	public void west() {
		image = new ImageIcon(".//img//frosttroll.jpg");
		imageLabel.setIcon(image);

		position = "west";
		mainTextArea.setText("You encounter a Frost Troll!\n");
		optionButtons.get(0).setText("Fight");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public int fight(int healthPool) {
		position = "fight";
		mainTextArea.setText("Monster HP: " + healthPool + "\n\nWhat do you do?");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		return healthPool;

	}
	public int attack(int monsterHealth) {
		position = "attack";
		mainTextArea.setText("You attacked the monster and gave\n" + the_player.primary.qualities.attack + " damage!");
		monsterHealth = monsterHealth - the_player.primary.qualities.attack;
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		return monsterHealth;

	}
	public void monsterAttack(int monsterAttack) {
		position = "monsterAttack";
		mainTextArea.setText("The monster attacked you and gave\n" + monsterAttack + " damage!");
		the_player.Stats.healthPool = the_player.Stats.healthPool - monsterAttack;
		playerhplabelNumber.setText(""+the_player.Stats.healthPool);
		the_player.health.setValue(the_player.Stats.healthPool);
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void win() {
		position ="win";
		if (silverRing == 1) 
		{
			int droppedGold = 0;
			droppedGold = new java.util.Random().nextInt(5) + 1;
			mainTextArea.setText("You defeated the monster!\n The troll dropped " + droppedGold + " gold!\n\n");
			the_player.gold = the_player.gold + droppedGold;
			playergoldlabelNumber.setText(""+the_player.gold);
			
		}
		else 
		{
			int slotNumber = 0;
			while (the_player.items.get(slotNumber) != null && slotNumber <4) {
				slotNumber++;
			}
			if(the_player.items.get(slotNumber) == null) {
				mainTextArea.setText("You defeated the monster!\n The troll dropped a ring\n\n(You obtained a Silver Ring");
				silverring = new misc();
				the_player.items.set(slotNumber, silverring);
			}
			else if (the_player.items.get(slotNumber) != null) {
				mainTextArea.setText("You have too much stuff!");
			}
			silverRing =1;
		}
		frostTroll.Stats.healthPool = 10;
		optionButtons.get(0).setText("Go east");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void wolfWin() {
		position ="wolfWin";
		int droppedGold = 0;
		droppedGold = new java.util.Random().nextInt(10) + 1;
		mainTextArea.setText("You defeated the wolf!\n The wolf dropped " + droppedGold + " gold!\n\n");
		the_player.gold = the_player.gold + droppedGold;
		playergoldlabelNumber.setText(""+the_player.gold);
		optionButtons.get(0).setText("Continue Straight");
		optionButtons.get(1).setText("Go South");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void lose() {
		position ="lose";
		mainTextArea.setText("You have died.\n\n<GAME OVER>");
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(0).setVisible(false);
		optionButtons.get(1).setVisible(false);
		optionButtons.get(2).setVisible(false);
		optionButtons.get(3).setVisible(false);
	}

	/*
	 * public void ending() { position ="ending"; mainTextArea.
	 * setText("Guard: Oh you killed that frost troll!\n Thank you so much! You are a hero!\n Welcome to the town of EverWinter\n\n Take this key to enter the city gates."
	 * ); optionButtons.get(0).setText(">");
	 * optionButtons.get(1).setText(""); optionButtons.get(2).setText("");
	 * optionButtons.get(3).setText(""); optionButtons.get(0).setVisible(false);
	 * optionButtons.get(1).setVisible(false);
	 * optionButtons.get(2).setVisible(false);
	 * optionButtons.get(3).setVisible(false);
	 * optionButtons.get(4).setVisible(false); inventoryButton.setVisible(false);
	 * musicButton.setVisible(false); }
	 */
	
	public void enterCity() {
		position = "enterCity";
		mainTextArea.setText("Guard: Oh you killed that frost troll!\n Thank you so much! You are a hero!\n Welcome to the town of EverWinter\n\n Take this key to enter the city gates.");
		key = 1; 
		silverRing = 0;
		the_player.questList.set(0, null);
		optionButtons.get(0).setText("Enter Town");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
		
	}
	public void path() {
		image = new ImageIcon(".//img//denseForest.jpeg");
		imageLabel.setIcon(image);
		position ="path";
		mainTextArea.setText("You find yourself on a beaten down path.\n Looks like its heading into the dense forest.");
		optionButtons.get(0).setText("Go South");
		optionButtons.get(1).setText("Continue Straight");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void TownEntrance() {
		image = new ImageIcon(".//img//town.jpeg");
		imageLabel.setIcon(image);
		position ="townEntrance";
		mainTextArea.setText("You use the key you obtained from the guard to open the castle gate. As soon as you enter"
				+ "\nyou see to the left a Shop Keep, to the right\n you see a crowd gathered around a stage...");
		optionButtons.get(0).setText("Go Left");
		optionButtons.get(1).setText("Go Right");
		optionButtons.get(2).setText("Continue Straight");
		optionButtons.get(3).setText("Back to Castle Gate");
		optionButtons.get(4).setText("");
	}
	public void Stage() {
		image = new ImageIcon(".//img//town.jpeg");
		imageLabel.setIcon(image);
		position ="Stage";
		mainTextArea.setText("You see people gathered around a stage with what looks to be the king on stage.");
		optionButtons.get(0).setText("Listen in");
		optionButtons.get(1).setText("Go Back to Center");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	
	public void CloseUpStage() {
		image = new ImageIcon(".//img//town.jpeg");
		imageLabel.setIcon(image);
		position ="CloseUpStage";
		mainTextArea.setText("You hear the King speak loudly to the people\n King: People of EverWinter, there is a dragon\nroaming amongst us, reeking havoc across\nour lands. We ask for the bravest heros to\nhelp us kill The Great Kong. If you are up\nfor the challenge head North into the forest\nto find Kong. Whoever brings the head to me will receive a great reward..");
		optionButtons.get(0).setText("Go Back to Center");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void WolfStage() {
		image = new ImageIcon(".//img//wolf.jpeg");
		imageLabel.setIcon(image);
		position ="WolfStage";
		mainTextArea.setText("As you continue straight you hear a howl as a\nbig ice wolf jumps in front of you ready to\nattack.");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	
	
	public void NorthForestSplit() {
		image = new ImageIcon(".//img//mountain.jpeg");
		imageLabel.setIcon(image);
		position ="NorthForestSplit";
		mainTextArea.setText("As you continue to walk the path you see it\nleading straight up a mountain. You also\nnotice to your right a path leading to a small\nstream and to your left a path leading to an\nold house...");
		optionButtons.get(0).setText("Straight");
		optionButtons.get(1).setText("Right");
		optionButtons.get(2).setText("Left");
		optionButtons.get(3).setText("South");
		optionButtons.get(4).setText("");
		
	}
	public void toMountain() {
		image = new ImageIcon(".//img//wolf.jpeg");
		imageLabel.setIcon(image);
		position ="WolfStage";
		mainTextArea.setText("As you begin the hike up the mountain you\ncome across a ...");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void right() {
		image = new ImageIcon(".//img//wolf.jpeg");
		imageLabel.setIcon(image);
		position ="WolfStage";
		mainTextArea.setText("As you continue straight you hear a howl as a\nbig ice wolf jumps in front of you ready to\nattack.");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void left() {
		image = new ImageIcon(".//img//wolf.jpeg");
		imageLabel.setIcon(image);
		position ="WolfStage";
		mainTextArea.setText("As you continue straight you hear a howl as a\nbig ice wolf jumps in front of you ready to\nattack.");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	

	
	public void itemUsed(int slotNumber) {
		
		if (the_player.Stats.healthPool >= the_player.Stats.healthPool) {
			the_player.Stats.healthPool = the_player.Stats.healthPool + 0;
			if(the_player.items.get(0) == null)
			{
				itemButton1.setText("empty");
			}
			else
			{
				itemButton1.setText(the_player.items.get(0).itemName);
			}
			if(the_player.items.get(1) == null)
			{
				itemButton2.setText("empty");
			}
			else
			{
				itemButton2.setText(the_player.items.get(0).itemName);
			}
			if(the_player.items.get(2) == null)
			{
				itemButton3.setText("empty");
			}
			else
			{
				itemButton3.setText(the_player.items.get(0).itemName);
			}
			if(the_player.items.get(3) == null)
			{
				itemButton4.setText("empty");
			}
			else
			{
				itemButton4.setText(the_player.items.get(0).itemName);
			}
			if(the_player.items.get(0) == null)
			{
				itemButton5.setText("empty");
			}
			else
			{
				itemButton5.setText(the_player.items.get(0).itemName);
			}
		}
		else {
		
		the_player.Stats.healthPool = the_player.Stats.healthPool + the_player.items.get(slotNumber).qualities.healthPool;
		playerhplabelNumber.setText(""+the_player.Stats.healthPool);
		the_player.health.setValue(the_player.Stats.healthPool);
		the_player.items.set(slotNumber, null);
		if(the_player.items.get(0) == null)
		{
			itemButton1.setText("empty");
		}
		else
		{
			itemButton1.setText(the_player.items.get(0).itemName);
		}
		if(the_player.items.get(1) == null)
		{
			itemButton2.setText("empty");
		}
		else
		{
			itemButton2.setText(the_player.items.get(0).itemName);
		}
		if(the_player.items.get(2) == null)
		{
			itemButton3.setText("empty");
		}
		else
		{
			itemButton3.setText(the_player.items.get(0).itemName);
		}
		if(the_player.items.get(3) == null)
		{
			itemButton4.setText("empty");
		}
		else
		{
			itemButton4.setText(the_player.items.get(0).itemName);
		}
		if(the_player.items.get(0) == null)
		{
			itemButton5.setText("empty");
		}
		else
		{
			itemButton5.setText(the_player.items.get(0).itemName);
		}
		}
		
	}
	public void questDesc(int slotNumber) {
		mainTextArea.setText(the_player.questList.get(slotNumber).questName + " : " + the_player.questList.get(slotNumber).questDesc);
	}

	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			enterName();

		}

	}
	public class InputHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			text = jtf.getText();
			if (text.length() < 1) {
				text = "NoName";
			}
			playerInterface();

		}

	}
	public class InventoryHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "inventoryButton":
				if(inventoryStatus.equals("close")) {
					optionButtons.get(0).setVisible(false);
					optionButtons.get(1).setVisible(false);
					optionButtons.get(2).setVisible(false);
					optionButtons.get(3).setVisible(false);
					optionButtons.get(4).setVisible(false);
					musicButton.setVisible(false);
					questButton.setVisible(false);
					inventoryPanel.setVisible(true);
					if(the_player.items.get(0) == null)
					{
						itemButton1.setText("empty");
					}
					else
					{
						itemButton1.setText(the_player.items.get(0).itemName);
					}
					if(the_player.items.get(1) == null)
					{
						itemButton2.setText("empty");
					}
					else
					{
						itemButton2.setText(the_player.items.get(1).itemName);
					}
					if(the_player.items.get(2) == null)
					{
						itemButton3.setText("empty");
					}
					else
					{
						itemButton3.setText(the_player.items.get(2).itemName);
					}
					if(the_player.items.get(3) == null)
					{
						itemButton4.setText("empty");
					}
					else
					{
						itemButton4.setText(the_player.items.get(3).itemName);
					}
					if(the_player.items.get(0) == null)
					{
						itemButton5.setText("empty");
					}
					else
					{
						itemButton5.setText(the_player.items.get(4).itemName);
					}
					inventoryStatus = "open";
				}
				else if (inventoryStatus.equals("open")) {
					optionButtons.get(0).setVisible(true);
					optionButtons.get(1).setVisible(true);
					optionButtons.get(2).setVisible(true);
					optionButtons.get(3).setVisible(true);
					optionButtons.get(4).setVisible(true);
					musicButton.setVisible(true);
					questButton.setVisible(true);
					inventoryPanel.setVisible(false);
					inventoryStatus = "close";
				}
				break;
			case "item1":
				if (the_player.items.get(0) == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else {
				itemUsed(0);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item2":
				if (the_player.items.get(1) == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else {
				itemUsed(1);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item3":
				if (the_player.items.get(2) == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else {
				itemUsed(2);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item4":
				if (the_player.items.get(3) == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else {
				itemUsed(3);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item5":
				if (the_player.items.get(4) == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else {
				itemUsed(4);
				mainTextArea.setText("Restored Health");
				}
				break;
			}

		}

	}
	public class QuestHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "quests":
				if(questStatus.equals("close")) {
					optionButtons.get(0).setVisible(false);
					optionButtons.get(1).setVisible(false);
					optionButtons.get(2).setVisible(false);
					optionButtons.get(3).setVisible(false);
					optionButtons.get(4).setVisible(false);
					musicButton.setVisible(false);
					inventoryButton.setVisible(false);
					questPanel.setVisible(true);
					if(the_player.questList.get(0) == null)
					{
						questButton1.setText("empty");
					}
					else
					{
						questButton1.setText(the_player.questList.get(0).questName);
					}
					if(the_player.questList.get(1) == null)
					{
						questButton2.setText("empty");
					}
					else
					{
						questButton2.setText(the_player.questList.get(1).questName);
					}
					if(the_player.questList.get(2) == null)
					{
						questButton3.setText("empty");
					}
					else
					{
						questButton3.setText(the_player.questList.get(2).questName);
					}
					if(the_player.questList.get(3) == null)
					{
						questButton4.setText("empty");
					}
					else
					{
						questButton4.setText(the_player.questList.get(3).questName);
					}
					if(the_player.questList.get(0) == null)
					{
						questButton5.setText("empty");
					}
					else
					{
						questButton5.setText(the_player.questList.get(4).questName);
					}
					questStatus = "open";
				}
				else if (questStatus.equals("open")) {
					optionButtons.get(0).setVisible(true);
					optionButtons.get(1).setVisible(true);
					optionButtons.get(2).setVisible(true);
					optionButtons.get(3).setVisible(true);
					optionButtons.get(4).setVisible(true);
					musicButton.setVisible(true);
					inventoryButton.setVisible(true);
					questPanel.setVisible(false);
					questStatus = "close";
				}
				break;
			case "quest1":
				questDesc(0);
				break;
			case "quest2":
				questDesc(1);
				break;
			case "quest3":
				questDesc(2);
				break;
			case "quest4":
				questDesc(3);
				break;
			case "quest5":
				questDesc(4);
				break;
			}

		}

	}
	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {


			se.setFile(clickSound);
			se.play();

			String yourChoice = event.getActionCommand();
			switch(yourChoice) {
			case "musicb":
				if(musicOnOff.equals("off")) {
				mu.setFile(gameMusic);
				mu.play();
				mu.loop();
				musicOnOff = "on";
				musicButton.setText("Music On");
				}
				else if (musicOnOff.equals("on")) {
					mu.stop();
					musicOnOff = "off";
					musicButton.setText("Music Off");
				}
			}
			switch(position) {
			case "castleGate":
				switch(yourChoice) {
				case "c3":
					for (int i = 0 ; i < the_player.items.size(); i++) {
						if (the_player.items.get(i) == silverring) {
							itemUsed(i);
							enterCity(); 
							break;
							}
						else {
							talkGuard();
						}
					}
					break; 
					
					
				case "c1": 
					if (key == 1)
						{
						TownEntrance(); 
						}
					else
					{
						talkGuard();
					}
					break;
				case "c2": attackGuard(); break;
				case "c4": pickBerry(); break;
				case "c5": crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": castleGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1": castleGate(); break;
				}
				break;
			case "pickBerry":
				switch(yourChoice) {
				case "c1": castleGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": castleGate(); break;
				case "c3": east(); break;
				case "c4": west(); break;
				case "c5": sky(); break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				case "c2" : path(); break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1": monsterHealth = fight(frostTroll.health.getValue()); 
							monsterAttack = frostTroll.attack(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "sky":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "path":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": WolfStage(); break;
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1": monsterHealth = attack(monsterHealth); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "attack":
				switch(yourChoice) {
				case "c1":
					if(monsterHealth<1) {
						if (monsterAttack == 3) {
						   win();
						}
						else if (monsterAttack == 6) {
							   wolfWin();
							}
					}
					else {
						monsterAttack(monsterAttack);
					}
					 break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c1":
					if(the_player.Stats.healthPool<1) {
						lose();
					}
					else {
						fight(monsterHealth);
					}
					 break;
				}
				break;
			case "win":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "enterCity":
				switch(yourChoice) {
				case "c1": TownEntrance(); break;
				}
				break;
			case "townEntrance":
				switch(yourChoice) {
				case "c1": TownEntrance(); break;
				case "c2": Stage(); break;
				case "c3": TownEntrance(); break;
				case "c4": castleGate(); break;
				}
				break;
			case "Stage":
				switch(yourChoice) {
				case "c1": CloseUpStage(); break;
				case "c2": TownEntrance(); break;
				}
				break;
			case "CloseUpStage":
				switch(yourChoice) {
				case "c1": TownEntrance(); break;
				}
				break;
			case "WolfStage":
				switch(yourChoice) {
				case "c1": monsterHealth = fight(wolf.health.getValue()); 
				monsterAttack = wolf.attack(); break;
				case "c2": path(); break;
				}
				break;
			case "wolfWin":
				switch(yourChoice) {
				case "c1": NorthForestSplit(); break;
				case "c2": path(); break;
				}
				break;
			case "NorthForestSplit":
				switch(yourChoice) {
				case "c1": toMountain(); break;
				case "c2": right(); break;
				case "c3": left(); break;
				case "c4": path(); break;
				}
				break;

			}

		}
	}
}
