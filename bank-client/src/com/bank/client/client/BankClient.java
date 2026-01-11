package com.bank.client.client;

import com.bank.server.util.Request;
import com.bank.server.util.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BankClient {
    private static final String SERVER = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER, PORT);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("========== WELCOME TO BEN BANK ==========");

            System.out.println("Connected to Bank Server!");

            boolean running = true;
            long accNo = 0;
            int pin = 0;

            // Login / account setup
            System.out.print("Enter your account number: ");
            accNo = scanner.nextLong();
            System.out.print("Enter your PIN: ");
            pin = scanner.nextInt();

            while (running) {
                System.out.println("\nSelect operation:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

                String operation = "";
                double amount = 0.0;
                long toAcc = 0;

                switch (choice) {
                    case 1:
                        operation = "DEPOSIT";
                        System.out.print("Enter amount to deposit: ");
                        amount = scanner.nextDouble();
                        break;
                    case 2:
                        operation = "WITHDRAW";
                        System.out.print("Enter amount to withdraw: ");
                        amount = scanner.nextDouble();
                        break;
                    case 3:
                        operation = "CHECK_BALANCE";
                        break;
                    case 4:
                        operation = "TRANSFER";
                        System.out.print("Enter amount to transfer: ");
                        amount = scanner.nextDouble();
                        System.out.print("Enter target account number: ");
                        toAcc = scanner.nextLong();
                        break;
                    case 5:
                        running = false;
                        continue;
                    default:
                        System.out.println("Invalid choice!");
                        continue;
                }

                // Create request
                Request request = new Request(operation, accNo, amount, toAcc, pin);

                // Send request to server
                output.writeObject(request);
                output.flush();

                // Receive response
                Response response = (Response) input.readObject();

                // Display response
                System.out.println("Success: " + response.isSuccess());
                System.out.println("Message: " + response.getMessage());
                System.out.println("Balance: " + response.getBalance());
            }

            System.out.println("Client disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
