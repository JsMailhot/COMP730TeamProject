import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class startGame {
	Boolean enterGame;
	Container con;
	JPanel titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel, imagePanel, namePanel, inputPanel, healthBarPanel;
	JLabel titleScreenLabel, playerhpLabel, playernameLabel, playerhplabelNumber, weaponLabel, weaponlabelName, imageLabel, nameLabel;
	JButton startButton, musicButton, enterButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8;
	JTextArea mainTextArea;
	int playerHP, frostTrollHP, playerHPCap, silverRing;
	String weapon, position, text;
	String clickSound, gameMusic, musicOnOff;
	ImageIcon image;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 24);
	JTextField jtf;
	List difficulty;
	player player = new player();
	JFrame window;
	ArrayList<JButton> optionButtons = new ArrayList<JButton>();

	InputHandler iHandler = new InputHandler();
	Music mu = new Music();
	SoundEffect se = new SoundEffect();
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
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
		mainTextPanel.setBounds(50, 500, 430, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea();
		mainTextArea.setBounds(50, 500, 430, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		mainTextArea.setEditable(false);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(500, 500, 300, 250);
		choiceButtonPanel.setBackground(Color.black);
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

		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(100, 15, 200, 30);
		healthBarPanel.setBackground(Color.blue);
		con.add(healthBarPanel);

		playerinfoPanel = new JPanel();
		playerinfoPanel.setBounds(540, 35, 270, 50);
		playerinfoPanel.setBackground(Color.black);
		playerinfoPanel.setLayout(new GridLayout(2, 2));
		con.add(playerinfoPanel);

		playernameLabel = new JLabel(text);
		playernameLabel.setFont(normalFont);
		playernameLabel.setForeground(Color.white);
		playerinfoPanel.add(playernameLabel);
		playerhpLabel = new JLabel("HP:");
		playerhpLabel.setFont(normalFont);
		playerhpLabel.setForeground(Color.white);
		playerinfoPanel.add(playerhpLabel);
		playerhplabelNumber = new JLabel();
		playerhplabelNumber.setFont(normalFont);
		playerhplabelNumber.setForeground(Color.white);
		playerinfoPanel.add(playerhplabelNumber);
		weaponLabel =  new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerinfoPanel.add(weaponLabel);
		weaponlabelName = new JLabel();
		weaponlabelName.setFont(normalFont);
		weaponlabelName.setForeground(Color.white);
		playerinfoPanel.add(weaponlabelName);

		imagePanel = new JPanel();
		imagePanel.setBounds(50, 50, 400, 250);
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
		weaponlabelName.setText(weapon);
		playerhplabelNumber.setText("" + playerHP);


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
		optionButtons.get(3).setText("Pick up shiny rock");
		optionButtons.get(4).setText("Walk away from gate");
	}
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hail Traveler,\nA Frost Troll has taken our city's priceless\nSilver Ring.\nIf you happen to see the troll\ntry to get the ring back for us would ya?\n(QUEST: Find Silver Ring!)");
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Your being dumb thinking you can win.\nGuard hits you hard. \n(Take 2 DMG)");
		playerHP = playerHP - 2;
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
	public void crossRoad() {
		image = new ImageIcon(".//img//crossroads.jpg");
		imageLabel.setIcon(image);

		position = "crossRoad";
		mainTextArea.setText("Walking away from the castle you find yourself at branching paths.\nGoing south leads back to the castle.");
		optionButtons.get(0).setText("Go North");
		optionButtons.get(1).setText("Go South");
		optionButtons.get(2).setText("Go East");
		optionButtons.get(3).setText("Go West");
		optionButtons.get(4).setText("Look at sky");
	}
	public void north() {
		position = "north";
		mainTextArea.setText("You find yourself at a overlook.\nYou take a moment to enjoy the view.\n(HP healed by 1)");
		if (playerHP == playerHPCap) {
			playerHP = playerHP + 0;
			mainTextArea.setText("You find yourself at a overlook.\nYou take a moment to enjoy the view.\n(HP healed by 0)");
		}
		else if (playerHP != playerHPCap) {
		playerHP = playerHP + 1;
		}
		playerhplabelNumber.setText(""+playerHP);
		optionButtons.get(0).setText("Go South");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void east() {
		position = "east";
		mainTextArea.setText("You find yourself at a large oak tree.\n You find a Long Sword under the tree!\n(You obtain a Long Sword)\n");
		weapon = "Long Sword";
		weaponlabelName.setText(weapon);
		optionButtons.get(0).setText("Go South");
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
		optionButtons.get(0).setText(">");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");

	}
	public void win() {
		position ="win";
		mainTextArea.setText("You defeated the monster!\n The troll dropped a ring\n\n(You obtained a Silver Ring)");
		silverRing =1;
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
	public void ending() {
		position ="ending";
		 mainTextArea.setText("Guard: Oh you killed that frost troll!\n Thank you so much! You are a hero!\n Welcome to the town of EverWinter\n\n<THE END>");
			optionButtons.get(0).setText(">");
			optionButtons.get(1).setText("");
			optionButtons.get(2).setText("");
			optionButtons.get(3).setText("");
			optionButtons.get(0).setVisible(false);
			optionButtons.get(1).setVisible(false);
			optionButtons.get(2).setVisible(false);
			optionButtons.get(3).setVisible(false);
			optionButtons.get(4).setVisible(false);
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
						ending();
					}
					else {
						talkGuard();
					}
					break;
				case "c1": break;
				case "c2": attackGuard(); break;
				case "c4": break;
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
			case "crossRoad":
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": castleGate(); break;
				case "c3": east(); break;
				case "c4": west(); break;
				case "c5": break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
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

			}

		}
	}
}
