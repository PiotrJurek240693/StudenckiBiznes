package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {



    @Override
    public void start(Stage primaryStage) {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(1700);
        MenuPowitalne.setFitHeight(1000);

        // Tworzenie przycisku 1
        Button button1 = new Button("Rozpocznij grę");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);


        // Tworzenie przycisku 2
        Button button2 = new Button("Ustawienia");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);

        // Tworzenie przycisku 3
        Button button3 = new Button("Wyjście");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);



        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
