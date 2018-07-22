package core;

import image.Tileset;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;

public class OverworldBase{

    public Tile[][] tileMap;
    public Tile[][] structureMap;
    //going to need to reimplement this, for the possibility that not every possible tile on a side leads to the other screen (trees/houses in the way)
	//or could just design maps so that only connecting tiles that don't lead to impassible tiles are accessible
    public Map<OverworldEdge, OverworldType> connections;
    public OverworldCharacter character;
    public JFrame window;
    
    public final int MAP_WIDTH = 25;
    public final int MAP_HEIGHT = 18;

    private void configureWindow()
	{
		window = new JFrame();
		window.setTitle("Archer Game");
		window.setLayout(null);
		window.getContentPane().setPreferredSize(new Dimension(1280, 720));
		window.getContentPane().setBackground(new Color(0, 150, 255));
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void resetMap()
	{
		tileMap = new Tile[MAP_WIDTH][MAP_HEIGHT];
		structureMap = new Tile[MAP_WIDTH][MAP_HEIGHT];
	}

    public OverworldBase()
    {
		configureWindow();
		resetMap();
		character = new OverworldCharacter(new Position(7, 7));
    }
    
    public void createOverworld(Tileset baseBlock)
    {
    	//Create Basic Map
    	for(int o = 0; o < MAP_WIDTH; o++)
    	{
    		for(int i = 0; i < MAP_HEIGHT; i++)
    		{
    			Tile t = new Tile(baseBlock.getTexture(), o * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
    			tileMap[o][i] = t;
    			window.add(t.tile);
    		}
    	}
    }
    
    //Creates a River
    /*Right now, only allows creation in a single row or column. Accepts "X" or "Y" for direction argument.*/
    public void generateRiver(int location, String direction)
    {
    	switch(direction)
    	{
    	case "X":
    		for(int i = 0; i < MAP_WIDTH; i++)
    		{
    			tileMap[i][location].setTexture(tileMap[i][location], Tileset.WATER.getTexture());
    		}
    		break;
    	case "Y":
    		for(int i = 0; i < MAP_HEIGHT; i++)
    		{
    			tileMap[location][i].setTexture(tileMap[location][i], Tileset.WATER.getTexture());
    		}
    		break;
    	default:
    		System.out.println("ERROR: Invalid direction!");
    		break;
    	}
    }
    
    //Creates a structure
    /*Maybe we can change this to be more general once we add more buildings? I'm trying to think of good reasons to call tile creations through their respective biome's class (i. e. "OVERWORLD") so we:
    	1) Don't create random structures through the Main Class and 2) Make it more than just a train of methods calling one another. I'll think about it to make it clearer when we talk next.*/
    public void generateStructure(String texture, int x, int y)
    {
    	Tile t = new Tile(texture, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
    	structureMap[x][y] = t;
		window.add(t.tile);
    }
    
    //Deletes a Tile
    public void remove(int x, int y) {
    	Tile.deleteTile(tileMap[x][y]);
    }
    
}
