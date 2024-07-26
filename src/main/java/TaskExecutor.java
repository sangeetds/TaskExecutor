
import java.util.*;

public class TaskExecutor {

    private final Map<Integer, Task> tasks;
    private final Map<Integer, List<Task>> dependencyGraph;

    public TaskExecutor() {
        this.tasks = new HashMap<>();
        dependencyGraph = new HashMap<>();
    }

    public void addTask(Task task) {
        if (tasks.containsKey(task.getId())) return;

        task.setTaskStatus(TaskStatus.ASSIGNED);
        tasks.put(task.getId(), task);
    }

    public void addDependency(Task dependentTask, Task task) {
        if (!this.tasks.containsKey(dependentTask.getId()) ||
                !this.tasks.containsKey(task.getId())) return;

        if (!dependencyGraph.containsKey(dependentTask.getId())) {
            dependencyGraph.put(dependentTask.getId(), new ArrayList<>());
        }

        dependencyGraph.get(dependentTask.getId()).add(task);
    }

    public void executeWorkflow() {
        List<TaskNode> orderTaskList = getDependencyList();

        System.out.println(orderTaskList);
        orderTaskList.sort(Comparator.comparingInt(TaskNode::getLevel));

        for (TaskNode taskNode: orderTaskList) {
            if (taskNode.getTask().getTaskStatus().equals(TaskStatus.COMPLETED)) continue;

            taskNode.getTask().setTaskStatus(TaskStatus.IN_PROGRESS);
            taskNode.getTask().run();
            taskNode.getTask().setTaskStatus(TaskStatus.COMPLETED);
        }
    }

    private List<TaskNode> getDependencyList() {
        Set<Integer> visited = new HashSet<>();
        List<TaskNode> dependencyList = new ArrayList<>();

        for (Task task : this.tasks.values()) {
            if (visited.contains(task.getId())) continue;
            int level = 0;
            createListWithBFS(visited, task, dependencyList, level);
        }

        return dependencyList;
    }

    private void createListWithBFS(Set<Integer> visited, Task task, List<TaskNode> dependencyList, int level) {
        if (visited.contains(task.getId())) return;

        visited.add(task.getId());

        if (this.dependencyGraph.containsKey(task.getId())) {
            for (Task dependentTask: this.dependencyGraph.get(task.getId())) {
                createListWithBFS(visited, dependentTask, dependencyList, level + 1);
            }
        }

        dependencyList.add(new TaskNode(level, task));
    }
}
