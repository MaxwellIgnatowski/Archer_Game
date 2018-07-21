package core;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Position pos) {
        return x == pos.x && y == pos.y;
    }

    public boolean equalsX(Position pos) {
        return x == pos.x;
    }

    public boolean equalsY(Position pos) {
        return y == pos.y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public void decrementX() {
        x--;
    }

    public void decrementY() {
        y--;
    }
}
