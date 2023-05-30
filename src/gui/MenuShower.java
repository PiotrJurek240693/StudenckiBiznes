package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MenuShower {
    public static void showMainMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Rozpocznij grę");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> {MenuController.onPlayButtonClick();});

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
        button3.setOnAction(event -> {MenuController.onExitButtonClick();});

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showMultiOrSingleMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Singleplayer");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> {MenuController.onSingleplayerButtonClick();});

        // Tworzenie przycisku 2
        Button button2 = new Button("Muliplayer");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {MenuController.onMultiplayerButtonClick();});

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {MenuController.onReturnToMainMenuButtonClick();});

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showHostOrJoinMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Hostuj");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(20);
        button1.setTranslateY(110);
        button1.setOnAction(event -> {MenuController.onHostButtonClick();});

        // Tworzenie przycisku 2
        Button button2 = new Button("Dołącz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {MenuController.onJoinButtonClick();});

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {MenuController.onReturnToMultiOrSingleMenuButtonClick();});

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, button1, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showJoinMenu() {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        TextField textField = new TextField();
        textField.setPromptText("Wprowadź tekst...");
        textField.setMaxWidth(400);
        textField.setTranslateX(20);
        textField.setTranslateY(110);

        // Tworzenie przycisku 2
        Button button2 = new Button("Dołącz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {MenuController.onJoinToSessionButtonClick(textField.getText());});

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {MenuController.onReturnToHostOrJoinMenuButtonClick();});

        // Tworzenie kontenera VBox i ustawianie przycisków na środku
        VBox buttonContainer = new VBox(10, textField, button2, button3);
        buttonContainer.setAlignment(Pos.CENTER);

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, buttonContainer);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    public static void showQuantity()
    {
        ImageView Quantity = new ImageView();
        Image QuantityImage = new Image("file:../../assets/WyborIlosciGraczy.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        Quantity.setImage(QuantityImage);
        Quantity.setFitWidth(ScreenSettings.screenWidth);
        Quantity.setFitHeight(ScreenSettings.screenHeight);

        // Tworzenie przycisku 1
        Button button1 = new Button("Wyjście");
        button1.getStyleClass().add("przyciski_menu_powitalne");
        button1.setTranslateX(0);
        button1.setTranslateY(300);
        button1.setOnAction(event -> {MenuController.onReturnToMultiOrSingleMenuButtonClick();});

        // Tworzenie przycisku 3
        Button button3 = new Button("");
        button3.getStyleClass().add("przyciski_niewidzialne");
        button3.setTranslateX(0);
        button3.setTranslateY(-340);
        button3.setVisible(false);


        // Tworzenie przycisku 4
        Button button4 = new Button("");
        button4.getStyleClass().add("przyciski_niewidzialne");
        button4.setTranslateX(0);
        button4.setTranslateY(-120);
        button4.setVisible(false);

        // Tworzenie przycisku 5
        Button button5 = new Button("");
        button5.getStyleClass().add("przyciski_niewidzialne");
        button5.setTranslateX(0);
        button5.setTranslateY(100);
        button5.setVisible(false);



        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(Quantity, button3, button4, button5, button1);


        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, QuantityImage.getWidth(), QuantityImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();

    }

    public static void showBoard()
    {
        ImageView Background = new ImageView();
        Image BackgroundImage = new Image("file:../../assets/Tlo.png");

        //PLANSZA
        Background.setImage(BackgroundImage);
        Background.setFitWidth(ScreenSettings.screenWidth);
        Background.setFitHeight(ScreenSettings.screenHeight);

        ImageView Board = new ImageView();
        Image BoardImage = new Image("file:../../assets/Studenckibiznes.png");
        Board.setImage(BoardImage);
        Board.setFitHeight(702);
        Board.setFitWidth(702);
        Board.setTranslateY(-25);
        Board.setTranslateX(350);

        //START

        ImageView Start = new ImageView();
        Image StartImage = new Image("file:../../assets/START.png");
        Start.setImage(StartImage);
        Start.setTranslateY(374);
        Start.setTranslateX(750);

        //WEEIA2

        ImageView Weeia2 = new ImageView();
        Image Weeia2Image = new Image("file:../../assets/WEEIA2.png");
        Weeia2.setImage(Weeia2Image);
        Weeia2.setTranslateY(284);
        Weeia2.setTranslateX(750);

        //WOiZ1

        ImageView Woiz1 = new ImageView();
        Image Woiz1Image = new Image("file:../../assets/WOiZ1.png");
        Woiz1.setImage(Woiz1Image);
        Woiz1.setTranslateY(374);
        Woiz1.setTranslateX(660);

        //Kasa studencka 1

        ImageView Kasastudencka1 = new ImageView();
        Image Kasastudencka1Image = new Image("file:../../assets/KASASTUDENCKA1.png");
        Kasastudencka1.setImage(Kasastudencka1Image);
        Kasastudencka1.setTranslateY(374);
        Kasastudencka1.setTranslateX(582);

        //WOiZ2

        ImageView Woiz2 = new ImageView();
        Image Woiz2Image = new Image("file:../../assets/WOiZ1.png");
        Woiz2.setImage(Woiz2Image);
        Woiz2.setTranslateY(374);
        Woiz2.setTranslateX(504);

        //Legitymacja

        ImageView Legitymacja = new ImageView();
        Image LegitymacjaImage = new Image("file:../../assets/LEGITYMACJA.png");
        Legitymacja.setImage(LegitymacjaImage);
        Legitymacja.setTranslateY(374);
        Legitymacja.setTranslateX(426);

        //ParkingA

        ImageView ParkingA = new ImageView();
        Image ParkingAImage = new Image("file:../../assets/PARKINGA.png");
        ParkingA.setImage(ParkingAImage);
        ParkingA.setTranslateY(374);
        ParkingA.setTranslateX(348);

        //WM1

        ImageView Wm1 = new ImageView();
        Image Wm1Image = new Image("file:../../assets/WM1.png");
        Wm1.setImage(Wm1Image);
        Wm1.setTranslateY(374);
        Wm1.setTranslateX(270);

        //Szansa 1

        ImageView Szansa1 = new ImageView();
        Image Szansa1Image = new Image("file:../../assets/SZANSA1.png");
        Szansa1.setImage(Szansa1Image);
        Szansa1.setTranslateY(374);
        Szansa1.setTranslateX(192);

        //WM2

        ImageView Wm2 = new ImageView();
        Image Wm2Image = new Image("file:../../assets/WM1.png");
        Wm2.setImage(Wm2Image);
        Wm2.setTranslateY(374);
        Wm2.setTranslateX(114);

        //WM3

        ImageView Wm3 = new ImageView();
        Image Wm3Image = new Image("file:../../assets/WM3.png");
        Wm3.setImage(Wm3Image);
        Wm3.setTranslateY(374);
        Wm3.setTranslateX(36);

        //Wiezienie

        ImageView Wiezienie = new ImageView();
        Image WiezienieImage = new Image("file:../../assets/WIEZIENIE.png");
        Wiezienie.setImage(WiezienieImage);
        Wiezienie.setTranslateY(374);
        Wiezienie.setTranslateX(-53);

        //WCH1

        ImageView Wch1 = new ImageView();
        Image Wch1Image = new Image("file:../../assets/WCH1.png");
        Wch1.setImage(Wch1Image);
        Wch1.setTranslateY(284);
        Wch1.setTranslateX(-52);

        //Zatoka Sportu

        ImageView ZatokaSportu = new ImageView();
        Image ZatokaSportuImage = new Image("file:../../assets/ZATOKASPORTU.png");
        ZatokaSportu.setImage(ZatokaSportuImage);
        ZatokaSportu.setTranslateY(206);
        ZatokaSportu.setTranslateX(-52);

        //WCH2

        ImageView Wch2 = new ImageView();
        Image Wch2Image = new Image("file:../../assets/WCH1.png");
        Wch2.setImage(Wch2Image);
        Wch2.setTranslateY(128);
        Wch2.setTranslateX(-52);


        //WCH3

        ImageView Wch3 = new ImageView();
        Image Wch3Image = new Image("file:../../assets/WCH3.png");
        Wch3.setImage(Wch3Image);
        Wch3.setTranslateY(50);
        Wch3.setTranslateX(-52);

        //Parking B

        ImageView ParkingB = new ImageView();
        Image ParkingBImage = new Image("file:../../assets/PARKINGB.png");
        ParkingB.setImage(ParkingBImage);
        ParkingB.setTranslateY(-28);
        ParkingB.setTranslateX(-52);

        //WTMiWT1

        ImageView Wtmiwt1 = new ImageView();
        Image Wtmiwt1Image = new Image("file:../../assets/WTMiWT1.png");
        Wtmiwt1.setImage(Wtmiwt1Image);
        Wtmiwt1.setTranslateY(-106);
        Wtmiwt1.setTranslateX(-52);

        //Kasa studencka 2

        ImageView Kasastudencka2 = new ImageView();
        Image Kasastudencka2Image = new Image("file:../../assets/KASASTUDENCKA2.png");
        Kasastudencka2.setImage(Kasastudencka2Image);
        Kasastudencka2.setTranslateY(-184);
        Kasastudencka2.setTranslateX(-52);

        //WTMiWT2

        ImageView Wtmiwt2 = new ImageView();
        Image Wtmiwt2Image = new Image("file:../../assets/WTMiWT1.png");
        Wtmiwt2.setImage(Wtmiwt2Image);
        Wtmiwt2.setTranslateY(-262);
        Wtmiwt2.setTranslateX(-52);

        //WTMiWT3

        ImageView Wtmiwt3 = new ImageView();
        Image Wtmiwt3Image = new Image("file:../../assets/WTMiWT3.png");
        Wtmiwt3.setImage(Wtmiwt3Image);
        Wtmiwt3.setTranslateY(-340);
        Wtmiwt3.setTranslateX(-52);

        //Biblioteka

        ImageView Biblioteka = new ImageView();
        Image BibliotekaImage = new Image("file:../../assets/BIBLIOTEKA.png");
        Biblioteka.setImage(BibliotekaImage);
        Biblioteka.setTranslateY(-429);
        Biblioteka.setTranslateX(-52);
        Biblioteka.setRotate(90);



        StackPane root = new StackPane();
        root.getChildren().addAll(Background, Board, Start, Weeia2, Woiz1, Kasastudencka1, Woiz2, Legitymacja, ParkingA,
                Wm1, Wm2, Szansa1, Wm3, Wiezienie, Wch1, Wch2, ZatokaSportu, Wch3, ParkingB, Wtmiwt1, Wtmiwt2, Kasastudencka2,
                Wtmiwt3, Biblioteka);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();



    }
}
