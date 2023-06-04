package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    private static Board board;
    private static int maxPlayers;
    private static int activePlayerIndex;
    private static ArrayList<Player> players;
    private static Server server;
    private static Client client;
    private static boolean started;
    private static GameType gameType;

    public static void init(String serverIP) throws IOException {
        client = new Client(serverIP, 8888);
        Game.gameType = GameType.MultiplayerClient;
    }

    public static void init(GameType gameType, int howManyPlayers) throws IOException {
        initHelper(howManyPlayers);
        if (gameType == GameType.MultiplayerClient) {
            throw new IllegalArgumentException();
        } else if (gameType == GameType.MultiplayerHost) {
            server = new Server();
        }
        Game.gameType = gameType;
    }

    private static void initHelper(int howManyPlayers) {
        maxPlayers = howManyPlayers;
        players = new ArrayList<>();
        activePlayerIndex = 0;
        board = new Board();
        started = false;
    }

    public static void addPlayer(Player player) {
        if (players.size() < maxPlayers) {
            players.add(player);
        }
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static int getNumberOfPlayers() {
        return players.size();
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

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static Player getActivePlayer() {
        return players.get(activePlayerIndex);
    }

    public static int getActivePlayerIndex() {
        return activePlayerIndex;
    }

    public static Server getServer() {
        return server;
    }

    public static void setBoard(Board board) {
        Game.board = board;
    }

    public static void setMaxPlayers(int maxPlayers) {
        Game.maxPlayers = maxPlayers;
    }

    public static void setActivePlayerIndex(int activePlayerIndex) {
        Game.activePlayerIndex = activePlayerIndex;
    }

    public static void setPlayers(ArrayList<Player> players) {
        Game.players = players;
    }


    public static boolean isStarted() {
        return started;
    }

    public static void start() {
        for(int i = players.size(); i < maxPlayers; i++){
            players.add(new Bot("", PawnColor.yellow));
        }
        Game.started = true;
    }

    public static GameType getGameType() {
        return gameType;
    }

    public static void setGameType(GameType gameType) {
        Game.gameType = gameType;
    }

}

