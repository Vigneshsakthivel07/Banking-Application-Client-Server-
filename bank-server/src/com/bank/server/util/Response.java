package com.bank.server.util;
import java.io.Serial;
import java.io.Serializable;
public class Response implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private double balance;
    public Response(boolean success,String message,double balance){
        this.success = success;
        this.message = message;
        this.balance = balance;
    }
    public boolean isSuccess(){
        return success;
    }
    public String getMessage(){
        return message;
    }
    public double getBalance(){
        return balance;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }


}
