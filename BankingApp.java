import java.util.ArrayList;

public class BankingApp {
    public static void main(String[] args) {
        ArrayList<Customer> customers;
        Customer c1, c2;

        customers = new ArrayList<>();
        c1 = new Customer("Alice Smith");
        c2 = new Customer("Bob Jones");

        c1.addAccount(new SavingsAccount("SA101", 500.0, 2.5));
        c1.addAccount(new LoanAccount("LA202", -1000.0, 5000.0));
        c2.addAccount(new SavingsAccount("SA303", 150.0, 1.5));

        customers.add(c1);
        customers.add(c2);

        System.out.println("--- Demo Transactions ---");
        try {
            System.out.println("Alice withdraws $450 (Should fail - Min Balance)");
            c1.getAccounts().get(0).withdraw(450.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println("Bob withdraws $20 (Should pass)");
            c2.getAccounts().get(0).withdraw(20.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n--- Customer Balance Table ---");
        System.out.printf("%-15s | %-12s | %-10s\n", "Customer", "Account", "Balance");
        System.out.println("----------------------------------------------");
        for (Customer c : customers) {
            for (Account acc : c.getAccounts()) {
                System.out.printf("%-15s | %-12s | $%-10.2f\n", 
                    c.getName(), acc.getAccountNumber(), acc.getBalance());
            }
        }
    }
}