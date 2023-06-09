package gui;

import connection.InfoSender;
import gameLogic.*;
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
        MenuShower.showQuantityMenu(Singleplayer);
    }

    public static void onReturnToMultiOrSingleMenuButtonClick() {
        MenuShower.showMultiOrSingleMenu();
    }

    public static void onReturnToHostOrJoinMenuButtonClick() {
        MenuShower.showHostOrJoinMenu();
    }

    public static void onJoinButtonClick() {
        MenuShower.showJoinMenu();
    }

    public static void onHostButtonClick() {
        MenuShower.showQuantityMenu(MultiplayerHost);
    }

    public static void onJoinToSessionButtonClick(String ip) {
        System.out.println("Laczenie...");
        try {
            Game.init(ip);
        } catch (IOException e) {
            //TODO: Okno z errorem
            throw new RuntimeException(e);
        }
    }

    public static void onQuantityButtonClick(GameType gameType, int numberOfPlayers) {
        System.out.println("Uruchamianie...");
        try {
            Game.init(gameType, numberOfPlayers);
        } catch (IOException e) {
            //TODO: Okno z errorem
            throw new RuntimeException(e);
        }
        MenuShower.showNickAndPawnMenu();
        System.out.println("Uruchomoino");

        //TODO: Dodac polaczenie z serwerem gry.
    }

    public static void onPawnButtonClick(String nick, PawnColor color) {
        Player player = new Player(nick, color);
        Game.addPlayer(player);
        if(Game.getGameType() == MultiplayerClient || Game.getGameType() == MultiplayerHost) {
            Game.setMyPlayerIndex(Game.getPlayers().size() - 1);
        }
        if (Game.getGameType() == Singleplayer && Game.getNumberOfPlayers() < Game.getMaxPlayers()) {
            MenuShower.showNickAndPawnMenu();
            return;
        }
        InfoSender.sendInfo();
        GameShower.showGame();
    }

    public static void onCloseInfoButtonClick() {
        PropertyInfoBox.closePropertyInfo();
    }
}
