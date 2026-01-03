import java.util.Scanner;

public class BooksMenu {

    public static Book getMostExpensiveBook(Book bookOne, Book bookTwo) {

        if (bookOne.getPrice() < bookTwo.getPrice()) {
            return bookTwo;
        }
        else {
            return bookOne;
        }

    }
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[10];

        int bookIndex = 0;

        while(true) {
            System.out.println(
                "Press '1' to view all books.\n" +
                "Press '2' to add a new book.\n" +
                "Press '3' to compare prices for two books.\n" +
                "Press '0' to exit."
            );

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                for (int i = 0; i < books.length; ++i){
                    if (books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            }
            else if (userAction.equals("2")) {
                if(bookIndex == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }

                System.out.println("Enter book's title:");
                String bookTitle = scanner.nextLine();
                System.out.println("Enter book's author:");
                String bookAuthor = scanner.nextLine();
                System.out.println("Enter book's price:");
                float bookPrice = Float.parseFloat(scanner.nextLine());

                Book newBook = new Book();
                newBook.setTitle(bookTitle);
                newBook.setAuthor(bookAuthor);
                newBook.setPrice(bookPrice);
                books[bookIndex++] = newBook;
            } 
            else if(userAction.equals("3")) {
                System.out.println("Enter index of the first book to compare:");
                int bookOneIndex = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter index of the second book to compare:");
                int bookTwoIndex = Integer.parseInt(scanner.nextLine());

                if(books[bookOneIndex] != null && books[bookTwoIndex] != null) {
                    Book mostExpensiveBook = getMostExpensiveBook(books[bookOneIndex], books[bookTwoIndex]);

                    System.out.println("The most expensive books is " + mostExpensiveBook);
                }
                else {
                    System.out.println("one of the books does not exists");
                }
            }
            else {
                scanner.close();
                break;
            }
        }
    }
}