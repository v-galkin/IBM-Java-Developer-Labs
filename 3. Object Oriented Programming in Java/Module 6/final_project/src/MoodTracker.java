import java.util.Scanner;
import java.util.ArrayList;

import cli.CreateMoodEntry;
import cli.DeleteMoodEntry;
import cli.EditMoodEntry;
import cli.SaveMoodEntries;
import cli.SearchMoodEntry;
//import cli.SearchMoodEntry;
import model.Mood;

public class MoodTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mood> moods = new ArrayList<>();

        CreateMoodEntry moodEntryHandler = new CreateMoodEntry(scanner);
        DeleteMoodEntry deleteHandler = new DeleteMoodEntry(scanner);
        SearchMoodEntry searchHandler = new SearchMoodEntry(scanner);
        EditMoodEntry editHandler = new EditMoodEntry(scanner);
        SaveMoodEntries saveHanlder = new SaveMoodEntries(scanner);

        try {
            boolean isAppRunning = true;
            
            while (isAppRunning) {
                System.out.println("----------- Mood Tracker -----------");
                System.out.println(
                        "1 - Add a new mood\n" +
                        "2 - Delete a mood\n" +
                        "3 - Edit a mood\n" +
                        "4 - Search for a mood\n" +
                        "5 - Show all moods\n" +
                        "6 - Save moods to a file\n" +
                        "0 - Exit"
                );

                String userAction = scanner.nextLine();

                System.out.println("\n");

                switch(userAction) {
                    case "1":
                        moodEntryHandler.addNewMoodEntry(moods);
                        break;

                    case "2":
                        deleteHandler.deleteMood(moods);
                        break;

                    case "3":
                        editHandler.editMoodNotes(moods);
                        break;

                    case "4":
                        searchHandler.seachMoodEntries(moods);
                        break;

                    case "5":
                        showAllMoods(moods);
                        break;

                    case "6":
                        saveHanlder.saveMoodEntriesToAFile(moods);
                        break;

                    case "0":
                        System.out.println("----------- Exit -----------");
                        System.out.println("Closing the application.\n");
                        isAppRunning = false;
                        break;

                    default:
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Invalid choice. Please select a number from the menu.");
                        System.out.println("-----------------------------------------------------\n");
                        break;
                }
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showAllMoods(ArrayList<Mood> moods) {
        System.out.println("----------- Show all moods -----------");
        for (Mood mood : moods) {
            System.out.println(mood + "\n");
        }
    }
}