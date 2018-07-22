package core;

import image.Tileset;

public class OverworldBuilder {

    private OverworldBase overworldScreen;

    public OverworldBuilder()
    {
        overworldScreen = new OverworldBase();
        buildFieldOverworld();
        overworldScreen.window.setVisible(true);
    }

    private void clearScreen()
    {
        //maybe call a method from the OverworldBase to empty tileset?
    }

    private void setupNewScreen(Position defaultScreenPosition)
    {
        if(overworldScreen.character != null)
            overworldScreen.character = new OverworldCharacter(overworldScreen.character);
        else
            overworldScreen.character = new OverworldCharacter(defaultScreenPosition);
    }

    public void buildOverworld(OverworldType type) {
        clearScreen();
        switch(type) {
            case FIELD:
                //need something better than this
                setupNewScreen(new Position(7, 7));
                buildFieldOverworld();
                break;
            case FOREST:
                //need something better than this
                setupNewScreen(new Position(7, 7));
                buildForestOverworld();
                break;
            default:
                System.out.println("ERROR: Invalid screen type!");
        }
    }

    private void buildFieldOverworld()
    {
        overworldScreen.generateStructure(Tileset.HOUSE.getTexture(), 1, 1); //Because of Java and the way I have things setup now, structures/top layer stuff must be made BEFORE grass/ground.
        overworldScreen.generateStructure(Tileset.HOUSE.getTexture(), 15, 6);
        overworldScreen.generateStructure(Tileset.HOUSE.getTexture(), 5, 9);
        overworldScreen.generateStructure(Tileset.TREE.getTexture(), 2, 11);
        overworldScreen.generateStructure(Tileset.TREE.getTexture(), 17, 12);
        overworldScreen.generateStructure(Tileset.TREE.getTexture(), 8, 2);
        overworldScreen.createOverworld(Tileset.GRASS);
        overworldScreen.generateRiver(3, "X");
        overworldScreen.generateRiver(12, "Y");
    }

    private void buildForestOverworld()
    {
        //more foresty thing
        //generateStructure for grass
        overworldScreen.createOverworld(Tileset.TREE);
    }

}
