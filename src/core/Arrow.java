package core;

import java.util.ArrayList;

public class Arrow extends ArrowBase {

    private int targetingOffset = 2; //can't attack enemies that are right next to you

    public Arrow() {
        damage = 1;
        pointCost = 1;
    }

    @Override
    public ArrayList<Position[]> getTargetingInformation(int characterX, int mapHeight, int mapWidth) {
        ArrayList<Position[]> targetingInformation = new ArrayList<Position[]>();
        for(int i = targetingOffset; i < mapHeight; i++) {
            targetingInformation.add(new Position[] {new Position(characterX, i)});
        }

        return targetingInformation;
    }

    @Override
    public void fire(ArrayList<BattleEnemy> targets) {
        for(BattleEnemy target : targets)
            target.takeDamage(damage);
    }
}
