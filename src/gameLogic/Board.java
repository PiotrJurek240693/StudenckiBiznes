package gameLogic;

import java.util.Random;

import java.util.ArrayList;

public class Board {
    public static final int UNUPGRADABLE = -1;
    public static final int UPGRADE_PRICE_ROW_1 = 100;
    public static final int UPGRADE_PRICE_ROW_2 = 200;
    public static final int UPGRADE_PRICE_ROW_3 = 300;
    public static final int UPGRADE_PRICE_ROW_4 = 400;
    public static final int START = 0;
    public static final int INSTITUTE = 1;
    public static final int STUDENT_CASH = 2;
    public static final int STUDENT_CARD = 3;
    public static final int PARKING = 4;
    public static final int CATHEDRAL = 5;
    public static final int CHANCE = 6;
    public static final int DANTE = 7;
    public static final int SPORT_VANUE = 8;
    public static final int LIBRARY = 9;
    public static final int DANTE_AGAIN = 10;
    public static final int FAILED_SUBIECT_FEE = 11;

    public static final int NO_ONE = -1;
    public static final int BANK = NO_ONE;
    public static final int RANDOMISE = -1;

    private static Random randomGenerator = new Random();
    private ArrayList<Square> squares=new ArrayList<Square>();
    private Player[] players;
    public Board(Player[] players)
    {
        this.players=players;
        initSquares();
    }
    public void run()
    {
        boolean isRunning=true;
        int playerIndex=0;
        while(isRunning) {
            playerRound(playerIndex);

            playerIndex++;
            if(playerIndex==players.length)
            {
                playerIndex=0;
            }
        }
    }
    private void playerRound(int playerIndex)
    {
        // TODO: (gameLogic) sprawdzić czy jest bankrutem jeśli jest to return;
        // TODO: wysłać i wyświetlić kogo jest kolej
        boolean endedRound=false;
        int doubles=0;
        while(!endedRound) {
            // TODO: zaoferować ulepszenie budynków o ile jakiś ma i da się ulepszyć i/lub usunięcie zastawienia
            int[] dices=rollDices(players[playerIndex].getDices());
            // TODO: (gameLogic) sprawdzić czy gracz ma ustawione robienie dante
            doMove(playerIndex,howFar(dices));
            int position=players[playerIndex].getPosition();
            doAction(playerIndex);
            if(isDouble(dices))
            {
                if(doubles==2) {
                    goToDante(playerIndex,3);
                    endedRound=true;
                } else {
                    endedRound=false;
                }
            }
            else{
                endedRound=true;
            }
            if(position!=players[playerIndex].getPosition())
            {
                // TODO: ponownie wysłać i wyświetlić pozycję gdyż uległa zmianie
            }
        }
    }
    private void goToDante(int playerIndex,int time)
    {
        // TODO: (gameLogic) obsłużyć czas siedzenia w dante
        players[playerIndex].setPosition(10);
    }
    private boolean isDouble(int[] dices)
    {
        // TODO: (gameLogic) dodać sprawdzenie czy był dublet
        return false;
    }
    private void doAction(int playerIndex)
    {
        int position=players[playerIndex].getPosition();
        Square square=squares.get(position);
        if(square.isCards()) {
            // TODO: (gameLogic) dobrać karte i ją obsłużyć
            // TODO: wysłać i wyświetlić kartę
        } else if (square.isSpecial()) {
            handleSpecial(square,playerIndex);
        } else if (square.isProperty()) {
            handleProperty(playerIndex, (Property) square);
        } else {
            pay(playerIndex,BANK,square.getFee());
        }
    }

    private void handleSpecial(Square square,int playerIndex)
    {
        switch (square.getType())
        {
            case DANTE:
                // TODO: (gameLogic) obsługa pola
                break;
            case LIBRARY:
                // TODO: (gameLogic) obsługa pola
                break;
            case DANTE_AGAIN:
                goToDante(playerIndex,RANDOMISE);
                break;
        }
    }

    private void handleProperty(int playerIndex, Property square)
    {
        if(square.isMortgaged()){
            return;
        }
        Property property= square;
        int ownerIndex=property.getOwnerIndex();
        if (ownerIndex==NO_ONE) {
            // TODO: zaoferować kupno posiadłości lub licytacje
        } else if (playerIndex!=ownerIndex){
            pay(playerIndex,ownerIndex,square.getFee());
        }
    }

    private void pay(int from,int to,int amount)
    {
        int moneyPaid=amount;
        if(from!=BANK)
        {
            // TODO: (gameLogic) zabrać graczowi o indexie [from] amount pieniędzy i obsłużyć bankructwo - wyliczyć ile zapłacił
            moneyPaid=amount;
        }
        if(to!=BANK)
        {
            // TODO: (gameLogic) dać graczowi o indeksie [to] moneyPaid pieniędzy
        }
        // TODO: wysłać i wyświetlić nowy stan gotówki
    }
    private void removePlayer(int playerIndex)
    {
        // TODO: (gameLogic) ustawić gracza jako bankruta
        for(int i=0;i<squares.size();i++)
        {
            Square square=squares.get(i);
            if(square.isProperty())
            {
                Property property=(Property)square;
                if(property.getOwnerIndex()==playerIndex)
                {
                    property.setOwnerIndex(NO_ONE);
                }
            }
        }
        // TODO: wysłać i wyświetlić pola spowrotem do kupienia, gracz wyszarzony
    }
    private int howFar(int[] dices)
    {
        int sum=0;
        for(int i=0;i<dices.length;i++) {
            sum+=dices[i];
        }
        return sum;
    }
    private int[] rollDices(int howMany)
    {
        int[] dices=new int[howMany];
        for(int i=0;i<howMany;i++) {
            dices[i]=randomGenerator.nextInt(6)+1;
        }
        // TODO: wysłać i wyświetlić wyrzucone kostki
        return dices;
    }
    public void doMove(int playerIndex,int move)
    {
        int position=players[playerIndex].getPosition();
        position+=move;
        if(position>squares.size()) {
            position-=squares.size();
            pay(BANK,playerIndex,200);
        }
        players[playerIndex].setPosition(position);
        // TODO: wysłać i wyświetlić przesunięcie gracza
    }
    private void initSquares() {
        squares.add(new Square("START", START,0));
        squares.add(new Property("INSTYTUT ZARZĄDZANIA", INSTITUTE,60,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("KASA STUDENCKA", STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT MARKETINGU I ZRÓWNOWAŻONEGO ROZWOJU",INSTITUTE,60,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("LEGITYMACJA",STUDENT_CARD,200));
        squares.add(new Property("PARKING KAMPUS A", PARKING,200,UNUPGRADABLE));
        squares.add(new Property("KATEDRA POJAZDÓW I PODSTAW BUDOWY MASZYN", CATHEDRAL,100,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("SZANSA", CHANCE,0));
        squares.add(new Property("INSTYTUT INŻYNIERII MATERIAŁOWEJ",INSTITUTE,100,UPGRADE_PRICE_ROW_1));
        squares.add(new Property("KATEDRA DYNAMIKI MASZYN",CATHEDRAL,120,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("DANTE",DANTE,0));
        squares.add(new Property("INSTYTUT TECHNOLOGII POLIMERÓW I BARWNIKÓW",INSTITUTE,140, UPGRADE_PRICE_ROW_2));
        squares.add(new Property("ZATOKA SPORTU", SPORT_VANUE,150,UNUPGRADABLE));
        squares.add(new Property("INSTYTUT CHEMII OGÓLNEJ I EKOLOGICZNEJ",INSTITUTE,140,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("MIĘDZYRESORTOWY INSTYTUT TCHNIKI RADIACYJNEJ",INSTITUTE,160,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("PARKING KAMPUS B",PARKING,200,UNUPGRADABLE));
        squares.add(new Property("INSTYTUT MATERIAŁOZNAWSTWA TEKSTYLIÓW I KOMPOZYTÓW POLIMEROWYCH",INSTITUTE,180,UPGRADE_PRICE_ROW_2));
        squares.add(new Square("KASA STUDENCKA",STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY TEKSTYLIÓW",INSTITUTE,180,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("KATEDRA TECHNOLOGII DZIEWIARSKICH I MASZYN WŁÓKIENNICZYCH",CATHEDRAL,200,UPGRADE_PRICE_ROW_2));
        squares.add(new Square("BIBLIOTEKA", LIBRARY,0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY I URBANISTYKI",INSTITUTE,220,UPGRADE_PRICE_ROW_3));
        squares.add(new Square("SZANSA",CHANCE,0));
        squares.add(new Property("KATEDRA BUDOWNICTWA BETONOWEGO",CATHEDRAL,220,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("KATEDRA MECHANIKI KONSTRUKCJI",CATHEDRAL,240,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("PARKING KAMPUS C",PARKING,200,UNUPGRADABLE));
        squares.add(new Property("KATEDRA INŻYNIERII BIOPROCESOWEJ",CATHEDRAL,260,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("KATEDRA INŻYNIERII BEZPIECZEŃSTWA PRACY",CATHEDRAL,260,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("CANTRUM SPORTU",SPORT_VANUE,150,UNUPGRADABLE));
        squares.add(new Property("KATEDRA INŻYNIERII MOLEKULARNEJ",CATHEDRAL,280,UPGRADE_PRICE_ROW_3));
        squares.add(new Square("PORA NA DANTE", DANTE_AGAIN,0));
        squares.add(new Property("INSTYTUT FIZYKI",INSTITUTE,300,UPGRADE_PRICE_ROW_4));
        squares.add(new Property("INSTYTUT INFORMATYKI",INSTITUTE,300,UPGRADE_PRICE_ROW_4));
        squares.add(new Square("KASA STUDENCKA",STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT MATEMATYKI",INSTITUTE,320,UPGRADE_PRICE_ROW_4));
        squares.add(new Property("PARKING REKTORA",PARKING,200,UNUPGRADABLE));
        squares.add(new Square("SZANSA",CHANCE,0));
        squares.add(new Property("INSTYTUT MECHATRONIKI SYSTEMÓW INFORMATYCZNYCH",INSTITUTE,350,UPGRADE_PRICE_ROW_4));
        squares.add(new Square("WARUNEK", FAILED_SUBIECT_FEE,100));
        squares.add(new Property("KATEDRA MIKROELEKTRONIKI I TECHNIK INFORMATYCZNYCH",CATHEDRAL,400,UPGRADE_PRICE_ROW_4));
    }


}
