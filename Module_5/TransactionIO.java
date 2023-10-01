import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; 

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    // expenses.txt showed here: 
    //07-30-2021 Shopping 199.99
    //07-30-2021 Food 33.99
    //07-30-2021 Dinning 88.72
    //07-30-2021 Supplies 199.77
    //07-30-2021 Bar 109.33
    //


    // Method to insert transactions into the file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        try {
            // Check if the file exists, if yes, open it for appending, else create a new file
            if (new File(FILE_NAME).exists()) {
                output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
            } else {
                output = new PrintWriter(FILE_NAME);
            }
            // Write each transaction's data to the file
            for (Transaction tran : transactions) {
                output.print(tran.getDate() + " ");
                output.print(tran.getDescription() + " ");
                output.println(tran.getAmount());
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    // Method to read transactions from the file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Scanner input = null; // Declare a Scanner object
        try {
            input = new Scanner(new File(FILE_NAME)); // Open the file for reading
            // Read each line of the file, create Transaction objects, and add them to the list
            while (input.hasNext()) {
                String date = input.next();
                String description = input.next();
                double amount = input.nextDouble();
                Transaction transaction = new Transaction(date, description, amount);
                transactions.add(transaction);
            }
        } finally {
            if (input != null) {
                input.close(); // Close the file
            }
        }
        return transactions;
    }
}
