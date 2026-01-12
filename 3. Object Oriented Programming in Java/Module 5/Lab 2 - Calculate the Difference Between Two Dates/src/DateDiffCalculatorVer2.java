import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;

public class DateDiffCalculatorVer2 {

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the format in which you want to feed the dates in:");

        String dateFormatInput = scanner.nextLine();
        
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern(dateFormatInput);

        try {
            System.out.println("Please provide date in " + dateFormatInput + " format.");

            String rawDateOne = scanner.nextLine();

            LocalDate givenDateOne = LocalDate.parse(rawDateOne, dateformat);

            System.out.println("Please provide another date in " + dateFormatInput + " format.");

            String rawDateTwo = scanner.nextLine();

            LocalDate givenDateTwo = LocalDate.parse(rawDateTwo, dateformat);

            System.out.println("The first given date is: " + givenDateOne.format(dateformat));
            System.out.println("The second given date is: " + givenDateTwo.format(dateformat));

            if(givenDateOne.isEqual(givenDateTwo)) {
                System.out.println(
                                    "'" + 
                                    givenDateOne + 
                                    "' and '" + 
                                    givenDateTwo + 
                                    "' are the same."
                                );
            } else {
                if(givenDateOne.isBefore(givenDateTwo)) {
                    System.out.println(getDatesDifference(givenDateOne, givenDateTwo));
                } else {
                    System.out.println(getDatesDifference(givenDateTwo, givenDateOne));
                }
            }
        } catch (DateTimeParseException dtpe) {
            System.out.println("Error: " + dtpe.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }

        scanner.close();
    }
}