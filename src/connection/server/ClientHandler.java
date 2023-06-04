package connection.server;

import gameLogic.Board;
import gameLogic.Game;
import gameLogic.Player;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

import static connection.Decryptor.decryptMessage;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final ObjectInputStream objectInput;
    ObjectOutputStream objectOutput;
    private boolean working;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        objectInput = new ObjectInputStream(clientSocket.getInputStream());
        objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
        working = true;
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " rozpoczoł działanie.");
    }

    @Override
    public void run() {
        try {
            sendGameInfo();
            while (working) {
                Object notificationContent = objectInput.readObject();
                if (notificationContent == null) {
                    break;
                }
                decryptMessage(notificationContent);
                Game.getServer().forwardMessage(notificationContent, this);
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ClientHandler na sokecie o numerze portu: " + clientSocket.getPort() + " zakończył działanie.");
    }

    public void sendMessage(Object message) throws IOException {
        objectOutput.writeObject(message);
    }

    public void sendGameInfo() throws IOException {
        objectOutput.writeInt(Game.getMaxPlayers());
        objectOutput.writeInt(Game.getActivePlayerIndex());
        objectOutput.writeObject(Game.getBoard());
        objectOutput.writeObject(Game.getPlayers());
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
