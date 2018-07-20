package com.company;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position pos) {
        return this.x == pos.x && this.y == pos.y;
    }
}
