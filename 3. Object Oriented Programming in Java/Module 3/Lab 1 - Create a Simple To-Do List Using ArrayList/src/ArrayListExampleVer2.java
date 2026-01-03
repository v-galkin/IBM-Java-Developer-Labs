import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExampleVer2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            ArrayList<Task> todoList = new ArrayList<Task>();

            while(true) {
                System.out.println(
                "Press '1' to add a new task.\n" +
                "Press '2' to view all the tasks.\n" +
                "Press '3' to change status of tasks.\n" +
                "Press '4' to delete a task.\n" +
                "Press '5' to sort tasks based on priority.\n" +
                "Press '0' to exit"
                );

                String userAction = scanner.nextLine();

                if(userAction.equals("1")) {
                    System.out.println("Enter a task.");
                    String taskName = scanner.nextLine();

                    System.out.println("Enter priority: 1 - Low, 2 - Medium, 3 - High.");
                    int priority = Integer.parseInt(scanner.nextLine());

                    priority = priority > 3 ? 1 : priority;

                    todoList.add(new Task(taskName, priority));
                    System.out.println("The task has been added to the list");
                } 
                
                else if (userAction.equals("2")) {
                    todoList.forEach(task -> System.out.println(task));
                } 
                
                else if (userAction.equals("3")) {
                    System.out.println("Enter index of the status you want to change");
                    int taskIndex = Integer.parseInt(scanner.nextLine());

                    if(taskIndex > (todoList.size() - 1)) {
                        System.out.println("The task with index " + taskIndex + " does not exist");
                    } else {
                        System.out.println(
                            "Press 'p' to change status to 'In Progress'.\n" +
                            "Press 'c' to change status to 'Completed'."
                        );
                        String updatedStatus = scanner.nextLine();

                        if (updatedStatus.equalsIgnoreCase("p")){
                            todoList.get(taskIndex).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("c")) {
                            todoList.get(taskIndex).setStatus(Task.COMPLETED);
                        }
                    }
                    System.out.println("The task has been changed in the list.");
                } 
                
                else if (userAction.equals("4")) {
                    System.out.println("Enter index of the task you want to delete");
                    int taskIndex = Integer.parseInt(scanner.nextLine());

                    if(taskIndex > (todoList.size() - 1)) {
                        System.out.println("The task with index " + taskIndex + " does not exist");
                    } else {
                        todoList.remove(taskIndex);
                        System.out.println("The task has been deleted from the list.");
                    }   
                }

                else if(userAction.equals("5")) {
                    Collections.sort(todoList, new Comparator<Task>() {
                        @Override
                        public int compare(Task t1, Task t2) {
                            return Integer.compare(t2.getPriority(), t1.getPriority());
                        }
                    });
                    System.out.println("Tasks sorted by priority from High to Low.");
                    todoList.forEach(task -> System.out.println(task));
                }

                else {
                    System.out.println("Exiting the application");
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}