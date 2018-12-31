package Assignment1.Bed;

import TodoList.Task;

import java.awt.*;

public interface Bed extends Task {

    /**
     * Returns the bed's colour
     * */
    Color getColour();

    /**
     * Returns the length
     * of the bed
     * */
    int getLength();

    /**
     * Returns the comfort
     * level of the bed
     * */
    int getComfort();

    /**
     * Returns the bed's
     * type:
     * SOFT,
     * MEDIUM, and
     * HARD,
     */
    String getType();

}
