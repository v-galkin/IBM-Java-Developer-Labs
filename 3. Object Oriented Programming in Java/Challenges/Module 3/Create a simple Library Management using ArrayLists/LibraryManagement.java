import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// LibraryManagement class to manage the book collection
public class LibraryManagement {
    public static void main(String[] args) {

        // Step 1: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Step 2: Create an ArrayList to store Book objects
        // Hint: Use ArrayList<Book>
        ArrayList<Book> library = new ArrayList<>();

        // Sample books for tests
        library.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.add(new Book("1984", "George Orwell", 1949));

        boolean exit = false;

        // Step 3: Implement a menu-driven program with the following options:
        // 1. Add a book
        // 2. View all books
        // 3. Search for a book by title
        // 4. Check out a book
        // 5. Return a book
        // 6. Sort books (by title, author, or publication year)
        // 7. View available books only
        // 8. Exit

        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break
        while(!exit) {

            System.out.println(
                "----------- Library Management. Main Menu. ------------\n" +
                "Press '1' to add a new book.\n" +
                "Press '2' to view all books.\n" +
                "Press '3' to search by the title.\n" +
                "Press '4' to check out a book.\n" +
                "Press '5' to return a book.\n" +
                "Press '6' to sort books.\n" +
                "Press '7' to view only available books.\n" +
                "Press '0' to exit"
            );

            String userAction = scanner.nextLine();

            // Step 5: Implement case handling for each menu option
            // Hint: Use switch-case or if-else if statements
            if(userAction.equals("1")) {
                addBook(scanner, library);
            }

            else if (userAction.equals("2")){
                viewBooks(library);
            }

            else if (userAction.equals("3")) {
                searchBook(scanner, library);
            }

            else if (userAction.equals("4")) {
                checkOut(scanner, library);
            }

            else if (userAction.equals("5")) {
                returnBook(scanner, library);
            }

            else if (userAction.equals("6")) {
                sortBooks(scanner, library);
            }

            else if (userAction.equals("7")) {
                viewAvailableBooks(library);
            }

            else if (userAction.equals("0")) {
                System.out.println("\n ------------ Exiting the application ------------\n");
                exit = true;
            }

            else {
                System.out.println("\nInvalid input. Please chooce from the menu options.\n");
            }
        }
    }

    // Step 6: Implement the addBook functionality
    // Hint: Prompt the user for title, author, and publication year
    public static void addBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n ------------ Add a new book ------------\n");
        
        System.out.println("Enter book's name.");
        String name = scanner.nextLine();

        System.out.println("Enter book's author.");
        String author = scanner.nextLine();

        int publicationYear = 0;
        boolean validYear = false;

        while(!validYear){
            System.out.println("Enter book's publication year");
            try {
                publicationYear = Integer.parseInt(scanner.nextLine());
                validYear = true;
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid year. Please enter a number.");
            }
        }

        library.add(new Book(name, author, publicationYear));
        System.out.println("New book was added to the library");
    }

    // Step 7: Implement the viewAllBooks functionality
    // Hint: Use a loop or forEach to display all books
    public static void viewBooks(ArrayList<Book> library) {
        System.out.println("\n ------------ View all books ------------\n");
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            System.out.println(
                "Book index: " + i + "\n" +
                book
            );
        }
    }

    // Step 8: Implement the search functionality
    // Hint: Take user input for search term and check each book
    public static void searchBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n ------------ Search a book by the title ------------\n");

        System.out.println("Enter the name of the book.");
        String title = scanner.nextLine();
        boolean found = false;
        int bookIndex = 0;

        for (Book book : library) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(
                    "\n ------------ Information about the book '" +  title + "' is below ------------ \n" +
                    "Book index: " + bookIndex + "\n" +
                    book
                );
                found = true;
            }
            bookIndex++;
        }

        if (!found) {
            System.out.println("No book with title: " + title);
        }
    }

    // Step 9: Implement the checkOut functionality
    // Hint: Find the book by index and use the checkOut() method
    public static void checkOut(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n ------------ Check out a book ------------\n");

        int bookIndex = getValidBookId(scanner, library.size(), "check out");

        Book book = library.get(bookIndex);

        if(book.checkOut()) {
            System.out.println("You checked out:\n" + book);
        } else {
            System.out.println(
                "\nBook with index " +  bookIndex + " is already checked out.\n" +
                "Please enter another index.\n"
            );
        }
    }

    // Step 10: Implement the returnBook functionality
    // Hint: Find the book by index and use the returnBook() method
    public static void returnBook(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n ------------ Return a book ------------\n");

        int bookIndex = getValidBookId(scanner, library.size(), "return");

        Book book = library.get(bookIndex);

        if (book.returnBook()) {
            System.out.println("You returned:\n" + book);
        } else {
            System.out.println(
                "\nBook with index " +  bookIndex + " is already available.\n" +
                "Please enter another index.\n"
            );
        }
    }
    
    // Step 11: Implement the sortBooks functionality
    // Hint: Use Collections.sort() with a Comparator
    public static void sortBooks(Scanner scanner, ArrayList<Book> library) {
        System.out.println("\n ------------ View sorted books ------------\n");

        while(true) {
            try {
                System.out.println(
                    "Press '1' to sort books by title.\n" +
                    "Press '2' to sort books by author.\n" +
                    "Press '3' to sort books by publication year."
                );

                int sortBy = Integer.parseInt(scanner.nextLine());

                if (sortBy < 1 || sortBy > 3) {
                    System.out.println("\nInvalid index. Please enter a number between 0 and 3.");
                    continue; 
                } else {
                    if (sortBy == 1) {
                        Collections.sort(library, new Comparator<Book>() {
                           @Override
                           public int compare(Book bookOne, Book bookTwo) {
                                return bookOne.getTitle().compareToIgnoreCase(bookTwo.getTitle());
                           }
                        });
                    } 
                    
                    else if (sortBy == 2){
                        Collections.sort(library, new Comparator<Book>(){
                            @Override
                            public int compare(Book bookOne, Book bookTwo) {
                                return bookOne.getAuthor().compareToIgnoreCase(bookTwo.getAuthor());
                            }
                        });
                    }

                    else {
                        Collections.sort(library, new Comparator<Book>() {
                            @Override 
                            public int compare(Book bookOne, Book bookTwo) {
                                return Integer.compare(bookOne.getPublicationYear(), bookTwo.getPublicationYear());
                            }
                        });
                    }

                    System.out.println("\n ------------ Sort books: ------------ \n");
                    for (int i = 0; i < library.size(); i++) {
                        System.out.println(
                            "Book index: " + i + "\n" + 
                            library.get(i));
                    }

                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    // Step 12: Implement the viewAvailableBooks functionality
    // Hint: Use ArrayList's stream() or loop through to filter
    public static void viewAvailableBooks(ArrayList<Book> library) {
        System.out.println("\n ------------ View only available books ------------\n");
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if(book.isAvailable()) {
                System.out.println(
                    "Book index: " + i + "\n" +
                    book
                );
            }
        }
    }


    public static int getValidBookId(Scanner scanner, int librarySize, String action) {
        while(true) {
            System.out.println("Enter the index of the book to " + action + ":");

            try {
                int bookIndex = Integer.parseInt(scanner.nextLine());

                if (bookIndex < 0 || bookIndex >= librarySize) {
                    System.out.println("\nInvalid index. Please enter a number between 0 and " + librarySize + "\n");
                    continue; 
                } else {
                    return bookIndex;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
