package com.bank.server.server;
import com.bank.server.service.BankService;
import java.net.ServerSocket;
import java.net.Socket;
public class BankServer {
    private static final  int PORT = 5000;
    public static void main(String[] args){
        System.out.println("====Bank Server Started====");
        BankService bankService = new BankService();
        try (ServerSocket serverSocket = new ServerSocket(PORT))
        {
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected : "+clientSocket.getInetAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket,bankService);
                new Thread(clientHandler).start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
