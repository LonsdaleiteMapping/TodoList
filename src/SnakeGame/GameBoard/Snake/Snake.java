package SnakeGame.GameBoard.Snake;

import SnakeGame.utility.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Snake {
    private final List<SnakeCell> snakeBody;
    private final SnakeActions snakeActions;
    private int parentWidth,parentHeight;
    private SnakeCell head;


    public Snake(Position position,int parentWidth,int parentHeight){
        this.snakeBody = new SnakeBody();
        this.head = new SnakeCell(UUID.randomUUID().toString(),position);
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
        snakeBody.add(this.head);
        snakeActions = new SnakeActions(this);
    }

    /**
     * The head of the snake is the last item in the list
     * @return the current position of the head
     */
    public Position getCurrentPosition()  {
        return  snakeBody.get(snakeBody.size() -1).getPosition();
    }

    public SnakeActions getSnakeAction(){
        return this.snakeActions;
    }

    protected List<SnakeCell> getSnakeBody(){
        return this.snakeBody;
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

    public int getParentWidth() {
        return parentWidth;
    }

    public int getParentHeight() {
        return parentHeight;
    }
}
