package TodoList;

public abstract class Item {
    private Task task;
    public boolean done;

    public Item(Task task){
        this.task = task;
        this.done = false;
    }

    public Task getTask(){
        return this.task;
    }

    public abstract boolean isDone();

    public abstract void setDone(boolean val);

}
