package core;

public class BattleCharacter {
    private int position;
    private int health;
    private int pointCount;
    public int pointIncrementer = 1;

    public BattleCharacter(int mapWidth) {
        position = mapWidth / 2;
        health = 3;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int getPosition() { return position;}

    public void takeDamage() {
        if(health > 0)
            health--;
        else
            new GameOverScreen("You have fallen bravely in battle.");
    }

    public void incrementPoint()
    {
        pointCount += pointIncrementer;
    }

    public int getPointCount() {
        return pointCount;
    }
}
