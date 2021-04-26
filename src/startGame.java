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
	JPanel titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel, imagePanel, namePanel, inputPanel, healthBarPanel, inventoryPanel;
	JLabel titleScreenLabel, playerhpLabel, playernameLabel, playerhplabelNumber, weaponLabel, weaponlabelName, imageLabel, nameLabel, playergoldLabel, playergoldlabelNumber;
	JButton startButton, musicButton, enterButton, inventoryButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
	JTextArea mainTextArea;
	int playerHP, frostTrollHP, playerHPCap, silverRing, gold, key;
	String weapon, position, text, inventoryStatus;
	String clickSound, gameMusic, musicOnOff;
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
	armor complex_armor = new armor("pants", "required to shop", new stats(), "enchanted".toCharArray());	// create a complex armor
	
	SuperItem[] playerItem = new SuperItem[5];
	Item_Potion potion = new Item_Potion();
	Item_Berry berry = new Item_Berry();
	Item_Empty empty = new Item_Empty();

	
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
		mainTextArea.setBounds(50, 500, 550, 250);
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


		testroom.roomOptions.choicePick.add(moveoption);
		testroom.roomOptions.choicePick.add(attackoption);
		testroom.roomOptions.choicePick.add(talkoption);
		testroom.roomOptions.choicePick.add(interactoption);


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
		healthBar = new JProgressBar(0, 15);
		healthBar.setPreferredSize(new Dimension(200, 30));
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
		
		playergoldLabel = new JLabel("  Gold:");
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
		
		inventoryPanel.add(itemButton1);
		inventoryPanel.add(itemButton2);
		inventoryPanel.add(itemButton3);
		inventoryPanel.add(itemButton4);
		inventoryPanel.add(itemButton5);
		
		inventoryPanel.setVisible(false);
	
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
		playerHP = 15;
		playerHPCap = 25;
		frostTrollHP = 20;
		weapon = "Stick";
		gold = 10;
		weaponlabelName.setText(weapon);
		playerhplabelNumber.setText("" + playerHP);
		playergoldlabelNumber.setText("" + gold);
		inventoryStatus = "close";
		
		playerItem[0] = potion;
		playerItem[1] = berry;
		playerItem[2] = empty;
		playerItem[3] = empty;
		playerItem[4] = empty;

		healthBar.setValue(playerHP);
		
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
		playerHP = playerHP - 2;
		healthBar.setValue(playerHP);
		playerhplabelNumber.setText(""+playerHP);
		if(playerHP < 0)
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
		position = "north";
		if (playerHP == playerHPCap) {
			playerHP = playerHP + 0;
			mainTextArea.setText("You find yourself at a overlook.\nYou take a moment to enjoy the view.\n(You have full health)\n "
					+ "You see a hidden path to the right which \nheads into the forest..");
		}
		else if (playerHP != playerHPCap) {
		playerHP = playerHP + 1;
		healthBar.setValue(playerHP);
		mainTextArea.setText("You find yourself at an overlook.\nYou take a moment to enjoy the view.\n(HP healed by 1)\n"
		+ "You see a hidden path to the right which \nheads into the forest..");
		}
		playerhplabelNumber.setText(""+playerHP);
		optionButtons.get(0).setText("Go Back South");
		optionButtons.get(1).setText("Go On The Path");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void east() {
		position = "east";
		if (weapon == "Long Sword")
		{
			mainTextArea.setText("You find yourself at a large oak tree.");
		}
		else {
			mainTextArea.setText("You find yourself at a large oak tree.\n You find a Long Sword under the tree!\n(You obtain a Long Sword)\n");
			weapon = "Long Sword";
			weaponlabelName.setText(weapon);
		}

		optionButtons.get(0).setText("Go South");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void sky() {
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
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster HP: " + frostTrollHP + "\n\nWhat do you do?");
		optionButtons.get(0).setText("Attack");
		optionButtons.get(1).setText("Run");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void attack() {
		position = "attack";
		int playerDamage = 0;
		if(weapon.equals("Stick"))
		{
		playerDamage = new java.util.Random().nextInt(5);
		}
		else if(weapon.equals("Long Sword"))
		{
		playerDamage = new java.util.Random().nextInt(10);
		}
		mainTextArea.setText("You attacked the monster and gave\n" + playerDamage + " damage!");
		frostTrollHP = frostTrollHP - playerDamage;
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void monsterAttack() {
		position = "monsterAttack";
		int monsterDamage = 0;
		monsterDamage = new java.util.Random().nextInt(3);
		mainTextArea.setText("The monster attacked you and gave\n" + monsterDamage + " damage!");
		playerHP = playerHP - monsterDamage;
		playerhplabelNumber.setText(""+playerHP);
		healthBar.setValue(playerHP);
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
			gold = gold + droppedGold;
			playergoldlabelNumber.setText(""+gold);
			
		}
		else 
		{
			mainTextArea.setText("You defeated the monster!\n The troll dropped a ring\n\n(You obtained a Silver Ring)");
			silverRing =1;
		}
		frostTrollHP = 20;
		optionButtons.get(0).setText("Go east");
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
		optionButtons.get(0).setText("Enter Town");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
		
	}
	public void path() {
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
				+ "\nyou see to the left a Shop Keep, to the right\n you see a crowd of villagers gathered around a stage...");
		optionButtons.get(0).setText("Go Left");
		optionButtons.get(1).setText("Go Right");
		optionButtons.get(2).setText("Continue Straight");
		optionButtons.get(3).setText("Back to Castle Gate");
		optionButtons.get(4).setText("");
	}
	
	public void itemUsed(int slotNumber) {
		
		if (playerHP >= playerHPCap) {
			playerHP = playerHP + 0;
			playerItem[slotNumber] = empty;
			itemButton1.setText(playerItem[0].name);
			itemButton2.setText(playerItem[1].name);
			itemButton3.setText(playerItem[2].name);
			itemButton4.setText(playerItem[3].name);
			itemButton5.setText(playerItem[4].name);
		}
		else {
		
		playerHP = playerHP + playerItem[slotNumber].healingValue;
		playerhplabelNumber.setText(""+playerHP);
		healthBar.setValue(playerHP);
		playerItem[slotNumber] = empty;
		itemButton1.setText(playerItem[0].name);
		itemButton2.setText(playerItem[1].name);
		itemButton3.setText(playerItem[2].name);
		itemButton4.setText(playerItem[3].name);
		itemButton5.setText(playerItem[4].name);
		}
		
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
					inventoryPanel.setVisible(false);
					inventoryStatus = "close";
				}
				break;
			case "item1":
				itemUsed(0);
				break;
			case "item2":
				itemUsed(1);
				break;
			case "item3":
				itemUsed(2);
				break;
			case "item4":
				itemUsed(3);
				break;
			case "item5":
				itemUsed(4);
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
					if(silverRing ==1)
					{
						enterCity();
					}
					else {
						talkGuard();
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
				case "c1": fight(); break;
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
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1": attack(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "attack":
				switch(yourChoice) {
				case "c1":
					if(frostTrollHP<1) {
						win();
					}
					else {
						monsterAttack();
					}
					 break;
				}
				break;
			case "monsterAttack":
				switch(yourChoice) {
				case "c1":
					if(playerHP<1) {
						lose();
					}
					else {
						fight();
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
				case "c2": TownEntrance(); break;
				case "c3": TownEntrance(); break;
				case "c4": castleGate(); break;
				}
				break;

			}

		}
	}
}
