import java.util.Scanner;

// ShapeDemo class to demonstrate polymorphism with Shapes
public class ShapeDemo {
    public static void main(String[] args) {
        // Step 1: Create an array of Shape objects with size 5
        // Hint: Shape[] shapes = new Shape[5];
        Shape[] shapes = new Shape[5];
        
        // Step 2: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        int shapesNum = 0;
        
        boolean exit = false;
        
        // Step 3: Create an interactive menu to add shapes to the array
        // Hint: Use a loop and a counter to keep track of how many shapes are added
        // The menu should allow users to:
        // 1. Add a Circle
        // 2. Add a Rectangle
        // 3. Add a Triangle
        // 4. Display all shapes
        // 5. Exit

        while(!exit) {
            System.out.println(
                "-------- Shapes Menu --------\n" +
                "Press '1' to add a new Circle.\n" +
                "Press '2' to add a new Rectangle.\n" +
                "Press '3' to add a new Triangle.\n" +
                "Press '4' to display all shapes.\n" +
                "Press '0' to exit.\n"
                );

            int userAction = scanner.nextInt();
            scanner.nextLine();

            if (userAction == 0) {
                System.out.println("Exiting the application.");
                exit = true;
            } 

            if (userAction >= 1 && userAction <= 3 && shapesNum >= shapes.length) {
                System.out.println("Shapes list is full. Cannot add another shape.");
                continue;
            }

            if (userAction == 1) {
                System.out.println("Please enter circle's name.");
                String circleName = scanner.nextLine();

                System.out.println("Please enter circle's color.");
                String circleColor = scanner.nextLine();

                System.out.println("Please enter circle's radius.");
                double circleRadius = scanner.nextDouble();
                scanner.nextLine();

                shapes[shapesNum] = new Circle(circleName, circleColor, circleRadius);
                System.out.println("Added: " + shapes[shapesNum]);
                shapesNum++;
            } else if (userAction == 2) {
                System.out.println("Please enter rectangle's name.");
                String rectName = scanner.nextLine();

                System.out.println("Please enter rectangle's color.");
                String rectColor = scanner.nextLine();

                System.out.println("Please enter rectangle's length.");
                double rectLength = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Please enter rectangle's width.");
                double rectWidth = scanner.nextDouble();
                scanner.nextLine();

                shapes[shapesNum] = new Rectangle(rectName, rectColor, rectLength, rectWidth);
                System.out.println("Added: " + shapes[shapesNum]);
                shapesNum++;
            } else if (userAction == 3) {
                System.out.println("Please enter triangle's name.");
                String rectName = scanner.nextLine();

                System.out.println("Please enter triangle's color.");
                String rectColor = scanner.nextLine();

                System.out.println("Please enter triangle's first side.");
                double tiangleSideOne = scanner.nextDouble();
                scanner.nextLine();
                
                System.out.println("Please enter triangle's second side.");
                double tiangleSideTwo = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Please enter triangle's third side.");
                double tiangleSideThree = scanner.nextDouble();
                scanner.nextLine();

                shapes[shapesNum] = new Triangle(rectName, 
                                                 rectColor, 
                                                 tiangleSideOne, 
                                                 tiangleSideTwo, 
                                                 tiangleSideThree
                                                );
                System.out.println("Added: " + shapes[shapesNum]);
                shapesNum++;
            } else if (userAction == 4) {
                System.out.println("-------- All Shapes --------");
                
                for(int i = 0; i < shapesNum; i++) {
                        System.out.println(shapes[i]);
                        System.out.println("-----------------");
                }
            } else {
                System.out.println("Invalid option.");
            } 
        }
        scanner.close();
    }
}