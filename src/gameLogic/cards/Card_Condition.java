package gameLogic.cards;

import gameLogic.Player;

public class Card_Condition implements Card
{
    // Zabiera graczowi gotowke
    public void takeAction(Player player)
    {
        player.takeMoney(CONDITION_VALUE);
    }
}
