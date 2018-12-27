package SnakeGame.GameBoard.Snake;

import SnakeGame.Tasks.Snake.MoveSnakeDown;
import SnakeGame.Tasks.Snake.MoveSnakeLeft;
import SnakeGame.Tasks.Snake.MoveSnakeRight;
import SnakeGame.Tasks.Snake.MoveSnakeUp;
import SnakeGame.enums.ListenerNames;
import SnakeGame.utility.Position;
import TodoList.Item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SnakeActions implements PropertyChangeListener {
    private final Snake snake;

    public SnakeActions(final Snake snake){
        this.snake = snake;
    }

    public void eatCell(SnakeCell cell) throws EatingSnakeBodyException{
        if(this.snake.getSnakeBody().contains(cell)){
            throw new EatingSnakeBodyException(cell);
        }
        this.snake.getSnakeBody().add(cell);
    }

    public void move(Position pos){
        Position newPos = pos;
        Position currentCellPos;

        // Move each SnakeCell along the path
        for(int a = snake.getSnakeBody().size() -1; a > -1; a--){
            currentCellPos = snake.getSnakeBody().get(a).getPosition();
            snake.getSnakeBody().get(a).setPosition(newPos);
            newPos = currentCellPos;
        }
    }

    private boolean isOutOfBounds(Position pos){
        return pos.x - 1 < 0 || pos.x + 1 > this.snake.getParentWidth() || pos.y  - 1 < 0 || pos.y + 1 > this.snake.getParentHeight();
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(ListenerNames.ITEM_ADDED.toString())){
            Item item = (Item)evt.getNewValue();
            if(!item.isDone()){
                Position position = this.snake.getCurrentPosition();
                if(!isOutOfBounds(position)){
                    if(item.getTask().getTaskOriginator() == MoveSnakeUp.class){
                        position.y += 1;
                        move(position);
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeDown.class){
                        position.y -= 1;
                        move(position);
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeRight.class){
                        position.x += 1;
                        move(position);
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeLeft.class){
                        position.x -= 1;
                        move(position);
                    }
                    System.out.println(item.getTask().showTaskDescription());
                }
            }
        }
    }
}
