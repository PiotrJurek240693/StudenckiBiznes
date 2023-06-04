package gui;

import gameLogic.Property;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class PropertyInfoBox {
    private static StackPane infoBox = new StackPane();

    public static void showPropertyInfo(Property property) {

        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(infoBox);
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setPrefWidth(500);
        infoBox.setPrefHeight(1000);
        infoBox.setTranslateX(700);
        infoBox.setTranslateY(50);

        //Karta
        Rectangle karta = new Rectangle(500, 800);
        karta.getStyleClass().add("karta");
        karta.setTranslateX(30);
        karta.setTranslateY(-30);

        //Pasek do karty
        Rectangle pasek = new Rectangle(500, 200);
        pasek.getStyleClass().add("pasek");
        pasek.setTranslateX(30);
        pasek.setTranslateY(-330);

        Button closeButton = new Button("X");
        closeButton.setOnAction(event -> {
            MenuController.onCloseInfoButtonClick();
        });
        closeButton.setTranslateX(260);
        closeButton.setTranslateY(-400);

        //Nazwa
        Label Nazwa = new Label(property.getName());
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
        Label CzynszCena = new Label(property.getStopPrices()[0] + "M$");
        CzynszCena.getStyleClass().add("tresc_WEEIA");
        CzynszCena.setTranslateX(240);
        CzynszCena.setTranslateY(-150);

        //Z jednym akademikiem
        Label Jeden_akademik = new Label("Z jednym akademikiem");
        Jeden_akademik.getStyleClass().add("tresc_WEEIA");
        Jeden_akademik.setTranslateX(-35);
        Jeden_akademik.setTranslateY(-110);

        //Z jednym akademikiem - cena
        Label JedenAkademikCena = new Label(property.getStopPrices()[1] + "M$");
        JedenAkademikCena.getStyleClass().add("tresc_WEEIA");
        JedenAkademikCena.setTranslateX(240);
        JedenAkademikCena.setTranslateY(-110);

        //Z dwoma akademikami
        Label Dwa_akademiki = new Label("Z dwoma akademikami");
        Dwa_akademiki.getStyleClass().add("tresc_WEEIA");
        Dwa_akademiki.setTranslateX(-34);
        Dwa_akademiki.setTranslateY(-70);

        //Z dwoma akademikami cena
        Label DwaAkademikiCena = new Label(property.getStopPrices()[2] + "M$");
        DwaAkademikiCena.getStyleClass().add("tresc_WEEIA");
        DwaAkademikiCena.setTranslateX(240);
        DwaAkademikiCena.setTranslateY(-70);

        //Z trzema akademikami
        Label TrzyAkademiki = new Label("Z trzema akademikami");
        TrzyAkademiki.getStyleClass().add("tresc_WEEIA");
        TrzyAkademiki.setTranslateX(-34);
        TrzyAkademiki.setTranslateY(-30);

        //Z trzema akademikami cena
        Label TrzyAkademikiCena = new Label(property.getStopPrices()[3] + "M$");
        TrzyAkademikiCena.getStyleClass().add("tresc_WEEIA");
        TrzyAkademikiCena.setTranslateX(240);
        TrzyAkademikiCena.setTranslateY(-30);

        //Z czterema akademikami
        Label CzteryAkademiki = new Label("Z czterema akademikami");
        CzteryAkademiki.getStyleClass().add("tresc_WEEIA");
        CzteryAkademiki.setTranslateX(-22);
        CzteryAkademiki.setTranslateY(10);

        //Z czterema akademikami cena
        Label CzteryAkademikamiCena = new Label(property.getStopPrices()[4] + "M$");
        CzteryAkademikamiCena.getStyleClass().add("tresc_WEEIA");
        CzteryAkademikamiCena.setTranslateX(240);
        CzteryAkademikamiCena.setTranslateY(10);


        //CZYNSZ Z Akademikiem PREMIUM
        Label CzynszZAkademikiemPREMIUM = new Label("CZYNSZ Z akademikiem PREMIUM");
        CzynszZAkademikiemPREMIUM.getStyleClass().add("tresc_WEEIA");
        CzynszZAkademikiemPREMIUM.setTranslateX(-30);
        CzynszZAkademikiemPREMIUM.setTranslateY(50);

        //CZYNSZ Z Akademikiem PREMIUM Cena
        Label CzynszZAkademikiemPREMIUMCena = new Label(property.getStopPrices()[5] + "M$");
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
        Label CenaAkademikaCena = new Label(property.getUpgradePrice() + "M$ za kazdy");
        CenaAkademikaCena.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaCena.setTranslateX(200);
        CenaAkademikaCena.setTranslateY(215);

        //Cena akademika PREMIUM
        Label CenaAkademikaPREMIUM = new Label("Cena akademikaPREMIUM");
        CenaAkademikaPREMIUM.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaPREMIUM.setTranslateX(-68);
        CenaAkademikaPREMIUM.setTranslateY(250);

        //Cena akademika PREMIUM Cena
        Label CenaAkademikaPREMIUMCena = new Label(property.getUpgradePrice() + "M$");
        CenaAkademikaPREMIUMCena.getStyleClass().add("tresc_WEEIA");
        CenaAkademikaPREMIUMCena.setTranslateX(200);
        CenaAkademikaPREMIUMCena.setTranslateY(250);

        //Wartosc hipoteczna
        Label WartoscHipoteczna = new Label("Wartosc hipoteczna dzialki");
        WartoscHipoteczna.getStyleClass().add("tresc_WEEIA");
        WartoscHipoteczna.setTranslateX(-45);
        WartoscHipoteczna.setTranslateY(285);

        //Wartosc hipoteczna Cena
        Label WartoscHipotecznaCena = new Label(property.mortgagePrice() + "M$");
        WartoscHipotecznaCena.getStyleClass().add("tresc_WEEIA");
        WartoscHipotecznaCena.setTranslateX(200);
        WartoscHipotecznaCena.setTranslateY(285);

        //Cena
        Label Cena = new Label(property.getPrice() + "M$");
        Cena.getStyleClass().add("cena_WEEIA");
        Cena.setTranslateX(30);
        Cena.setTranslateY(335);

        infoBox.getChildren().addAll(karta, pasek, Nazwa, TytulWlasnosci, Czynsz, CzynszCena, Jeden_akademik,
                JedenAkademikCena, Dwa_akademiki, DwaAkademikiCena, TrzyAkademiki, TrzyAkademikiCena, CzteryAkademiki,
                CzteryAkademikamiCena, CzynszZAkademikiemPREMIUM, CzynszZAkademikiemPREMIUMCena, Linia1, Formulka,
                Linia2, Cena_akademika, CenaAkademikaCena, CenaAkademikaPREMIUM, CenaAkademikaPREMIUMCena,
                WartoscHipoteczna, WartoscHipotecznaCena, Cena, closeButton);

        stackPane.getChildren().add(infoBox);
    }

    public static void closePropertyInfo() {
        Scene scene = ScreenSettings.primaryStage.getScene();
        Pane stackPane = (Pane) scene.getRoot();
        stackPane.getChildren().remove(infoBox);
        infoBox = new StackPane();
    }
}
