package gameLogic.cards;

import gameLogic.Player;

public class Card_OnlineSite implements Card
{
    // Daje graczowi gotowke
    public void takeAction(Player player)
    {
        player.giveMoney(ONLINE_SITE_VALUE);
    }
}
