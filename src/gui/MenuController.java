package gui;

import javafx.application.Platform;

public class MenuController {
    public static void onExitButtonClick() {
        Platform.exit();
    }

    public static void onQuantityButtonClick() {MenuShower.showNickAndPawn();}

    public static void onPawnButtonClick() { MenuShower.showBoard(); }
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
        MenuShower.showQuantity();
    }
    public static void onReturnToMultiOrSingleMenuButtonClick() {
        MenuShower.showMultiOrSingleMenu();
    }

    public static void onReturnToHostOrJoinMenuButtonClick() {
        MenuShower.showHostOrJoinMenu();
    }

    public static void onJoinButtonClick() { MenuShower.showJoinMenu(); }

    public static void onHostButtonClick() {
        MenuShower.showQuantity();
        //TODO: Dodac uruchamianie serwera.
    }

    public static void onJoinToSessionButtonClick(String ip) {
        //TODO: Dodac polaczenie z serwerem gry.
        //Piotrek, nie zapomnij dodac wyboru okienka z nickiem i pionkami :)
    }
}
