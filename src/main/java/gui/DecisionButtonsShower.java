package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class DecisionButtonsShower {
    private static StackPane decisionButtons = new StackPane();

    private static void init(){
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(decisionButtons);
        decisionButtons = new StackPane();
        decisionButtons.setAlignment(Pos.CENTER);
        decisionButtons.setPrefWidth(696);
        decisionButtons.setPrefHeight(302);
        decisionButtons.setTranslateX(152);
        decisionButtons.setTranslateY(450);
        stackPane.getChildren().add(decisionButtons);
    }

    public static void showGameStartButton() {
        init();

        Button button1;
        button1 = new Button("Rozpocznij gre");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            DecisionButtonsController.onStartGameButtonClick();
        });
        decisionButtons.getChildren().add(button1);
    }

    public static void showRoundStartDecisionButtons() {
        init();

        Button button1;
        button1 = new Button("Rzuć kośćmi");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            DecisionButtonsController.onDicesButtonClick();
        });
        decisionButtons.getChildren().add(button1);
    }
}
