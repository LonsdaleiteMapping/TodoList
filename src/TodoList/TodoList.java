package TodoList;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class TodoList  {

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
        return this.items.stream().filter( item ->
                (finish && item.isDone()) ||
                        (!finish && !item.isDone())).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Item> getFinishedItems(){
        return this.getItems(true);
    }

    public ArrayList<Item> getUnfinishedItems(){
        return this.getItems(false);
    }

    public Item getItem(int index){
        return this.items.get(index);
    }

    public Item getItem(Item item){
        return this.getItem(this.items.indexOf(item));
    }

    public ArrayList<Item> getItems(){
        return (ArrayList<Item>)this.items.clone();
    }

    public int getSize(){
        return items.size();
    }

}
