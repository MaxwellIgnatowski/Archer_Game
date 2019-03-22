package core;

import java.util.ArrayList;

public class BattleTurnSnapshot {
    public ArrayList<BattleEnemy> enemyList;

    public BattleTurnSnapshot(BattleEnemy... enemyList) {
        this.enemyList = new ArrayList<BattleEnemy>();
        for(BattleEnemy enemy : enemyList)
            this.enemyList.add(enemy);
    }

}
