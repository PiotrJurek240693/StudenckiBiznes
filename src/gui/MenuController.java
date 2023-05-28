package gui;

import connection.server.Server;
import javafx.application.Platform;

import java.io.IOException;

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
}
