package SnakeGame;

import SnakeGame.EventSystem.EventHandler;
import SnakeGame.GameBoard.GameBoard;

import javax.swing.*;
import java.awt.*;

public class SnakeGame {
    public static void main (String [] args){
        /*
            Create Window for Game Board
            Create Window for Score
            Create Window that displays history
         */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EventHandler.getInstance();

                JFrame frame = new JFrame("Snake Game");
                frame.setLayout(new BorderLayout());
                frame.add(new GameBoard(600,600,8,8));
                frame.setSize(600,600);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });

    }


}
