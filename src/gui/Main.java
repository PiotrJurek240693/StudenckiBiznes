package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Studencki Biznes");

        StackPane root = new StackPane();

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}