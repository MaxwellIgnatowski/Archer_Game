package core;

import image.Tileset;

public class Main {

    public static void main(String[] args) {
    	//Testing characters...
    	BattleCharacter juice = new BattleCharacter();
    	
    	//Testing Game Over...
    	//GameOverScreen gos = new GameOverScreen("You have fallen bravely in battle.");
    	
    	//Testing Overworld...
    	OverworldBase ow = new OverworldBase();
    	ow.generateStructure(Tileset.HOUSE.getTexture(), 1, 1); //Because of Java and the way I have things setup now, structures/top layer stuff must be made BEFORE grass/ground.
    	ow.generateStructure(Tileset.HOUSE.getTexture(), 15, 6);
    	ow.generateStructure(Tileset.HOUSE.getTexture(), 5, 9);
    	ow.generateStructure(Tileset.TREE.getTexture(), 2, 11);
    	ow.generateStructure(Tileset.TREE.getTexture(), 17, 12);
    	ow.generateStructure(Tileset.TREE.getTexture(), 8, 2);
    	ow.createOverworld();
    	ow.window.setVisible(true);
    	ow.generateRiver(3, "X");
    	ow.generateRiver(12, "Y");
    }
}
