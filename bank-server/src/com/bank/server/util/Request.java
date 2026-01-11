package com.bank.server.util;
import java.io.Serial;
import java.io.Serializable;
public class Request implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private String operation;
    private long accNo;
    private double amount;
    private long toAccount;
    private int pin;
    public Request(String operation, long accNo, double amount, long toAccount, int pin){
        this.operation = operation;
        this.accNo =accNo;
        this.amount =amount;
        this.toAccount = toAccount;
        this.pin =pin;
    }
    public String getOperation(){
        return operation;
    }
    public long getAccNo(){
        return accNo;
    }
    public double getAmount(){
        return amount;
    }
    public long getToAccount(){
        return toAccount;
    }
    public int getPin(){
        return pin;
    }
    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
