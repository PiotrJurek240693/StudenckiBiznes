package gui;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class Dices {
    private static StackPane dices = new StackPane();

    public static void showDices(ArrayList<Integer> dicesNumbers) {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(dices);

        if(dicesNumbers.size() >= 1){
            ImageView Kostka1 = new ImageView();
            Image Kostka1Image = Chooser.chooseDice(dicesNumbers.get(0));
            Kostka1.setImage(Kostka1Image);
            Kostka1.setTranslateX(-400);
            Kostka1.setTranslateY(250);
            Kostka1.setRotate(40);
            dices.getChildren().addAll(Kostka1);
        }

        if(dicesNumbers.size() >= 2) {
            ImageView Kostka2 = new ImageView();
            Image Kostka2Image = Chooser.chooseDice(dicesNumbers.get(0));
            Kostka2.setImage(Kostka2Image);
            Kostka2.setTranslateX(-250);
            Kostka2.setTranslateY(200);
            Kostka2.setRotate(25);
            dices.getChildren().addAll(Kostka2);
        }

        if(dicesNumbers.size() >= 3) {
            ImageView Kostka3 = new ImageView();
            Image Kostka2Image = Chooser.chooseDice(dicesNumbers.get(0));
            Kostka3.setImage(Kostka2Image);
            Kostka3.setTranslateX(-350);
            Kostka3.setTranslateY(400);
            Kostka3.setRotate(55);
            dices.getChildren().addAll(Kostka3);
        }

        stackPane.getChildren().add(dices);
    }
}
