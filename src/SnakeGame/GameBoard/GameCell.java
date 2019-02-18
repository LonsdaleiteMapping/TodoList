package SnakeGame.GameBoard;

import SnakeGame.GameBoard.Snake.Snake;
import SnakeGame.Enums.ListenerNames;
import SnakeGame.Utility.Position;
import TodoList.Item;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameCell extends JPanel implements PropertyChangeListener {

    private Color defaultBackground;
    private Position position;
    private final Snake snake;



    public GameCell(Position position, Snake snake){
        this.position = position;
        this.snake = snake;

        this.defaultBackground = this.getBackground();

        if(isApartOfSnake()){
            setBackground(Color.RED);
        }
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(50,50);
    }


    public boolean isApartOfSnake(){
        return this.snake.isApartOfSnake(this.position);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(ListenerNames.ITEM_SET_DONE.toString())) {
            Item item = (Item) evt.getNewValue();
            if (item.isDone()) {
                if (this.snake.isApartOfSnake(this.position)) {
                    setBackground(Color.RED);
                }else{
                    setBackground(this.defaultBackground);
                }
            }
        }
    }
}
