package com.bank.server.server;
import com.bank.server.service.BankService;
import com.bank.server.util.Request;
import com.bank.server.util.Response;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ClientHandler implements Runnable{

    private final Socket socket;
    private final BankService bankservice;

    public ClientHandler(Socket socket,BankService bankservice){
        this.socket = socket;
        this.bankservice = bankservice;
    }

    @Override
    public void run() {
        try     (
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                )
        {
            while(true) {
                Request request = (Request) input.readObject();
                Response response = processRequest(request);
                output.writeObject(response);
                output.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private Response processRequest(Request request){

        long accNo = request.getAccNo();
        int pin = request.getPin();
        double amount = request.getAmount();
        double balance = 0.0;
        String resultMessage;

        switch(request.getOperation()) {
            case "DEPOSIT":
                resultMessage = bankservice.deposit(accNo, amount, pin);
                if (resultMessage.equals("Deposit successful")) {
                    balance = bankservice.checkBalance(accNo, pin);
                    return new Response(true, resultMessage, balance);
                } else {
                    return new Response(false, resultMessage, 0.0);
                }

            case "WITHDRAW":
                resultMessage = bankservice.withdraw(accNo, amount, pin);
                if (resultMessage.equals("Withdraw successful")) {
                    balance = bankservice.checkBalance(accNo, pin);
                    return new Response(true, resultMessage, balance);
                } else {
                    return new Response(false, resultMessage, 0.0);
                }

            case "CHECK_BALANCE":
                balance = bankservice.checkBalance(accNo, pin);
                if (balance >= 0) {
                    return new Response(true, "Balance retrieved", balance);
                } else {
                    return new Response(false, "Invalid Credentials", 0.0);
                }

            case "TRANSFER":
                long toAcc = request.getToAccount();
                resultMessage = bankservice.transfer(accNo, toAcc, amount, pin);
                if (resultMessage.equals("Transfer successful")) {
                    balance = bankservice.checkBalance(accNo, pin);
                    return new Response(true, resultMessage, balance);
                } else {
                    return new Response(false, resultMessage, 0.0);
                }

            default:
                return new Response(false, "invalid request", 0.0);

        }
        }
    }

