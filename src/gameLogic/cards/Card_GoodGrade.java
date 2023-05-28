package gameLogic.cards;

import gameLogic.Player;

public class Card_GoodGrade implements Card
{
    // karta przesuwa gracza o dowolna wartosc od -3 do 3
    public void takeAction(Player player)
    {
        int shift = 0;
        // TODO: pobranie wartosci od gracza
        player.setPosition(shift);
    }
}
