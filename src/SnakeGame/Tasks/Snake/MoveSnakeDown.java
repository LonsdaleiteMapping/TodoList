package SnakeGame.Tasks.Snake;

import TodoList.Task;

public class MoveSnakeDown implements Task {

    @Override
    public String showTaskDescription() {
        return "Move Snake Down";
    }

    @Override
    public Class getTaskOriginator() {
        return this.getClass();
    }
}
