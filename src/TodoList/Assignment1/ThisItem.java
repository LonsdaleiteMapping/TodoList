package TodoList.Assignment1;

import TodoList.Item;
import TodoList.Task;

public class ThisItem implements Item {

    private boolean done;

    private Task task;

    public ThisItem(Task task){
        this.task = task;
    }

    public boolean isDone(){
        return this.done;
    }

    public void setDone(boolean f){
        this.done = f;
    }

    public Task getTask(){
        return this.task;
    }

}
