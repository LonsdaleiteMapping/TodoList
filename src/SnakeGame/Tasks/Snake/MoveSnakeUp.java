package SnakeGame.Tasks.Snake;

import TodoList.Task;

public class MoveSnakeUp implements Task {

    @Override
    public String showTaskDescription() {
        return "Move Snake Up";
    }

    @Override
    public Class getTaskOriginator() {
        return this.getClass();
    }
}
