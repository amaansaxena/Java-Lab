public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        double minBalance;
        minBalance = 100.0;
        if (balance - amount < minBalance) {
            throw new InsufficientFundsException("Min balance violation ($100) for: " + accountNumber);
        }
        super.withdraw(amount);
    }
}
