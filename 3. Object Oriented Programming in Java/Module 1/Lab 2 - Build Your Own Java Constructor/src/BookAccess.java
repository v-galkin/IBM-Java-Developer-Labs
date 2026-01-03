public class BookAccess {

    public static void comaprePrices(Book bookOne, Book bookTwo) {
        String bookOneTitle = bookOne.getTitle();
        String bookTwoTitle = bookTwo.getTitle();
        float bookOnePrice = bookOne.getPrice();
        float bookTwoPrice = bookTwo.getPrice();

        String priceComparisonMessage = "";

        if (bookOnePrice < bookTwoPrice) {
            priceComparisonMessage = bookOneTitle + " costs less than " + bookTwoTitle;
        } 
        else if (bookOnePrice == bookTwoPrice) {
            priceComparisonMessage = bookOneTitle+ " costs as much as " + bookTwoTitle;
        } 
        else {
            priceComparisonMessage = bookOneTitle + " costs more than " +  bookTwoTitle;
        }

        System.out.println(priceComparisonMessage);
    }

    
    public static void main(String s[]) {
        Book bookOne = new Book("Atomic Habits", "James Clear",30.00f);

        Book bookTwo = new Book("Sapiens", "Yuval Noah Harari", 25.00f);

        System.out.println("The first book object is:");
        System.out.println(bookOne + "\n");

        System.out.println("The second book object is:");
        System.out.println(bookTwo + "\n");

        // comaprePrices(bookOne, bookTwo);
    }
}