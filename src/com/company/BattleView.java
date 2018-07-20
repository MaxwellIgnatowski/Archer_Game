package com.company;

import java.util.ArrayList;

public interface BattleView {

    void updateScreen();
    void showTargetingInformation(ArrayList<Position> positions);
    Position getTarget();
}
