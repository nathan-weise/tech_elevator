package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    @Override
    public int withdraw(int amountOfWithdraw) {
        int newBalance = super.getBalance() - amountOfWithdraw;
        int overdraftFee = 10;
        int minBalance = -100;

        if ((newBalance < 0) && (newBalance >= minBalance)) {
            super.withdraw(amountOfWithdraw + overdraftFee);
        } else if ((newBalance >= 0)) {
            super.withdraw(amountOfWithdraw);
        }
        return super.getBalance();
    }
}
