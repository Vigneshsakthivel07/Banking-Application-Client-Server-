# Client-Server Banking Application in Java

## Project Title
Java Client-Server Bank Management Application

## Project Description
This project is a console-based Java application that demonstrates how a banking system can be implemented using a client-server architecture.  
The application allows multiple clients to connect to a centralized bank server and perform core banking operations such as deposit, withdrawal, balance enquiry, and fund transfer.

Communication between the client and server is achieved using socket programming and object serialization.

---

## Problem Statement
Traditional banking systems require secure and reliable communication between users and backend services.  
This project focuses on designing a simple and centralized banking system where multiple clients can safely perform transactions using core Java networking concepts, without the use of external frameworks or databases.

---

## Objective of the Project
The primary objective of this project is to build an entry-level client-server banking application using core Java concepts.  
It helps learners understand:
- Client-server communication
- Server-side business logic handling
- Networking, serialization, and multithreading in Java

---

## Tools and Technologies Used
- Java SE (JDK 17 or above)
- Socket Programming (java.net)
- Object Serialization (java.io)
- IDE: IntelliJ IDEA or Eclipse
- Console-based execution  
No external libraries or databases are used.

---

## System Architecture Overview
The system follows a client-server architecture:
- The bank server listens on a specific port for incoming connections
- Clients connect to the server using sockets
- Communication is performed using serialized Request and Response objects
- Each client connection is handled in a separate thread to support concurrency

---

## Client-Server Communication Flow
1. The client establishes a socket connection with the server  
2. The client sends a serialized Request object  
3. The server processes the request using banking business logic  
4. The server sends a serialized Response object back to the client  
5. The client displays the transaction result to the user  

---

## Core Java Concepts Used

### Object-Oriented Programming
The project follows object-oriented principles such as encapsulation and abstraction.  
Classes like Account, Transaction, Request, and Response encapsulate both data and behavior.  
Business logic is centralized in the BankService class to ensure modularity and maintainability.

### Serialization
Serialization is used to convert Java objects into byte streams for network transmission.  
The Request and Response classes implement the Serializable interface and are transferred using ObjectInputStream and ObjectOutputStream.

### Socket Programming
Socket programming enables communication between the client and server.  
The ServerSocket class listens for incoming client requests, while the Socket class is used to establish a connection and exchange data.

### Multithreading
The server uses multithreading to handle multiple clients simultaneously.  
Each client connection is managed by a ClientHandler class that implements the Runnable interface.

### Synchronization
Critical banking operations such as deposit, withdrawal, and fund transfer are synchronized to prevent data inconsistency when accessed by multiple clients concurrently.

### Exception Handling
Exception handling is implemented using try-catch blocks to manage runtime and network errors.  
Try-with-resources is used to ensure proper closure of sockets and streams.

---

## Server-Side Design
- BankServer: Starts the server and listens for client connections  
- BankService: Contains all banking business logic  
- ClientHandler: Handles individual client requests and sends responses  

---

## Client-Side Design
- BankClient provides a menu-driven console interface  
- It collects user input, sends requests to the server, and displays responses  

---

## Advantages of the Project
- Demonstrates real-time client-server communication
- Enhances understanding of Java networking and concurrency
- Clean, modular, and extensible design

---

## Limitations of the Project
- No database integration (data stored in memory)
- No encryption or advanced security mechanisms
- Console-based user interface

---

## Future Enhancements
- Database integration using JDBC
- Secure communication using encryption
- User authentication and authorization
- Graphical or web-based user interface
- RESTful services using Spring Boot

---

## Conclusion
The Java Client-Server Banking Application demonstrates how core Java concepts can be effectively used to build a real-world networking system.  
This project provides a strong foundation for understanding distributed systems and prepares learners for advanced Java technologies such as JDBC, Spring Boot, and RESTful services.
