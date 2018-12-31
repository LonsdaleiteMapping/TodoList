package Assignment1.Bed;

import java.awt.*;

public class MakeBed implements Bed {

    @Override
    public Color getColour() {
        return null;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public int getComfort() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String showTaskDescription() {
        return null;
    }

    @Override
    public Class getTaskOriginator() {
        return null;
    }

    @Override
    public String toString(){
        return this.showTaskDescription();
    }

}
