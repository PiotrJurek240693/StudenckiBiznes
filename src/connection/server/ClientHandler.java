package connection.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final BufferedReader input;
    private final PrintWriter output;
    private boolean working;

    ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        working = true;
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " rozpoczoł działanie.");
    }

    @Override
    public void run() {
        try {
            while (working) {
                String notificationContent = input.readLine();
                if (notificationContent == null) {
                    break;
                }
                System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " otrzymał wiadomość:\n" + notificationContent);
                // TODO: Napisać funkcję interpretującą otrzymane wiadomości
            }
        } catch (IOException e) {
            if (working) {
                System.out.println("Bład podczas odbierania danych od klienta. Klient zostanie rozłączony!");
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    System.out.println("Bład podczas zamykania gniazda!");
                }
            }
        }
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " zakończył działanie.");
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    public void close() {
        working = false;
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Bład podczas zamykania gniazda!");
        }
        this.interrupt();
    }
}
