import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class window1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel scorePanel, questionPanel, answersPanel1, answersPanel2, empty1, empty2;
	JButton button1, button2, button3, button4, nextbutton, easy, moderate, difficult;
	JLabel scorelabel, logoJLabel, wlcmLabel, image, questionlabel;
	public static int x = 0;
	degree_of_question degree_of_question;
	public int selection = degree_of_question.getSelection();

	question_section q_a = new question_section();
	public static String question, answer1, answer2, answer3, answer4;
	public static boolean sound = true;
	public static String exception;

	
	

	ImageIcon imageIcona = new ImageIcon("Assets/logos/right.png"); 
	ImageIcon imageIconb = new ImageIcon("Assets/logos/left.png");
	ImageIcon imageIcon = new ImageIcon("Assets/logos/2.5.png");
	static ImageIcon warn = new ImageIcon("warn.png");

	public window1() {
		

		// define area

		scorePanel = new JPanel();
		questionPanel = new JPanel();
		answersPanel1 = new JPanel();
		answersPanel2 = new JPanel();
		empty1 = new JPanel();
		empty2 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		nextbutton = new JButton();
		scorelabel = new JLabel();
		logoJLabel = new JLabel();
		wlcmLabel = new JLabel();
		image = new JLabel();
		questionlabel = new JLabel();

		// start the constructor of question_section for placement on labels
		question_section.placement();

		String question, answer1, answer2, answer3, answer4;
		question = question_section.getQuestion();
		answer1 = question_section.getAnswer1();
		answer2 = question_section.getAnswer2();
		answer3 = question_section.getAnswer3();
		answer4 = question_section.getAnswer4();

		// Frame Section
		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Part_1");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(4, 1));

//		empty3.setLayout(new GridLayout(2,1));
		empty2.setBackground(new Color(2, 12, 57));
		empty2.setPreferredSize(new Dimension(356, 300));

		// Score Panel
		scorePanel.setBackground(new Color(2, 12, 57));
		scorePanel.setPreferredSize(new Dimension(1100, 300));
//		scorePanel.setLayout(new GridLayout(2, 1));
//		scorePanel.setBorder(BorderFactory.createEtchedBorder());

		// Question Panel
		questionPanel.setSize(1920, 200);
		questionPanel.setBackground(new Color(2, 12, 57));
		questionPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		questionlabel.setText(question);
		questionlabel.setHorizontalAlignment(JLabel.CENTER);
		questionlabel.setFont(new Font("Safir", Font.PLAIN, 20));
		questionlabel.setForeground(Color.white);

		// Answer Panel 1 for up buttons
		answersPanel1.setBackground(Color.gray);
		answersPanel1.setSize(1920, 200);
		answersPanel1.setLayout(new GridLayout(1, 2));

		// Answer Panel 2 for bottom buttons

		answersPanel2.setBackground(Color.gray);
		answersPanel2.setSize(1920, 200);
		answersPanel2.setLayout(new GridLayout(1, 2));

		// Logo Image

		image.setIcon(imageIcon);
		image.setHorizontalAlignment(JLabel.CENTER);
		image.setVerticalAlignment(JLabel.TOP);
//		image.setPreferredSize(new Dimension(empty1.getWidth(), empty1.getHeight()));
//		image.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// empty 1 area for score panel

		empty1.setBackground(new Color(2, 12, 57));
		empty1.setPreferredSize(new Dimension(1100, 300));
		empty1.setLayout(new GridLayout(1, 3));
//		empty1.setBorder(BorderFactory.createEtchedBorder());

		//  Welcome label

		wlcmLabel.setText("Welcome to Who Wanna Be a Millionaire");
		wlcmLabel.setFont(new Font("MV Boli", Font.PLAIN, 17));
		wlcmLabel.setForeground(Color.white);
		wlcmLabel.setPreferredSize(new Dimension(356, 50));
		wlcmLabel.setHorizontalTextPosition(JLabel.CENTER);

		// Buttons
		button1.setText(answer1);
		button1.setVerticalTextPosition(JLabel.CENTER);
		button1.setHorizontalAlignment(JLabel.CENTER);
		button1.setPreferredSize(new Dimension(910, 100));
		button1.setForeground(Color.white);
		button1.setBackground(new Color(27, 40, 94));
		button1.setFont(new Font("Safir", Font.PLAIN, 20));
		button1.setBorder(BorderFactory.createEtchedBorder());
		button1.setOpaque(true);
		button1.addActionListener(this);

		button2.setText(answer2);
		button2.setVerticalTextPosition(JLabel.CENTER);
		button2.setHorizontalAlignment(JLabel.CENTER);
		button2.setPreferredSize(new Dimension(910, 100));
		button2.setForeground(Color.white);
		button2.setBackground(new Color(27, 40, 94));
		button2.setFont(new Font("Safir", Font.PLAIN, 20));
		button2.setBorder(BorderFactory.createEtchedBorder());
		button2.setOpaque(true);
		button2.addActionListener(this);

		button3.setText(answer3);
		button3.setVerticalTextPosition(JLabel.CENTER);
		button3.setHorizontalAlignment(JLabel.CENTER);
		button3.setPreferredSize(new Dimension(910, 100));
		button3.setForeground(Color.white);
		button3.setBackground(new Color(27, 40, 94));
		button3.setFont(new Font("Safir", Font.PLAIN, 20));
		button3.setBorder(BorderFactory.createEtchedBorder());
		button3.setOpaque(true);
		button3.addActionListener(this);

		button4.setText(answer4);
		button4.setVerticalTextPosition(JLabel.CENTER);
		button4.setHorizontalAlignment(JLabel.CENTER);
		button4.setPreferredSize(new Dimension(910, 100));
		button4.setForeground(Color.white);
		button4.setBackground(new Color(27, 40, 94));
		button4.setFont(new Font("Safir", Font.PLAIN, 20));
		button4.setBorder(BorderFactory.createEtchedBorder());
		button4.setOpaque(true);
		button4.addActionListener(this);

		// Next button to pass part 2
		nextbutton.setPreferredSize(new Dimension(350, 150));
		nextbutton.setText("NEXT");
		nextbutton.setFont(new Font("MV Boli", Font.PLAIN, 30));
		nextbutton.setVerticalTextPosition(JLabel.CENTER);
		nextbutton.setHorizontalAlignment(JLabel.CENTER);
		nextbutton.setForeground(Color.white);
		nextbutton.setBackground(new Color(2, 12, 57));
		nextbutton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nextbutton.setOpaque(true);
		nextbutton.addActionListener(this);
		nextbutton.setEnabled(false);
		nextbutton.setFocusable(false);

		// scores
		scorelabel.setBackground(new Color(2, 12, 57));
		scorelabel.setOpaque(true);
		scorelabel.setText(String.valueOf(x));
		scorelabel.setFont(new Font("Safir", Font.PLAIN, 40));
		scorelabel.setHorizontalAlignment(JLabel.CENTER);
		scorelabel.setVerticalAlignment(JLabel.CENTER);
		scorelabel.setForeground(Color.white);
		scorelabel.setPreferredSize(new Dimension(356, 300));

		// Adding area
		this.add(scorePanel);
		this.add(questionPanel);
		this.add(answersPanel1);
		this.add(answersPanel2);
		questionPanel.add(questionlabel, BorderLayout.SOUTH);
		scorePanel.add(empty1);
		answersPanel1.add(button1);
		answersPanel1.add(button2);
		answersPanel2.add(button3);
		answersPanel2.add(button4);
		empty1.add(image);
		empty1.add(empty2);
		empty1.add(scorelabel, BorderLayout.CENTER);
		empty2.add(wlcmLabel, BorderLayout.NORTH);
		empty2.add(nextbutton, BorderLayout.SOUTH);

		// visibility for frame

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(question_section.buttonchecker);

		// if answer is correct score adding area
		try {
		if (e.getSource() == button1) {
			if (degree_of_question.getSelection() == 1) {
				if (q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'a'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'A') {
					x += 10;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 2) {
				if (q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'a'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'A') {
					x += 30;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 3) {
				if (q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'a'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'A') {
					x += 50;
					scorelabel.setText(String.valueOf(x));
				}
			} else {
				System.out.println("------");
				scorelabel.setText(String.valueOf(x));
			}

		}
		if (e.getSource() == button2) {
			if (degree_of_question.getSelection() == 1) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'b'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'B')) {
					x += 10;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 2) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'b'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'B')) {
					x += 30;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 3) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'b'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'B')) {
					x += 50;
					scorelabel.setText(String.valueOf(x));
				}
			} else {
				System.out.println("------");
				scorelabel.setText(String.valueOf(x));
			}

		}

		if (e.getSource() == button3) {
			if (degree_of_question.getSelection() == 1) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'c'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'C')) {
					x += 10;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 2) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'c'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'C')) {
					x += 30;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 3) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'c'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'C')) {
					x += 50;
					scorelabel.setText(String.valueOf(x));
				}
			} else {
				System.out.println("------");
				scorelabel.setText(String.valueOf(x));
			}

		}
		if (e.getSource() == button4) {
			if (degree_of_question.getSelection() == 1) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'd'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'D')) {
					x += 10;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 2) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'd'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'D')) {
					x += 30;
					scorelabel.setText(String.valueOf(x));
				}
			} else if (degree_of_question.getSelection() == 3) {
				if ((q_a.lines[q_a.array[q_a.buttonchecker]]
						.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'd'
						|| q_a.lines[q_a.array[q_a.buttonchecker]]
								.charAt(q_a.lines[q_a.array[q_a.buttonchecker]].length() - 1) == 'D')) {
					x += 50;
					scorelabel.setText(String.valueOf(x));
				}
			} else {
				System.out.println("------");
				scorelabel.setText(String.valueOf(x));
			}

		}

		// Next button is to pass the game
		if (e.getSource() == nextbutton)

		{
			question_section.buttonchecker--;
			this.dispose();
			window2 window2 = new window2();

		}

		// generation a new question ands answers. Moreover, Calculating the button
		// press count.
		question_section question_section = new question_section();
		question_section.buttonchecker++;

		question_section.qstn_answr();
		question = question_section.getQuestion();
		answer1 = question_section.getAnswer1();
		answer2 = question_section.getAnswer2();
		answer3 = question_section.getAnswer3();
		answer4 = question_section.getAnswer4();
		questionlabel.setText(question);
		button1.setText(answer1);
		button2.setText(answer2);
		button3.setText(answer3);
		button4.setText(answer4);

		// End of the questions disable answers, and enable the next button
		
			if (question_section.buttonchecker == 5) {
				nextbutton.setEnabled(true);
				nextbutton.setFocusable(false);
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);

				// result section on question label
				String aString = String.valueOf(x);
				nextbutton.setFont(new Font("Safir", Font.PLAIN, 25));
				questionlabel.setText(String.format(
						"<html><h1 style=\"text-align: center;\"><span>To Pass the Game, Please press the NEXT Button</span></h1>\n"
								+ "<h1 style=\"text-align: center;\"><span>Your score is: %s&nbsp;</span></h1></html>",
						aString));

				// adding arrows

				image.setIcon(imageIcona);
				scorelabel.setIcon(imageIconb);
				scorelabel.setHorizontalAlignment(JLabel.CENTER);
				scorelabel.setVerticalAlignment(JLabel.TOP);
				scorelabel.setText("");
			}
		} catch (Exception e2) {

			exception = ("Oops, something went wrong!!!");
			JOptionPane.showMessageDialog(null, exception, "ERROR", JOptionPane.WARNING_MESSAGE, warn);
			System.exit(0);}
	

	}

}