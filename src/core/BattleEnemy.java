package core;

public class BattleEnemy {

    private int startingPosition;
    private int health;
    private boolean dead;
    private int speed;

    public BattleEnemy(int startingPosition, int startingHealth)
    {
        this.startingPosition = startingPosition;
        health = startingHealth;
        dead = false;
    }

    public int getStartingPosition()
    {
        return startingPosition;
    }

    public boolean isDead()
    {
        return dead;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void takeDamage(int damage)
    {
        health -= damage;
        if(health <= 0)
            dead = true;
    }

}
