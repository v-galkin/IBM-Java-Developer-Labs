// Student class to store and manage student information
public class Student {
    // Step 1: Declare private variables for studentId, name, grade, and isActive
    // Hint: Use appropriate data types (String, String, double, boolean)
    private String id;
    private String name;
    private double grade;
    private boolean isActive;
    
    // Step 2: Create getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public boolean isActive() {
        return this.isActive;
    }
    
    // Step 3: Create setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add simple validation:
    // - For grade: Ensure it is between 0 and 100
    // - For studentId: No special validation needed
    // - For name: No special validation needed
    // - For isActive: No special validation needed
    public void setId(String id) {
        this.id = id;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void isActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    // Step 4: Create a method to display student details
    // Hint: Use System.out.println() to print all student information
    // Format should include ID, name, grade, and status (Active/Inactive)
    public void displayInfo() {
        System.out.println("Student ID: " + this.id);
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Grade: " + this.grade);
        System.out.println("Student active status: " + isActive);
    }
    
    
    // Step 5: Create a method that returns a letter grade based on the numeric grade
    // Hint: A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public String getLetterGrade() {
        if (this.grade >= 90) {
            return "A";
        } else if (this.grade >= 80 && this.grade <= 89) {
            return "B";
        } else if(this.grade >= 70 && this.grade <= 79) {
            return "C";
        } else if (this.grade >= 60 && this.grade <= 69){
            return "D";
        } else {
            return "F";
        }
    }
    
    // Step 6: Create a method to check if the student is passing (grade >= 60)
    // Hint: Return a boolean value
    public boolean isPassing() {
        if (this.grade >= 60) {
            return true;
        } else {
            return false;
        }
    }
}
