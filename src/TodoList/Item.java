package TodoList;

public interface Item {

    Task getTask();
    boolean isDone();
    void setDone(boolean val);

}
