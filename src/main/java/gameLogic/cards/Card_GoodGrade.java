package gameLogic.cards;

import gameLogic.Game;
import gameLogic.Player;

public class Card_GoodGrade implements Card
{
    private final static String name = "Card_GoodGrade";

    // karta przesuwa gracza o dowolna wartosc od -3 do 3
    public void takeAction(Player player)
    {
        //int shift = Game.chooseNumber();
        //player.setPosition(shift);
    }

    @Override
    public String getName() {
        return name;
    }
}
