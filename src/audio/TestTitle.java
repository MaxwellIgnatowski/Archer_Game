package audio;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import javafx.scene.media.AudioClip;

public class TestTitle extends JFrame
{
	//Public Fields
	static JButton title = new JButton("Theme");
	static JButton battle = new JButton("Battle");
	static JButton npc = new JButton("NPC");
	static JButton boss = new JButton("Boss");
	
	static AudioClip current;
	final AudioClip TITLE = new AudioClip(getClass().getResource("title.wav").toString());
	final AudioClip BATTLE = new AudioClip(getClass().getResource("battle.wav").toString());
	final AudioClip NPC = new AudioClip(getClass().getResource("city.wav").toString());
	final AudioClip BOSS = new AudioClip(getClass().getResource("boss.wav").toString());
	
	public TestTitle()
	{
		//Configure Window
		setTitle("Archer Game");
		setLayout(null);  
		getContentPane().setPreferredSize(new Dimension(350, 200));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Song Choice
		current = TITLE;
		
		title.setBounds(5, 175, 80, 20);
		title.setFocusPainted(false);
		add(title);
		
		battle.setBounds(90, 175, 80, 20);
		battle.setFocusPainted(false);
		add(battle);
		
		npc.setBounds(175, 175, 80, 20);
		npc.setFocusPainted(false);
		add(npc);
		
		boss.setBounds(260, 175, 80, 20);
		boss.setFocusPainted(false);
		add(boss);
		
		//Different Song
		title.addActionListener(e -> playAudio(TITLE));
		battle.addActionListener(e -> playAudio(BATTLE));
		npc.addActionListener(e -> playAudio(NPC));
		boss.addActionListener(e -> playAudio(BOSS));
		
		//Display Background Image
		JLabel container = new JLabel(new ImageIcon(new ImageIcon("src/com/company/titleScreen.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
		container.setBounds(0, 0, getWidth(), getHeight());
		add(container);
		
		//Show Final Frame
		setVisible(true);
	}
	
	public void playAudio(AudioClip a)
	{
		//Play Audio
		current.stop();
		current = a;
		a.play();
	}
}
