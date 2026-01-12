import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ZonedDateTimePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ZonedDateTime currentDateTime = ZonedDateTime.now();

        System.out.println("Current Date and Time Format is:");
        System.out.println(currentDateTime);

        System.out.println("--------------------------------------------------");
        System.out.println("Enter the format you would like to print the time in\n" +
                            "dd for day, \n"+
                            "M for month, MM for zero-padded month, MMM for abreviated month, MMMM for full name, \n" +
                            "yy or yyyy for year\n" +
                            "H for Hour of day (0-23), HH for Zero-padded hour of day (00-23), \n" +
                            "h for Hour of am/pm (1-12), hh for Zero-padded hour of am/pm (01-12) \n" +
                            "m for Minute of hour (0-59)\n" +
                            "mm for Zero-padded minute of hour (00-59)\n" +
                            "s for Second of minute (0-59), ss for Zero-padded second of minute (00-59)\n" +
                            "z for Time zone (for example, PDT, EST), zzz: Time zone (for example, Pacific Daylight Time, Eastern Standard Time)" +
                            "Z for Time zone offset (for example, +0800, -0500)");
        
        String strDateTimeFormat = scanner.nextLine();
        
        DateTimeFormatter newDateTimeformat = DateTimeFormatter.ofPattern(strDateTimeFormat);
        
        System.out.println("The date and time is " + currentDateTime.format(newDateTimeformat));
    }
}