import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimePrinterVer2 {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                            "Enter the format you would like to print the date in\n" +
                            "dd for day,\n" +
                            "M for month, MM for zero-padded month, MMM for abbreviated month, MMMM for full name,\n" +
                            "yy or yyyy for year." 
        );

        String dateFormatString = scanner.nextLine();

        DateTimeFormatter newDateFormat = DateTimeFormatter.ofPattern(dateFormatString);

        System.out.println("The date is " + currentDate.format(newDateFormat));

        LocalTime currentTime = LocalTime.now();

         System.out.println("\n\nEnter the format you would like to print the time in\n" +
                "H for Hour of day (0-23), HH for Zero-padded hour of day (00-23), \n" +
                "h for Hour of am/pm (1-12), hh for Zero-padded hour of am/pm (01-12) \n" +
                "m for Minute of hour (0-59)\n" +
                "mm for Zero-padded minute of hour (00-59)\n" +
                "s for Second of minute (0-59), ss for Zero-padded second of minute (00-59)");

        String timeFormatString = scanner.nextLine();

        DateTimeFormatter newTimeFormat = DateTimeFormatter.ofPattern(timeFormatString);

        System.out.println("The time is " + currentTime.format(newTimeFormat));

         
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        System.out.println(currentDateTime);
        
        System.out.println("\n\nEnter the format you would like to print the date and time in\n");
        
        String dateTimeFormatString = scanner.nextLine();
        
        DateTimeFormatter newDateTimeformat = DateTimeFormatter.ofPattern(dateTimeFormatString);
        
        System.out.println("The date and time is " + currentDateTime.format(newDateTimeformat));
    }
}