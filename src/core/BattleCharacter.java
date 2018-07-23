package core;

public class BattleCharacter {
    private int position;
    private int health;

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

    public void takeDamage() {
        if(health > 0)
            health--;
        else
            new GameOverScreen("You have fallen bravely in battle.");
    }

}
