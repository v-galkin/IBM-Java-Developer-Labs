import java.io.File;
import java.util.Scanner;

public class DirectoryExplorerVer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of file or directory with full path.");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if(file.exists()) {
            if(file.isFile()) {
                System.out.println("---------------------------------");
                System.out.println(fileName + "\n");
                System.out.println("Is a file.");
                System.out.println("---------------------------------");
                
            } else {
                System.out.println("---------------------------------");
                System.out.println(fileName + "\n");
                System.out.println("Is a directory.");
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println(fileName + " is not a valid file or directory.");
        }
    }
}