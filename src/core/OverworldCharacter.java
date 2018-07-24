package core;

import core.Tile;

import image.Tileset;

import java.awt.Image;
import java.awt.geom.Area;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OverworldCharacter {

	public JLabel sprite;
	public boolean canMove;
	
    private Position position;
    private CharacterDirection direction;

    //constructor used when not coming from another Overworld screen
    public OverworldCharacter(Position position) {
        this.position = position;
        this.direction = CharacterDirection.DOWN;
        canMove = true;
        createSprite();
    }

    //constructor used when coming from another Overworld screen
    public OverworldCharacter(OverworldCharacter previousCharacter) {
        this.direction = previousCharacter.getDirection();
        if(this.direction == CharacterDirection.UP || this.direction == CharacterDirection.DOWN)
            this.position = new Position(previousCharacter.position.getX(), 0);
        else
            this.position = new Position(0, previousCharacter.position.getY());
    }

    //Creates Character Sprite
    public void createSprite()
    {
    	sprite = new JLabel(new ImageIcon(new ImageIcon(Tileset.CTR_DOWN.getTexture()).getImage().getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Image.SCALE_DEFAULT)));
    	sprite.setBounds(position.getX(), position.getY(), Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }
    
    //Tests Collision With Enemy
  	public boolean intersects(OverworldEnemy enemy){
  	    Area playerArea = new Area(sprite.getBounds());
  	    Area enemyArea = new Area(enemy.hotspot.getBounds());

  	    return playerArea.intersects(enemyArea.getBounds2D());
  	}
    
    public CharacterDirection getDirection() {
        return direction;
    }

    public void setDirection(CharacterDirection newDirection) {
    	direction = newDirection;
    	
    	switch(newDirection)
    	{
    	case UP:
    		sprite.setIcon(new ImageIcon(new ImageIcon(Tileset.CTR_UP.getTexture()).getImage().getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Image.SCALE_DEFAULT)));
    		break;
    	case LEFT:
    		sprite.setIcon(new ImageIcon(new ImageIcon(Tileset.CTR_LEFT.getTexture()).getImage().getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Image.SCALE_DEFAULT)));
    		break;
    	case RIGHT:
    		sprite.setIcon(new ImageIcon(new ImageIcon(Tileset.CTR_RIGHT.getTexture()).getImage().getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Image.SCALE_DEFAULT)));
    		break;
    	case DOWN:
    		sprite.setIcon(new ImageIcon(new ImageIcon(Tileset.CTR_DOWN.getTexture()).getImage().getScaledInstance(Tile.TILE_WIDTH, Tile.TILE_HEIGHT, Image.SCALE_DEFAULT)));
    		break;
    	}
    }
    
    public void setPosition(int newX, int newY) {
    	position.setX(newX);
    	position.setY(newY);
    }
    
    public Position getPosition() {
        return position;
    }

    public void moveLeft() {
        position.decrementX();
    }

    public void moveRight() {
        position.incrementX();
    }

    public void moveUp() {
        position.decrementY();
    }

    public void moveDown() {
        position.incrementY();
    }
}
