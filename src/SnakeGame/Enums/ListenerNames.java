package SnakeGame.Enums;

public enum ListenerNames {
    ITEM_ADDED ("ITEM_ADDED"),
    ITEM_SET_DONE ("ITEM_SET_DONE");

    private final String name;

    ListenerNames(String s){
        this.name = s;
    }

    public boolean equals(String ot){
        return this.name.equals(ot);
    }

    public String toString(){
        return this.name;
    }
}
