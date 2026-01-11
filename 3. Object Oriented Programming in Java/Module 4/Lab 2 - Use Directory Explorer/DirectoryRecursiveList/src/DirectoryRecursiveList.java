import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class DirectoryRecursiveList {
    public static void directoryList(File directoryPath) {
        System.out.println("Printing " + directoryPath + " recursively.");

        File files[] = directoryPath.listFiles();

        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()) {
                System.out.println(files[i].getAbsolutePath());
            } else {
                directoryList(files[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(
                                "Press '1' to recursively list a directory.\n" + 
                                "Press '0' to exit."
                            );
            
            String userAction = scanner.nextLine();

            if(userAction.equals("1")){
                System.out.println("Please enter a full path to the directory.");

                String dirPath = scanner.nextLine();

                File directory = new File(dirPath);

                if(directory.exists() && directory.isDirectory()) {
                    directoryList(directory);
                } else {
                    System.out.println(directory + " is not a valid directory");
                    continue;
                }
            }
            else if(userAction.equals("0")) {
                System.out.println("CLosing the application.");
                break;
            }
            else {
                System.out.println("Invalid imput. Please enter a number from the list in the main menu.");
            }

        }
     

    }
}