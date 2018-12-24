package TodoList;

import java.util.ArrayList;

public class TodoList {

    private ArrayList<Item> items;

    public TodoList(){
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void setItemDone(int index){
        this.items.get(index).setDone(true);
    }

    private ArrayList<Item> getItems(boolean finish){
        ArrayList<Item> l = new ArrayList<Item>();
        for (int i = 0; i < this.items.size(); i++)
            if (finish && this.items.get(i).isDone())
                l.add(this.items.get(i));
            else if (!finish && !this.items.get(i).isDone())
                l.add(this.items.get(i));
        return l;
    }

    public ArrayList<Item> getFinishedItems(){
        return this.getItems(true);
    }

    public ArrayList<Item> getUnfinishedItems(){
        return this.getItems(false);
    }

    public Item getItemFromIndex(int index){
        return this.items.get(index);
    }

    public ArrayList<Item> getItems(){
        return (ArrayList<Item>)this.items.clone();
    }


}
