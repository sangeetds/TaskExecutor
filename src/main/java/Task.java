
public class Task implements Runnable {

    private final int id;
    private TaskStatus taskStatus;

    public Task(int id, TaskStatus taskStatus) {
        this.id = id;
        this.taskStatus = taskStatus;
    }

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hello world " + getId());
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }
}
