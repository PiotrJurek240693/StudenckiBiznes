package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    static private ArrayList<Player> players=new ArrayList<Player>();

    static private Board board;

    private Server server;
    private Client client;
    private void init()
    {

    }
    public Game(GameType gameType, String serverIP) throws IOException {
        init();
        if(gameType == GameType.MultiplayerClient){
            client = new Client(serverIP, 8888);
        }
        else if(gameType == GameType.MultiplayerHost){
            server = new Server();
        }
    }

    public Game(GameType gameType) throws IOException
    {
        init();
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
    public static ArrayList<Player> getPlayers()
    {
        return players;
    }
    public static void pay(int from,int to,int amount)
    {
        int moneyPaid=amount;
        if(from!=Board.BANK)
        {
            moneyPaid=players.get(from).takeMoney(amount);
        }
        if(to!=Board.BANK)
        {
            players.get(to).giveMoney(moneyPaid);
        }
        // TODO: wysłać i wyświetlić nowy stan gotówki
    }

    public static Player choosePlayer(ArrayList<Player> availablePlayers)
    {
        // TODO: funkcja przekazuje graczy, sposrod ktorych ma zostac wybrany jeden. Wyboru dokonuje gracz, ktory ma obecnie ture
        // Gracza wybierajacego nie ma wsrod availablePlayers
        return availablePlayers.get(0);
    }
    public static Property chooseProperty(ArrayList<Property> availableProperties, int amountToGet)
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
    public static void offerPlayerPayingForECTS(int time)
    {
        // TODO: wyświetlić graczowi propozycje opłacenia ECTS w zależności od pozostałego czasu
    }

    public static void offerUpgrading(ArrayList<Property> upgradeable)
    {
        // TODO: zapytać gracza co (czy) chce upelszyć z jego posiadłości - upgradeable
        //      -w jednym ruchu student może zrobić tylko 1 ulepszenie na jedno pole
        //              gotowe metody do wykorzystania: upgrade() i hasRecentlyGetUpgrade() i clearRecentlyGetUpgrade();
        //      -aby móc dobudować, ulepszać student musi posiadać cały wydział
        //      -wszystkie instytuty i katedry w danym wydziale mogą mieć różnice ilości sali maksymalnie o 1 między sobą
    }
}

