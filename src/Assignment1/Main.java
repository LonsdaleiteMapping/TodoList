package Assignment1;

import Assignment1.Bed.Bed;
import Assignment1.Bed.MakeBed;
import TodoList.TodoList;
import TodoList.Item;
import TodoList.Task;

public class Main {

    private static void print(Object c){
        System.out.println(c);
    }

    public static void main(String[] args){
        TodoList list = new TodoList();
        list.addItem(new ThatItem(new MakeBed()));
        for (Item item : list.getItems()){
            if (item.getTask() instanceof Bed) print(item.getTask().toString());
        }
    }

    private static class ThatItem implements Item {

        private Task task;

        private boolean done;

        public ThatItem(Task task){
            this.task = task;
        }

        @Override
        public Task getTask() {
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

}
