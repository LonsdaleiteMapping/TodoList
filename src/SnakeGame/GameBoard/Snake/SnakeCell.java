package SnakeGame.GameBoard.Snake;

import SnakeGame.Utility.Position;

public class SnakeCell {

    private boolean apartOfBody;
    private String uniqueId;
    private Position position;

    public SnakeCell(String uniqueId,Position position){
        this.uniqueId = uniqueId;
        this.position = position;
        this.apartOfBody = false;
    }

    public void isbeingEaten(){
        this.apartOfBody = true;
    }

    public boolean isApartOfBody(){
        return this.apartOfBody;
    }

    public Position getPosition(){ return this.position; }

    public void setPosition(Position position){ this.position = position; }

    public String getUniqueId(){
        return this.uniqueId;
    }

    @Override
    public String toString() {
        return "SnakeCell{" +
                "apartOfBody=" + apartOfBody +
                ", uniqueId='" + uniqueId + '\'' +
                ", position=" + position +
                '}';
    }
}
