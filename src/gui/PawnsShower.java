package gui;

import gameLogic.Game;
import gameLogic.Pawn;
import gameLogic.Player;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PawnsShower {
    private static StackPane pawns = new StackPane();

    public static void showPawnsOnStart() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(pawns);

        for (Player player : Game.getPlayers()) {
            ImageView Pawn = new ImageView();
            Pawn.setImage(Chooser.choosePawn(player.getPawn().getColor()));
            Pawn.setTranslateY(player.getPawn().getY());
            Pawn.setTranslateX(player.getPawn().getX());
            Pawn.setFitWidth(30);
            Pawn.setFitHeight(30);
            pawns.getChildren().add(Pawn);
        }

        stackPane.getChildren().add(pawns);
    }

    public static void animatePawnMove(int pawnNumber, int moves) {
        int position = Game.getPlayer(pawnNumber).getPosition();
        var pawnImg = pawns.getChildren().get(pawnNumber);
        Pawn pawn = Game.getPlayer(pawnNumber).getPawn();

        while(moves > 0){
            if(position >= 0 && position < 10){
                pawn.changeX(-78);
            }
            else if(position >= 10 && position < 20){
                pawn.changeY(-78);
            }
            else if(position >= 20 && position < 30){
                pawn.changeX(78);
            }
            else if(position >= 30 && position < 40){
                pawn.changeY(78);
            }
            position++;
            if(position >= 40) {
                position = 0;
            }
            moves--;
            pawnImg.setTranslateX(pawn.getX());
            pawnImg.setTranslateY(pawn.getY());
        }
    }
}
