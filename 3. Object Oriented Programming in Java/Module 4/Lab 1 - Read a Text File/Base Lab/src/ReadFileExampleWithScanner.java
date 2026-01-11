import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter the name of the file you want to open.");
            String fileName = scanner.nextLine();

            Scanner fileReader = new Scanner(new FileReader(fileName));

            while (fileReader.hasNext()) {
                String fileLine = fileReader.nextLine();

                System.out.println(fileLine);
            }
            scanner.close();
            fileReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Error reading the file: " + exception.getMessage());
        }
    }
}