package TodoList.Assignment1;

import TodoList.TodoList;

public class Main {

    public static void main(String[] args){
        TodoList list = new TodoList();
        new Adder().addTaskToList(list, "A task description.");
    }

}
