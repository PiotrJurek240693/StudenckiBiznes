package gameLogic.cards;

import gameLogic.Player;

public class Card_Scholarship implements Card
{
    // Daje graczowi gotowke
    public void takeAction(Player player)
    {
        player.giveMoney(SCHOLARSHIP_VALUE);
    }
}
