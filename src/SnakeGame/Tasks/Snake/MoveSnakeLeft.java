package SnakeGame.Tasks.Snake;

import TodoList.Task;

public class MoveSnakeLeft implements Task {

    @Override
    public String showTaskDescription() {
        return "Move Snake Left";
    }

    @Override
    public Class getTaskOriginator() {
        return this.getClass();
    }
}
