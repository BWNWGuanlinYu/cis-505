import java.util.Scanner;
// Name: Guanlin Yu
// Class: CIS505




public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get customer details
        System.out.print("Enter a customer ID: ");
        int id = sc.nextInt();
        Customer customer = CustomerDB.getCustomer(id);

        // Step 2: Create an Account object
        Account account = new Account();

        // Step 3: Display menu and handle user input
        String option;
        do {
            account.displayMenu();
            option = sc.next().toLowerCase();
            
            switch(option) {
                case "d":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case "w":
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case "b":
                    System.out.printf("Account balance: $%,.2f\n", account.getBalance());
                    break;
                default:
                    System.out.println("Error: Invalid option");
            }

            System.out.print("Continue?(y/n):");
            option = sc.next().toLowerCase();
        } while(option.equals("y"));

        // Step 4: Display customer details and account balance
        System.out.println("\n--Customer details--");
        System.out.println(customer.toString());
        System.out.printf("Balance as of %s is $%,.2f\n", account.getTransactionDate(), account.getBalance());
        System.out.println("end of line ...");

        sc.close();
    }
}
