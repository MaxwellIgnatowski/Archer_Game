package core;

import java.util.ArrayList;

public class BattleTurnSnapshot {
    public ArrayList<BattleEnemy> enemyList;

    public BattleTurnSnapshot(BattleEnemy... enemyList) {
        for(BattleEnemy enemy : enemyList)
            this.enemyList.add(enemy);
    }

}
