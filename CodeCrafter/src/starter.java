import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class starter extends JFrame implements ActionListener {
	JButton press;
	ImageIcon buttonicon = new ImageIcon("button1.2.png");

	File file = new File("Click.wav");
	AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
	Clip clip = AudioSystem.getClip();

	public starter() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		// sound

		clip.open(audiostream);

		press = new JButton();
		this.setSize(1100, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("START");
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		press.setPreferredSize(new Dimension(1100, 900));
		press.addActionListener(this);
		press.setIcon(buttonicon);
		press.setOpaque(true);

		this.add(press);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == press) {
			clip.start();
			this.dispose();
			try {
				about about = new about();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			}
		}
	}

}
