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
}
