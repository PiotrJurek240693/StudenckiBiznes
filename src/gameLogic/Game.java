package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private static Board board;
    private static int maxPlayers;
    private static int activePlayerIndex;
    private static ArrayList<Player> players;
    private static Server server;
    private static Client client;

    public static void init(String serverIP) throws IOException {
        client = new Client(serverIP, 8888);
    }

    public static void init(GameType gameType, int howManyPlayers) throws IOException {
        initHelper(howManyPlayers);
        if (gameType == GameType.MultiplayerClient) {
            throw new IllegalArgumentException();
        } else if (gameType == GameType.MultiplayerHost) {
            server = new Server();
        }
    }

    private static void initHelper(int howManyPlayers) {
        maxPlayers = howManyPlayers;
        players = new ArrayList<Player>();
        players.add(new Player());
        activePlayerIndex = 0;
        board = new Board();
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void nextRound() {
        activePlayerIndex++;
        if (activePlayerIndex >= players.size()) {
            activePlayerIndex = 0;
        }
    }

    public static void removePlayerAndCleanProperties() {
        // TODO: wysłać i wyświetlić pola z powrotem do kupienia, gracz wyszarzony
    }

    public static void closeGame() {
        if (server != null) {
            server.close();
        }
        if (client != null) {
            client.close();
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static void pay(Player from, Player to, int amount) {
        players.get(activePlayerIndex).takeMoney(amount);
        players.get(activePlayerIndex).giveMoney(amount);
    }

    public static Player getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    public static Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }

    public static int getActivePlayerIndex() {
        return activePlayerIndex;
    }
}

