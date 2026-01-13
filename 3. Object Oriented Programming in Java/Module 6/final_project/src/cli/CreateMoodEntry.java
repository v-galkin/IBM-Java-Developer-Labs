package cli;
import model.Mood;
import util.MoodTrackerUtils;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateMoodEntry {
    private Scanner scanner;

    public CreateMoodEntry(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addNewMoodEntry(ArrayList<Mood> moods) {
        Mood newMood = createMood();
        
        boolean newMoodAlreadyExist = false;

        for (Mood mood : moods) {
            if(mood.equals(newMood)) {
                newMoodAlreadyExist = true;
                break;
            }
        }

        if (newMoodAlreadyExist) {
            System.out.println("\n----------- This mood entry already exists. \n");
        } else {
            moods.add(newMood);
            System.out.println("\n----------- Mood entry added successfully. -----------");
            System.out.println(newMood + "\n");
        }
    }

    private Mood createMood() {
            System.out.println("----------- Add Mood -----------");
            
            String name = MoodTrackerUtils.getName(this.scanner);

            LocalDate date;
            LocalTime time;

            while(true) {
                System.out.println("Are you creating the new mood entry for the current day? y/n");
                String isForCurrentDate = this.scanner.nextLine();

                if(isForCurrentDate.equalsIgnoreCase("y")){
                    date = LocalDate.now();
                    time = LocalTime.now().withSecond(0).withNano(0);
                    break;
                }

                else if (isForCurrentDate.equalsIgnoreCase("n")) {
                    date = MoodTrackerUtils.getDate(this.scanner);
                    time = MoodTrackerUtils.getTime(this.scanner);
                    break;
                }

                else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            };

            String notes = MoodTrackerUtils.getNotes(this.scanner);

            return new Mood(name, date, time, notes);
        }
}