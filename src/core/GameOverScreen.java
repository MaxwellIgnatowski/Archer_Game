package core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverScreen extends JFrame{

    public GameOverScreen(String message) {
    	//Configure Window
    	JPanel container = new JPanel();
    	BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    	container.setLayout(layout);
    	container.setBackground(new Color(0, 0, 0));
    	
  		setTitle("Game Over");  
  		getContentPane().setPreferredSize(new Dimension(1280, 720));
  		pack();
  		setResizable(false);
  		setLocationRelativeTo(null);
  		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
  		//Text
  		JLabel gameOver = new JLabel("GAME OVER");
  		gameOver.setFont(new Font("Impact", Font.PLAIN, 72));
  		gameOver.setForeground(new Color(255, 0, 0));
  		gameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
  		
  		JLabel cause = new JLabel(message);
  		cause.setFont(new Font("Calibri", Font.PLAIN, 36));
  		cause.setForeground(new Color(255, 255, 255));
  		cause.setAlignmentX(Component.CENTER_ALIGNMENT);
  		
  		//Add Items to Containers
  		add(container);
  		container.add(gameOver);
  		container.add(cause);
  		
  		//Show Frame
  		setVisible(true);
    }

}
