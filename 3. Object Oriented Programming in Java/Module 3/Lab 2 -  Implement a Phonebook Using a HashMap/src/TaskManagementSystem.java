import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;;

public class TaskManagementSystem {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            HashMap<String, Task> tasks = new HashMap<>();

            while(true) {
                System.out.println(
                    " ------------ Tasks Management System ------------\n" +
                    "Press '1' to add a new task.\n" +
                    "Press '2' to view all tasks.\n" +
                    "Press '3' to seach for a task by name.\n" +
                    "Press '4' to delete a task.\n" +
                    "Press '5' to sort tasks by names.\n" +
                    "Press '6' to save tasks to a file.\n" +
                    "Press '0' to exit."
                );

                String userAction = scanner.nextLine();

                if(userAction.equals("1")) {
                    System.out.println("\n ------------ Add a new task ------------\n");

                    System.out.println("Enter a new task name");
                    String taskName = scanner.nextLine();

                    System.out.println("\nEnter a description for the task.");
                    String taskDescription = scanner.nextLine();

                    System.out.println("\nEnter a priority for the task: 1 - Low, 2 - Medium, 3 - High.");
                    int priorityInput = Integer.parseInt(scanner.nextLine());

                    // Priority Enum is located in Task.java file
                    Priority priority;

                    switch (priorityInput) {
                        case 2:
                            priority = Priority.MEDIUM;
                            break;
                        case 3:
                            priority = Priority.HIGH;
                        default:
                            priority = Priority.LOW;
                            break;
                    }

                    tasks.put(taskName, new Task(taskName, taskDescription, priority));
                    System.out.println("\nNew task has been created.\n");
                }

                else if (userAction.equals("2")) {
                    System.out.println("\n ------------ View all tasks ------------\n");
                    for (String taskName : tasks.keySet()) {
                        System.out.println(tasks.get(taskName));
                    }
                }

                else if (userAction.equals("3")) {
                    System.out.println("\n ------------ Search task by the name ------------ \n");
                    System.out.println("Enter the name of the task.");
                    String taskName = scanner.nextLine();

                    if (tasks.containsKey(taskName)) {
                        System.out.println("\nInformation for task " + "'" + taskName + "'" + " is below:\n");
                        System.out.println("Description: " + tasks.get(taskName).getDescription());
                        System.out.println("Priority: " + tasks.get(taskName).getPriority());
                        System.out.println("Status: " + tasks.get(taskName).getStatus() + "\n");
                    } else {
                        System.out.println("\nNo task with such name.\n");
                    }
                }

                else if (userAction.equals("4")) {
                    System.out.println("\n ------------ Delete task by the name ------------ \n");
                    System.out.println("Enter the name of the task you want to delete.");
                    String taskToDelete = scanner.nextLine();

                    if (tasks.containsKey(taskToDelete)) {
                        tasks.remove(taskToDelete);
                        System.out.println("Task '" + taskToDelete + "' has been deleted.");
                    } else {
                        System.out.println("\nNo task with such name.\n");
                    }
                }

                else if (userAction.equals("5")){
                    System.out.println(" ------------ Sort tasks by name ------------");
                    TreeMap tasksTreeMap = new TreeMap<String, Task>(tasks);

                    for (Object taskName : tasksTreeMap.keySet()) {
                        System.out.println(tasksTreeMap.get((String)taskName));
                    }
                }

                else if (userAction.equals("6")) {
                    System.out.println(" ------------ Save tasks to a file ------------");

                    try (PrintWriter writer = new PrintWriter(new FileWriter("All Tasks.txt"))) {
                        for (String name : tasks.keySet()) {
                            writer.println(tasks.get(name));
                        }
                        System.out.println("The tasks are saved to a file");
                    }
                    
                    catch (IOException ioe) {
                        System.err.println("Error writing to file: " + ioe.getMessage());
                    }
                }

                else {
                    System.out.println("Exiting the application.");
                    break;
                }
            }

            scanner.close();

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }

    }
}