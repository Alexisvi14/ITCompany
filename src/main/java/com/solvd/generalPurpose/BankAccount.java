package com.solvd.generalPurpose;

import com.solvd.exceptions.InsufficientFundsException;
import com.solvd.exceptions.InvalidAmountException;

public class BankAccount {
    private int number;
    private String bankName;
    private double balance;


    public BankAccount() {
        this.number = number;
        this.bankName = bankName;
        this.balance = balance;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double accountBalance) {
        if (balance >= 0) {
            this.balance = accountBalance;
        } else {
            throw new InvalidAmountException ("Account balance can't be less than zero");
        }
    }
    public void deposit (double amount) {
        if (amount >= 0) {
            this.setBalance(this.getBalance() + amount);
        } else {
            throw new InvalidAmountException("Can't deposit a negative amount");
        }
    }
    public void withdraw (double amount) {
        if (amount <= this.getBalance()) {
            this.setBalance(this.getBalance() - amount);
        } else {
            throw new InsufficientFundsException("Can't perform transaction: funds are insufficient");
        }
    }
}
