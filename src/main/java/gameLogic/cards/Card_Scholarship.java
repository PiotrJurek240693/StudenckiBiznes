package gameLogic.cards;

import gameLogic.Player;

public class Card_Scholarship implements Card
{
    private final static String name = "Card_Scholarship";

    // Daje graczowi gotowke
    public void takeAction(Player player)
    {
        player.giveMoney(SCHOLARSHIP_VALUE);
    }

    @Override
    public String getName() {
        return name;
    }
}
