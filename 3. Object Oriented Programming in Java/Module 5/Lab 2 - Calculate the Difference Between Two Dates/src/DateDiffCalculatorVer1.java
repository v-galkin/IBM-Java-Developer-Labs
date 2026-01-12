import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;

public class DateDiffCalculatorVer1 {

    public static String getDatesDifference(LocalDate dateOne, LocalDate dateTwo) {
        Period period = dateOne.until(dateTwo);

        String differenceMessage = "The difference is ";

        if(period.getYears() > 0) {
            differenceMessage = differenceMessage + period.getYears() + " years, ";
        }

        if(period.getMonths() != 0) {
            differenceMessage = differenceMessage + period.getMonths() + " months, ";
        }

        if(period.getDays() != 0) {
            differenceMessage = differenceMessage + period.getDays() + " day(s).";
        }

        return differenceMessage;
    }
    public static void main(String[] args) {
        LocalDate todayDate = LocalDate.now();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("The date is " + todayDate.format(dateFormat));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please privde date in 'DD/MM/YYYY' format");

        String rawDate = scanner.nextLine();

        try {
            LocalDate givenDate = LocalDate.parse(rawDate, dateFormat);

            System.out.println("Given date is: " + givenDate.format(dateFormat));

            if(givenDate.isEqual(todayDate)) {
                System.out.println(
                                    "'" + 
                                    givenDate + 
                                    "' and '" + 
                                    todayDate + 
                                    "' are the same."
                                );
            } else {
                if(givenDate.isBefore(todayDate)) {
                    System.out.println(getDatesDifference(givenDate, todayDate));
                } else {
                    System.out.println(getDatesDifference(todayDate, givenDate));
                }
            }
        } catch (DateTimeParseException dtpe) {
            System.out.println("Error: " + dtpe.getMessage());
        }

        scanner.close();
    }
}