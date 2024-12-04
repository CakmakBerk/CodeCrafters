import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class about extends JFrame implements ActionListener {
	JPanel left, center_2, center_1, a2, center, a3, right, a4, panel1, panel2;
	JLabel berklabel, berkaboutlabel, xlabel, xaboutlabel, ylabel, yaboutlabel, abdullahlabel,
			abdullahaboutlabel, image, image2;
	JButton rules, start;
	ImageIcon berk = new ImageIcon("Assets/people/berk.png");
	ImageIcon x = new ImageIcon("Assets/people/");
	ImageIcon y = new ImageIcon("Assets/people/");
	ImageIcon apo = new ImageIcon("Assets/people/apo.png");
	ImageIcon logo1 = new ImageIcon("Assets/logos/3.1.png");
	ImageIcon logo2 = new ImageIcon("Assets/logos/3.2.png");

	File file = new File("Click.wav");
	AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();

	public about() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		clip.open(audiostream);

		left = new JPanel();
		center_1 = new JPanel();
		center = new JPanel();
		right = new JPanel();
		center_2 = new JPanel();
		berklabel = new JLabel();
		berkaboutlabel = new JLabel();
		xaboutlabel = new JLabel();
		xlabel = new JLabel();
		yaboutlabel = new JLabel();
		ylabel = new JLabel();
		abdullahaboutlabel = new JLabel();
		abdullahlabel = new JLabel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		image = new JLabel();
		image2 = new JLabel();
		rules = new JButton();
		start = new JButton();

		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("WHO WE ARE");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(2, 12, 57));

		berklabel.setIcon(berk);
		berklabel.setHorizontalAlignment(JLabel.CENTER);
		berklabel.setVerticalTextPosition(JLabel.BOTTOM);
		berkaboutlabel.setText("<html><p style=\"text-align: center;\"><strong>Berk ÇAKMAK</strong></p>\n"
				+ "<p><br></p>\n" + "<p>-&gt; Preparation of CSV file</p>\n" + "<p>-&gt; Score calculation</p>\n"
				+ "<p>-&gt; Logo design</p>\n" + "<p>-&gt; Adjusting questions according to difficulty</p>\n"
				+ "<p>&nbsp;&nbsp;&nbsp; &nbsp;level</p>\n" + "<p>-&gt; Determining the number of questions</p>\n"
				+ "<p>-&gt; Placement of random questions and &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;answers</p>\n"
				+ "<p>-&gt; Checking the correct option</p>\n" + "<p>-&gt; Warnings about exceptions in csv files</p>\n"
				+ "<p>-&gt; Sound effects</p></html>");
		berkaboutlabel.setForeground(Color.white);
		berkaboutlabel.setFont(new Font("Safir", Font.PLAIN, 12));
		berkaboutlabel.setVerticalTextPosition(JLabel.TOP);

		xlabel.setIcon(x);
		xlabel.setHorizontalAlignment(JLabel.CENTER);
		xlabel.setVerticalTextPosition(JLabel.BOTTOM);
		xaboutlabel.setText("<html><p style=\"text-align: center;\"><strong>Berk ÇAKMAK</strong></p>\n"
				+ "<p><br></p>\n"
				+ "<p>-&gt; Settings of JFrame, JPanel, Jbutton, JLabel, &nbsp; &nbsp;&nbsp; JRadioButton for about, rules and &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;difficulty level screens</p>\n"
				+ "<p>-&gt; Frontend work with Java swing library</p></html>");
		xaboutlabel.setForeground(Color.white);
		xaboutlabel.setFont(new Font("Safir", Font.PLAIN, 12));
		xaboutlabel.setVerticalTextPosition(JLabel.TOP);

		ylabel.setIcon(y);
		ylabel.setHorizontalAlignment(JLabel.CENTER);
		ylabel.setVerticalTextPosition(JLabel.BOTTOM);
		yaboutlabel.setText("<html><p style=\"text-align: center;\"><strong>Berk ÇAKMAK</strong></p>\n"
				+ "<p><br></p>\n" + "<p>-&gt; Settings of JFrame, JPanel, Jbutton, JLabel,</p>\n"
				+ "<p>&nbsp; &nbsp;&nbsp; JRadioButton for start, part1 and part2 </p>\n"
				+ "<p>&nbsp;&nbsp;&nbsp; &nbsp;screens</p>\n" 
				+ "<p>-&gt; Frontend work with Java swing library</p></html>");
		yaboutlabel.setForeground(Color.white);
		yaboutlabel.setFont(new Font("Safir", Font.PLAIN, 12));
		yaboutlabel.setVerticalTextPosition(JLabel.TOP);

		abdullahlabel.setIcon(apo);
		abdullahlabel.setHorizontalAlignment(JLabel.CENTER);
		abdullahlabel.setVerticalTextPosition(JLabel.BOTTOM);
		abdullahaboutlabel.setText("<html><p><br></p>\n"
				+ "<p style=\"text-align: center;\"><strong>Abdullah ESİN</strong></p>\n" + "<p><br></p>\n"
				+ "<p>-&gt; Part 2 background work of the game</p>\n"
				+ "<p>-&gt; Distributing diamonds and determining </p>\n" + "<p>&nbsp; &nbsp;&nbsp; their number</p>"
				+ "<p>-&gt; Calculating the time to move on to Part 2</p>\n"
				+ "<p>-&gt; Score calculation of Part 2 game</p>\n" + "<p><br></p></html>");
		abdullahaboutlabel.setForeground(Color.white);
		abdullahaboutlabel.setFont(new Font("Safir", Font.PLAIN, 12));
		abdullahaboutlabel.setVerticalTextPosition(JLabel.TOP);

		panel1.setPreferredSize(new Dimension(1100, 200));
		panel1.setBackground(new Color(2, 12, 57));
		panel1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel1.setLayout(new GridLayout(1, 4));

		image.setIcon(logo1);
		image.setOpaque(true);
		image.setVerticalAlignment(JLabel.CENTER);
		image.setHorizontalAlignment(JLabel.CENTER);

		image2.setIcon(logo2);
		image2.setOpaque(true);
		image2.setVerticalAlignment(JLabel.CENTER);
		image2.setHorizontalAlignment(JLabel.CENTER);

		panel2.setPreferredSize(new Dimension(1100, 700));
		panel2.setLayout(new GridLayout(1, 4));

		left.setPreferredSize(new Dimension(275, 700));
		left.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		left.setBackground(new Color(2, 12, 57));
		left.setLayout(new GridLayout(2, 1));
		center_1.setPreferredSize(new Dimension(275, 700));
		center_1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		center_1.setBackground(new Color(2, 12, 57));
		center_1.setLayout(new GridLayout(2, 1));
		right.setPreferredSize(new Dimension(275, 700));
		right.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		right.setBackground(new Color(2, 12, 57));
		center_2.setSize(275, 700);
		right.setLayout(new GridLayout(2, 1));
		center_2.setBorder(BorderFactory.createEtchedBorder());
		center_2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		center_2.setBackground(new Color(2, 12, 57));
		center_2.setLayout(new GridLayout(2, 1));

		start.setPreferredSize(new Dimension(275, 200));
		start.setText("START");
		start.setFont(new Font("MV Boli", Font.PLAIN, 30));
		start.setVerticalTextPosition(JLabel.CENTER);
		start.setHorizontalAlignment(JLabel.CENTER);
		start.setForeground(Color.white);
		start.setBackground(new Color(2, 12, 57));
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		start.setOpaque(true);
		start.addActionListener(this);
		start.setEnabled(true);
		start.setFocusable(false);

		rules.setPreferredSize(new Dimension(275, 200));
		rules.setText("Rules");
		rules.setFont(new Font("MV Boli", Font.PLAIN, 30));
		rules.setVerticalTextPosition(JLabel.CENTER);
		rules.setHorizontalAlignment(JLabel.CENTER);
		rules.setForeground(Color.white);
		rules.setBackground(new Color(2, 12, 57));
		rules.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		rules.setOpaque(true);
		rules.addActionListener(this);
		rules.setEnabled(true);
		rules.setFocusable(false);

		this.add(panel1, BorderLayout.NORTH);
		panel1.add(rules);
		panel1.add(image);
		panel1.add(image2);
		panel1.add(start);
		this.add(panel2, BorderLayout.SOUTH);
		panel2.add(left);
		panel2.add(center_1);
		panel2.add(center_2);
		panel2.add(right);

		left.add(berklabel);
		left.add(berkaboutlabel);
		center_1.add(xlabel);
		center_1.add(xaboutlabel);
		center_2.add(ylabel);
		center_2.add(yaboutlabel);
		right.add(abdullahlabel);
		right.add(abdullahaboutlabel);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			clip.start();
			this.dispose();
			degree_of_question degree_of_question = new degree_of_question();
			try {
				degree_of_question.degree_of_question1();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == rules) {
			clip.start();
			this.dispose();
			try {
				rules rules = new rules();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}