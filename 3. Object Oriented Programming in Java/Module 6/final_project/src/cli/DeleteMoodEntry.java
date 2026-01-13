package cli;
import model.Mood;
import util.MoodTrackerUtils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeleteMoodEntry {
    Scanner scanner;

    public DeleteMoodEntry(Scanner scanner) {
        this.scanner = scanner;
    }

    public void deleteMood(ArrayList<Mood> moods)  {
        try {
            while(true) {
                System.out.println("----------- Delete Mood Entry -----------");

                System.out.println(
                                    "Press '1' to delete mood entries by date.\n" +
                                    " - Please note all mood entries with the same date will be deleted.\n" +
                                    "Press '2' to delete mood by name, date, and time.\n" +
                                    "Press '0' to exit."
                                );

                String userAction = this.scanner.nextLine();

                switch (userAction) {
                    case "1":
                        deleteMoodsByDate(moods);
                        System.out.println("Returning to 'Main Menu'");
                        return;
                
                    case "2":
                        deleteMoodByFullDetails(moods);
                        return;
                    
                    case "0":
                        System.out.println("Returning to 'Main Menu'");
                        return;

                    default:
                        System.out.println("Invalid input. Please choice from the menu.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }  
    }

    private void deleteMoodsByDate(ArrayList<Mood> moods) {
        LocalDate date = MoodTrackerUtils.getDate(scanner);

        Iterator<Mood> iterator = moods.iterator();

        boolean anyDeleted = false;
        while(iterator.hasNext()) {
            Mood mood = iterator.next();

            if(mood.getDate().equals(date)){
                iterator.remove();
                anyDeleted = true;
            }
        }

        if(anyDeleted) {
            System.out.println("Deleted all moods with date " + date + " from the list.");
        } else {
            System.out.println("No moods with date " + date + " were found.");
        }
    }

    private void deleteMoodByFullDetails(ArrayList<Mood> moods) {
        String name = MoodTrackerUtils.getName(scanner);
        LocalDate date = MoodTrackerUtils.getDate(scanner);
        LocalTime time = MoodTrackerUtils.getTime(scanner);

        //Mood moodToDelete = null;

        /* 
        for (Mood mood : moods) {
            if (mood.getName().equalsIgnoreCase(name) &&
                mood.getDate().equals(date) &&
                mood.getTime().equals(time)
            ) {
                moodToDelete = mood;
                break;
            }
        }
        */

        Mood moodToDelete = MoodTrackerUtils.searchMoodEntry(moods, name, date, time);

        if (moodToDelete != null) {
            moods.remove(moodToDelete);
            System.out.println();
            System.out.println("Mood '" + moodToDelete.getName() + "' was deleted successfully.");
        } else {
            System.out.println("No mood with provided details.");
        }
    }
}