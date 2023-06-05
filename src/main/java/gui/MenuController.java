package gui;

import gameLogic.*;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;

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
        MenuShower.showNickAndPawnMenu();
        System.out.println("Polaczono");
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
        Game.addPlayer(new Player(nick, color));
        if(Game.getNumberOfPlayers() < Game.getMaxPlayers()){
            MenuShower.showNickAndPawnMenu();
            return;
        }
        GameShower.showGame();
    }

    public static void onStartGameButtonClick() {
        Game.start();
        PlayersInfoShower.showPlayersInfo();
        DecisionButtonsShower.showRoundStartDecisionButtons();
        PawnsShower.showPawns();
    }

    public static void onSquareClick(Property property) {
        PropertyInfoBox.showPropertyInfo(property);
    }

    public static void onCloseInfoButtonClick() {
        PropertyInfoBox.closePropertyInfo();
    }

    public static void onDicesButtonClick() {
        Player player = Game.getActivePlayer();
        while(player.getInDante() > 0){
            Game.nextRound();
            player = Game.getActivePlayer();
        }
        player.rollDices();
        player.conditionalMove();
        //Dices.showDices(dices);
        PawnsShower.showPawns();
        PlayersInfoShower.showPlayersInfo();
        if(!player.checkDoubles() || player.getInDante() > 0) {
            Game.nextRound();
        }
    }
}