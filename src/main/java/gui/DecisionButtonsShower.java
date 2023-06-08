package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class DecisionButtonsShower {
    private static StackPane decisionButtons = new StackPane();

    public static void showGameStartButton() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(decisionButtons);
        decisionButtons = new StackPane();
        decisionButtons.setAlignment(Pos.CENTER);
        decisionButtons.setPrefWidth(696);
        decisionButtons.setPrefHeight(502);
        decisionButtons.setTranslateX(152);
        decisionButtons.setTranslateY(450);

        Button button1;
        button1 = new Button("Rozpocznij gre");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            MenuController.onStartGameButtonClick();
        });

        decisionButtons.getChildren().add(button1);

        stackPane.getChildren().add(decisionButtons);
    }

    public static void showRoundStartDecisionButtons() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(decisionButtons);
        decisionButtons = new StackPane();
        decisionButtons.setAlignment(Pos.CENTER);
        decisionButtons.setPrefWidth(696);
        decisionButtons.setPrefHeight(502);
        decisionButtons.setTranslateX(152);
        decisionButtons.setTranslateY(450);

        Button button1;
        button1 = new Button("Rzuc koscmi");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            MenuController.onDicesButtonClick();
        });
        decisionButtons.getChildren().add(button1);

        stackPane.getChildren().add(decisionButtons);
    }
}
