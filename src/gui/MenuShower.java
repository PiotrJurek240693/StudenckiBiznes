package gui;

import gameLogic.GameType;
import gameLogic.Property;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
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
        button1.setOnAction(event -> {
            MenuController.onPlayButtonClick();
        });

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
        button3.setOnAction(event -> {
            MenuController.onExitButtonClick();
        });

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
        button1.setOnAction(event -> {
            MenuController.onSingleplayerButtonClick();
        });

        // Tworzenie przycisku 2
        Button button2 = new Button("Muliplayer");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {
            MenuController.onMultiplayerButtonClick();
        });

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {
            MenuController.onReturnToMainMenuButtonClick();
        });

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
        button1.setOnAction(event -> {
            MenuController.onHostButtonClick();
        });

        // Tworzenie przycisku 2
        Button button2 = new Button("Dołącz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {
            MenuController.onJoinButtonClick();
        });

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {
            MenuController.onReturnToMultiOrSingleMenuButtonClick();
        });

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
        textField.setPromptText("Wprowadz tekst...");
        textField.setMaxWidth(400);
        textField.getStyleClass().add("text_field");
        textField.setTranslateX(20);
        textField.setTranslateY(110);

        // Tworzenie przycisku 2
        Button button2 = new Button("Dołącz");
        button2.getStyleClass().add("przyciski_menu_powitalne");
        button2.setTranslateX(20);
        button2.setTranslateY(130);
        button2.setOnAction(event -> {
            MenuController.onJoinToSessionButtonClick(textField.getText());
        });

        // Tworzenie przycisku 3
        Button button3 = new Button("Powrót");
        button3.getStyleClass().add("przyciski_menu_powitalne");
        button3.setTranslateX(20);
        button3.setTranslateY(150);
        button3.setOnAction(event -> {
            MenuController.onReturnToHostOrJoinMenuButtonClick();
        });

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

    public static void showQuantity(GameType gameType) {
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
        button1.setOnAction(event -> {
            MenuController.onReturnToMultiOrSingleMenuButtonClick();
        });

        // Tworzenie przycisku 3
        Button button3 = new Button("");
        button3.getStyleClass().add("przyciski_niewidzialne");
        button3.setTranslateX(0);
        button3.setTranslateY(-340);
        button3.setVisible(false);
        button3.setOnAction(event -> {MenuController.onQuantityButtonClick();});


        // Tworzenie przycisku 4
        Button button4 = new Button("");
        button4.getStyleClass().add("przyciski_niewidzialne");
        button4.setTranslateX(0);
        button4.setTranslateY(-120);
        button4.setVisible(false);
        button4.setOnAction(event -> {MenuController.onQuantityButtonClick();});

        // Tworzenie przycisku 5
        Button button5 = new Button("");
        button5.getStyleClass().add("przyciski_niewidzialne");
        button5.setTranslateX(0);
        button5.setTranslateY(100);
        button5.setVisible(false);
        button5.setOnAction(event -> {MenuController.onQuantityButtonClick();});

        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(Quantity, button3, button4, button5, button1);


        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, QuantityImage.getWidth(), QuantityImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();

    }

    public static void showBoard() {
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


        //BAiS 1

        ImageView Bais1 = new ImageView();
        Image Bais1Image = new Image("file:../../assets/BAiŚ1.png");
        Bais1.setImage(Bais1Image);
        Bais1.setTranslateY(-427);
        Bais1.setTranslateX(36);

        //Szansa 2

        ImageView Szansa2 = new ImageView();
        Image Szansa2Image = new Image("file:../../assets/SZANSA2.png");
        Szansa2.setImage(Szansa2Image);
        Szansa2.setTranslateY(-427);
        Szansa2.setTranslateX(114);


        //BAiS 2

        ImageView Bais2 = new ImageView();
        Image Bais2Image = new Image("file:../../assets/BAiŚ1.png");
        Bais2.setImage(Bais2Image);
        Bais2.setTranslateY(-427);
        Bais2.setTranslateX(192);

        //BAiS 3

        ImageView Bais3 = new ImageView();
        Image Bais3Image = new Image("file:../../assets/BAiŚ3.png");
        Bais3.setImage(Bais3Image);
        Bais3.setTranslateY(-427);
        Bais3.setTranslateX(270);


        //Parking C

        ImageView ParkingC = new ImageView();
        Image ParkingCImage = new Image("file:../../assets/PARKINGC.png");
        ParkingC.setImage(ParkingCImage);
        ParkingC.setTranslateY(-427);
        ParkingC.setTranslateX(348);

        //IPiOS 1

        ImageView Ipios1 = new ImageView();
        Image Ipios1Image = new Image("file:../../assets/IPiOS1.png");
        Ipios1.setImage(Ipios1Image);
        Ipios1.setTranslateY(-427);
        Ipios1.setTranslateX(426);

        //IPiOS 2

        ImageView Ipios2 = new ImageView();
        Image Ipios2Image = new Image("file:../../assets/IPiOS1.png");
        Ipios2.setImage(Ipios2Image);
        Ipios2.setTranslateY(-427);
        Ipios2.setTranslateX(504);

        //Centrum Sportu

        ImageView CentrumSportu = new ImageView();
        Image CentrumSportuImage = new Image("file:../../assets/CENTRUMSPORTU.png");
        CentrumSportu.setImage(CentrumSportuImage);
        CentrumSportu.setTranslateY(-427);
        CentrumSportu.setTranslateX(582);

        //IPiOS 3

        ImageView Ipios3 = new ImageView();
        Image Ipios3Image = new Image("file:../../assets/IPiOS3.png");
        Ipios3.setImage(Ipios3Image);
        Ipios3.setTranslateY(-427);
        Ipios3.setTranslateX(660);

        //Pora na Dante

        ImageView PoraNaDante = new ImageView();
        Image PoraNaDanteImage = new Image("file:../../assets/PORANADANTE.png");
        PoraNaDante.setImage(PoraNaDanteImage);
        PoraNaDante.setTranslateY(-427);
        PoraNaDante.setTranslateX(750);
        PoraNaDante.setRotate(180);


        //Warunek

        ImageView Warunek = new ImageView();
        Image WarunekImage = new Image("file:../../assets/WARUNEK.png");
        Warunek.setImage(WarunekImage);
        Warunek.setTranslateY(206);
        Warunek.setTranslateX(750);
        Warunek.setRotate(-90);

        //WEEIA1

        ImageView Weeia1 = new ImageView();
        Image Weeia1Image = new Image("file:../../assets/WEEIA1.png");
        Weeia1.setImage(Weeia1Image);
        Weeia1.setTranslateY(128);
        Weeia1.setTranslateX(750);

        //Szansa 3

        ImageView Szansa3 = new ImageView();
        Image Szansa3Image = new Image("file:../../assets/SZANSA3.png");
        Szansa3.setImage(Szansa3Image);
        Szansa3.setTranslateY(50);
        Szansa3.setTranslateX(750);
        Szansa3.setRotate(-90);

        //Parking Rektora

        ImageView ParkingRektora = new ImageView();
        Image ParkingRektoraImage = new Image("file:../../assets/PARKINGREKTORA.png");
        ParkingRektora.setImage(ParkingRektoraImage);
        ParkingRektora.setTranslateY(-28);
        ParkingRektora.setTranslateX(750);
        ParkingRektora.setRotate(-90);

        //FTIMS 3

        ImageView Ftims3 = new ImageView();
        Image Ftims3Image = new Image("file:../../assets/FTIMS3.png");
        Ftims3.setImage(Ftims3Image);
        Ftims3.setTranslateY(-106);
        Ftims3.setTranslateX(750);
        Ftims3.setRotate(-90);

        //Kasa studencka 3

        ImageView Kasastudencka3 = new ImageView();
        Image Kasastudencka3Image = new Image("file:../../assets/KASASTUDENCKA3.png");
        Kasastudencka3.setImage(Kasastudencka3Image);
        Kasastudencka3.setTranslateY(-184);
        Kasastudencka3.setTranslateX(750);
        Kasastudencka3.setRotate(-90);

        //FTIMS 2

        ImageView Ftims2 = new ImageView();
        Image Ftims2Image = new Image("file:../../assets/FTIMS1.png");
        Ftims2.setImage(Ftims2Image);
        Ftims2.setTranslateY(-262);
        Ftims2.setTranslateX(750);
        Ftims2.setRotate(-90);

        //FTIMS 1

        ImageView Ftims1 = new ImageView();
        Image Ftims1Image = new Image("file:../../assets/FTIMS1.png");
        Ftims1.setImage(Ftims1Image);
        Ftims1.setTranslateY(-340);
        Ftims1.setTranslateX(750);
        Ftims1.setRotate(-90);

        //Saldo gracz niebieski
        ImageView SaldoNiebieski = new ImageView();
        Image SaldoNiebieskiImage = new Image("file:../../assets/SALDONIEBIESKI.png");
        SaldoNiebieski.setImage(SaldoNiebieskiImage);
        SaldoNiebieski.setTranslateX(-626);
        SaldoNiebieski.setTranslateY(-376);

        //Label dla gracza 1
        Label Gracz1 = new Label("GRACZ 1");
        Gracz1.getStyleClass().add("label");
        Gracz1.setTranslateX(-626);
        Gracz1.setTranslateY(-425);

        //Label_saldo dla gracza niebiskiego
        Label Saldo1 = new Label("2000M$");
        Saldo1.getStyleClass().add("saldo_blue");
        Saldo1.setTranslateX(-626);
        Saldo1.setTranslateY(-330);




        //Saldo gracz czerwony
        ImageView SaldoCzerwony = new ImageView();
        Image SaldoCzerwonyImage = new Image("file:../../assets/SALDOCZERWONY.png");
        SaldoCzerwony.setImage(SaldoCzerwonyImage);
        SaldoCzerwony.setTranslateX(-278);
        SaldoCzerwony.setTranslateY(-376);

        //Label dla gracza 2
        Label Gracz2 = new Label("GRACZ 2");
        Gracz2.getStyleClass().add("label");
        Gracz2.setTranslateX(-278);
        Gracz2.setTranslateY(-425);

        //Label_saldo dla gracza czerwonego
        Label Saldo2 = new Label("2000M$");
        Saldo2.getStyleClass().add("saldo_red");
        Saldo2.setTranslateX(-278);
        Saldo2.setTranslateY(-330);




        //Saldo gracz zolty
        ImageView SaldoZolty = new ImageView();
        Image SaldoZoltyImage = new Image("file:../../assets/SALDOZOLTY.png");
        SaldoZolty.setImage(SaldoZoltyImage);
        SaldoZolty.setTranslateX(-278);
        SaldoZolty.setTranslateY(-176);

        //Label dla gracza 3
        Label Gracz3 = new Label("GRACZ 3");
        Gracz3.getStyleClass().add("label");
        Gracz3.setTranslateX(-626);
        Gracz3.setTranslateY(-225);

        //Label_saldo dla gracza zoltego
        Label Saldo3 = new Label("2000M$");
        Saldo3.getStyleClass().add("saldo_yellow");
        Saldo3.setTranslateX(-278);
        Saldo3.setTranslateY(-130);




        //Saldo gracz zielony
        ImageView SaldoZielony = new ImageView();
        Image SaldoZielonyImage = new Image("file:../../assets/SALDOZIELONY.png");
        SaldoZielony.setImage(SaldoZielonyImage);
        SaldoZielony.setTranslateX(-626);
        SaldoZielony.setTranslateY(-176);

        //Label dla gracza 4
        Label Gracz4 = new Label("GRACZ 4");
        Gracz4.getStyleClass().add("label");
        Gracz4.setTranslateX(-278);
        Gracz4.setTranslateY(-225);


        //Label_saldo dla gracza zielonego
        Label Saldo4 = new Label("2000M$");
        Saldo4.getStyleClass().add("saldo_green");
        Saldo4.setTranslateX(-626);
        Saldo4.setTranslateY(-130);



        ImageView Kostka1 = new ImageView();
        Image Kostka1Image = new Image("file:../../assets/Kostka4.png");
        Kostka1.setImage(Kostka1Image);
        Kostka1.setTranslateX(-400);
        Kostka1.setTranslateY(250);
        Kostka1.setRotate(40);


        ImageView Kostka2 = new ImageView();
        Image Kostka2Image = new Image("file:../../assets/Kostka1.png");
        Kostka2.setImage(Kostka2Image);
        Kostka2.setTranslateX(-250);
        Kostka2.setTranslateY(200);
        Kostka2.setRotate(25);

        //Przycisk do losowania
        Button button1 = new Button("Rzuć kośćmi");
        button1.getStyleClass().add("przyciski_losowania");
        button1.setTranslateX(-350);
        button1.setTranslateY(0);

        StackPane root = new StackPane();
        root.getChildren().addAll(Background, Board, Start, Weeia2, Woiz1, Kasastudencka1, Woiz2, Legitymacja, ParkingA,
                Wm1, Wm2, Szansa1, Wm3, Wiezienie, Wch1, Wch2, ZatokaSportu, Wch3, ParkingB, Wtmiwt1, Wtmiwt2, Kasastudencka2,
                Wtmiwt3, Biblioteka, Bais1, Bais2, Szansa2, ParkingC, Bais3, Ipios1, Ipios2, Ipios3, CentrumSportu, PoraNaDante,
                Warunek, Weeia1, Szansa3, ParkingRektora, Ftims3, Kasastudencka3, Ftims1, Ftims2,SaldoNiebieski,
                SaldoCzerwony, SaldoZolty, SaldoZielony, Gracz1, Gracz2, Gracz3, Gracz4, Saldo1, Saldo2, Saldo3, Saldo4,
                Kostka1, Kostka2, button1)
        ;

        Scene scene = new Scene(root);
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();


    }

    public static void showNickAndPawn()
    {
        // Tworzenie obiektu MenuPowitlane
        ImageView MenuPowitalne = new ImageView();

        // Wczytywanie obrazu
        Image MenuPowitlaneImage = new Image("file:../../assets/MenuPowitalne.png");

        // Ustawianie wczytanego obrazu z MenuPowitalne
        MenuPowitalne.setImage(MenuPowitlaneImage);
        MenuPowitalne.setFitWidth(ScreenSettings.screenWidth);
        MenuPowitalne.setFitHeight(ScreenSettings.screenHeight);

        //Podaj swój nick
        Button button5 = new Button("PODAJ SWÓJ NICK");
        button5.getStyleClass().add("tekst");
        button5.setTranslateX(30);
        button5.setTranslateY(-80);

        //Okienko do wpisywania
        TextField textField = new TextField();
        textField.setPromptText("Twoj nick");
        textField.getStyleClass().add("text_field");
        textField.setMaxWidth(400);
        textField.setTranslateX(30);
        textField.setTranslateY(0);

        //Wybierz swój pionek
        Button button6 = new Button("WYBIERZ SWÓJ PIONEK");
        button6.getStyleClass().add("tekst");
        button6.setTranslateX(30);
        button6.setTranslateY(140);

        //Pionek1
        ImageView Pionek1 = new ImageView();
        Image Pionek1Image = new Image("file:../../assets/PIONEK1.png");
        Pionek1.setImage(Pionek1Image);
        Pionek1.setTranslateY(284);
        Pionek1.setTranslateX(-220);

        //Przycisk do pionka 1

        Button button1 = new Button("");
        button1.getStyleClass().add("pionki");
        button1.setTranslateY(284);
        button1.setTranslateX(-220);
        button1.setOnAction(event -> {MenuController.onPawnButtonClick();});


        //Pionek2
        ImageView Pionek2 = new ImageView();
        Image Pionek2Image = new Image("file:../../assets/PIONEK2.png");
        Pionek2.setImage(Pionek2Image);
        Pionek2.setTranslateY(284);
        Pionek2.setTranslateX(-50);

        //Przycisk do pionka 2

        Button button2 = new Button("");
        button2.getStyleClass().add("pionki");
        button2.setTranslateY(284);
        button2.setTranslateX(-50);
        button2.setOnAction(event -> {MenuController.onPawnButtonClick();});

        //Pionek3
        ImageView Pionek3 = new ImageView();
        Image Pionek3Image = new Image("file:../../assets/PIONEK3.png");
        Pionek3.setImage(Pionek3Image);
        Pionek3.setTranslateY(284);
        Pionek3.setTranslateX(120);

        //Przycisk do pionka 3

        Button button3 = new Button("");
        button3.getStyleClass().add("pionki");
        button3.setTranslateY(284);
        button3.setTranslateX(120);
        button3.setOnAction(event -> {MenuController.onPawnButtonClick();});

        //Pionek4
        ImageView Pionek4 = new ImageView();
        Image Pionek4Image = new Image("file:../../assets/PIONEK4.png");
        Pionek4.setImage(Pionek4Image);
        Pionek4.setTranslateY(284);
        Pionek4.setTranslateX(290);

        //Przycisk do pionka 4

        Button button4 = new Button("");
        button4.getStyleClass().add("pionki");
        button4.setTranslateY(284);
        button4.setTranslateX(290);
        button4.setOnAction(event -> {MenuController.onPawnButtonClick();});



        // Tworzenie kontenera StackPane i dodawanie MenuPowitalne oraz przycisków do niego
        StackPane root = new StackPane();
        root.getChildren().addAll(MenuPowitalne, textField, button5, button6, Pionek1, Pionek2, Pionek3, Pionek4, button1, button2,
                button3, button4);

        // Tworzenie sceny i ustawianie jej w Stage
        Scene scene = new Scene(root, MenuPowitlaneImage.getWidth(), MenuPowitlaneImage.getHeight());
        scene.getStylesheets().add(MenuShower.class.getResource("styles.css").toExternalForm()); // Dodanie arkusza stylów CSS

        ScreenSettings.primaryStage.setScene(scene);
        ScreenSettings.primaryStage.show();
    }

    void drawCard(Property property)
    {
        //Karta
        Rectangle karta = new Rectangle(500,800);
        karta.getStyleClass().add("karta");
        karta.setTranslateX(30);
        karta.setTranslateY(-30);

        //Pasek do karty
        Rectangle pasek = new Rectangle(500,200);
        pasek.getStyleClass().add("pasek");
        pasek.setTranslateX(30);
        pasek.setTranslateY(-330);


        //Nazwa
        Label Nazwa = new Label("Katedra Pojazdów");
        Nazwa.getStyleClass().add("nazwa");
        Nazwa.setTranslateX(30);
        Nazwa.setTranslateY(-380);

        //Tytuł właśności
        Label TytulWlasnosci = new Label("TYTUL WLASNOSCI");
        TytulWlasnosci.getStyleClass().add("tytul_wlasnosci_WEEIA");
        TytulWlasnosci.setTranslateX(35);
        TytulWlasnosci.setTranslateY(-200);

        //CZYNSZ
        Label Czynsz = new Label("CZYNSZ - teren niezabudowany");
        Czynsz.getStyleClass().add("tresc_WEEIA");
        Czynsz.setTranslateX(-32);
        Czynsz.setTranslateY(-150);

        //CZYNSZ - Cena
        Label CzynszCena = new Label("350k$");
        CzynszCena.getStyleClass().add("tresc_WEEIA");
        CzynszCena.setTranslateX(240);
        CzynszCena.setTranslateY(-150);

        //Z jednym akademikiem
        Label Jeden_akademik = new Label("Z jednym akademikiem");
        Jeden_akademik.getStyleClass().add("tresc_WEEIA");
        Jeden_akademik.setTranslateX(-35);
        Jeden_akademik.setTranslateY(-110);

        //Z jednym akademikiem - cena
        Label JedenAkademikCena = new Label("1,75M$");
        JedenAkademikCena.getStyleClass().add("tresc_WEEIA");
        JedenAkademikCena.setTranslateX(240);
        JedenAkademikCena.setTranslateY(-110);

        //Z dwoma akademikami
        Label Dwa_akademiki = new Label("Z dwoma akademikami");
        Dwa_akademiki.getStyleClass().add("tresc_WEEIA");
        Dwa_akademiki.setTranslateX(-34);
        Dwa_akademiki.setTranslateY(-70);

        //Z dwoma akademikami cena
        Label DwaAkademikiCena = new Label("5M$");
        DwaAkademikiCena.getStyleClass().add("tresc_WEEIA");
        DwaAkademikiCena.setTranslateX(240);
        DwaAkademikiCena.setTranslateY(-70);

        //Z trzema akademikami
        Label TrzyAkademiki = new Label("Z trzema akademikami");
        TrzyAkademiki.getStyleClass().add("tresc_WEEIA");
        TrzyAkademiki.setTranslateX(-34);
        TrzyAkademiki.setTranslateY(-30);

        //Z trzema akademikami cena
        Label TrzyAkademikiCena = new Label("11M$");
        TrzyAkademikiCena.getStyleClass().add("tresc_WEEIA");
        TrzyAkademikiCena.setTranslateX(240);
        TrzyAkademikiCena.setTranslateY(-30);

        //Z czterema akademikami
        Label CzteryAkademiki = new Label("Z czterema akademikami");
        CzteryAkademiki.getStyleClass().add("tresc_WEEIA");
        CzteryAkademiki.setTranslateX(-22);
        CzteryAkademiki.setTranslateY(10);

        //Z czterema akademikami cena
        Label CzteryAkademikamiCena = new Label("13M$");
        CzteryAkademikamiCena.getStyleClass().add("tresc_WEEIA");
        CzteryAkademikamiCena.setTranslateX(240);
        CzteryAkademikamiCena.setTranslateY(10);



        //CZYNSZ Z Akademikiem PREMIUM
        Label CzynszZAkademikiemPREMIUM = new Label("CZYNSZ Z akademikiem PREMIUM");
        CzynszZAkademikiemPREMIUM.getStyleClass().add("tresc_WEEIA");
        CzynszZAkademikiemPREMIUM.setTranslateX(-30);
        CzynszZAkademikiemPREMIUM.setTranslateY(50);

        //CZYNSZ Z Akademikiem PREMIUM Cena
        Label CzynszZAkademikiemPREMIUMCena = new Label("15M$");
        CzynszZAkademikiemPREMIUMCena.getStyleClass().add("tresc_WEEIA");
        CzynszZAkademikiemPREMIUMCena.setTranslateX(240);
        CzynszZAkademikiemPREMIUMCena.setTranslateY(50);

        Label Linia1 = new Label("-------------------------------------------------------");
        Linia1.getStyleClass().add("tresc_WEEIA");
        Linia1.setTranslateX(30);
        Linia1.setTranslateY(70);

        //Formulka
        Label Formulka = new Label("Jezeli gracz posiada wszystkie dzialki w\ndanej grupie koloru, za niezabudowane\ndzialki pobiera podwojny czynsz");
        Formulka.getStyleClass().add("tresc_WEEIA");
        Formulka.setTranslateX(30);
        Formulka.setTranslateY(130);

        Label Linia2 = new Label("-------------------------------------------------------");
        Linia2.getStyleClass().add("tresc_WEEIA");
        Linia2.setTranslateX(30);
        Linia2.setTranslateY(185);

        //Cena akademika
        Label Cena_akademika = new Label("Cena akademika");
        Cena_akademika.getStyleClass().add("tresc_WEEIA");
        Cena_akademika.setTranslateX(-115);
        Cena_akademika.setTranslateY(215);

        //Cena akademika Cena
        Label CenaAkademikaCena = new Label("2M$ za kazdy");
        CenaAkademikaCena.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaCena.setTranslateX(200);
        CenaAkademikaCena.setTranslateY(215);

        //Cena akademika PREMIUM
        Label CenaAkademikaPREMIUM = new Label("Cena akademikaPREMIUM");
        CenaAkademikaPREMIUM.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaPREMIUM.setTranslateX(-68);
        CenaAkademikaPREMIUM.setTranslateY(250);

        //Cena akademika PREMIUM Cena
        Label CenaAkademikaPREMIUMCena = new Label("10M$");
        CenaAkademikaPREMIUMCena.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaPREMIUMCena.setTranslateX(200);
        CenaAkademikaPREMIUMCena.setTranslateY(250);

        //Wartosc hipoteczna
        Label WartoscHipoteczna = new Label("Wartosc hipoteczna dzialki");
        WartoscHipoteczna.getStyleClass().add("tresc_WEEIA");
        WartoscHipoteczna.setTranslateX(-45);
        WartoscHipoteczna.setTranslateY(285);

        //Wartosc hipoteczna Cena
        Label WartoscHipotecznaCena = new Label("1,75M$");
        WartoscHipotecznaCena.getStyleClass().add("tresc_WEEIA");
        WartoscHipotecznaCena.setTranslateX(200);
        WartoscHipotecznaCena.setTranslateY(285);

        //Cena
        Label Cena = new Label("260M$");
        Cena.getStyleClass().add("cena_WEEIA");
        Cena.setTranslateX(30);
        Cena.setTranslateY(335);
    }
}
