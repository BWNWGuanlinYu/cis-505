import java.util.Scanner;

public class TestBowlingShopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("x")) {
                System.out.println("End of line...");
                break;
            } else {
                GenericQueue<Product> products = ProductDB.getProducts(choice);
                displayProducts(products);
            }
        }
    }
    // Display the menu
    public static void displayMenu() {
        System.out.println("MENU OPTIONS");
        System.out.println("1. <b> Bowling Balls");
        System.out.println("2. <a> Bowling Bags");
        System.out.println("3. <s> Bowling Shoes");
        System.out.println("4. <x> To exit");
        System.out.print("Please choose an option: ");
    }
    // Display the products in the queue
    public static void displayProducts(GenericQueue<Product> products) {
        System.out.println("--Product Listing--");

        while (products.size() > 0) {
            Product product = products.dequeue();
            System.out.println(product);
            System.out.println();
        }
    }
}
