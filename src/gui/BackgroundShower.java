package gui;

import gameLogic.Game;
import gameLogic.Player;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class BackgroundShower {
    private static StackPane background = new StackPane();

    public static void showBackground() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        StackPane stackPane = (StackPane) scene.getRoot();
        stackPane.getChildren().remove(background);



        stackPane.getChildren().add(background);
    }
}
