package core;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import image.Tileset;

public class Tile
{	
	public JLabel tile;
	private Tileset texture;
	
	public static final int TILE_WIDTH = 40;
	public static final int TILE_HEIGHT = 40;
	
	//Creates a New Map Tile
    public Tile(Tileset texture, int x, int y)
    {
    	tile = new JLabel(new ImageIcon(new ImageIcon(texture.getTexture()).getImage().getScaledInstance(TILE_WIDTH, TILE_HEIGHT, Image.SCALE_DEFAULT)));
    	tile.setBounds(x, y, TILE_WIDTH, TILE_HEIGHT);
    	this.texture = texture;
    }
    
    //Changes a Tile's Texture
    public void setTexture(Tileset texture)
    {
    	tile.setIcon(new ImageIcon(new ImageIcon(texture.getTexture()).getImage().getScaledInstance(TILE_WIDTH, TILE_HEIGHT, Image.SCALE_DEFAULT)));
    	this.texture = texture;
    }
    
    //Retrieves a Tile's Texture
    public Tileset getTexture()
    {
    	return texture;
    }
    
	//Deletes a Tile
    public void deleteTile()
    {
    	tile.setVisible(false);
    }
    
}
