package SnakeGame.GameBoard.Snake;

public class EatingSnakeBodyException extends Exception{
    private SnakeCell snakeCell;

    public  EatingSnakeBodyException(SnakeCell snakeCell){
        this.snakeCell = snakeCell;
    }

    @Override
    public String getMessage() {
        return "Snake " + this.snakeCell.getUniqueId() + " was eaten.";
    }
}
