package core;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BattleBase implements KeyListener{

    public Tile[][] tileMap;
    public BattleEnemy[][] enemyMap;
    public BattleCharacter character;
    public OverworldCharacter originalCharacter;
    public JFrame window;
    public int turnNumber;
    public ArrayList<BattleTurnSnapshot> turnList;

    public final int MAP_WIDTH = 25;
    public final int MAP_HEIGHT = 18;

    
    //Delete this later
    JButton quit;
    
    
    public BattleBase() {
        turnNumber = 0;
        character = new BattleCharacter(MAP_WIDTH);
        configureScreen();
    }

    private void configureScreen() {
    	window = new JFrame();
    	window.setTitle("Battle Screen");
		window.setLayout(null);
		window.getContentPane().setPreferredSize(new Dimension(1280, 720));
		window.getContentPane().setBackground(new Color(125, 125, 125));
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(this);
		window.setFocusable(true);
		window.setFocusTraversalKeysEnabled(false);
		
		
		//Delete this later
		quit = new JButton("Return to Overworld");
		quit.setBounds(0, 0, 150, 25);
		quit.addActionListener(e -> {
				window.setVisible(false);
				originalCharacter.canMove = true;
		});
		window.add(quit);
		
		
    }
    
    public void updateScreen() {
        //swing magic
    }

    public void startTurn() {
        moveEnemies();
        addNewEnemies();
        turnNumber++;
    }

    private void addNewEnemies()
    {
        BattleTurnSnapshot currentTurnSnapshot = turnList.get(turnNumber);

        for (BattleEnemy enemy : currentTurnSnapshot.enemyList)
            enemyMap[enemy.getStartingPosition()][MAP_HEIGHT - 1] = enemy;
    }

    private void moveEnemies()
    {
        for(int y = MAP_HEIGHT - 1; y >= 0; y-- ) {
            for(int x = MAP_WIDTH - 1; x >= 0; x--) {
                BattleEnemy currentEnemy = enemyMap[y][x];
                if(currentEnemy != null) {
                    if(currentEnemy.isDead()) {
                        removeEnemy(x, y);
                    }
                    if(y - currentEnemy.getSpeed() < 0) {
                        //Maybe show them hit the zone or something?
                        character.takeDamage();
                        removeEnemy(x, y);
                    } else {
                        removeEnemy(x, y);
                        addEnemy(currentEnemy, x, y);
                    }
                }
            }
        }
    }

    private void removeEnemy(int x, int y)
    {
        enemyMap[y][x] = null;
    }

    private void addEnemy(BattleEnemy enemy, int x, int y)
    {
        enemyMap[y][x] = enemy;
    }

	@Override
	public void keyPressed(KeyEvent e) {
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
			
	}

	@Override
	public void keyTyped(KeyEvent e) {/* UNUSED */}

}
