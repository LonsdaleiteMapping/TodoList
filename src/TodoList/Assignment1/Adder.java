package TodoList.Assignment1;

import TodoList.TodoList;

public class Adder {

    public void addTaskToList(TodoList list, String desc){
        list.addItem(new ThisItem(new TheTask(this.getClass(), desc)));
    }

}
