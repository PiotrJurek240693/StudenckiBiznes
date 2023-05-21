package gameLogic;

import gameLogic.squares.*;

import java.util.ArrayList;

public class Board {
    private ArrayList<Square> squares=new ArrayList<Square>();
    public Board()
    {
        initSquares();
    }

    private void initSquares() {
        squares.add(new Start());
        squares.add(new Building());
        squares.add(new StudentCash());
        squares.add(new Building());
        squares.add(new Payment());
        squares.add(new Parking());
        squares.add(new Building());
        squares.add(new Chance());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new Dante());
        squares.add(new Building());
        squares.add(new SportsVenue());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new Parking());
        squares.add(new Building());
        squares.add(new StudentCash());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new Library());
        squares.add(new Building());
        squares.add(new Chance());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new Parking());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new SportsVenue());
        squares.add(new Building());
        squares.add(new GoToDante());
        squares.add(new Building());
        squares.add(new Building());
        squares.add(new StudentCash());
        squares.add(new Building());
        squares.add(new Parking());
        squares.add(new Chance());
        squares.add(new Building());
        squares.add(new Payment());
        squares.add(new Building());
    }
}
