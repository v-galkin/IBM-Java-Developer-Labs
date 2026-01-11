import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class DirectoryExplorerVer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(" --------------- Main Menu --------------- ");
            System.out.println(
                "Press '1' to open 'File Manager'.\n" +
                "Press '0' to exit."
            );

            String userAction = scanner.nextLine();

            if(userAction.equals("1")){
                System.out.println("Enter the name of the file or directory with full path.");

                String fileName = scanner.nextLine();

                File file = new File(fileName);

                if (file.exists()) {
                    if (file.isFile()) {
                        System.out.println("You entered path to the file");
                    } else {
                        System.out.println("You entered path to the directory.");
                    }
                } else {
                    boolean createNew = true;
                    while(createNew) {
                        System.out.println(
                            "You entered path to the file or directory that does not exists.\n" +
                            "Press '1' if you want to create a file at the giving path.\n" +
                            "Press '2' if you want to create a new directory at the giving path.\n" +
                            "Press '0' go back to the main menu."
                        );

                        String createChoice = scanner.nextLine();

                        if(createChoice.equals("1")){
                            String parentDirPath = file.getParent();
                            File parentDir = new File(parentDirPath);

                            if (!parentDir.exists()) {
                                boolean created = parentDir.mkdirs();
                                if(!created) {
                                    System.out.println("The parent directory could not be created.");
                                    continue;
                                }
                            }

                            try {
                                file.createNewFile();
                                System.out.println("File successfully created.");
                            } catch (IOException ioe) {
                                System.out.println("Coult not create file. " + ioe.getMessage());
                            }

                            createNew = false;
                        }

                        else if (createChoice.equals("2")){
                            boolean created = file.mkdirs();
                            if (created) {
                                System.out.println("The directory has been created");
                            } else {
                                System.out.println("The directory couldn't be created");
                            }

                            createNew = false;
                        } 

                        else if (createChoice.equals("0")) {
                            createNew = false;
                        }

                        else {
                            System.out.println("Invalid input. Please enter a number from the menu.");
                        }
                    }
                }
            }

            else if(userAction.equals("0")){
                System.out.println("Closing the application.");
                break;
            }
            else {
                System.out.println("Invalid input. Please enter a number from the main menu.");
            }
        }
        scanner.close();
    }
}