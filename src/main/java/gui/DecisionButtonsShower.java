package gui;

import gameLogic.Game;
import gameLogic.GameInfo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Label label = new Label("Czy chcesz kupic to pole?");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

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

    public static void showGoToDanteDecisionButtons() {
        init();

        Label label = new Label("Idziesz robic Dante! Konczysz ture.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            DecisionButtonsController.onGoToDanteOkButtonClick();
        });
        decisionButtons.getChildren().add(button1);
    }

    public static void showInDanteDecisionButtons(boolean hasCard) {
        init();

        Label label = new Label("Robisz Dante jeszcze przez " + Game.getActivePlayer().getInDante() + "tury.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Rzuć kośćmi");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            DecisionButtonsController.onDicesInDanteButtonClick();
        });
        decisionButtons.getChildren().add(button1);

        if(Game.getActivePlayer().getMoneyAmount() >= GameInfo.LEAVE_DANTE_PAY){
            button1.setTranslateX(-150);

            Button button2;
            button2 = new Button("Zaplac " + GameInfo.LEAVE_DANTE_PAY + "M$");
            button2.getStyleClass().add("przyciski_losowania");
            button2.setTranslateX(150);
            button2.setOnAction(event -> {
                DecisionButtonsController.onPayInDanteButtonClick();
            });
            decisionButtons.getChildren().add(button2);
        }

        if(hasCard){
            Button button3;
            button3 = new Button("Uzyj karty");
            button3.getStyleClass().add("przyciski_losowania");
            button3.setTranslateY(100);
            button3.setOnAction(event -> {
                DecisionButtonsController.onUseCardInDanteButtonClick();
            });
            decisionButtons.getChildren().add(button3);
        }
    }

    public static void showEndRoundDecisionButtons() {
        init();

        Label label = new Label("Konczysz ture.");
        label.getStyleClass().add("nazwa");
        label.setTranslateX(0);
        label.setTranslateY(-100);
        decisionButtons.getChildren().add(label);

        Button button1;
        button1 = new Button("Ok");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setOnAction(event -> {
            DecisionButtonsController.onEndTurnOkButtonClick();
        });
        decisionButtons.getChildren().add(button1);
    }
}
