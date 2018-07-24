package core;

import image.Tileset;
import core.OverworldBase;

public class OverworldBuilder {

    public OverworldBase overworldScreen;
    
    public OverworldEnemy enemy1;

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

    public void newBattle()
    {
    	enemy1.hotspot.setVisible(false);
    	
    	overworldScreen.character.canMove = false;
    	overworldScreen.character.setDirection(CharacterDirection.DOWN);
    	overworldScreen.character.sprite.setLocation((overworldScreen.character.getPosition().getX() + (Tile.TILE_WIDTH / 2)) - ((overworldScreen.character.getPosition().getX() + (Tile.TILE_WIDTH / 2)) % Tile.TILE_WIDTH), (overworldScreen.character.getPosition().getY() + (Tile.TILE_HEIGHT / 2)) - ((overworldScreen.character.getPosition().getY() + (Tile.TILE_HEIGHT / 2)) % Tile.TILE_HEIGHT));
    	overworldScreen.character.setPosition((int)overworldScreen.character.sprite.getLocation().getX(), (int)overworldScreen.character.sprite.getLocation().getY());
		
		BattleBase newBattle = new BattleBase();
		newBattle.originalCharacter = overworldScreen.character;
		newBattle.window.setVisible(true);
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
        overworldScreen.generateStructure(Tileset.LILYPAD, 12, 12);
        
        enemy1 = new OverworldEnemy(new Position(440, 400));
        overworldScreen.createEnemyHotspot(enemy1);
        
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
        overworldScreen.createOverworld(Tileset.TREE);
    }
}
