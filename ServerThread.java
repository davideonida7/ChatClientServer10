import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
class ServerThread implements Runnable {
        private ServerSocket serverSocket;

        public ServerThread() {
            try {
                serverSocket = new ServerSocket(6789);
                System.out.println("Server listening on port 6789...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Accepted connection from: " + clientSocket.getInetAddress().getHostAddress());
                    new Thread(new ClientHandler(clientSocket)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
