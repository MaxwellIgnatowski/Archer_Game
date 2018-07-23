package core;

import core.Tile;

import java.awt.Color;

import javax.swing.JLabel;

public class OverworldEnemy {

	public JLabel hotspot;
	
	private Position position;
	
	public OverworldEnemy(Position position)
	{
		hotspot = new JLabel();
		this.position = position;
		configureHotspot();
	}
	
	//Setup the Hotspot
	public void configureHotspot()
	{
		hotspot.setOpaque(true);
		hotspot.setBackground(new Color(255, 0, 0));
		hotspot.setBounds(position.getX(), position.getY(), Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	}
	
}
