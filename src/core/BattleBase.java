package core;

import javax.swing.JButton;
import javax.swing.JFrame;

import image.Tileset;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BattleBase implements KeyListener, MouseListener{
	
	public BattleTile[][] tileMap;
    public BattleEnemy[][] enemyMap;
    public BattleCharacter character;
    public OverworldCharacter originalCharacter;
    public int turnNumber;
    public boolean playerSelectingTarget;
    public ArrayList<BattleTurnSnapshot> turnList;
    
    public final int BATTLE_MAP_WIDTH = 25;
    public final int BATTLE_MAP_HEIGHT = 18;
    
    JFrame battleWindow;
    
    //Delete this later
    JButton quit;
    
    public BattleBase() {
        turnNumber = 0;
        character = new BattleCharacter(BATTLE_MAP_WIDTH);
        playerSelectingTarget = false;
        configureScreen();
    }

    private void configureScreen() {
    	battleWindow = new JFrame();
    	battleWindow.setTitle("Battle Screen");
    	battleWindow.setLayout(null);
    	battleWindow.getContentPane().setPreferredSize(new Dimension(1280, 720));
    	battleWindow.getContentPane().setBackground(new Color(125, 125, 125));
    	battleWindow.pack();
    	battleWindow.setResizable(false);
    	battleWindow.setLocationRelativeTo(null);
    	battleWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	battleWindow.addKeyListener(this);
    	battleWindow.setFocusable(true);
    	battleWindow.setFocusTraversalKeysEnabled(false);
		
		
		//Delete this later
		quit = new JButton("Return to Overworld");
		quit.setBounds(1050, 25, 150, 25);
		quit.addActionListener(e -> {
			battleWindow.setVisible(false);
				originalCharacter.canMove = true;
		});
		battleWindow.add(quit);
		
		resetMap();
		createBattleMap(Tileset.GRASS);
    }
    
    private void createBattleMap(Tileset baseBlock)
    {
    	for(int o = 0; o < BATTLE_MAP_WIDTH; o++)
        {
            for(int i = 0; i < BATTLE_MAP_HEIGHT; i++)
            {
                BattleTile t = new BattleTile(baseBlock, o * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
                t.tile.addMouseListener(this);
                tileMap[o][i] = t;
                battleWindow.add(t.tile);
            }
        }
    }
    
    //Setup Array
  	private void resetMap()
  	{
  		tileMap = new BattleTile[BATTLE_MAP_WIDTH][BATTLE_MAP_HEIGHT];
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
            enemyMap[enemy.getStartingPosition()][BATTLE_MAP_HEIGHT - 1] = enemy;
    }

    private void moveEnemies()
    {
        for(int y = BATTLE_MAP_HEIGHT - 1; y >= 0; y-- ) {
            for(int x = BATTLE_MAP_WIDTH - 1; x >= 0; x--) {
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


    //Run when the player clicks on the any of the arrow buttons
    //If playerSelectingTarget is true, don't move anything on the screen, this would be a simple check in the tick method
    private void purchaseArrow(ArrowBase arrow) {
        if(character.getPointCount() > arrow.pointCost) {
            ArrayList<Position[]> targetOptions = arrow.getTargetingInformation(character.getPosition(), BATTLE_MAP_HEIGHT, BATTLE_MAP_WIDTH);
            showPlayerTargetingOptions(targetOptions);
            playerSelectingTarget = true;

            //When the character selects an option, call
            //arrow.fire(convertPositionsToEnemies(targetOptions[?]))

        }

    }

    private ArrayList<BattleEnemy> convertPositionsToEnemies(Position[] positions) {
        ArrayList<BattleEnemy> enemies = new ArrayList<BattleEnemy>();
        for(Position position : positions) {
            BattleEnemy currentEnemy = enemyMap[position.getY()][position.getX()];
            if(currentEnemy != null) {
                enemies.add(currentEnemy);
            }
        }
        return enemies;
    }


    private void showPlayerTargetingOptions(ArrayList<Position[]> targetOptions) {
        //swing magic
        //the only initially highlighted bit is the first array index of all of the possible positions, when the character
        //mouses over it then the other elements of that array are highlighted as well
    }

	@Override
	public void keyPressed(KeyEvent e) 
	{
				
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
			
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		JButton location = (JButton)e.getSource();
		
		//Example of a way to see if a tile was clicked...
		if(location.equals(tileMap[2][2].tile))
		{
			battleWindow.setTitle("You clicked on a button!");
			quit.setText("(%&*_+=#");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		JButton location = (JButton)e.getSource();
		
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {/* UNUSED */}
	
	@Override
	public void mouseExited(MouseEvent e) {/*UNUSED*/}

	@Override
	public void mousePressed(MouseEvent e) {/*UNUSED*/}

	@Override
	public void mouseReleased(MouseEvent e) {/*UNUSED*/}

}
