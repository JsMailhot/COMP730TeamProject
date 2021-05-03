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

public class startGame {
	Boolean enterGame;
	Container con;
	JPanel titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel, imagePanel, namePanel, inputPanel, healthBarPanel, inventoryPanel, questPanel;
	JLabel titleScreenLabel, playerhpLabel, playernameLabel, playerhplabelNumber, weaponLabel, weaponlabelName, imageLabel, nameLabel, playergoldLabel, playergoldlabelNumber;
	JButton startButton, musicButton, enterButton, inventoryButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5, questButton, questButton1, questButton2, questButton3, questButton4, questButton5;
	JTextArea mainTextArea;
  
	int silverRing, gold, key, pelt, head;
	int playerHPCap = 25;
	int mimickey;

	String weapon, position, text, inventoryStatus, questStatus;
	String clickSound, gameMusic, musicOnOff, cantuse;
	ImageIcon image;
	Font titleFont = new Font("Times New Roman", Font.BOLD, 82);
	Font normalFont = new Font("Times New Roman", Font.ITALIC, 24);
	JTextField jtf;
	List difficulty;
	player player = new player();
	JFrame window;
	ArrayList<JButton> optionButtons = new ArrayList<JButton>();
	JProgressBar healthBar;

	InputHandler iHandler = new InputHandler();
	Music mu = new Music();
	SoundEffect se = new SoundEffect();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	InventoryHandler invHandler = new InventoryHandler();
	QuestHandler qsHandler = new QuestHandler();
	armor complex_armor = new armor("pants", "required to shop", new stats(), "enchanted".toCharArray()); // create a complex armor
	quest NoQuest = new quest("Empty");
	quest frosttrollquest = new quest("Kill Frost Troll", "The local guard wants me to kill a \n frost troll that took his ring.");
	quest wolfquest = new quest("Hunt wolf", "The local inkeep wants me to hunt a wolf and bring him a pelt");
	quest mainquest = new quest("Kill Dragon", "The local king wants me to kill the dragon in the north and bring him its head");
	
	int monsterHealth = 0;
	int monsterAttack = 0;
	
	quest[] quests = new quest[5];
	SuperItem[] playerItem = new SuperItem[5];
	Item_Potion potion = new Item_Potion();
	Item_Berry berry = new Item_Berry();
	Item_Empty empty = new Item_Empty();
	silverRing silverring = new silverRing();
	wolfPelt wolfpelt = new wolfPelt();
	dragonHead dragonhead = new dragonHead();
	
	stats frostTrollStats = new stats(10, 3, 2, 0, 0);
	stats wolfStats = new stats(15, 6, 2, 0, 0);
	stats mimicStats = new stats(20, 12, 2, 0, 0);
	stats goblinStats = new stats(20, 9, 2, 0, 0);
	stats kingkongStats = new stats(30, 14, 3, 0, 0);

	
	
	enemy frostTroll = new enemy(0, new ArrayList<item>(), frostTrollStats, "Frost Troll", "Troll", "Frost Troll which is located in the coldest areas of the world",null, 2, new weapon());
	enemy wolf = new enemy(0, new ArrayList<item>(), wolfStats, "Frost Wolf", "Wolf", "Frost Wolves roam the dense forests",null, 2, new weapon());
	enemy mimic = new enemy(0, new ArrayList<item>(), mimicStats, "Mimic Chest", "Mimic", "Treasure Chest",null, 2, new weapon());
	enemy goblin = new enemy(0, new ArrayList<item>(), goblinStats, "Small Goblin", "Goblin", "Here to take your loot.",null, 2, new weapon());
	enemy kingkong = new enemy(0, new ArrayList<item>(), kingkongStats, "King Kong", "Dragon", "Not what you were expecting.",null, 2, new weapon());
	
	
	stats playerStats = new stats(25, 5, 5, 0, 0);
	player Player = new player(25, new ArrayList<item>(), playerStats, "player", "playerName", "A young elf looking for adventure", null, 0, new weapon(), null, new armor());
	
	stats rustySwordStats = new stats(0, 10, 0, 0, 0);
	weapon rustySword = new weapon("Rusty Sword", "An old rusty sword", rustySwordStats, "weapon", 5);
	
	stats stickStats = new stats(0, 3, 0, 0, 0);
	weapon stickWeapon = new weapon("Stick", "A stick from the ground", stickStats, "weapon" , 2);

	
	
	int i, soundCue;
	
	
	public static void main(String[] args) {
		new startGame();

	}
	public startGame() {
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
		titleScreenPanel.setVisible(false);
		startButtonPanel.setVisible(false);

		namePanel = new JPanel();
		namePanel.setBounds(150, 250, 500, 100);
		namePanel.setBackground(Color.black);
		nameLabel = new JLabel("Please enter your name:");
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(normalFont);
		namePanel.add(nameLabel);
		con.add(namePanel);

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
		namePanel.setVisible(false);
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
		playernameLabel = new JLabel(text);
		playernameLabel.setFont(normalFont);
		playernameLabel.setForeground(Color.white);
		healthBarPanel.add(playernameLabel);
		playerhpLabel = new JLabel("  HP:");
		playerhpLabel.setFont(normalFont);
		playerhpLabel.setForeground(Color.white);
		healthBarPanel.add(playerhpLabel);
		playerhplabelNumber = new JLabel();
		playerhplabelNumber.setFont(normalFont);
		playerhplabelNumber.setForeground(Color.white);
		healthBarPanel.add(playerhplabelNumber);
		healthBar = new JProgressBar(0, 25);
		healthBar.setPreferredSize(new Dimension(200, 25));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.green);
		healthBarPanel.add(healthBar);
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
		playerStats.healthPool = 25;
		player.gold = 10;
		playerHPCap = 25;
		weaponlabelName.setText(stickWeapon.toString());
		playerhplabelNumber.setText("" + playerStats.healthPool);
		playergoldlabelNumber.setText("" + player.gold);
		player.primary = stickWeapon;
		inventoryStatus = "close";
		questStatus = "close";
		
		playerItem[0] = potion;
		playerItem[1] = berry;
		playerItem[2] = empty;
		playerItem[3] = empty;
		playerItem[4] = empty;
		
		quests[0] = NoQuest;
		quests[1] = NoQuest;
		quests[2] = NoQuest;
		quests[3] = NoQuest;
		quests[4] = NoQuest;
		healthBar.setValue(playerStats.healthPool);
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
			quests[0] = frosttrollquest;
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
		playerStats.healthPool = playerStats.healthPool - 2;
		healthBar.setValue(playerStats.healthPool);
		playerhplabelNumber.setText(""+playerStats.healthPool);
		if(playerStats.healthPool < 0)
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
		while (playerItem[slotNumber] != empty && slotNumber <4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==empty) {
			mainTextArea.setText("You pick a Berry from a nearby bush.\n(You recieve a Berry!)");
			playerItem[slotNumber] = berry;
		}
		else if (playerItem[slotNumber] != empty) {
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
		if (playerStats.healthPool == playerHPCap) {
			playerStats.healthPool = playerStats.healthPool + 0;
			mainTextArea.setText("You find yourself at a overlook.\nYou take a moment to enjoy the view.\n(You have full health)\n "
					+ "You see a hidden path to the right which \nheads into the forest..");
		}
		else if (playerStats.healthPool != playerHPCap) {
		playerStats.healthPool = playerStats.healthPool + 1;
		healthBar.setValue(playerStats.healthPool);
		mainTextArea.setText("You find yourself at an overlook.\nYou take a moment to enjoy the view.\n(HP healed by 1)\n"
		+ "You see a hidden path to the right which \nheads into the forest..");
		}
		playerhplabelNumber.setText(""+playerStats.healthPool);
		optionButtons.get(0).setText("Go Back South");
		optionButtons.get(1).setText("Go On The Path");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void east() {
		position = "east";
		if (player.primary == rustySword)
		{
			mainTextArea.setText("You find yourself at a large oak tree.");
		}
		else {
			mainTextArea.setText("You find yourself at a large oak tree.\n You find a Rusty Sword under the tree!\n(You obtain a Rusty Sword)\n");
			
			player.primary = rustySword; 
			weaponlabelName.setText(player.primary.itemName);
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
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		return healthPool;

	}
	public int attack(int monsterHealth) {
		position = "attack";
		mainTextArea.setText("You attacked the monster and gave\n" + player.primary.qualities.attack + " damage!");
		monsterHealth = monsterHealth - player.primary.qualities.attack;
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
		playerStats.healthPool = playerStats.healthPool - monsterAttack;
		playerhplabelNumber.setText(""+playerStats.healthPool);
		healthBar.setValue(playerStats.healthPool);
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void win() {
		position ="win";
		if (silverRing == 1 || key == 1) 
		{
			int droppedGold = 0;
			droppedGold = new java.util.Random().nextInt(5) + 1;
			mainTextArea.setText("You defeated the monster!\n The troll dropped " + droppedGold + " gold!\n\n");
			player.gold = player.gold + droppedGold;
			playergoldlabelNumber.setText(""+player.gold);
			
		}
		else 
		{
			int slotNumber = 0;
			while (playerItem[slotNumber] != empty && slotNumber <4) {
				slotNumber++;
			}
			if(playerItem[slotNumber]==empty) {
				mainTextArea.setText("You defeated the monster!\n The troll dropped a ring\n\n(You obtained a Silver Ring");
				playerItem[slotNumber] = silverring;
			}
			else if (playerItem[slotNumber] != empty) {
				mainTextArea.setText("You have too much stuff!");
			}
			silverRing =1;
		}
		frostTrollStats.healthPool = 10;
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
		mainTextArea.setText("You defeated the wolf!\nThe wolf dropped " + droppedGold + " gold and a fur pelt!\n\n");
		player.gold = player.gold + droppedGold;
		
		int slotNumber = 0;
		while (playerItem[slotNumber] != empty && slotNumber <4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==empty) {
			playerItem[slotNumber] = wolfpelt;
			pelt = 1;
		}
		else if (playerItem[slotNumber] != empty) {
			mainTextArea.setText("You have too much stuff!");
		}
		
		playergoldlabelNumber.setText(""+player.gold);
		optionButtons.get(0).setText("Continue Straight");
		optionButtons.get(1).setText("Go South");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void goblinWin() {
		position ="goblinWin";
		int droppedGold = 0;
		droppedGold = new java.util.Random().nextInt(15) + 1;
		mainTextArea.setText("You defeated the goblin!\nThe goblin dropped " + droppedGold + " gold and a potion!\n\n");
		player.gold = player.gold + droppedGold;
		
		int slotNumber = 0;
		while (playerItem[slotNumber] != empty && slotNumber <4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==empty) {
			playerItem[slotNumber] = potion;
		}
		else if (playerItem[slotNumber] != empty) {
			mainTextArea.setText("You have too much stuff!");
		}
		
		playergoldlabelNumber.setText(""+player.gold);
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void dragonWin() {
		position ="dragonWin";
		int droppedGold = 0;
		droppedGold = new java.util.Random().nextInt(100) + 1;
		mainTextArea.setText("You defeated the dragon!\nThe dragon dropped " + droppedGold + " gold and a ITS HEAD!\n\n");
		player.gold = player.gold + droppedGold;
		
		int slotNumber = 0;
		while (playerItem[slotNumber] != empty && slotNumber <4) {
			slotNumber++;
		}
		if(playerItem[slotNumber]==empty) {
			playerItem[slotNumber] = dragonhead;
			head = 1;
		}
		else if (playerItem[slotNumber] != empty) {
			mainTextArea.setText("You have too much stuff!");
		}
		
		playergoldlabelNumber.setText(""+player.gold);
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
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
		quests[0] = NoQuest;
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
		mainTextArea.setText("You use the key you obtained from the guard to open the castle gate. As soon as you enter\nstraight ahead you see the EverWinter Inn,"
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
		if (head == 1)
		{
			mainTextArea.setText("HAIL " + text + " SAVIOR OF EVERWINTER (MAIN QUEST COMPLETE)");
			quests[2] = NoQuest;
		}
		else {
			mainTextArea.setText("You hear the King speak loudly to the people\n King: People of EverWinter, there is a dragon\nroaming amongst us, reeking havoc across\nour lands. We ask for the bravest heros to\nhelp us kill The Great Kong. If you are up\nfor the challenge head North into the forest\nto find Kong. Whoever brings the head to me will receive a great reward..");
			quests[2] = mainquest;
		}
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
		image = new ImageIcon(".//img//dragon.jpg");
		imageLabel.setIcon(image);
		position ="DragonStage";
		mainTextArea.setText("As you begin the hike up the mountain you\nsee a red dragon swoop down\nand perch right in front of you.\nReady or not its time to fight.");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void right() {
		image = new ImageIcon(".//img//goblin.jpg");
		imageLabel.setIcon(image);
		position ="GoblinStage";
		mainTextArea.setText("As you continue along the stream\na golbin jumps out to\nattack.");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void left() {
		image = new ImageIcon(".//img//treasurechest.jpeg");
		imageLabel.setIcon(image);
		position ="left";
		mainTextArea.setText("As you head into the old burnt down house\nyou notice a locked treasure chest on the\ntable in front of you.");
		optionButtons.get(0).setText("Look for key");
		optionButtons.get(1).setText("Go back");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void unlockchest() {
		image = new ImageIcon(".//img//treasurechest.jpeg");
		imageLabel.setIcon(image);
		position ="unlockchest";
		mainTextArea.setText("As you unlock the chest you notice\nyou notice the chest begins to grow legs,\nand suddenly you feel breathing against your hands...");
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void chestFight() {
		image = new ImageIcon(".//img//mimicChest.jpeg");
		imageLabel.setIcon(image);
		position ="chestFight";
		mainTextArea.setText("Faster than you can blink;\nthe chest transforms\n");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void chestWin() {
		position ="chestWin";
		int droppedGold = 0;
		droppedGold = new java.util.Random().nextInt(80) + 10;
		mainTextArea.setText("You defeated the chest mimic and it dropped " + droppedGold + " gold!\n\n");
		player.gold = player.gold + droppedGold;

		playergoldlabelNumber.setText(""+player.gold);
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	
	public void lookAround() {
		image = new ImageIcon(".//img//chestroom.jpeg");
		imageLabel.setIcon(image);
		position ="lookAround";
		mainTextArea.setText("You begin looking around the dark room for the key to the chest..");
		optionButtons.get(0).setText("Look under book");
		optionButtons.get(1).setText("Look under table");
		optionButtons.get(2).setText("Look behind door");
		optionButtons.get(3).setText("Look on the floor");
		optionButtons.get(4).setText("Go back");
		
	}
	
	public void EverWinterInn() {
		image = new ImageIcon(".//img//innkeeper.jpeg");
		imageLabel.setIcon(image);
		position ="EverWinterInn";
		mainTextArea.setText("Inn Keeper: Hello Traveler!\nWhat might I do for you?\n");
		optionButtons.get(0).setText("Mead: 2 Gold");
		optionButtons.get(1).setText("Wine: 2 Gold");
		optionButtons.get(2).setText("Mystical Ale: 10 Gold");
		optionButtons.get(3).setText("Talk to Inn Keeper");
		optionButtons.get(4).setText("Leave");
		
	}
	public void InnQuest() {
		image = new ImageIcon(".//img//innkeeper.jpeg");
		imageLabel.setIcon(image);
		position ="InnQuest";
		if (pelt == 1)
		{
			mainTextArea.setText("Thank you for getting the wolf's pelt! Here is 15 gold.");
			player.gold = player.gold + 15;
			playergoldlabelNumber.setText("" + player.gold);
			quests[1] = NoQuest;
		}
		else {
			mainTextArea.setText("Inn Keeper: Aye Traveler,\nI'm in need of a wolf pelt. If you come\nacross one be sure to bring it to me\nas I will give you 15 gold for it.\n");
			quests[1] = wolfquest;
		}
		optionButtons.get(0).setText("Leave");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void drink(int drinkcost) {
		image = new ImageIcon(".//img//innkeeper.jpeg");
		imageLabel.setIcon(image);
		position ="drink";
		if (drinkcost == 2)
		{
			player.gold = player.gold - 2;
			playergoldlabelNumber.setText("" + player.gold);
			mainTextArea.setText("You drink the Mead and feel refreshed\n You are back to full health.");
			playerStats.healthPool = playerHPCap;
			healthBar.setValue(playerStats.healthPool);
			playerhplabelNumber.setText("" + playerStats.healthPool);
		}
		else if (drinkcost == 3)
		{
			player.gold = player.gold - 3;
			playergoldlabelNumber.setText("" + player.gold);
			mainTextArea.setText("You drink the Wine and feel refreshed\n You are back to full health.");
			playerStats.healthPool = playerHPCap;
			playerhplabelNumber.setText("" + playerStats.healthPool);
			healthBar.setValue(playerStats.healthPool);
		}
		else if (drinkcost == 10)
		{
			player.gold = player.gold - 10;
			playergoldlabelNumber.setText("" + player.gold);
			mainTextArea.setText("\n");
			mainTextArea.setText("You drink the Mystical Ale and feel refreshed but different..\nYou are back to full health and you've gained 5 HP to your total HP.");
			playerHPCap = playerHPCap + 5;
			playerStats.healthPool = playerHPCap;
			playerStats.healthPool = playerHPCap;
			playerhplabelNumber.setText("" + playerStats.healthPool);
			healthBar.setPreferredSize(new Dimension(200, playerStats.healthPool));
			healthBar.setValue(playerStats.healthPool);
		}
		optionButtons.get(0).setText("Leave");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	
	public void itemUsed(int slotNumber) {
		
		if (playerStats.healthPool >= playerHPCap) {
			playerStats.healthPool = playerStats.healthPool + 0;
			playerItem[slotNumber] = empty;
			itemButton1.setText(playerItem[0].name);
			itemButton2.setText(playerItem[1].name);
			itemButton3.setText(playerItem[2].name);
			itemButton4.setText(playerItem[3].name);
			itemButton5.setText(playerItem[4].name);
		}
		else {
		
		playerStats.healthPool = playerStats.healthPool + playerItem[slotNumber].healingValue;
		playerhplabelNumber.setText(""+playerStats.healthPool);
		healthBar.setValue(playerStats.healthPool);
		playerItem[slotNumber] = empty;
		itemButton1.setText(playerItem[0].name);
		itemButton2.setText(playerItem[1].name);
		itemButton3.setText(playerItem[2].name);
		itemButton4.setText(playerItem[3].name);
		itemButton5.setText(playerItem[4].name);
		}
		
	}
	public void questDesc(int slotNumber) {
		mainTextArea.setText(quests[slotNumber].questName + " : " + quests[slotNumber].questDesc);
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
					itemButton1.setText(playerItem[0].name);
					itemButton2.setText(playerItem[1].name);
					itemButton3.setText(playerItem[2].name);
					itemButton4.setText(playerItem[3].name);
					itemButton5.setText(playerItem[4].name);
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
				if (playerItem[0] == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else if (playerItem[0] == wolfpelt) {
					mainTextArea.setText("Can't use a wolf pelt");
				}
				else {
				itemUsed(0);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item2":
				if (playerItem[1] == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else if (playerItem[1] == wolfpelt) {
					mainTextArea.setText("Can't use a wolf pelt");
				}
				else {
				itemUsed(1);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item3":
				if (playerItem[2] == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else if (playerItem[2] == wolfpelt) {
					mainTextArea.setText("Can't use a wolf pelt");
				}
				else {
				itemUsed(2);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item4":
				if (playerItem[3] == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else if (playerItem[3] == wolfpelt) {
					mainTextArea.setText("Can't use a wolf pelt");
				}
				else {
				itemUsed(3);
				mainTextArea.setText("Restored Health");
				}
				break;
			case "item5":
				if (playerItem[4] == silverring) {
					mainTextArea.setText("Can't use a ring");
				}
				else if (playerItem[4] == wolfpelt) {
					mainTextArea.setText("Can't use a wolf pelt");
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
					questButton1.setText(quests[0].questName);
					questButton2.setText(quests[1].questName);
					questButton3.setText(quests[2].questName);
					questButton4.setText(quests[3].questName);
					questButton5.setText(quests[4].questName);
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
					for (int i = 0 ; i < playerItem.length; i++) {
						if (playerItem[i] == silverring) {
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
				case "c1": monsterHealth = fight(frostTrollStats.healthPool); 
							monsterAttack = frostTrollStats.attack; break;
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
						else if (monsterAttack == 12)
						{
							chestWin();

						else if (monsterAttack == 9) {
							   goblinWin();
							}
						else if (monsterAttack == 14) {
							dragonWin();

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
					if(playerStats.healthPool<1) {
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
				case "c3": EverWinterInn(); break;
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
				case "c1": monsterHealth = fight(wolfStats.healthPool); 
				monsterAttack = wolfStats.attack; break;
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
			case "EverWinterInn":
				switch(yourChoice) {
				
				case "c1": 
					if (player.gold >= 2) {
						drink(2); break;
					}
					else 
					{
						mainTextArea.setText("Sorry you can't afford that right now.");
						break;
					}
				case "c2": 
					if (player.gold >= 3) {
						drink(3); break;
					}
					else 
					{
						mainTextArea.setText("Sorry you can't afford that right now.");
						break;
					}
				case "c3":	
					if (player.gold >= 10) {
						drink(10); break;
				}
					else 
					{
						mainTextArea.setText("Sorry you can't afford that right now.");
						break;
					}
				case "c4": InnQuest(); break;
				case "c5": TownEntrance(); break;
				}
				break;
				
			case "InnQuest":
				switch(yourChoice) {
				case "c1":
					for (int i = 0 ; i < playerItem.length; i++) {
						if (playerItem[i] == wolfpelt) {
							itemUsed(i);
							EverWinterInn(); 
							break;
							}
						else {
							EverWinterInn();
						}
					}
					break; 
				}
				break;
			case "drink":
				switch(yourChoice) {
				case "c1": EverWinterInn(); break;
				}
				break;

			case "left":
				switch(yourChoice) {
				case "c1": if(mimickey == 0)
				{
					lookAround(); break;
				}
				else if (mimickey == 1)
				{
					mainTextArea.setText("You already found the key.");
					break;
				}
				case "c2": NorthForestSplit(); break;
				}
				break;
				
			case "lookAround":
				switch(yourChoice) {
				case "c1": 
					mainTextArea.setText("No key under the book..");
				break;
				case "c2": 
					mainTextArea.setText("No key under the table..."); 
				break;
				case "c3": 
					mainTextArea.setText("No key behind the door..."); 
				break;
				case "c4": 
					mainTextArea.setText("Aha! The key was on the floor under the carpet...\n You begin to open the chest..");
					mimickey = 1;
					unlockchest();
				break;
				}
				break;
				
			case "unlockchest":
				switch(yourChoice) {
				case "c1": chestFight(); break;				
				}
				break;
				
			case "chestFight":
				switch(yourChoice) {
				case "c1": monsterHealth = fight(mimicStats.healthPool); 
				monsterAttack = mimicStats.attack; break;
				case "c2": left(); break;			
				}
				break;
			case "chestWin":
				switch(yourChoice) {
				case "c1":  NorthForestSplit();break;		
				}
				break;

			case "GoblinStage":
				switch(yourChoice) {
				case "c1": 
					monsterHealth = fight(goblinStats.healthPool); 
					monsterAttack = goblinStats.attack; break;
				case "c2":
					NorthForestSplit();
					break;
				}
				break;
			case "goblinWin":
				switch(yourChoice) {
				case "c1":
					NorthForestSplit();
					break;
				}
				break;
			case "DragonStage":
				switch(yourChoice) {
				case "c1": 
					monsterHealth = fight(kingkongStats.healthPool); 
					monsterAttack = kingkongStats.attack; break;
				}
				break;
			case "dragonWin":
				switch(yourChoice) {
				case "c1":
					NorthForestSplit();
					break;
				}
				break;
			}
				}

		}
	}
