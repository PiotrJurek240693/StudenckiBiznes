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

    private static Random randomGenerator = new Random();
    private ArrayList<Square> squares=new ArrayList<Square>();
    private ArrayList<Action> actionsToSend=new ArrayList<Action>();
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
        while(isRunning)
        {
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
        boolean endedRound=false;
        while(!endedRound)
        {
            int[] dices=rollDices(players[playerIndex].getDices());
            // TODO: wysłać i wyświetlić żut kostkami
            int position=doMove(playerIndex,howFar(dices));
            // TODO: zrobić obsługę ruchu
        }
    }
    private int howFar(int[] dices)
    {
        int sum=0;
        for(int i=0;i<dices.length;i++)
        {
            sum+=dices[i];
        }
        return sum;
    }
    private int[] rollDices(int howMany)
    {
        int[] dices=new int[howMany];
        for(int i=0;i<howMany;i++)
        {
            dices[i]=randomGenerator.nextInt(6)+1;
        }
        return dices;
    }
    public int doMove(int playerIndex,int move)
    {
        int position=players[playerIndex].getPosition();
        position+=move;
        if(position>squares.size())
        {
            position-=squares.size();
        }
        players[playerIndex].setPosition(position);
        // TODO: wysłać i wyświetlić przesunięcie gracza
        return position;
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
