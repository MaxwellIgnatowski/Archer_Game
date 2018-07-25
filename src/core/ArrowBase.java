package core;

import java.util.ArrayList;

public abstract class ArrowBase {

    public int damage;
    public int pointCost;
    //public image
    abstract ArrayList<Position[]> getTargetingInformation(int characterPosition, int mapHeight, int mapWidth);
    abstract void fire(ArrayList<BattleEnemy> targets);

}
