package gameLogic.cards;

import gameLogic.Player;

public class Card_FoundMoney implements Card
{
    //
    public void takeAction(Player player)
    {
        player.giveMoney(MONEY_FOUND_VALUE);
    }
}
