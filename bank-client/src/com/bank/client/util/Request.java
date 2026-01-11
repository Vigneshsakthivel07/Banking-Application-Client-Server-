package com.bank.client.util;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String operation;   // DEPOSIT, WITHDRAW, CHECK_BALANCE, TRANSFER, CREATE_ACCOUNT
    private long accNo;         // account number
    private int pin;            // account PIN
    private double amount;      // amount for deposit/withdraw/transfer
    private long toAccount;     // target account for transfer
    private String name;        // account holder name (for create account)

    public Request(String operation, long accNo, int pin, double amount, long toAccount, String name) {
        this.operation = operation;
        this.accNo = accNo;
        this.pin = pin;
        this.amount = amount;
        this.toAccount = toAccount;
        this.name = name;
    }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public long getAccNo() { return accNo; }
    public void setAccNo(long accNo) { this.accNo = accNo; }

    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public long getToAccount() { return toAccount; }
    public void setToAccount(long toAccount) { this.toAccount = toAccount; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
