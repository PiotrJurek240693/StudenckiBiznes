package gameLogic;

import gameLogic.cards.Card;
import gameLogic.cards.Card_FreeFromDante;

import java.io.Serializable;
import java.util.Random;

import java.util.ArrayList;

import static gameLogic.TypesOfSqueres.*;

public class Board implements Serializable {
    public static final int UNUPGRADABLE = -1;
    public static final int UPGRADE_PRICE_ROW_1 = 100;
    public static final int UPGRADE_PRICE_ROW_2 = 200;
    public static final int UPGRADE_PRICE_ROW_3 = 300;
    public static final int UPGRADE_PRICE_ROW_4 = 400;

    public static final int NO_ONE = -1;
    public static final int BANK = NO_ONE;
    public static final int RANDOMISE = -1;

    private static Random randomGenerator = new Random();

    private static ArrayList<Square> squares = new ArrayList<Square>();
    private StackOfCards chance = new StackOfCards();
    private StackOfCards studentCash = new StackOfCards();

    public Board() {
        initSquares();
        chance.initStackOfCardsChance();
        studentCash.initStackOfCardsStudentCash();
    }

    private boolean checkIfPlayerOwnsFaculty(int faculty) {
        boolean owns = true;
        for (Square square : squares) {
            if (square.isProperty()) {
                Property property = (Property) square;
                if (property.getFaculty() == faculty) {
                    if (property.getOwner() != Game.getActivePlayer()) {
                        owns = false;
                        break;
                    }
                }
            }
        }
        return owns;
    }

    private void checkIfUpgradePossibleAndOfferUpgrading() {
        ArrayList<Property> upgradeable = new ArrayList<Property>();
        for (Square square : squares) {
            if (square.isProperty()) {
                Property property = (Property) square;
                if (property.getUpgradePrice() != UNUPGRADABLE && property.getOwner() == Game.getActivePlayer()) {
                    if (checkIfPlayerOwnsFaculty(property.getFaculty())) {
                        upgradeable.add(property);
                    }
                }
            }
        }
    }

    private boolean isDouble(int[] dices) {
        boolean isDouble = false;
        for (int i = 0; i < dices.length - 1; i++) {
            for (int j = i + 1; j < dices.length; j++) {
                if (dices[i] == dices[j]) {
                    isDouble = true;
                }
            }
        }
        return isDouble;
    }

    private void handleCardDrawing(TypesOfSqueres type) {
        if (type == STUDENT_CASH) {
            Card card = studentCash.drawCard();
            card.takeAction(Game.getActivePlayer());
            if (!(card instanceof Card_FreeFromDante)) {
                studentCash.returnCard(card);
            }
        } else if (type == CHANCE) {
            Card card = chance.drawCard();
            card.takeAction(Game.getActivePlayer());
            chance.returnCard(card);
        }
        // TODO: wysłać i wyświetlić kartę
    }

    private void handleSquareAction() {
        int position = Game.getActivePlayer().getPosition();
        Square square = squares.get(position);
        if (square.isCards()) {
            handleCardDrawing(square.getType());
        } else if (square.isSpecial()) {
            handleSpecialSquareAction(square);
        } else if (square.isProperty()) {
            handleProperty((Property) square);
        } else {
            Game.getActivePlayer().takeMoney(square.getFee());
        }
    }

    private void handleSpecialSquareAction(Square square) {
        switch (square.getType()) {
            case DANTE:
                // TODO: jeśli getInDante()==0 to należy wyświetlić na polu dla odwiedzających
                break;
            case LIBRARY:
                Game.getActivePlayer().setHowManyDicesToThrow(3);
                // TODO: wysłanie i wyświetlenie darmowej herbaty
                break;
            case DANTE_AGAIN:
                Game.getActivePlayer().setDanteDuration(3);
                break;
        }
    }

    private void handleProperty(Property square) {
        if (square.isMortgaged()) {
            return;
        }
        Property property = square;
        Player owner = property.getOwner();
        if (owner == null) {
            //TODO: okienko z wyborem
        } else if (Game.getActivePlayer() != owner) {
            Game.pay(Game.getActivePlayer(), owner, square.getFee());
        }
    }

    private void initSquares() {
        squares.add(new Square("START", START, 0));
        squares.add(new Property("INSTYTUT ZARZĄDZANIA", INSTITUTE, 60, UPGRADE_PRICE_ROW_1, 1, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT MARKETINGU I ZRÓWNOWAŻONEGO ROZWOJU", INSTITUTE, 60, UPGRADE_PRICE_ROW_1, 1, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("LEGITYMACJA", STUDENT_CARD, 200));
        squares.add(new Property("PARKING KAMPUS A", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA POJAZDÓW I PODSTAW BUDOWY MASZYN", CATHEDRAL, 100, UPGRADE_PRICE_ROW_1, 2, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("INSTYTUT INŻYNIERII MATERIAŁOWEJ", INSTITUTE, 100, UPGRADE_PRICE_ROW_1, 2, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA DYNAMIKI MASZYN", CATHEDRAL, 120, UPGRADE_PRICE_ROW_1, 2, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("DANTE", DANTE, 0));
        squares.add(new Property("INSTYTUT TECHNOLOGII POLIMERÓW I BARWNIKÓW", INSTITUTE, 140, UPGRADE_PRICE_ROW_2, 3, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("ZATOKA SPORTU", SPORT_VANUE, 150, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("INSTYTUT CHEMII OGÓLNEJ I EKOLOGICZNEJ", INSTITUTE, 140, UPGRADE_PRICE_ROW_2, 3, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("MIĘDZYRESORTOWY INSTYTUT TECHNIKI RADIACYJNEJ", INSTITUTE, 160, UPGRADE_PRICE_ROW_2, 3, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("PARKING KAMPUS B", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("INSTYTUT MATERIAŁOZNAWSTWA TEKSTYLIÓW I KOMPOZYTÓW POLIMEROWYCH", INSTITUTE, 180, UPGRADE_PRICE_ROW_2, 4, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY TEKSTYLIÓW", INSTITUTE, 180, UPGRADE_PRICE_ROW_2, 4, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA TECHNOLOGII DZIEWIARSKICH I MASZYN WŁÓKIENNICZYCH", CATHEDRAL, 200, UPGRADE_PRICE_ROW_2, 4, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("BIBLIOTEKA", LIBRARY, 0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY I URBANISTYKI", INSTITUTE, 220, UPGRADE_PRICE_ROW_3, 5, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("KATEDRA BUDOWNICTWA BETONOWEGO", CATHEDRAL, 220, UPGRADE_PRICE_ROW_3, 5, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA MECHANIKI KONSTRUKCJI", CATHEDRAL, 240, UPGRADE_PRICE_ROW_3, 5, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("PARKING KAMPUS C", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA INŻYNIERII BIOPROCESOWEJ", CATHEDRAL, 260, UPGRADE_PRICE_ROW_3, 6, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA INŻYNIERII BEZPIECZEŃSTWA PRACY", CATHEDRAL, 260, UPGRADE_PRICE_ROW_3, 6, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("CANTRUM SPORTU", SPORT_VANUE, 150, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("KATEDRA INŻYNIERII MOLEKULARNEJ", CATHEDRAL, 280, UPGRADE_PRICE_ROW_3, 6, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("PORA NA DANTE", DANTE_AGAIN, 0));
        squares.add(new Property("INSTYTUT FIZYKI", INSTITUTE, 300, UPGRADE_PRICE_ROW_4, 7, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("INSTYTUT INFORMATYKI", INSTITUTE, 300, UPGRADE_PRICE_ROW_4, 7, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH, 0));
        squares.add(new Property("INSTYTUT MATEMATYKI", INSTITUTE, 320, UPGRADE_PRICE_ROW_4, 7, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Property("PARKING REKTORA", PARKING, 200, UNUPGRADABLE, UNUPGRADABLE, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("SZANSA", CHANCE, 0));
        squares.add(new Property("INSTYTUT MECHATRONIKI SYSTEMÓW INFORMATYCZNYCH", INSTITUTE, 350, UPGRADE_PRICE_ROW_4, 8, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
        squares.add(new Square("WARUNEK", FAILED_SUBIECT_FEE, 100));
        squares.add(new Property("KATEDRA MIKROELEKTRONIKI I TECHNIK INFORMATYCZNYCH", CATHEDRAL, 400, UPGRADE_PRICE_ROW_4, 8, new int[]{0 ,0 ,0 ,0 ,0 ,0}));
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

}
