public class LoanAccount extends Account {
    private double loanLimit;

    public LoanAccount(String accountNumber, double balance, double loanLimit) {
        super(accountNumber, balance);
        this.loanLimit = loanLimit;
    }

    @Override
    public void deposit(double amount) {
        if (balance + amount <= 0) {
            super.deposit(amount);
        } else {
            System.out.println("Error: Deposit exceeds loan balance.");
        }
    }
}
