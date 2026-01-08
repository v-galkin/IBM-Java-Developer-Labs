import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PhoneBookHashMapVer2 {
    private static boolean isNameValid(String name) {
        if(name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name.");
            return false;
        }

        return true;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            HashMap<String, String> phoneBook = new HashMap<>();
            
            while(true) {
                System.out.println(
                    " ------------ Phone Book Management System ------------\n" +
                    "Press '1' to add a new entry to the phonebook.\n" +
                    "Press '2' to view all entries in the phonebook.\n" +
                    "Press '3' to seach for an entry in the phonebook by name.\n" +
                    "Press '4' to delete an entry from the phonebook.\n" +
                    "Press '5' to sort entries by names.\n" +
                    "Press '6' to save enties to a file.\n" +
                    "Press '0' to exit."
                );

                String userAction = scanner.nextLine();

                if(userAction.equals("1")) {
                    System.out.println(" ------------ Add a new antry to the phonebook ------------");
                    System.out.println("Enter a name.");
                    String name = scanner.nextLine();

                    if(!isNameValid(name)){
                        continue;
                    }

                    if(phoneBook.containsKey(name)) {
                        System.out.println("This name already exists. Do you want to replace the number y/n?");
                        String replyChoice = scanner.nextLine();

                        if(replyChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Enter the phone number.");
                    String phoneNumber = scanner.nextLine();

                    if(!isPhoneNumberValid(phoneNumber)) {
                        System.out.println("Invalid phone number.");
                        continue;
                    }

                    phoneBook.put(name, phoneNumber);
                    System.out.println("New entry has been added to the phone book.");

                }

                else if (userAction.equals("2")) {
                    System.out.println(" ------------ View all entries in the phonebook ------------");
                    for(String name : phoneBook.keySet()) {
                        System.out.println(name + " - " + phoneBook.get(name));
                    }
                }

                else if (userAction.equals("3")) {
                    System.out.println(" ------------ Search entry by name in the phonebook ------------");
                    System.out.println("Enter the name you are search infomration for..");

                    String name = scanner.nextLine();

                    if(!isNameValid(name)){
                        continue;
                    }

                    if(phoneBook.containsKey(name)) {
                        System.out.println(name + " phone number is: " + phoneBook.get(name));
                    } else {
                        System.out.println("No information for " + name + " in the phonebook.");
                    }
                }

                else if (userAction.equals("4")) {
                    System.out.println(" ------------ Delete entry from the phonebook ------------");
                    System.out.println("Enter the name you want to delete.");
                    String name = scanner.nextLine();

                    if(!isNameValid(name)) {
                        continue;
                    }

                    if(phoneBook.containsKey(name)) {
                        phoneBook.remove(name);
                    } else {
                        System.out.println("No such name found in the book.");
                    }
                }

                else if(userAction.equals("5")) {
                    System.out.println(" ------------ Sort entries by name ------------");
                    TreeMap phoneBookTreeMap = new TreeMap<String, String>(phoneBook);

                    for (Object name : phoneBookTreeMap.keySet()) {
                        System.out.println(name + ": " + phoneBookTreeMap.get((String)name));
                    }
                }

                else if (userAction.equals("6")) {
                    System.out.println(" ------------ Save entries to a file ------------");
                    try (PrintWriter writer = new PrintWriter(new FileWriter("phonebook.txt"))) {
                        for (String name : phoneBook.keySet()) {
                            writer.println(name + ": " + phoneBook.get(name));
                        }
                        System.out.println("The entries are written to a file");
                    }catch (IOException ioe) {
                        System.err.println("Error writing to file: " + ioe.getMessage());
                    }
                }

                else {
                    System.out.println("Exiting the application.");
                    break;
                }
            }
            
            scanner.close();

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}