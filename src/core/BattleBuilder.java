package core;

import java.util.ArrayList;

public class BattleBuilder {

    //Make this actually make the stage, like OverworldBuilder does (It is named the same, so should perform a similar function)
    public void buildBattle(BattleType type) {
        switch(type) {
            case TUTORIAL:
                //Need something better than this
                break;
            default:
                System.out.println("ERROR: Invalid screen type!");
        }
    }

    public static ArrayList<BattleTurnSnapshot> buildBattleTurnList(BattleType type) {
        switch(type) {
            case TUTORIAL:
                return buildTutorialBattleTurnList();
            default:
                System.out.println("ERROR: Invalid screen type!");
                return new ArrayList<BattleTurnSnapshot>();
        }
    }

    private static ArrayList<BattleTurnSnapshot> buildTutorialBattleTurnList() {
        ArrayList<BattleTurnSnapshot> turnList = new ArrayList<BattleTurnSnapshot>();
        turnList.add(new BattleTurnSnapshot(new Skeleton(4)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(3)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(8), new Skeleton(0)));
        turnList.add(new BattleTurnSnapshot());
        turnList.add(new BattleTurnSnapshot(new Skeleton(2), new Skeleton(5), new Skeleton(12)));
        return turnList;
    }
}
