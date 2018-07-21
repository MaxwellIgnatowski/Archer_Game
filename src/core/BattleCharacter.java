package core;

public class BattleCharacter {
    private int position;
    private int health;

    public BattleCharacter() {
        position = 0;
        health = 3;
    }

    public void moveLeft() {
        position--;
        //more code here
    }

    public void moveRight() {
        position++;
        //more code here
    }

    public void takeDamage() {
        if(health > 0)
            health--;
        else
            new GameOverScreen("You have fallen bravely in battle.");
    }

}
