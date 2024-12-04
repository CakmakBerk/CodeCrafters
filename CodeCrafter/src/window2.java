import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class window2 extends JFrame {
	// VARIABLES
	Timer timer;
	private static int score = 0;
	private final int rownumber = 6;
	private final int colnumber = 6;
	private static final long serialVersionUID = 1L;
	private int foundedDiamonds;
	private int remainingClickableButtons;
	private int currentRow = 0;
	private int currentCol = 0;
	private int dCount = 0;
	JButton upButton, leftButton, selectButton, rightButton, downButton;
	JButton[][] gameButtons;
	JPanel dpanel, scorePanel, logo1, logo2, logo3, empty1, empty2, empty3, empty4;
	JLabel image, image1, timeJLabel, scoreJLabel, remainingDiamond;
	private char[][] matrix;
	private boolean[][] checker;
	public static boolean sound = true;
	public static int timeLeft = 1;
	static ImageIcon warn = new ImageIcon("warn.png");

	
	

	public window2()  {

		
		// I created a new 2D array. This array adds 'k' to the every element of matrix.
		matrix = new char[rownumber][colnumber];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = 'k';
			}
		}
		checker = new boolean[rownumber][colnumber];
		Random randomDiamond = new Random();
		// This while-loop changes 'k' matrixs with 'D' which means they'll be diamond
		// button later
		// And checker will be false in every diamonds
		while (dCount < randomDiamond.nextInt(rownumber * colnumber)) {
			int randomRow = randomDiamond.nextInt(matrix.length);
			int randomCol = randomDiamond.nextInt(matrix.length);
			if (matrix[randomRow][randomCol] != 'D') {
				matrix[randomRow][randomCol] = 'D';
				checker[randomRow][randomCol] = false;
				dCount++;
			}
		}
		// Integrating the logo into java
		String imagepath = "Assets/logos/2.6.png";
		ImageIcon imageIcon = new ImageIcon(imagepath);
		image = new JLabel(imageIcon);
		image1 = new JLabel(imageIcon);
		// JFRAME settings
		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Part_2");
		this.setResizable(false);
		this.setBackground(new Color(2, 12, 57));
		this.setLocationRelativeTo(null);
		// buttons and panels settings
		gameButtons = new JButton[rownumber][colnumber];
		scorePanel = new JPanel();
		upButton = new JButton("UP");
		upButton.setFocusable(false);
		leftButton = new JButton("LEFT");
		leftButton.setFocusable(false);
		selectButton = new JButton("SELECT");
		selectButton.setFocusable(false);
		rightButton = new JButton("RIGHT");
		rightButton.setFocusable(false);
		downButton = new JButton("DOWN");
		downButton.setFocusable(false);
		timeJLabel = new JLabel();
		scoreJLabel = new JLabel();
		remainingDiamond = new JLabel();
		// calls window1 so that we can get the points which collected from part1
		window1 window1 = null;

		String timeString = String.valueOf(window1.x * 3);
		timeLeft = window1.x * 3;
		timeJLabel.setText("Remaining time: " + timeString);
		timeJLabel.setForeground(Color.white);
		timeJLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		// The timer part
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeLeft--;
				timeJLabel.setText("Remaining time: " + timeLeft);
				if (timeLeft <= 0) {
					((Timer) (e.getSource())).stop();
					timeJLabel.setText("Time's up!");
					upButton.setEnabled(false);
					leftButton.setEnabled(false);
					rightButton.setEnabled(false);
					downButton.setEnabled(false);
					selectButton.setEnabled(false);
					JOptionPane.showMessageDialog(window2.this,
							"Game finished. Time's up!" + "\nYour total score is :" + score,"INFORMATION", JOptionPane.WARNING_MESSAGE,warn);
					System.exit(0);

				}
			}
		});

		timer.start();
		// setting of score display location
		scoreJLabel.setText("Your score is: " + score);
		scoreJLabel.setForeground(Color.white);
		scoreJLabel.setFont(new Font("MV Boli", Font.BOLD, 20));

		// Setting of the remaining diamond display area
		remainingDiamond.setText("Not founded diamonds: " + dCount);
		remainingDiamond.setForeground(Color.white);
		remainingDiamond.setFont(new Font("MV Boli", Font.BOLD, 17));
		// dpanel's settings
		dpanel = new JPanel();
		dpanel.setPreferredSize(new Dimension(800, 900));
		dpanel.setLayout(new GridLayout(rownumber, colnumber));
		dpanel.setBackground(new Color(2, 12, 57));
		// scorepanel's settings
		scorePanel.setPreferredSize(new Dimension(300, 900));
		scorePanel.setLayout(new GridLayout(3, 1));
		scorePanel.setBackground(new Color(2, 12, 57));
		// logos's settings

		logo1 = new JPanel();
		logo1.setBorder(BorderFactory.createEtchedBorder());
		logo1.setPreferredSize(new Dimension(200, 100));
		logo1.setLayout(new GridLayout(3, 1));
		logo1.setBackground(new Color(2, 12, 57));

		logo2 = new JPanel();
		logo2.setBorder(BorderFactory.createEtchedBorder());
		logo2.setPreferredSize(new Dimension(200, 100));
		logo2.setLayout(new GridLayout(3, 3));

		logo3 = new JPanel();
		logo3.setBorder(BorderFactory.createEtchedBorder());
		logo3.setPreferredSize(new Dimension(200, 100));
		logo3.add(image);
		logo3.setBackground(new Color(2, 12, 57));

		// empty settings
		empty1 = new JPanel();
		empty1.setBackground(new Color(2, 12, 57));
		empty2 = new JPanel();
		empty2.setBackground(new Color(2, 12, 57));
		empty3 = new JPanel();
		empty3.setBackground(new Color(2, 12, 57));
		empty4 = new JPanel();
		empty4.setBackground(new Color(2, 12, 57

		));

		// adding area
		this.add(dpanel, BorderLayout.WEST);
		this.add(scorePanel, BorderLayout.EAST);
		// oyun butonlarını döngüyle yazan kısım
		for (int i = 0; i < rownumber; i++) {
			for (int j = 0; j < colnumber; j++) {
				gameButtons[i][j] = new JButton();
				gameButtons[i][j].setEnabled(false);
				// The part that directs you to control when the button is clicked
				gameButtons[i][j].addActionListener(new ButtonClickListener(i, j));
				dpanel.add(gameButtons[i][j]);

			}
		}

		// Activating the starting cell
		gameButtons[currentRow][currentCol].setEnabled(true);
		// Adding logo 1 2 3 to the score panel
		logo1.add(timeJLabel);
		logo1.add(scoreJLabel);
		logo1.add(remainingDiamond);
		scorePanel.add(logo1, BorderFactory.createLineBorder(new Color(2, 12, 57), 20));
		scorePanel.add(logo2, BorderFactory.createLineBorder(new Color(2, 12, 57), 20));
		scorePanel.add(logo3, BorderFactory.createLineBorder(new Color(2, 12, 57), 20));
		// Writing and color settings for the empty and button parts of logo 2
		logo2.add(empty1);
		logo2.add(upButton);
		upButton.setForeground(new Color(203, 167, 118));
		upButton.setBackground(new Color(0, 196, 215));
		logo2.add(empty2);
		logo2.add(leftButton);
		leftButton.setForeground(new Color(203, 167, 118));
		leftButton.setBackground(new Color(0, 196, 215));
		logo2.add(selectButton);
		selectButton.setForeground(new Color(203, 167, 118));
		selectButton.setBackground(new Color(0, 196, 215));
		logo2.add(rightButton);
		rightButton.setForeground(new Color(203, 167, 118));
		rightButton.setBackground(new Color(0, 196, 215));
		logo2.add(empty3);
		logo2.add(downButton);
		downButton.setForeground(new Color(203, 167, 118));
		downButton.setBackground(new Color(0, 196, 215));
		logo2.add(empty4);
		// Sets the game visible
		this.setVisible(true);

		// Go up when you press the up key
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (currentRow > 0) {
					gameButtons[currentRow][currentCol].setEnabled(false);
					currentRow--;
					gameButtons[currentRow][currentCol].setEnabled(true);
				}
			}
		});
		// Go down when you press the down key
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentRow < rownumber - 1) {
					gameButtons[currentRow][currentCol].setEnabled(false);
					currentRow++;
					gameButtons[currentRow][currentCol].setEnabled(true);
				}
			}
		});
		// Go left when you press the left key
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentCol > 0) {
					gameButtons[currentRow][currentCol].setEnabled(false);
					currentCol--;
					gameButtons[currentRow][currentCol].setEnabled(true);
				}
			}
		});
		// Go right when you press the right key
		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentCol < colnumber - 1) {
					gameButtons[currentRow][currentCol].setEnabled(false);
					currentCol++;
					gameButtons[currentRow][currentCol].setEnabled(true);
				}
			}
		});
		// selection when you press the select key
		selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameButtons[currentRow][currentCol].doClick();
				gameButtons[currentRow][currentCol].setEnabled(true);
			}
		});

		// If the randomly assigned number of diamonds is 0, it ends without allowing
		// the player to move.
		if (dCount == 0) {
			timer.stop();
			JOptionPane.showMessageDialog(window2.this,
					"Game finished. Unlucky,You couldn't get any diamonds randomly.","RESULT", JOptionPane.WARNING_MESSAGE,warn);
			System.exit(0);
		}

	}

	// Inner class listening for JButton click event
	private class ButtonClickListener implements ActionListener {
		private int row;
		private int col;
		static ImageIcon warn = new ImageIcon("warn.png");

		public ButtonClickListener(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public void actionPerformed(ActionEvent e) {
			// Checking if there is the letter "D" in the clicked cell
			if (matrix[currentRow][currentCol] == 'D' && checker[currentRow][currentCol] == false) {
				ImageIcon diamondIcon = new ImageIcon("Assets/logos/diamond.png");
				gameButtons[currentRow][currentCol].setIcon(diamondIcon);
				;
				JOptionPane.showMessageDialog(window2.this, "You have founded a diamond!","INFORMATION", JOptionPane.WARNING_MESSAGE,warn);
				gameButtons[currentRow][currentCol].setFocusable(true);
				checker[currentRow][currentCol] = true;
				foundedDiamonds++;
				score += 10;
				scoreJLabel.setText("Your score is: " + score);
				remainingDiamond.setText("Not founded diamonds: " + (dCount - foundedDiamonds));
			} else if (checker[currentRow][currentCol] == true && matrix[currentRow][currentCol] == 'D') {
				JOptionPane.showMessageDialog(window2.this, "You have already founded that diamond !","INFORMATION", JOptionPane.WARNING_MESSAGE,warn);
			} else if (matrix[currentRow][currentCol] == 'k' & checker[currentRow][currentCol] == true) {
				JOptionPane.showMessageDialog(window2.this, "You have already clicked this button !","INFORMATION", JOptionPane.WARNING_MESSAGE,warn);
				remainingClickableButtons--;
			}
			// If the button is empty writes empty
			else {
				gameButtons[currentRow][currentCol].setBackground(Color.RED);
				gameButtons[currentRow][currentCol].setOpaque(true);
				gameButtons[currentRow][currentCol].setText("EMPTY");
				gameButtons[currentRow][currentCol].setFocusable(false);
				checker[currentRow][currentCol] = true;
			}
			// Increase the number of buttons clicked
			remainingClickableButtons++;
			// Make the clicked cell unclickable again
			gameButtons[currentRow][currentCol].setEnabled(false);

			if (remainingClickableButtons == rownumber && foundedDiamonds == 0) {
				timer.stop();
				// 6(right to try as many as the number of lines)
				// If no diamond is found in one tryend the game.
				JOptionPane.showMessageDialog(window2.this, "Game finished. No diamonds found.","RESULT", JOptionPane.WARNING_MESSAGE,warn);
				System.exit(0);
			}
			// number of diamonds found = number of diamonds created then finish the game.
			if (foundedDiamonds == dCount) {
				timer.stop();
				JOptionPane.showMessageDialog(window2.this,
						"Game finished. You have founded all diamonds." + "\n Your total score is :" + score,"RESULT", JOptionPane.WARNING_MESSAGE,warn);
				System.exit(0);
			}
		}
	}
}
