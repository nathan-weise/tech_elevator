package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    @Override
    public int withdraw(int amountOfWithdraw) {
        int newBalance = super.getBalance() - amountOfWithdraw;
        int minBalance = 150;
        int serviceFee = 2;


        if (newBalance < minBalance && newBalance >= 0) {
            super.withdraw(amountOfWithdraw + serviceFee);
        } else if (newBalance >= minBalance) {
            super.withdraw(amountOfWithdraw);
        }
        return super.getBalance();
    }
}

