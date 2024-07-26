public class Driver {

    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        Task firstTask = new Task(1);
        Task secondTask = new Task(2);
        Task thirdTask = new Task(3);
        Task fourthTask = new Task(4);
        Task fifthTask = new Task(5);
        Task sixthTask = new Task(6);
        Task sevenTask = new Task(7);

        taskExecutor.addTask(firstTask);
        taskExecutor.addTask(secondTask);
        taskExecutor.addTask(thirdTask);
        taskExecutor.addTask(fourthTask);
        taskExecutor.addTask(fifthTask);
        taskExecutor.addTask(sixthTask);
        taskExecutor.addTask(sevenTask);

        // 1 -> 7
        // 2 -> 6
        // 3 -> 1, 2
        // 4
        // 5
        // 6
        // 7


        // 2 1 2 1 0 0 0

        // 7 1 6 2 3 4 5
        taskExecutor.addDependency(thirdTask, firstTask);
        taskExecutor.addDependency(thirdTask, secondTask);
        taskExecutor.addDependency(firstTask, sevenTask);
        taskExecutor.addDependency(secondTask, sixthTask);

        taskExecutor.executeWorkflow();


    }
}
///*
//Hey
//
//PFA the problem statement.
//
//You are required to implement a thread-safe in-memory task workflow orchestration system.
//The system should be capable of handling complex workflows where tasks depend on the completion of other tasks.
// Each task can be executed asynchronously, and the system should manage the dependencies and ensure that each task is
// executed only after all its dependencies have been completed. The system must support the following operations efficiently:
//Add Task: Add a task to the workflow.
//Add Dependency: Add a dependency between tasks.
//Execute Workflow: Execute the entire workflow, ensuring all dependencies are respected.
//Shutdown: Gracefully shutdown the system, ensuring all tasks are completed before termination.
//Example
//taskSystem.addTask(task1);
//taskSystem.addTask(task2);
//taskSystem.addTask(task3);
//
//taskSystem.addDependency(task3.id, task2.id);
//taskSystem.addDependency(task3.id, task1.id);
//
//taskSystem.executeWorkflow();
//
//taskSystem.addTask(task4);
//taskSystem.addDependency(task4.id, task3.id);
//taskSystem.executeWorkflow();
//
//// Output:
//task1.execute()
//task2.execute()
//task3.execute()
//
//OR
//
//task2.execute()
//task1.execute()
//task3.execute()
//
//taskSystem.shutdown();
//Milestone 1:
//Task can be run sequentially
//Milestone 2:
//Non dependent tasks should run parallel to each other in multi-threaded environment
//Milestone 3:
//Tasks can have retries defined.
//task.execute() {
//// some logic to fail task given number of times
//}
//
//Regards
//Lokesh
//
// */


/*

List<task> tasks

graph<task> tasksGraph

addTask(newTask) {
    tasks.add(newTask)
}

addDependency(t1, t2) {
   graph.add(t1, t2)
}

map<Task, List<Task> //

t1
t2
t3 -> (t2, t1)


t1 -> t2, t3
t2 -> t4
t3
t4
t5 -> t4

  0   0   1   1   2
(t4, t3, t2, t5, t1)

executeWorkflow() {
    list<Task> orderedTasks = getDependencyList //  (t1, t2, t3)

}

shutDown()


 */
