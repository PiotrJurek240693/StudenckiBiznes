package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;
import java.util.List;

public class Game {
    static private List<Player> players;

    static private Board board;

    private Server server;
    private Client client;
    public Game(GameType gameType, String serverIP) throws IOException {
        if(gameType == GameType.MultiplayerClient){
            client = new Client(serverIP, 8888);
        }
        else if(gameType == GameType.MultiplayerHost){
            server = new Server();
        }
    }

    public Game(GameType gameType) throws IOException
    {
        if(gameType == GameType.MultiplayerClient){
            throw new IllegalArgumentException();
        }
        else if(gameType == GameType.MultiplayerHost){
            server = new Server();
        }
    }

    public void closeGame(){
        if(server != null){
            server.close();
        }
        if(client != null){
            client.close();
        }
    }

    public static Board getBoard()
    {
        return board;
    }
    public static List<Player> getPlayers()
    {
        return players;
    }

    public static Player choosePlayer(List<Player> availablePlayers)
    {
        // TODO: funkcja przekazuje graczy, sposrod ktorych ma zostac wybrany jeden. Wyboru dokonuje gracz, ktory ma obecnie ture
        // Gracza wybierajacego nie ma wsrod availablePlayers
        return availablePlayers.get(0);
    }
    public static Property chooseProperty(List<Property> availableProperties, int amountToGet)
    {
        // TODO: funkcja przekazuje Property gracza, sposrod ktorych ma zostac wybrany jeden. Wyboru dokonuje gracz, ktory ma obecnie ture
        // do funkcji przekazuje rowniez sume, ktora jest potrzebna do wyplacenia (dla podgladu dla gracza)
        return null;
    }
    public static int chooseNumber()
    {
        // TODO: funkcja pobiera od gracza wartosc od -3 do 3
        return 0;
    }
    public static void offerPlayerBuyingOrAuction()
    {
        // TODO: zaoferować kupno posiadłości lub licytacje
    }
}

