package SnakeGame.Tasks.Snake;

import TodoList.Task;

public class MoveSnakeRight implements Task {

    @Override
    public String showTaskDescription() {
        return "Move Snake Right";
    }

    @Override
    public Class getTaskOriginator() {
        return this.getClass();
    }
}
