import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to read.");

        Path filePath = Paths.get(scanner.nextLine());

        try {
            String fileContent = Files.readString(filePath);

            System.out.println(fileContent);
        } catch (IOException ioException) {
            System.err.println("Error reading the file: " + ioException.getMessage());
        }
    }
}