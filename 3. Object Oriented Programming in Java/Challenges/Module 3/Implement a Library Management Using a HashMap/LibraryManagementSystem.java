import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.time.Year;

public class LibraryManagementSystem {
    // Book class to represent book information
    static class Book {
        // Step 1: Declare variables for title, author, genre, and publication year
        // Hint: Use appropriate data types (String for text, int for year)
        private String title;
        private String author;
        private String genre;
        private int publicationYear;
        
        // Step 2: Create a constructor for the Book class
        // Hint: The constructor should take parameters for all book attributes
        public Book(String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
        }
        
        // Step 3: Create getter methods for each attribute
        // Hint: Use the format: public dataType getAttribute()
        public String getTitle() {
            return this.title;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getGenre() {
            return this.genre;
        }

        public int getPublicationYear() {
            return this.publicationYear;
        }
        
        // Step 4: Create a method to display book details
        // Hint: Return a formatted string with all book information
        public String toString() {
            String message = 
                            "Title: " + this.title + "\n" +
                            "Author: " + this.author + "\n" +
                            "Genre: " + this.genre + "\n" +
                            "Publication Year: " + this.publicationYear;
            
            return message;
        }
    }
    
    // Method to validate if the title and author have valid formats
    private static boolean isValidText(String text) {
        // Step 5: Implement validation to ensure text isn't empty
        // Hint: Check if the string is null, empty, or only whitespace
        return text != null && !text.trim().isEmpty();
    }
    
    // Method to validate publication year
    private static boolean isValidYear(int year) {
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        int currentYear = Year.now().getValue();
        return year > 1000 && year <= currentYear;
    }
    
    public static void main(String[] args) {
        try {
            // Step 7: Create a Scanner for user input
            Scanner scanner = new Scanner(System.in);
            
            // Step 8: Create a HashMap to store books (with ISBN as the key)
            HashMap<String, Book> library = new HashMap<>();


            library.put("B001", new Book(
                                        "The Great Gatsby", 
                                        "F. Scott Fitzgerald", 
                                        "Classic", 
                                        1925
                                        )
                                    );
            library.put("B002", new Book(
                                        "To Kill a Mockingbird", 
                                        "Harper Lee", 
                                        "Classic", 
                                        1960
                                        )
                                    );
            library.put("B003", new Book(
                                        "1984", 
                                        "George Orwell", 
                                        "Dystopian", 
                                        1949
                                        )
                                    );
            
            // Step 9: Implement the main loop with menu options
            // Hint: Options should include adding a book, viewing all books, 
            // searching for books, removing a book, viewing sorted books, and exiting
            while(true) {
                System.out.println(" ------------ Main Menu ------------ ");
                System.out.println(
                                    "Press '1' to add a new book.\n" +
                                    "Press '2' to view all books.\n" +
                                    "Press '3' to search a book.\n" +
                                    "Press '4' to delete a book.\n" +
                                    "Press '5' to view sorted books.\n" +
                                    "Press '0' to exit."
                );

                String userAction = scanner.nextLine();

                // Step 10: Implement the "Add a book" option
                // Hint: Prompt user for book details (ISBN, title, author, genre, year)
                // Validate input and add to the HashMap
                if(userAction.equals("1")) {
                    addBook(scanner, library);
                }

                // Step 11: Implement the "View all books" option
                // Hint: Iterate through the HashMap and display all books
                else if (userAction.equals("2")) {
                    viewAllBooks(scanner, library);
                }

                // Step 12: Implement the "Search for a book" option
                // Hint: Allow searching by ISBN, title or author
                else if (userAction.equals("3")) {
                    searchBook(scanner, library);
                }
                
                // Step 13: Implement the "Remove a book" option
                // Hint: Remove a book from the collection using its ISBN
                else if (userAction.equals("4")) {
                    deleteBook(scanner, library);
                }

                // Step 14: Implement the "View sorted books" option
                // Hint: Use TreeMap to sort books by title or author
                else if (userAction.equals("5")) {
                    viewSortedBooks(scanner, library);
                }

                // Exit 
                else if (userAction.equals("0")){
                    System.out.println("Exiting the application.");
                    break;
                }
            }
            

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public static void addBook(Scanner scanner, HashMap<String, Book> library) {
        System.out.println(" ------------ Add a new book. ------------ ");

        System.out.println("Enter book's name.");
        String name = scanner.nextLine();

        System.out.println("Enter book's author name.");
        String author = scanner.nextLine();

        System.out.println("Enter book's genre.");
        String genre = scanner.nextLine();

        System.out.println("Enter book's publication year.");

        int publicationYear;
        while (true) {
            try {
                System.out.println("Enter publication year:");
                publicationYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year.");
            }
        }

        String isbn = String.format("B%03d", library.size() + 1);

        Book book = new Book(isbn, author, genre, publicationYear);
        library.put(name, book);

        System.out.println("Book:" + name + "was added to the library.");
    }  

    public static void viewAllBooks(Scanner scanner, HashMap<String, Book> library) {
        System.out.println(" ------------ View all books. ------------ ");
        for (String isbn : library.keySet()) {
                System.out.println(
                                    "ISBN: " + isbn + "\n" + 
                                    library.get(isbn) + "\n");
        } 
    }

    public static void searchBook(Scanner scanner, HashMap<String, Book> library) {
        System.out.println(" ------------ Search a book ------------ ");
        System.out.println("Enter ISBN of the book you are searching.\n");
        String isbn = scanner.nextLine();

        if(library.containsKey(isbn)) {
            System.out.println(" \n------------ Details for book with ISBN '" + isbn + "'' are below. ------------");
            System.out.println(library.get(isbn) + "\n");
        } else {
            System.out.println("No information for '" + isbn + "'' in the library.");
        }
    }

    public static void deleteBook(Scanner scanner, HashMap<String, Book> library) {
        System.out.println(" ------------ Delete a book. ------------ ");

        System.out.println("Enter ISBN of the book you want to delete.\n");
        String isbn = scanner.nextLine();

        if(library.containsKey(isbn)) {
            library.remove(isbn);
            System.out.println("Book with ISBN '" + isbn + "' has been deleted from the library.");
        } else {
            System.out.println("No information for '" + isbn + "'' in the library.");
        }
    }

    public static void viewSortedBooks(Scanner scanner, HashMap<String, Book> library) {
        System.out.println(" ------------ View sorted books. ------------ ");
        TreeMap<String, Book> libraryTreeMap = new TreeMap<>(library);

        for (Map.Entry<String, Book> book : libraryTreeMap.entrySet()) {
            System.out.println(
                "ISBN: " + book.getKey() + "\n" +
                book.getValue() + "\n"
            );
        }
    }
}