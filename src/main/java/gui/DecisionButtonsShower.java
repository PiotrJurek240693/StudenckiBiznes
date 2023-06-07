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
        decisionButtons.setPrefHeight(262);
        decisionButtons.setTranslateX(152);
        decisionButtons.setTranslateY(490);
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

    public static void showBuyDecisionButtons() {
        init();

        Button button1;
        button1 = new Button("Kup");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setTranslateX(-100);
        button1.setOnAction(event -> {
            DecisionButtonsController.onBuyButtonClick();
        });
        decisionButtons.getChildren().add(button1);

        Button button2;
        button2 = new Button("Pomin");
        button2.getStyleClass().add("przyciski_losowania");
        button2.setTranslateX(100);
        button2.setOnAction(event -> {
            DecisionButtonsController.onSkipBuyingButtonClick();
        });
        decisionButtons.getChildren().add(button2);
    }

    public static void showPayDecisionButtons() {
        init();
    }
}
