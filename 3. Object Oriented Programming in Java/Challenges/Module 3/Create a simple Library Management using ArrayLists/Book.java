// Book class to represent a library book
public class Book {
    // Step 1: Declare private variables for bookTitle, author, publicationYear, and isAvailable
    // Hint: Use appropriate data types (String for title/author, int for year, boolean for availability)
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    
    // Step 2: Create a constructor that accepts bookTitle, author, and publicationYear
    // Hint: Initialize all fields including setting isAvailable to true by default
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }
    
    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    // Step 4: Create public setter methods for relevant variables
    // Hint: You might not need setters for all variables
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    // Step 5: Create methods to check out and return a book
    // checkOut() method should set isAvailable to false and return true if the book was available
    // returnBook() method should set isAvailable to true and return true if the book was checked out
    public boolean checkOut() {
        if (this.isAvailable) {
            setAvailable(false);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            return true;
        }
        else {
            return false;
        }
    }
    
    // Step 6: Override toString() method to display book details
    // Hint: Show title, author, year, and availability status
    @Override
    public String toString() {
        String availabilityStatus = "Available";

        if (!this.isAvailable) {
            availabilityStatus = "Unavailable";
        }

        String message = 
                        "Title: " + this.title + "\n" +
                        "Author: " + this.author + "\n" +
                        "Publication Year: " + this.publicationYear + "\n" +
                        "Status: " + availabilityStatus + "\n";
        
        return message;
    }
}
