package com.bank.server.model;
import java.time.LocalDate;
import java.io.Serializable;
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    private long transactionID;
    private long accNo;
    private String type;
    private double amount;
    private LocalDate timestamp;

    public Transaction(long transactionID,long accNo,String type,double amount){
        this.transactionID = transactionID;
        this.accNo = accNo;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDate.now();
    }
    public long getTransactionID(){
        return transactionID;
    }
    public long getAccNo(){
        return accNo;
    }
    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public LocalDate getTimestamp(){
        return timestamp;
    }
}
