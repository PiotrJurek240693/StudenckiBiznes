package gameLogic;

import connection.client.Client;
import connection.server.Server;

import java.io.IOException;

public class Game {
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
}
