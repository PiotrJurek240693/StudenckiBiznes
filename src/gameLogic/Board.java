package gameLogic;

import gameLogic.squares.*;

import java.util.ArrayList;

public class Board {
    public static final int UPGRADE_PRICE_ROW_1 = 100;
    public static final int UPGRADE_PRICE_ROW_2 = 200;
    public static final int UPGRADE_PRICE_ROW_3 = 3;
    public static final int UPGRADE_PRICE_ROW_4 = 4;
    private ArrayList<Square> squares=new ArrayList<Square>();
    public Board()
    {
        initSquares();
    }

    public Action checkAction(int square)
    {
        if(square<0||square>=squares.size())
        {
            return new Action('e',-1);
        }
        return squares.get(square).doAction();
    }
    private void initSquares() {
        squares.add(new Start());
        squares.add(new Building(60,UPGRADE_PRICE_ROW_1));
        squares.add(new StudentCash());
        squares.add(new Building(60,UPGRADE_PRICE_ROW_1));
        squares.add(new Payment(200));
        squares.add(new Parking(200));
        squares.add(new Building(100,UPGRADE_PRICE_ROW_1));
        squares.add(new Chance());
        squares.add(new Building(100,UPGRADE_PRICE_ROW_1));
        squares.add(new Building(120,UPGRADE_PRICE_ROW_1));
        squares.add(new Dante());
        squares.add(new Building(140, UPGRADE_PRICE_ROW_2));
        squares.add(new SportsVenue(150));
        squares.add(new Building(140,UPGRADE_PRICE_ROW_2));
        squares.add(new Building(160,UPGRADE_PRICE_ROW_2));
        squares.add(new Parking(200));
        squares.add(new Building(180,UPGRADE_PRICE_ROW_2));
        squares.add(new StudentCash());
        squares.add(new Building(180,UPGRADE_PRICE_ROW_2));
        squares.add(new Building(200,UPGRADE_PRICE_ROW_2));
        squares.add(new Library());
        squares.add(new Building(220,UPGRADE_PRICE_ROW_3));
        squares.add(new Chance());
        squares.add(new Building(220,UPGRADE_PRICE_ROW_3));
        squares.add(new Building(240,UPGRADE_PRICE_ROW_3));
        squares.add(new Parking(200));
        squares.add(new Building(260,UPGRADE_PRICE_ROW_3));
        squares.add(new Building(260,UPGRADE_PRICE_ROW_3));
        squares.add(new SportsVenue(150));
        squares.add(new Building(280,UPGRADE_PRICE_ROW_3));
        squares.add(new GoToDante());
        squares.add(new Building(300,UPGRADE_PRICE_ROW_4));
        squares.add(new Building(300,UPGRADE_PRICE_ROW_4));
        squares.add(new StudentCash());
        squares.add(new Building(320,UPGRADE_PRICE_ROW_4));
        squares.add(new Parking(200));
        squares.add(new Chance());
        squares.add(new Building(350,UPGRADE_PRICE_ROW_4));
        squares.add(new Payment(100));
        squares.add(new Building(400,UPGRADE_PRICE_ROW_4));
    }
}
