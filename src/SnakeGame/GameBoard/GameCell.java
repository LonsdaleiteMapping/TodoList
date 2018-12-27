package SnakeGame.GameBoard;

import SnakeGame.utility.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCell extends JPanel {

    private Color defaultBackground;

    private int parentHeight;
    private int parentWdith;
    private Position position;
    private boolean apartOfSnake;



    public GameCell(int parentHeight, int parentWidth,int x, int y, boolean apartOfSnake){
        this.parentHeight = parentHeight;
        this.parentWdith = parentWidth;
        this.position = new Position(x,y);
        this.apartOfSnake = apartOfSnake;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                defaultBackground = getBackground();
                setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBackground);
            }
        });

        if(this.apartOfSnake){
            setBackground(Color.RED);
        }
    }



    @Override
    public Dimension getPreferredSize(){
        return new Dimension(50,50);
    }

    public Position getCurrentPosition(){
        return this.position;
    }

    public Boolean isApartOfSnake(){
        return this.apartOfSnake;
    }
}
