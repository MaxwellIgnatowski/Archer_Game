package core;

import image.Tileset;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JFrame;

public class OverworldBase implements KeyListener{

    public Tile[][] tileMap;
    public Tile[][] structureMap;
    /*Going to need to re-implement this, for the possibility that not every possible tile on a side leads to the other screen (trees/houses in the way)
		or could just design maps so that only connecting tiles that don't lead to impossible tiles are accessible*/
    public Map<OverworldEdge, OverworldType> connections;
    public OverworldCharacter character;
    public JFrame window;
    
    public final int MAP_WIDTH = 25;
    public final int MAP_HEIGHT = 18;

    public OverworldBase()
    {
		configureWindow();
		resetMap();
		character = new OverworldCharacter(new Position(0, 80));
		window.add(character.sprite);
    }
    
    private void configureWindow()
	{
		window = new JFrame();
		window.setTitle("Overworld");
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
	}

	private void resetMap()
	{
		tileMap = new Tile[MAP_WIDTH][MAP_HEIGHT];
		structureMap = new Tile[MAP_WIDTH][MAP_HEIGHT];
	}
    
	//Create Basic Map
    public void createOverworld(Tileset baseBlock)
    {
    	for(int o = 0; o < MAP_WIDTH; o++)
    	{
    		for(int i = 0; i < MAP_HEIGHT; i++)
    		{
    			Tile t = new Tile(baseBlock, o * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
    			tileMap[o][i] = t;
    			window.add(t.tile);
    		}
    	}
    }
    
    //Deletes a Tile
    public void remove(int x, int y) {
    	tileMap[x][y].deleteTile();
    }
    
    //Creates Landscape Features in the X Direction
    public void generateTerrainX(Tileset texture, int x, int y, int length)
    {
    	int pos = x;
		int loop = 0;
		
		while(loop < length && pos < MAP_WIDTH)
		{
			if(texture.equals(Tileset.PATH) && tileMap[pos][y].getTexture().equals(Tileset.WATER))
				tileMap[pos][y].setTexture(Tileset.BRIDGE_HORIZONTAL);
			else
				tileMap[pos][y].setTexture(texture);
			
			pos++;
			loop++;				
		}
    }
    
    //Creates Landscape Features in the Y Direction
    public void generateTerrainY(Tileset texture, int x, int y, int length)
    {
    	int pos = y;
		int loop = 0;
		
		while(loop < length && pos < MAP_HEIGHT)
		{
			if(texture.equals(Tileset.PATH) && tileMap[x][pos].getTexture().equals(Tileset.WATER))
				tileMap[x][pos].setTexture(Tileset.BRIDGE_VERTICAL);
			else
				tileMap[x][pos].setTexture(texture);
			
			pos++;
			loop++;
		}
    }
    
    //Creates a Structure
    /*Maybe we can change this to be more general once we add more buildings? I'm trying to think of good reasons to call tile creations through their respective biome's class (i. e. "OVERWORLD") so we:
    	1) Don't create random structures through the Main Class and 2) Make it more than just a train of methods calling one another. I'll think about it to make it clearer when we talk next.*/
    public void generateStructure(Tileset texture, int x, int y)
    {
    	Tile t = new Tile(texture, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
    	structureMap[x][y] = t;
		window.add(t.tile);
    }

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		switch(key)
		{
		case KeyEvent.VK_W:
					
			break;
		case KeyEvent.VK_A:
			
		    break;
		case KeyEvent.VK_S:
			
		    break;
		case KeyEvent.VK_D: //THE PROBLEM: For whatever reason, whenever this method is called, it thinks that "character.sprite" does not exist, when it was clearly instantiated earlier.
							//The only time I got this to work was when "character.sprite" was defined as "static" in "OverworldCharacter".
			System.out.println(character.sprite); //Will print "null".
			
			character.setDirection(CharacterDirection.RIGHT); //Null Pointer Exception. (References "character.sprite" within the "setDirection()" method.
            character.moveRight();
            character.sprite.setLocation(character.getPosition().getX(), character.getPosition().getY()); //Null Pointer Exception.
            break;	 
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {/*Unused*/}

	@Override
	public void keyTyped(KeyEvent e) {/*Unused*/}
}
    
    
    
    
    /*OLD METHODS - In case anything ever breaks...*/
    
    //Creates a River
    /*Right now, only allows creation in a single row or column. Accepts "X" or "Y" for direction argument.*/
    /*
    public void generateRiver(int x, int y, int length, String direction)
    {
    	switch(direction)
    	{
    	case "X":
    		int xVal = x;
    		int loopX = 0;
    		
    		while(loopX < length && xVal < MAP_WIDTH)
    		{
				tileMap[xVal][y].setTexture(Tileset.WATER);
    			xVal++;
    			loopX++;				
    		}
    		
    		break;
    	case "Y":
    		int yVal = y;
    		int loopY = 0;
    		
    		while(loopY < length && yVal < MAP_HEIGHT)
    		{
				tileMap[x][yVal].setTexture(Tileset.WATER);
    			yVal++;
    			loopY++;
    		}
    		
    		break;
	    	default:
	    		System.out.println("ERROR: Invalid direction!");
	    		break;
    	}
    }
    
    //Creates a Path
    /*Accepts "X" or "Y" for direction. Builds left -> right and top -> bottom.*/
    /*
    public void generatePath(Tileset texture, int x, int y, int length, String direction)
    {
    	switch(direction)
    	{
	    	case "X":
	    		int xVal = x;
	    		int loopX = 0;
	    		
	    		while(loopX < length && xVal < MAP_WIDTH)
	    		{
	    			if(tileMap[xVal][y].getTexture().equals(Tileset.WATER))
	    			{
	    				tileMap[xVal][y].setTexture(Tileset.BRIDGE_HORIZONTAL);
		    			xVal++;
		    			loopX++;
	    			}
	    			else
	    			{
	    				tileMap[xVal][y].setTexture(texture);
		    			xVal++;
		    			loopX++;
	    			}
    				
	    		}
	    		
	    		break;
	    	case "Y":
	    		int yVal = y;
	    		int loopY = 0;
	    		
	    		while(loopY < length && yVal < MAP_HEIGHT)
	    		{
	    			if(tileMap[x][yVal].getTexture().equals(Tileset.WATER))
	    			{
	    				tileMap[x][yVal].setTexture(Tileset.BRIDGE_VERTICAL);
		    			yVal++;
		    			loopY++;
	    			}
	    			else
	    			{
	    				tileMap[x][yVal].setTexture(texture);
		    			yVal++;
		    			loopY++;
	    			}
	    		}
	    		
	    		break;
	    	default:
	    		System.out.println("ERROR: Invalid direction!");
	    		break;
    	}
    }*/
