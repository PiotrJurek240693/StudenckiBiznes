package connection.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
    private final ArrayList<ClientHandler> clientHandlers;
    private final ServerSocket serverSocket;
    private boolean working;

    Server() throws IOException {
        serverSocket = new ServerSocket(8888);
        clientHandlers = new ArrayList<>();
        working = true;
        this.start();
        System.out.println("Serwer nasłuchuje na porcie 8888.");
    }

    @Override
    public void run() {
        try {
            while (working) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nowe połączenie: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
                clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            if(working){
                System.out.println("Bład podczas dołączania nowego klienta!");
                close();
            }
        }
        System.out.println("Serwer zakończył działanie.");
    }

    public void sendMessage(String message) {
        for (ClientHandler ch : clientHandlers) {
            ch.sendMessage(message);
        }
    }

    public void close() {
        for (ClientHandler ch : clientHandlers) {
            ch.close();
        }
        working = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Bład podczas zamykania gniazda!");
        }
        this.interrupt();
    }
}
