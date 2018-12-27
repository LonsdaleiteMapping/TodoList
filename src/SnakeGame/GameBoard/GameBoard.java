package SnakeGame.GameBoard;

import SnakeGame.EventSystem.EventHandler;
import SnakeGame.GameBoard.Snake.Snake;
import SnakeGame.Tasks.Snake.MoveSnakeDown;
import SnakeGame.Tasks.Snake.MoveSnakeLeft;
import SnakeGame.Tasks.Snake.MoveSnakeRight;
import SnakeGame.Tasks.Snake.MoveSnakeUp;
import SnakeGame.enums.ListenerNames;
import SnakeGame.utility.Position;
import TodoList.Item;
import TodoList.Task;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;


public class GameBoard extends JPanel implements PropertyChangeListener {

    public GameBoard(int parentHeight, int parentWidth,int rows,int cols){

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Random Starting location for the Snake
        int x = new Random().nextInt(cols);
        int y = new Random().nextInt(rows);

        Snake snake = new Snake(new Position(x,y),parentWidth,parentHeight);

        for(int row = 0; row < rows; row++){
            for(int col =0; col < cols; col++){
                gbc.gridx = col;
                gbc.gridy = row;

                Position cellPosition = new Position(col,row);

                GameCell cellPane = new GameCell(parentHeight,parentWidth,col,row,snake.getCurrentPosition().equals(cellPosition));

                Border border = null;
                if(row < rows - 1){
                    if(col < cols -1){
                        border = new MatteBorder(1,1,0,0, Color.GRAY);
                    }else{
                        border = new MatteBorder(1,1,0,1, Color.GRAY);
                    }
                }else{
                    if(col < cols -1){
                        border = new MatteBorder(1,1,1,0, Color.GRAY);
                    }else{
                        border = new MatteBorder(1,1,1,1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                add(cellPane,gbc);
            }
        }

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            /**
             * Invoked when a key has been pressed.
             *
             * @param e
             */
            @Override
            public void keyPressed(KeyEvent e) {
                int location = e.getKeyCode();
                switch(location){
                    case KeyEvent.VK_UP:
                        print("Up");
                        EventHandler.getInstance().addItem(new GenericTest(new MoveSnakeUp()));
                        break;
                    case KeyEvent.VK_DOWN:
                        print("Down");
                        EventHandler.getInstance().addItem(new GenericTest(new MoveSnakeDown()));
                        break;
                    case KeyEvent.VK_LEFT:
                        print("Left");
                        EventHandler.getInstance().addItem(new GenericTest(new MoveSnakeLeft()));
                        break;
                    case KeyEvent.VK_RIGHT:
                        print("Right");
                        EventHandler.getInstance().addItem(new GenericTest(new MoveSnakeRight()));
                        break;
                }
            }

            /**
             * Invoked when a key has been released.
             * See the class description for {@link KeyEvent} for a definition of
             * a key released event.
             *
             * @param e the event to be processed
             */
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setFocusable(true);
        this.requestFocusInWindow();

        EventHandler.getInstance().trackAddItem(this);
        EventHandler.getInstance().trackAddItem(snake.getSnakeAction());

    }

    static void print(String str){
        System.out.println(str);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Variation of " + evt.getPropertyName());
        System.out.println("\t(" + evt.getOldValue() +
                " -> " + evt.getNewValue() + ")");
        System.out.println("Property in object " + evt.getSource());

        if(evt.getPropertyName().equals(ListenerNames.ITEM_ADDED)){

        }
    }

    private class GenericTest implements Item{

        private Task task;
        private boolean done;

        public GenericTest(Task task){
            this.task = task;
            this.done = false;
        }

        @Override
        public TodoList.Task getTask() {
            return this.task;
        }

        @Override
        public boolean isDone() {
            return this.done;
        }

        @Override
        public void setDone(boolean val) {
            this.done = val;
        }
    }

    private class GenericTask implements TodoList.Task{

        @Override
        public String showTaskDescription() {
            return "Description check";
        }

        @Override
        public Class getTaskOriginator() {
            return this.getClass();
        }
    }
}