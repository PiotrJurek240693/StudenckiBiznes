package gameLogic.cards;

import gameLogic.Player;

public interface Card
{
    public String getName();
    public String getDescription();
    public void takeAction(Player player);
}
