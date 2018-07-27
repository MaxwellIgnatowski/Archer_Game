package core;

import java.util.ArrayList;

public class BattleBuilder {

    public void buildBattle(BattleType type) {
        switch(type) {
            case TUTORIAL:
                //Need something better than this
                buildTutorialBattle();
                break;
            default:
                System.out.println("ERROR: Invalid screen type!");
        }
    }

    private void buildTutorialBattle() {
        ArrayList<BattleTurnSnapshot> turnList = new ArrayList<BattleTurnSnapshot>();
        turnList.add(new BattleTurnSnapshot(new Skeleton(4)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(3)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(8), new Skeleton(0)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(2), new Skeleton(5), new Skeleton(12)));
    }
}
