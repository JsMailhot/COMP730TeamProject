package game;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game.startGame.ChoiceHandler;
import game.startGame.InputHandler;
import game.startGame.InventoryHandler;
import game.startGame.TitleScreenHandler;


public class UI {
		JFrame window;
		int playerHP, frostTrollHP, playerHPCap, silverRing, gold;
		Container con;
		JPanel titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel, imagePanel, namePanel, inputPanel, healthBarPanel, inventoryPanel;
		JLabel titleScreenLabel, playerhpLabel, playernameLabel, playerhplabelNumber, weaponLabel, weaponlabelName, imageLabel, nameLabel, playergoldLabel, playergoldlabelNumber;
		JButton startButton, musicButton, enterButton, inventoryButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5;
		Font titleFont = new Font("Times New Roman", Font.BOLD, 82);
		Font normalFont = new Font("Times New Roman", Font.ITALIC, 24);
		String clickSound, gameMusic, musicOnOff, text, weapon, inventoryStatus;
		ImageIcon image;
		Music mu = new Music();
		SoundEffect se = new SoundEffect();
		JTextField jtf;
		JTextArea mainTextArea;
		JProgressBar healthBar;
		SuperItem[] playerItem = new SuperItem[5];
		Item_Potion potion = new Item_Potion();
		Item_Berry berry = new Item_Berry();
		Item_Empty empty = new Item_Empty();
		
		
	public void createmainMenuUI(TitleScreenHandler tsHandler) {
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
	public void createnameUI(InputHandler iHandler) {
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
	public void createplayerUI(ChoiceHandler choiceHandler, InventoryHandler invHandler) {
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

	}
	}
