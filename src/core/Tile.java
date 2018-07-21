package core;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile
{	
	public JLabel tile;
	
	public static final int TILE_WIDTH = 40;
	public static final int TILE_HEIGHT = 40;
	
	//Creates a New Map Tile
    public Tile(String texture, int x, int y)
    {
    	tile = new JLabel(new ImageIcon(new ImageIcon(texture).getImage().getScaledInstance(TILE_WIDTH, TILE_HEIGHT, Image.SCALE_DEFAULT)));
    	tile.setBounds(x, y, TILE_WIDTH, TILE_HEIGHT);
    }
    
    //Changes a Tile's Texture
    public void setTexture(Tile tileToChange, String texture)
    {
    	tileToChange.tile.setIcon(new ImageIcon(new ImageIcon(texture).getImage().getScaledInstance(TILE_WIDTH, TILE_HEIGHT, Image.SCALE_DEFAULT)));
    }
    
	//Deletes a Tile
    public static void deleteTile(Tile tileToDelete)
    {
    	tileToDelete.tile.setVisible(false);
    }
    
}
