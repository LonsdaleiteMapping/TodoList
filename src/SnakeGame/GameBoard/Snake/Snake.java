package SnakeGame.GameBoard.Snake;

import SnakeGame.utility.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Snake {
    private final List<SnakeCell> snakeBody;
    private final SnakeActions snakeActions;
    private int colAmount, rowAmount;
    private SnakeCell head; //  The head of the snake is the last item in the list


    public Snake(Position position, int colAmount, int rowAmount){
        this.rowAmount = rowAmount;
        this.colAmount = colAmount;

        this.snakeBody = new SnakeBody();
        this.head = new SnakeCell(UUID.randomUUID().toString(),position);

        snakeBody.add(this.head);
        snakeActions = new SnakeActions(this);
    }

    /**
     *
     * @return the current position of the head
     */
    public Position getCurrentPosition()  {
        return  this.head.getPosition();
    }

    public SnakeActions getSnakeAction(){
        return this.snakeActions;
    }

    protected List<SnakeCell> getSnakeBody(){
        return this.snakeBody;
    }

    protected int getColAmount(){ return this.colAmount; }
    protected int getRowAmount() { return this.rowAmount; }

    public SnakeCell getSnakeHead(){
        return  this.head;
    }

    public boolean isApartOfSnake(Position pos){
        return this.snakeBody.stream().filter( body -> body.getPosition().equals(pos)).collect(Collectors.toList()).size() == 1;
    }

    private class SnakeBody extends LinkedList<SnakeCell>{
        @Override
        public boolean contains(Object o) {
            boolean result = false;
            if(o instanceof SnakeCell){
                result = this.stream()
                        .filter(body -> body.getUniqueId().equals(((SnakeCell)o).getUniqueId())).collect(Collectors.toList()).size() == 1;
            }
            return result;
        }
    }
}
