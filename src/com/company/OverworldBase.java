package com.company;

import java.util.Map;

public class OverworldBase {

    public Tile[][] tileSet;
    public Map<OverworldEdge, OverworldBase> connections;
    public OverworldCharacter character;

    public OverworldBase(OverworldCharacter previousCharacter, Tile[][] tileSet) {
        character = new OverworldCharacter(previousCharacter);
        this.tileSet = tileSet;
    }

}
