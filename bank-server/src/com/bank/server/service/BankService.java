package com.bank.server.service;
import com.bank.server.model.Account;
import com.bank.server.model.Transaction;
import java.util.*;
public class BankService {
    private Map<Long,Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private long transactionID = 1000L;

    public BankService() {
        // Default test account
        accounts.put(1001L, new Account(1001L, "Admin", 1234, 5000));
    }

    public synchronized String createAccount(long accNo,String name,int pin,double balance){
        if(accounts.containsKey(accNo)){
            return "Already account exists";
        }
        accounts.put(accNo, new Account(accNo,name,pin,balance));
        return "account created successfully";
    }

    public synchronized boolean validatePin(Account account,int pin){
        return account.getPin() == pin;
    }

    public synchronized double checkBalance(long accNo,int pin){
        Account account = accounts.get(accNo);
        if(account == null || !validatePin(account,pin)){
            return -1;
        }
        return account.getBalance();
    }

    public synchronized String deposit(long accNo,double amount,int pin){
        Account account = accounts.get(accNo);
        if(account == null || !validatePin(account,pin)){
            return "Invalid Account or Pin";
        }
        account.setBalance(account.getBalance() + amount);
        transactions.add(new Transaction(++transactionID,accNo,"DEPOSIT",amount));
        return "Deposit successful";
    }

    public synchronized String withdraw(long accNo,double amount,int pin){
        Account account = accounts.get(accNo);
        if(account == null || !validatePin(account,pin)) {
            return "Invalid Account or Pin";
        }
        if(account.getBalance() < amount){
            return "Insufficient Balance";
        }

        account.setBalance(account.getBalance()-amount);
        transactions.add(new Transaction(++transactionID,accNo,"WITHDRAW",amount));
        return "Withdraw successful";
    }

    public synchronized String transfer(long fromAcc,long toAcc,double amount,int pin){
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);
        if(sender == null || receiver == null || !validatePin(sender,pin)){
            return "Invalid account details or pin";
        }
        if(sender.getBalance()<amount){
            return "Insufficient balance";
        }
        sender.setBalance(sender.getBalance()-amount);
        receiver.setBalance(receiver.getBalance()+amount);
        transactions.add(new Transaction(++transactionID,fromAcc,"TRANSFER",amount));
        transactions.add(new Transaction(++transactionID,toAcc,"TRANSFER",amount));
        return "Transfer successful";
    }
}
