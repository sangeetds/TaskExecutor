
public class TaskNode {

    private final int level;
    private Task task;

    public TaskNode(int level, Task task) {
        this.level = level;
        this.task = task;
    }

    public int getLevel() {
        return level;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return task.getId() + " " + getLevel();
    }
}
