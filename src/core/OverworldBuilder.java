package core;

import image.Tileset;
import core.OverworldBase;

public class OverworldBuilder {

    public OverworldBase overworldScreen;

    public OverworldBuilder()
    {
        overworldScreen = new OverworldBase();
        buildOverworld(OverworldType.FIELD);
        overworldScreen.window.setVisible(true);
    }

    private void clearScreen()
    {
        for(int o = 0; o < overworldScreen.MAP_WIDTH; o++)
        {
        	for(int i = 0; i < overworldScreen.MAP_HEIGHT; i++)
        	{
        		overworldScreen.remove(o, i);
        	}
        }
    }

    private void setupNewScreen(Position defaultScreenPosition)
    {
        if(overworldScreen.character != null)
            overworldScreen.character = new OverworldCharacter(overworldScreen.character);
        else
            overworldScreen.character = new OverworldCharacter(defaultScreenPosition);
    }

    public void buildOverworld(OverworldType type) {
        switch(type) {
            case FIELD:
                //Need something better than this
                setupNewScreen(new Position(7, 7));
                buildFieldOverworld();
                break;
            case FOREST:
                //Need something better than this
                setupNewScreen(new Position(7, 7));
                buildForestOverworld();
                break;
            default:
                System.out.println("ERROR: Invalid screen type!");
        }
    }

    private void buildFieldOverworld()
    {
        overworldScreen.generateStructure(Tileset.HOUSE, 1, 1);
        overworldScreen.generateStructure(Tileset.HOUSE, 15, 6);
        overworldScreen.generateStructure(Tileset.HOUSE, 5, 9);
        overworldScreen.generateStructure(Tileset.TREE, 5, 1);
        overworldScreen.generateStructure(Tileset.TREE, 17, 12);
        overworldScreen.generateStructure(Tileset.TREE, 7, 9);
        overworldScreen.generateStructure(Tileset.TREE, 22, 5);
        overworldScreen.createOverworld(Tileset.GRASS);
        overworldScreen.generateRiver(3, "X");
        overworldScreen.generateRiver(12, "Y");
        overworldScreen.generatePath(Tileset.PATH, 0, 2, 5, "X"); 
    	overworldScreen.generatePath(Tileset.PATH, 0, 10, 12, "X");
    	overworldScreen.generatePath(Tileset.PATH, 13, 7, 20, "X"); //Error Trap for Length Works :)
    	overworldScreen.generatePath(Tileset.PATH, 4, 0, 2, "Y");
    	overworldScreen.generatePath(Tileset.PATH, 8, 11, 7, "Y");
    	overworldScreen.generatePath(Tileset.PATH, 18, 7, 11, "Y");
    	overworldScreen.generatePath(Tileset.PATH, 21, 4, 3, "Y");
    }

    private void buildForestOverworld()
    {
        //More Forest
        //generateStructure for Grass
        overworldScreen.createOverworld(Tileset.TREE);
    }

}
