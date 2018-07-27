package core;

public abstract class BattleEnemy {

    public int startingPosition;
    public int health;
    public boolean dead;
    public int speed;

    public BattleEnemy(int startingPosition)
    {
        this.startingPosition = startingPosition;
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
