package com.bank.server.model;
import java.io.Serializable;
public class Account implements Serializable{
    private static final long serialVersionUID = 1L;

    private long accountNumber;
    private String holderName;
    transient int pin;
    private double balance;

    public Account(long accountNumber,String holderName,int pin,double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.balance = balance;
    }

    public long getAccNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public int getPin(){
        return pin;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
}
