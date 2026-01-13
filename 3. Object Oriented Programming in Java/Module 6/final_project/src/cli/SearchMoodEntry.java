package cli;

import model.Mood;
import util.MoodTrackerUtils;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;

public class SearchMoodEntry {
    private Scanner scanner;

    public SearchMoodEntry(Scanner scanner) {
        this.scanner = scanner;
    }

    public void seachMoodEntries(ArrayList<Mood> moods) {
        try {
            while(true) {
                System.out.println("----------- Search Mood Entries -----------");
                System.out.println(
                                    "Press '1' to seach mood entries by date.\n" +
                                    "Press '2' to search mood entry by 'Name', 'Date', and 'Time'.\n" +
                                    "Press '3' to show all saved mood entries.\n" +
                                    "Press '0' to return to the main menu."
                );

                String userAction = this.scanner.nextLine();

                switch (userAction) {
                    case "1":
                        searchEntriesByDate(moods);
                        return;
                    
                    case "2":
                        searchMoodEntry(moods);
                        return;

                    case "3":
                        showAllMoods(moods);
                        return;

                    case "0":
                        return;

                    default:
                        System.out.println("Invalid input. Please chooce from the menu options.");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        

    }

    private void searchEntriesByDate(ArrayList<Mood> moods) {
        System.out.println("----------- Show moods by date -----------");
        LocalDate date = MoodTrackerUtils.getDate(this.scanner);

        for (Mood mood : moods) {
            if(mood.getDate().equals(date)){
                System.out.println(mood);
            }
        }
    }

    private void searchMoodEntry(ArrayList<Mood> moods) {
        System.out.println("----------- Show mood by Name, Date, Time -----------");
        String name = MoodTrackerUtils.getName(this.scanner);
        LocalDate date = MoodTrackerUtils.getDate(this.scanner);
        LocalTime time = MoodTrackerUtils.getTime(this.scanner);

        Mood tempMood = MoodTrackerUtils.searchMoodEntry(moods, name, date, time);

        if(tempMood != null) {
            System.out.println(tempMood);
        }
    }

    private void showAllMoods(ArrayList<Mood> moods) {
        System.out.println("----------- Show all moods -----------");
        for (Mood mood : moods) {
            System.out.println(mood + "\n");
        }
    }
}