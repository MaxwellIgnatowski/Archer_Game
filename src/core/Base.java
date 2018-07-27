package core;

import image.Tileset;

import javax.swing.*;

public class Base {

    public Tile[][] tileMap;
    public JFrame window;
    
    public final int MAP_WIDTH = 25;
    public final int MAP_HEIGHT = 18;

    public void createBasicMap(Tileset baseBlock)
    {
        for(int o = 0; o < MAP_WIDTH; o++)
        {
            for(int i = 0; i < MAP_HEIGHT; i++)
            {
                Tile t = new Tile(baseBlock, o * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
                tileMap[o][i] = t;
                window.add(t.tile);
            }
        }
    }

}
