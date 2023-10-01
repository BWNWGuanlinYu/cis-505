import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueOption = "y";
        ArrayList<Transaction> transactions;

        while (continueOption.equalsIgnoreCase("y")) {
            System.out.println("Welcome to the Expense Tracker");
            System.out.println("MENU OPTIONS");
            System.out.println("1. View Transactions");
            System.out.println("2. Add Transactions");
            System.out.println("3. View Expense");
            int input = ValidatorIO.getInt(sc, "Please choose an option: ");

            if (input == 1) {
                try {
                    transactions = TransactionIO.findAll();
                    System.out.println("Monthly expenses");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.toString());
                    }
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 2) {
                String c = "y";
                transactions = new ArrayList<>();
                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\nEnter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "Enter the amount: ");
                    Transaction transaction = new Transaction("07-30-2021",description, amount);
                    transactions.add(transaction);
                    c = ValidatorIO.getString(sc, "\nAdd another transaction? (y/n): ");
                }
                try {
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            } else if (input == 3) {
                try {
                    transactions = TransactionIO.findAll();
                    double monthlyExpense = 0.0;
                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount();
                    }
                    System.out.println("Your total monthly expense is $" + String.format("%.2f", monthlyExpense));
                } catch (IOException e) {
                    System.out.println("\nException: " + e.getMessage());
                }
            }

            continueOption = ValidatorIO.getString(sc, "\nContinue? (y/n): ");
        }

        System.out.println("Program terminated by the user...");
        sc.close();
    }
}
