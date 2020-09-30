package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] accountsArray = new Accountable[accounts.size()];

        for (int i = 0; i < accountsArray.length; i++ ) {
            accountsArray[i] = accounts.get(i);
        }
        return accountsArray;
    }
    public boolean isVip() {
        int accountValue = 0;
        for (Accountable account : accounts) {
            accountValue = account.getBalance() + accountValue;
        }

        return (accountValue >= 25000);

    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
}
    @Override
    public int getBalance() {
        return 0;
    }
}
