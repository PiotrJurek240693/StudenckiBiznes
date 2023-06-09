package gameLogic.cards;

import gameLogic.Player;

public class Card_Condition implements Card
{
    private final static String name = "Card_Condition";

    // Zabiera graczowi gotowke
    public void takeAction(Player player)
    {
        player.takeMoney(CONDITION_VALUE);
    }

    @Override
    public String getName() {
        return name;
    }
}
