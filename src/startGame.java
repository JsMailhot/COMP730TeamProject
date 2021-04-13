import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class startGame {
	Boolean enterGame;
	Container con;
	JPanel titleScreenPanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerinfoPanel;
	JLabel titleScreenLabel, playerhpLabel, playerhplabelNumber, weaponLabel, weaponlabelName;
	JButton startButton, choice, choice2, choice3, choice4, choice5, choice6, choice7, choice8;
	JTextArea mainTextArea;
	int playerHP;
	String weapon, position;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	List difficulty;
	player player = new player();
	JFrame window;
	ArrayList<JButton> optionButtons = new ArrayList<JButton>();
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	public static void main(String[] args) {
		new startGame();

	}
	public startGame() {
		window = new JFrame();
		window.setSize(800, 800);
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
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		
		
		
		titleScreenPanel.add(titleScreenLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleScreenPanel);
		con.add(startButtonPanel);
		window.setVisible(true);
		
	}
	public String enterName() {
		return "name";
	}
	public String enterDesc() {
		return "Desc";
	}
	public void generateRoom() {
		
	}
	public void playerInterface() {
		
		titleScreenPanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Testing text visablity");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 350);
		choiceButtonPanel.setBackground(Color.black);
		con.add(choiceButtonPanel);
		
		room testroom = new room();
		
		
		ArrayList<room> roomList = new ArrayList<room>();
		player testPlayer = new player();
		testroom.actorList.add(testPlayer);
		
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
		playerinfoPanel = new JPanel();
		playerinfoPanel.setBounds(100, 15, 600, 50);
		playerinfoPanel.setBackground(Color.black);
		playerinfoPanel.setLayout(new GridLayout(1, 4));
		con.add(playerinfoPanel);
		
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
		
		playerSetup();
		
	}
	public void playerSetup() {
		playerHP = 15;
		weapon = "Stick";
		weaponlabelName.setText(weapon);
		playerhplabelNumber.setText("" + playerHP);
		
		castleGate();
		
	}
	
	public void castleGate() {
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
		mainTextArea.setText("Guard: Stay safe Traveler.");
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
		optionButtons.get(0).setText("Back");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
		
	}
	public void crossRoad() {
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
		playerHP = playerHP + 1;
		playerhplabelNumber.setText(""+playerHP);
		optionButtons.get(0).setText("Go South");
		optionButtons.get(1).setText("");
		optionButtons.get(2).setText("");
		optionButtons.get(3).setText("");
		optionButtons.get(4).setText("");
	}
	public void east() {
		position = "east";
		mainTextArea.setText("You find yourself at a large oak tree.\n You find a Long Sword under the tree!\n(You obtain a Long Sword)");
		
	}
	public void west() {
		
	}
	public class TitleScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			playerInterface ();
			
		}
		
	}
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			switch(position) {
			case "castleGate":
				switch(yourChoice) {
				case "c3": talkGuard(); break;
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
				case "c3": break;
				case "c4": break;
				case "c5": break;
				}
				break;
			case "north":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				
			}
			
		}
	}

}