import java.util.Scanner;

public class ExceptionTrial {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArray = new String[5];

        int stringIndex = 0;

        while (true) {
            System.out.println(
                "Press '1' to add a new string.\n" +
                "Press '2' to get a string from a particular address.\n" +
                "Press '3' to get the length of a string in any address.\n" +
                "Press '4' to get all the strings in the array.\n" +
                "Press any other keys to exit."
            );

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                if (stringIndex == 5) {
                    System.out.println("There are already 5 strings in the array!");
                } else {
                    System.out.println("Enter the String:");
                    String userStringInput = scanner.nextLine();
                    stringArray[stringIndex++] = userStringInput;
                }
            } else if (userAction.equals("2")) {
                try{
                    System.out.println("Enter index you want to retrieve:");
                    int userIndexinput = Integer.parseInt(scanner.nextLine());

                    System.out.println(stringArray[userIndexinput]);
                } catch (NumberFormatException error) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                } catch (ArrayIndexOutOfBoundsException error) {
                    System.out.println("Invalid index! Please enter an index between 0 and " + (stringArray.length - 1));
                }

            } else if (userAction.equals("3")) {
                try {
                    System.out.println("Enter index you check the length of:");
                    int userIndexInput = Integer.parseInt(scanner.nextLine());

                    System.out.println(stringArray[userIndexInput].length());
                } catch (NumberFormatException error) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                } catch (ArrayIndexOutOfBoundsException error) {
                    System.out.println("Invalid index! Please enter an index between 0 and " + (stringArray.length - 1));
                } catch (NullPointerException error) {
                    System.out.println("No string exists at the specified index!");
                }

            } else if (userAction.equals("4")) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(stringArray[i]);
                }
            } else {
                break;
            }
        }
    }
}