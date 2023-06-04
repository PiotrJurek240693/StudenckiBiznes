package connection.client;

import gameLogic.Board;
import gameLogic.Game;
import gameLogic.Player;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static connection.Decryptor.decryptMessage;

public class Client extends Thread {
    private final Socket socket;
    private final ObjectOutputStream objectOutput;
    private final ObjectInputStream objectInput;
    private boolean working;

    public Client(String serverIP, int port) throws IOException {
        socket = new Socket(serverIP, port);
        objectOutput = new ObjectOutputStream(socket.getOutputStream());
        objectInput = new ObjectInputStream(socket.getInputStream());
        working = true;
        this.start();
        System.out.println("Połączono z serwerem.");
    }

    @Override
    public void run() {
        try {
            getGameInfo();
            while (working) {
                String notificationContent = objectInput.readLine();
                if (notificationContent == null) {
                    break;
                }
                decryptMessage(notificationContent);
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

    public void sendMessage(Object message) throws IOException {
        objectOutput.writeObject(message);
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

    private void getGameInfo() throws IOException {
        try{
            Game.setMaxPlayers(objectInput.readInt());
            System.out.println(Game.getMaxPlayers());
            Game.setActivePlayerIndex(objectInput.readInt());
            System.out.println(Game.getActivePlayerIndex());
            Game.setBoard((Board)objectInput.readObject());
            Game.setPlayers((ArrayList<Player>)objectInput.readObject());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
