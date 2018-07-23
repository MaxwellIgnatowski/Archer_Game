package core;

import image.Tileset;

public class Main {

    public static void main(String[] args) {
    	//Testing Game Over...
    	//GameOverScreen gos = new GameOverScreen("You have fallen bravely in battle.");
    	
    	//Testing Overworld...

    	//we'll need to handle switching from a battle screen to an overworld screen
		//either by always creating a new OverworldBase object, or by hiding the OverworldBaseObject when a battle screen is shown
    	OverworldBuilder builder = new OverworldBuilder();
    	
    	
    	
    	/* SCENE 1 */
    	if(builder.overworldScreen.character.intersects(builder.enemy1)) {}
    		//Collision stuff that doesn't work quite yet...
    	
    }
}
