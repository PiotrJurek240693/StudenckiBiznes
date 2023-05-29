package gui;

import javafx.application.Platform;

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

    public static void onReturnToMultiOrSingleMenuButtonClick() {
        MenuShower.showMultiOrSingleMenu();
    }

    public static void onReturnToHostOrJoinMenuButtonClick() {
        MenuShower.showHostOrJoinMenu();
    }

    public static void onJoinButtonClick() { MenuShower.showJoinMenu(); }

    public static void onHostButtonClick() {
        //TODO: Dodac uruchamianie serwera.
    }

    public static void onJoinToSessionButtonClick(String ip) {
        //TODO: Dodac polaczenie z serwerem gry.
    }
}
