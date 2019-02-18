package SnakeGame.GameBoard.Snake;

import SnakeGame.EventSystem.EventHandler;
import SnakeGame.Tasks.Snake.MoveSnakeDown;
import SnakeGame.Tasks.Snake.MoveSnakeLeft;
import SnakeGame.Tasks.Snake.MoveSnakeRight;
import SnakeGame.Tasks.Snake.MoveSnakeUp;
import SnakeGame.Enums.ListenerNames;
import SnakeGame.Utility.Position;
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

    /**
     * Task:
     * Find a way to keep the snake movements within the bounds of the cells
     * - Keep wrap around
     * - this class gets instance of snake
     * @param pos
     */
    public void move(Position pos){
        Position newPos = pos;
        Position currentCellPos;

        // Move each SnakeCell along the path
        for(int a = snake.getSnakeBody().size() -1; a > -1; a--){
            currentCellPos = snake.getSnakeBody().get(a).getPosition();
            snake.getSnakeBody().get(a).setPosition(
                    new Position(!this.isOutOfXBounds(newPos) ? newPos.x :
                            (newPos.x < 0 ? this.snake.getColAmount() - 1 : 0),
                            !this.isOutOfYBounds(newPos) ? newPos.y :
                                    (newPos.y < 0 ? this.snake.getRowAmount() - 1 : 0)));
            newPos = currentCellPos;
        }
    }

    private boolean isOutOfYBounds(Position pos){
        return pos.y < 0 || pos.y + 1 > this.snake.getRowAmount();
    }

    private boolean isOutOfXBounds(Position pos){
        return pos.x < 0 || pos.x + 1 > this.snake.getColAmount();
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
                    System.out.println(item.getTask().showTaskDescription());
                    if(item.getTask().getTaskOriginator() == MoveSnakeUp.class ){
                        position.y -= 1;
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeDown.class){
                        position.y += 1;
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeRight.class){
                        position.x += 1;
                    }else if(item.getTask().getTaskOriginator() == MoveSnakeLeft.class){
                        position.x -= 1;
                    }
                    move(position);
                    EventHandler.getInstance().setItemDone(item);
            }
        }
    }
}
