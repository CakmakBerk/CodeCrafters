import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class degree_of_question extends JFrame implements ActionListener {

	JRadioButton easy, moderate, difficult;
	ButtonGroup group;
	JPanel panel1, panel2, panel3;
	JLabel label, empty1, empty2, image;
	JButton nextButton;
	private static int selection;

	public static int getSelection() {
		return selection;
	}

	public static void setSelection(int selection) {
		degree_of_question.selection = selection;
	}

	ImageIcon imageIcon = new ImageIcon("Assets/logos/2.5.png");

	public void degree_of_question1() {

		easy = new JRadioButton("EASY");
		moderate = new JRadioButton("MODERATE");
		difficult = new JRadioButton("DIFFICULT");
		nextButton = new JButton("NEXT");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		label = new JLabel();
		empty1 = new JLabel();
		empty2 = new JLabel();
		group = new ButtonGroup();

		// Frame Section
		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Part_1");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(2, 12, 57));

		panel1.setPreferredSize(new Dimension(1100, 300));
		panel1.setBackground(new Color(2, 12, 57));

		panel2.setPreferredSize(new Dimension(1100, 600));
		panel2.setBackground(new Color(2, 12, 57));

		panel3.setPreferredSize(new Dimension(900, 500));
		panel3.setBackground(new Color(2, 12, 57));
		panel3.setLayout(new GridLayout(3, 2));

		label.setText("IF YOU ARE READY, PLEASE MAKE YOUR CHOICE!!!");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setVerticalAlignment(JLabel.BOTTOM);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.black);
		label.setFont(new Font("Safir", Font.PLAIN, 25));
		label.setForeground(Color.lightGray);
		label.setIconTextGap(20);

		label.setIcon(imageIcon);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.TOP);

		easy.setPreferredSize(new Dimension(250, 50));
		easy.setText("EASY");
		easy.setVerticalTextPosition(JLabel.CENTER);
		easy.setHorizontalAlignment(JLabel.CENTER);
		easy.setForeground(Color.white);
		easy.setBorder(BorderFactory.createEtchedBorder());
		easy.setOpaque(true);
		easy.addActionListener(this);
		easy.setBackground(new Color(2, 12, 57));
		easy.setFont(new Font("Safir", Font.PLAIN, 50));

		moderate.setPreferredSize(new Dimension(250, 50));
		moderate.setText("MODERATE");
		moderate.setVerticalTextPosition(JLabel.CENTER);
		moderate.setHorizontalAlignment(JLabel.CENTER);
		moderate.setForeground(Color.white);
		moderate.setBorder(BorderFactory.createEtchedBorder());
		moderate.setOpaque(true);
		moderate.addActionListener(this);
		moderate.setBackground(new Color(2, 12, 57));
		moderate.setFont(new Font("Safir", Font.PLAIN, 50));

		difficult.setPreferredSize(new Dimension(250, 50));
		difficult.setText("DIFFICULT");
		difficult.setVerticalTextPosition(JLabel.CENTER);
		difficult.setHorizontalAlignment(JLabel.CENTER);
		difficult.setForeground(Color.white);
		difficult.setBorder(BorderFactory.createEtchedBorder());
		difficult.addActionListener(this);
		difficult.setBackground(new Color(2, 12, 57));
		difficult.setOpaque(true);
		difficult.setFont(new Font("Safir", Font.PLAIN, 50));

		group.add(easy);
		group.add(moderate);
		group.add(difficult);

		nextButton.setSize(100, 50);
		nextButton.setText("NEXT");
		nextButton.setVerticalTextPosition(JLabel.CENTER);
		nextButton.setHorizontalAlignment(JLabel.CENTER);
		nextButton.setForeground(Color.white);
		nextButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nextButton.setOpaque(true);
		nextButton.addActionListener(this);
		nextButton.setEnabled(false);
		nextButton.setBackground(new Color(2, 12, 57));
		nextButton.setFont(new Font("Safir", Font.PLAIN, 50));

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		panel1.add(label, SwingConstants.CENTER);
		panel2.add(panel3, BorderLayout.CENTER);
		panel3.add(easy);
		panel3.add(empty1);
		panel3.add(moderate);
		panel3.add(nextButton);
		panel3.add(difficult);
		panel3.add(empty2);
		easy.addActionListener(this);
		moderate.addActionListener(this);
		difficult.addActionListener(this);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == easy) {
			setSelection(1);
			nextButton.setEnabled(true);

		} else if (e.getSource() == moderate) {
			setSelection(2);
			nextButton.setEnabled(true);

		} else if (e.getSource() == difficult) {
			setSelection(3);
			nextButton.setEnabled(true);

		}
		if (e.getSource() == nextButton) {
			this.dispose();
				window1 window1 = new window1();
				
			}

		}

	}


