// StudentRegistry class to test the Student class
public class StudentRegistry {

    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student studentOne = new Student();
        Student studentTwo = new Student();
        
        
        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        studentOne.setId("S001");
        studentOne.setName("John Doe");
        studentOne.setGrade(85.5);
        studentOne.isActive(true);
        
        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        studentTwo.setId("S002");
        studentTwo.setName("John Smith");
        studentTwo.setGrade(92.0);
        studentTwo.isActive(true);
        
        // Step 4: Display details of both students
        System.out.println("Student One Information:");
        studentOne.displayInfo();
        System.out.println("\n");
        System.out.println("Student Two Infomration:");
        studentTwo.displayInfo();
        System.out.println("\n");
        
    
        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        double highestGrade = compareGrades(studentOne.getGrade(), studentTwo.getGrade());
        System.out.println("Highest grade is: " + highestGrade);
        System.out.println("\n");
        
        // Step 6: Test the letter grade method for both students
        System.out.println("Student One grade is: " + studentOne.getGrade() + ". Student One Letter Grade is: " + studentOne.getLetterGrade());
        System.out.println("Student Two grade is: " + studentTwo.getGrade() + ". Student Two Letter Grade is: " + studentTwo.getLetterGrade());
        System.out.println("\n");

        // Step 7: Test the passing status method for both students
        System.out.println("Is Student One Passing: " + studentOne.isPassing());
        System.out.println("Is Student Two Passing: " + studentTwo.isPassing());
        System.out.println("\n");

        // Step 8: Change one student to inactive and display the updated information
        studentTwo.isActive(false);

        System.out.println("Student Two Infomration:");
        studentTwo.displayInfo();

    }
    
    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
    public static double compareGrades(double gradeOne, double gradeTwo) {
        if (gradeOne > gradeTwo) {
            return gradeOne;
        } else {
            return gradeTwo;
        }
     }
}
