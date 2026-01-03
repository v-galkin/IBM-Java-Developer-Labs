import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GroceryShopping {

    private static int searchItem(String[] groceryItems,String itemName) {
        for (int i = 0; i < groceryItems.length; ++i) {
            if (groceryItems[i].equalsIgnoreCase(itemName)){
                    return i;
                }
            }
            return -1;
        }

    private static double calculateAveragePrice(double[] groceryPrices) {
        double totalSum = 0.0;
        int groceryPricesLength = groceryPrices.length;
        for (int i = 0; i < groceryPricesLength; ++i) {
            totalSum += groceryPrices[i];
        }

        double averagePrice = totalSum / groceryPricesLength;

        return averagePrice;
    }

    private static List<String> findPricesBelowThreshold(String[] groceryItems, double[] groceryPrices, double priceThreshould) {
        int groceryItemsLength = groceryItems.length;

        List<String> itemsBelowThreshould = new ArrayList<>();

        for (int i = 0; i < groceryItemsLength; ++i) {
            if (groceryPrices[i] < priceThreshould) {
                itemsBelowThreshould.add("Item Name: " + groceryItems[i] + ". Item Price: $" + groceryPrices[i]);
            }
        }

        return itemsBelowThreshould; 
    }

    public static void main(String s[]) {
        String[] groceryItems = {
            "Milk (1L)",
            "Bread",
            "Eggs (12)",
            "Cheese (500g)",
            "Chicken Breast (1kg)",
            "Beef (1kg)",
            "Apples (1kg)",
            "Bananas (1kg)",
            "Tomatoes (1kg)",
            "Potatoes (1kg)",
            "Onions (1kg)",
            "Lettuce",
            "Rice (1kg)",
            "Cooking Oil (2L)",
            "Cereal"
        };

        double[] groceryPrices = {
            3.50,
            4.00,
            9.50,
            11.00,
            16.00,
            24.00,
            5.50,
            4.50,
            8.50,
            3.00,
            2.20,
            4.00,
            3.50,
            5.50,
            4.00
        };

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(
                "To start shopping press '1'.\n" +
                "To calculate average price press '2'.\n" +
                "To find items below with price below threshould press '3'. \n" +
                "To exit the application type 'Exit'."
            );

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                double totalBill = 0.0f;
                while(true) {
                    try {
                        System.out.println(
                            "Enter the name of the product or type 'finish' to end shopping.\n" 
                        );

                        String userShoppingAction = scanner.nextLine();

                        if (userShoppingAction.equalsIgnoreCase("finish")) {
                            System.out.println("Finishing shopping");
                            System.out.println("Your total bill is: $" + totalBill);
                            System.out.println("Thank you for shopping with us!");
                            break;
                        }

                        int itemIndex = searchItem(groceryItems, userShoppingAction);

                        if (itemIndex == -1) {
                            String message = ("Item '"+ userShoppingAction + "' not found. Please try again");
                            throw new ItemNotFoundException(message);
                        }

                        System.out.println("Enter the quality of " + groceryItems[itemIndex] + ":");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        double itemCost = groceryPrices[itemIndex] *quantity;
                        totalBill += itemCost;

                        System.out.println("Added " + quantity + " x " + groceryItems[itemIndex] + " to the bill. Current total: " + totalBill);
                    } catch (ItemNotFoundException error) {
                        System.out.println(error.getMessage());
                    } catch (Exception error) {
                        System.out.println("invalid Input. Please try again.");
                        scanner.nextLine();
                    }
                }
            } else if (userAction.equals("2")) {
                double averagePrice = 0.0;
                averagePrice = calculateAveragePrice(groceryPrices);
                System.out.println("Average price is: $" + averagePrice + "\n");
            } else if (userAction.equalsIgnoreCase("3")) {
                List<String> itemsBelowThreshold = new ArrayList<>();
                itemsBelowThreshold = findPricesBelowThreshold(groceryItems, groceryPrices, 5.0);

                for (String item : itemsBelowThreshold) {
                    System.out.println(item);
                }
            }

            if (userAction.equalsIgnoreCase("exit")) {
                System.out.println("\nClosing the application");
                break;
            }
        }

        scanner.close();
    }
}