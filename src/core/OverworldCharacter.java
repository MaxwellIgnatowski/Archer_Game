package core;

public class OverworldCharacter {

    private Position position;
    private CharacterDirection direction;
    //public image

    //constructor used when not coming from another Overworld screen
    public OverworldCharacter(Position position) {
        this.position = position;
        this.direction = CharacterDirection.DOWN;
    }

    //constructor used when coming from another Overworld screen
    public OverworldCharacter(OverworldCharacter previousCharacter) {
        this.direction = previousCharacter.getDirection();
        if(this.direction == CharacterDirection.UP || this.direction == CharacterDirection.DOWN)
            this.position = new Position(previousCharacter.position.getX(), 0);
        else
            this.position = new Position(0, previousCharacter.position.getY());
    }

    public CharacterDirection getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public void moveLeft() {
        position.decrementX();
    }

    public void moveRight() {
        position.incrementX();
    }

    public void moveUp() {
        position.incrementY();
    }

    public void moveDown() {
        position.decrementY();
    }
}
