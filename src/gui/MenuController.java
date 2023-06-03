package gui;

import gameLogic.Game;
import gameLogic.GameType;
import gameLogic.Player;
import javafx.application.Platform;

import java.io.IOException;

import static gameLogic.GameType.*;

public class MenuController {
    public static void onExitButtonClick() {
        Platform.exit();
    }
    public static void onPlayButtonClick() {
        MenuShower.showMultiOrSingleMenu();
    }

    public static void onReturnToMainMenuButtonClick() {
        MenuShower.showMainMenu();
    }

    public static void onMultiplayerButtonClick() {
        MenuShower.showHostOrJoinMenu();
    }

    public static void onSingleplayerButtonClick() {
        MenuShower.showQuantity(Singleplayer);
    }
    public static void onReturnToMultiOrSingleMenuButtonClick() {
        MenuShower.showMultiOrSingleMenu();
    }

    public static void onReturnToHostOrJoinMenuButtonClick() {
        MenuShower.showHostOrJoinMenu();
    }

    public static void onJoinButtonClick() { MenuShower.showJoinMenu(); }

    public static void onHostButtonClick() {
        MenuShower.showQuantity(MultiplayerHost);
    }

    public static void onJoinToSessionButtonClick(String ip) {
        System.out.println("Laczenie...");
        try{
            Game.init(ip);
        } catch (IOException e) {
            //TODO: Okno z errorem
            throw new RuntimeException(e);
        }
        MenuShower.showNickAndPawn();
        System.out.println("Polaczono");
    }

    public static void onQuantityButtonClick(GameType gameType, int numberOfPlayers) {
        System.out.println("Uruchamianie...");
        try{
            Game.init(gameType, numberOfPlayers);
        } catch (IOException e) {
            //TODO: Okno z errorem
            throw new RuntimeException(e);
        }
        MenuShower.showNickAndPawn();
        System.out.println("Uruchomoino");

        //TODO: Dodac polaczenie z serwerem gry.
        //Piotrek, nie zapomnij dodac wyboru okienka z nickiem i pionkami :)
    }

    public static void onPawnButtonClick(String nick) {
        Game.addPlayer(new Player(nick));
        MenuShower.showBoard();
    }
}
