package connection.client;

import connection.server.ClientHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private final Socket socket;
    private final BufferedReader input;
    private final PrintWriter output;
    private boolean working;

    Client(String serverIP, int port) throws IOException {
        socket = new Socket(serverIP, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        working = true;
        this.start();
        System.out.println("Połączono z serwerem.");
    }

    @Override
    public void run() {
        try {
            while (working) {
                String notificationContent = input.readLine();
                if (notificationContent == null) {
                    break;
                }
                System.out.println("Otrzymano wiadomość: " + notificationContent);
                // TODO: Napisać funkcję interpretującą otrzymane wiadomości
            }
        } catch (IOException e) {
            if (working) {
                System.out.println("Bład podczas odbierania danych od serwera. Zostałeś rozłączony!");
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Bład podczas zamykania gniazda!");
                }
            }
        }
        System.out.println("Rozłączono z serwerem!");
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    public void close() {
        working = false;
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Bład podczas zamykania gniazda!");
        }
        this.interrupt();
    }
}
