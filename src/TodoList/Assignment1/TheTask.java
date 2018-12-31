package TodoList.Assignment1;

import TodoList.Task;

public class TheTask implements Task {

    private String desc;
    private Class origin;

    public TheTask(Class origin, String desc){
        this.origin = origin;
        this.desc = desc;
    }

    public Class getTaskOriginator(){
        return this.origin;
    }

    public String showTaskDescription(){
        return this.desc;
    }

    public String toString(){
        return this.showTaskDescription();
    }

}
