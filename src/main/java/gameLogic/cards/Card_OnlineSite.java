package gameLogic.cards;

import gameLogic.Player;

public class Card_OnlineSite implements Card
{
    private final static String name = "Card_OnlineSite";

    // Daje graczowi gotowke
    public void takeAction(Player player)
    {
        player.giveMoney(ONLINE_SITE_VALUE);
    }

    @Override
    public String getName() {
        return name;
    }
}
