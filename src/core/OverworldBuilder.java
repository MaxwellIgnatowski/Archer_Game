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
                buildFieldOverworld();
                break;
            case FOREST:
                //Need something better than this
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
        
        overworldScreen.generateStructure(Tileset.LILYPAD, 10, 3);
        
        overworldScreen.createOverworld(Tileset.GRASS);
        
        overworldScreen.generateTerrainX(Tileset.WATER, 0, 3, 23);
        overworldScreen.generateTerrainY(Tileset.WATER, 12, 0, 15);
        
        overworldScreen.generateTerrainX(Tileset.PATH, 0, 2, 4);
        overworldScreen.generateTerrainX(Tileset.PATH, 0, 10, 18);
        overworldScreen.generateTerrainX(Tileset.PATH, 13, 7, 20);
        overworldScreen.generateTerrainY(Tileset.PATH, 4, 0, 10);
        overworldScreen.generateTerrainY(Tileset.PATH, 8, 11, 7);
        overworldScreen.generateTerrainY(Tileset.PATH, 18, 7, 11);
        overworldScreen.generateTerrainY(Tileset.PATH, 21, 0, 7);
    }

    private void buildForestOverworld()
    {
        //More Forest
        //generateStructure for Grass
        overworldScreen.createOverworld(Tileset.TREE);
    }

}
