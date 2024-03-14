import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ToDoList {
    private List<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (!tasks.isEmpty()) {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else {
            System.out.println("No tasks yet!");
        }
    }

    public void completeTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.set(taskIndex - 1, tasks.get(taskIndex - 1) + " (Completed)");
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            tasks.remove(taskIndex - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 1 && index <= tasks.size();
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                    break;
                case 2:
                    todoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    todoList.completeTask(completeIndex);
                    break;
                case 4:
                    System.out.print("Enter the index of the task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    todoList.deleteTask(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
