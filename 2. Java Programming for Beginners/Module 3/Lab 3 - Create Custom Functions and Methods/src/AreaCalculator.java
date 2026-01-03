import java.util.Scanner;

public class AreaCalculator {
    private static float pi = 3.142f;

    // Add the methods to calculate area here

    private static float calculateCircleArea(float radius) {
        return (pi * radius * radius);
    }

    private static float calcualteSquareArea(float length) {
        return (length * length);
    }

    private static float calcualteRectangleArea(float length, float breath) {
        return (length * breath);
    }

    private static float calculateSphereVolume(float radius) {
        float volume = (4.0f / 3.0f) * pi * (radius * radius * radius);
        return volume;
    }

    private static float calculateCubeVolume(float sideLength) {
        return (sideLength * sideLength * sideLength);
    }

    private static float calculateCuboidVolume(float length, float width, float height) {
        return length * width * height;
    }

    public static void main(String s[]) {
        System.out.println("Welcome to the area calculator!");

        while(true) {
            System.out.println("\nEnter '1' to calculate area of the circle.\n" +
                                "Enter '2' to calculate area of the square.\n" +
                                "Enter '3' to calculate area of the rectangle.\n" +
                                "Enter '4' to calculate volume of the sphere.\n" +
                                "Enter '5' to calculate volume of the cube.\n" +
                                "Enter '6' to calcualte volume of the cuboid.\n" +
                                "Enter '0' to close calculator."
            );

            Scanner scanner = new Scanner(System.in);

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.println("Please enter the radius of the circle: ");
                float inputRadius = Float.parseFloat(scanner.nextLine());
                float circleArea = calculateCircleArea(inputRadius);
                System.out.println("The area of circle of radius " + inputRadius + " is " + circleArea);
            } else if (choice == 2) {
                System.out.println("Please enter the length of the square: ");
                float inputLength = Float.parseFloat(scanner.nextLine());
                float squareArea = calcualteSquareArea(inputLength);
                System.out.println("The area of square of side length " + inputLength + " is " + squareArea);
            } else if (choice == 3) {
                System.out.println("Please enter the length of the rectangle: ");
                float inputLength = Float.parseFloat(scanner.nextLine());
                System.out.println("Please enter the breath of the rectange: ");
                float inputBreath = Float.parseFloat(scanner.nextLine());
                float rectangleArea = calcualteRectangleArea(inputLength, inputBreath);
                System.out.println("The area of rectangle of length " + inputLength +
                                    " and breath " + inputBreath + " is " + rectangleArea
                );
            } else if (choice == 4) {
                System.out.println("Please enter the radius of the sphere: ");
                float inputRadius = Float.parseFloat(scanner.nextLine());
                float sphereVolume = calculateSphereVolume(inputRadius);
                System.out.println("The volume of the sphere of radius " + inputRadius + " is " + sphereVolume);
            } else if (choice == 5) {
                System.out.println("Please enter the length of the cube side: ");
                float inputCubeSideLength = Float.parseFloat(scanner.nextLine());
                float cubeVolume = calculateCubeVolume(inputCubeSideLength);
                System.out.println("The volume of the cube of side: " + inputCubeSideLength + " is " + cubeVolume);
            } else if (choice == 6) {
                System.out.println("Please enter the length of the cuboid: ");
                float inputLength = Float.parseFloat(scanner.nextLine());
                System.out.println("Please enter the width of the cuboid");
                float inputWidth = Float.parseFloat(scanner.nextLine());
                System.out.println("Please enter the height of the cuboid");
                float inputHeight = Float.parseFloat(scanner.nextLine());

                float cuboidVolume = calculateCuboidVolume(inputLength, inputWidth, inputHeight);

                System.out.println("The volume of cuboid of length " + inputLength +
                                    " and width " + inputWidth + " and height " + inputHeight + " is " + cuboidVolume
                );
            } else if (choice == 0) {
                System.out.println("Exiting. Thanks for using our calulator!");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}