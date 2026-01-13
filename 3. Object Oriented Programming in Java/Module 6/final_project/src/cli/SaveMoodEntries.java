package cli;

import model.Mood;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveMoodEntries {
    private Scanner scanner;

    public SaveMoodEntries(Scanner scanner) {
        this.scanner = scanner;
    }

    public void saveMoodEntriesToAFile(ArrayList<Mood> moods) {
        System.out.println("----------- Save mood entries to a file -----------");
        System.out.print("Enter file name: ");

        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("File name cannot be empty.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Mood mood : moods) {
                writer.write(mood.toString());
                writer.newLine();
            }
            System.out.println("All mood entries saved to the file:" + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
