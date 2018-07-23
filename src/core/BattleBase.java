package core;

import javax.swing.JFrame;
import java.util.ArrayList;

public class BattleBase {

    public Tile[][] tileMap;
    public BattleEnemy[][] enemyMap;
    public BattleCharacter character;
    public JFrame window;
    public int turnNumber;
    public ArrayList<BattleTurnSnapshot> turnList;

    public final int MAP_WIDTH = 25;
    public final int MAP_HEIGHT = 18;

    public BattleBase() {
        turnNumber = 0;
        character = new BattleCharacter(MAP_WIDTH);
        //swing set up
    }

    public void updateScreen() {
        //swing magic
    }

    public void startTurn() {

        addNewEnemies();
        turnNumber++;
    }

    private void addNewEnemies()
    {
        BattleTurnSnapshot currentTurnSnapshot = turnList.get(turnNumber);

        for (BattleEnemy enemy : currentTurnSnapshot.enemyList)
            enemyMap[enemy.getStartingPosition()][MAP_HEIGHT - 1] = enemy;
    }

    private void moveEnemies()
    {
        for(int y = MAP_HEIGHT - 1; y >= 0; y-- ) {
            for(int x = MAP_WIDTH - 1; x >= 0; x--) {
                BattleEnemy currentEnemy = enemyMap[y][x];
                if(currentEnemy != null) {
                    if(currentEnemy.isDead()) {
                        removeEnemy(x, y);
                    }
                    if(y - currentEnemy.getSpeed() < 0) {
                        //Maybe show them hit the zone or something?
                        removeEnemy(x, y);
                    } else {
                        removeEnemy(x, y);
                        addEnemy(currentEnemy, x, y);
                    }
                }
            }
        }
    }

    private void removeEnemy(int x, int y)
    {
        enemyMap[y][x] = null;
    }

    private void addEnemy(BattleEnemy enemy, int x, int y)
    {
        enemyMap[y][x] = enemy;
    }

}
