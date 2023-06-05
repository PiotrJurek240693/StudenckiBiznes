package gameLogic.cards;

import gameLogic.Player;

public class Card_CrossingRedLight implements Card
{
    // karta zabiera graczowi 100 pe-elenów
    public void takeAction(Player player)
    {
        player.takeMoney(CROSSING_RED_LIGHT_VALUE);
    }
}
