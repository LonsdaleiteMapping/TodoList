package SnakeGame.Utility;

public class Position {
    public int x;
    public int y;

    public Position(){}

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position pos){
        return pos.x == this.x && pos.y == this.y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
