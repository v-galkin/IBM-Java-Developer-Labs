import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManagementSystem {
    public static void main(String[] args) {
        try {
            ArrayList<Student> students = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);

            while(true) {
                System.out.println(
                    "--------- Student Management System Menu ---------\n" +
                    "Press '1' to add a new student.\n" +
                    "Press '2' to view all students.\n" +
                    "Press '3' to update a student details.\n" +
                    "Press '4' to delete a student.\n" +
                    "Press '5' to sort students by age.\n" +
                    "Press '0' to exit."
                );

                String userAction = scanner.nextLine();

                if(userAction.equals("1")) {
                    System.out.println("--------- Create a new student ---------");
                    System.out.println("Enter student's name.");
                    String studentName = scanner.nextLine();

                    System.out.println("Enter student's age.");
                    int studentAge = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter student's major");
                    String studentMajor = scanner.nextLine();

                    students.add(new Student(studentName, studentAge, studentMajor));
                }

                else if (userAction.equals("2")) {
                    System.out.println("--------- View all students ---------");
                    students.forEach(student -> System.out.println(student));
                }

                else if(userAction.equals("3")) {
                    System.out.println("--------- Update a student details ---------");
                    System.out.println("Enter the index of the student to update.");
                    int studentIndex = Integer.parseInt(scanner.nextLine());

                    if(studentIndex >= 0 && studentIndex < students.size()) {
                        System.out.println("Enter student's name.");
                        String studentName = scanner.nextLine();

                        System.out.println("Enter student's age.");
                        int studentAge = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter student's major");
                        String studentMajor = scanner.nextLine();

                        students.get(studentIndex).setName(studentName);
                        students.get(studentIndex).setAge(studentAge);
                        students.get(studentIndex).setMajor(studentMajor);
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Invalid index. No student found at the specified index.");
                    }
                }

                else if(userAction.equals("4")) {
                    System.out.println("--------- Delete a student ---------");
                    System.out.println("Enter the index of the student to delete.");
                    int studentIndex = Integer.parseInt(scanner.nextLine());

                    if(studentIndex >= 0 && studentIndex < students.size()) {
                        students.remove(studentIndex);
                        System.out.println("The student has been deleted from the list.");
                    } else {
                        System.out.println("Invalid index. No student found at the specified index.");
                    }
                }

                else if (userAction.equals("5")) {
                    System.out.println("--------- Sort students by age ---------");
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student studentOne, Student studentTwo) {
                            return Integer.compare(studentTwo.getAge(), studentOne.getAge());
                        }
                    });
                }

                else {
                    System.out.println("Exiting the application");
                    break;
                }
            }
            scanner.close();
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}