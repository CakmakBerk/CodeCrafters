import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class rules extends JFrame implements ActionListener {
	JButton back;
	JLabel label;
	JPanel panel;

	File file = new File("Click.wav");
	AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();

	public rules() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		back = new JButton();
		label = new JLabel();
		panel = new JPanel();
		clip.open(audiostream);

		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("RULES");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(2, 12, 57));

		back.setPreferredSize(new Dimension(1100, 150));
		back.setText("BACK");
		back.setFont(new Font("MV Boli", Font.PLAIN, 30));
		back.setVerticalTextPosition(JLabel.CENTER);
		back.setHorizontalAlignment(JLabel.CENTER);
		back.setForeground(Color.white);
		back.setBackground(new Color(2, 12, 57));
		back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		back.setOpaque(true);
		back.addActionListener(this);
		back.setEnabled(true);
		back.setFocusable(false);

		panel.setBackground(new Color(2, 12, 57));
		panel.setPreferredSize(new Dimension(1100, 750));

		label.setText(
				"<html><p><br></p><p style=\"text-align: center;\"><strong>Part 1 is quiz competition</strong></p>\n"
						+ "<p><br></p>" + "<p>Today I have easy, medium and hard questions for you</p>\n"
						+ "<p>-&gt;Easy questions are worth 10 points</p>\n"
						+ "<p>-&gt;Middle questions are worth 30 points</p>\n"
						+ "<p>-&gt;Difficult questions are worth 50 points</p>\n"
						+ "<p>You can start with the easy one, if you say you have general knowledge.</p>\n"
						+ "<p>Choose the difficult one and try yourself, if you are confident.</p>\n" + "<p><br></p>\n"
						+ "<p style=\"text-align: center;\">Part 2 is Earn Diamond game</p>\n" + "<p><br></p>"
						+ "<p>-&gt; The game starts with a countdown equal to the points you collected from Part 1 multiplied by 3, </p>\n<p>and the game ends when the time runs out.</p>\n"
						+ "<p>-&gt; The main purpose of the game is to find a random number of diamonds placed by the system between 0-36 </p>\n<p>in a 6&times;6 matrix.</p>\n"
						+ "<p>-&gt;At the beginning of the game, you have the right to try 6 times, and if you cannot find even one diamond in these 6 tries, </p>\n<p>the game will automatically close and you will lose.</p>\n"
						+ "<p>-&gt;If you find a diamond in one of the 6 attempts, the game gives you the chance to find other diamonds.</p>\n"
						+ "<p>-&gt; You can see the number of diamonds created by the game, </p>\n<p>your score and the remaining time in the box in the upper right corner of the game.</p>\n"
						+ "<p><br></p>\n" + "<p><br></p>"
						+ "<p><strong>Note: The points you collect in the part 1 are very valuable because they will be useful in Part 2. Think well :)</strong></p></html>");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setVerticalAlignment(JLabel.BOTTOM);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(Color.white);
		label.setBackground(new Color(2, 12, 57));
		label.setFont(new Font("Safir", Font.PLAIN, 17));
		label.setForeground(Color.white);

		this.add(back, BorderLayout.SOUTH);
		this.add(panel, BorderLayout.NORTH);
		panel.add(label);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			clip.start();
			this.dispose();
			try {
				about about = new about();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
