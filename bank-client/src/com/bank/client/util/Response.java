package com.bank.client.util;

import java.io.Serial;
import java.io.Serializable;

public class Response implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;
    private double balance;

    public Response() {}

    public Response(boolean success, String message, double balance) {
        this.success = success;
        this.message = message;
        this.balance = balance;
    }

    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
