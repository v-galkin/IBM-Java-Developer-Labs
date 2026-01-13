package cli;

import model.Mood;
import util.MoodTrackerUtils;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;

public class EditMoodEntry {
    private Scanner scanner;

    public EditMoodEntry(Scanner scanner) {
        this.scanner = scanner;
    }

    public void editMoodNotes(ArrayList<Mood> moods) {
        System.out.println("----------- Edit Mood -----------");
        String name = MoodTrackerUtils.getName(this.scanner);
        LocalDate date = MoodTrackerUtils.getDate(this.scanner);
        LocalTime time = MoodTrackerUtils.getTime(this.scanner);

        Mood tempMood = MoodTrackerUtils.searchMoodEntry(moods, name, date, time);
        
        if(tempMood != null) {
            String notes = MoodTrackerUtils.getNotes(this.scanner);

            tempMood.setNotes(notes);

            System.out.println(
                                "Updated notes for mood entry:\n" +
                                tempMood
            );
        }
    }
}