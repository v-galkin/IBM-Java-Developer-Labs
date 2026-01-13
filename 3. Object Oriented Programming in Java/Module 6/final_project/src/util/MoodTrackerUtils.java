package util;
import model.Mood;



import java.util.Scanner;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MoodTrackerUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static String getName(Scanner scanner) {
        String name;

        while (true) {
            System.out.println("Enter a name:");

            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty. Try again.");
        }
    }

    public static LocalDate getDate(Scanner scanner) {
        while (true) {
            System.out.println("Enter a date (YYYY-MM-DD):");
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }
    }

    public static LocalTime getTime(Scanner scanner) {
        while (true) {
            System.out.println("Enter time (HH:mm):");
            String input = scanner.nextLine().trim();
            try {
                return LocalTime.parse(input, TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Try again.");
            }
        }
    }

    public static String getNotes(Scanner scanner) {
        System.out.println("Enter notes (optional):");
        
        return scanner.nextLine().trim();
    }

    public static Mood searchMoodEntry(ArrayList<Mood> moods, String name, LocalDate date, LocalTime time) {
        for (Mood mood : moods) {
            if (mood.getName().equalsIgnoreCase(name)
                    && mood.getDate().equals(date)
                    && mood.getTime().equals(time)) {
                return mood;
            }
        }
        return null;
    }
}
