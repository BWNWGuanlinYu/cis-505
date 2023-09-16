// Name: Guanlin Yu
// Class: CIS505

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

    private double balance = 200;

    // Accessor method
    public double getBalance() {
        return balance;
    }

    // Methods
    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        if(balance >= amt) {
            balance -= amt;
        }
    }

    public void displayMenu() {
        System.out.println("Account menu");
        System.out.println("Enter <D/d> for deposit");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
        System.out.print("   Enter option>:");
    }

    public String getTransactionDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(new Date());
    }
}
