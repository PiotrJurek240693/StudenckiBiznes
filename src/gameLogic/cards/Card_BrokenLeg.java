package gameLogic.cards;

import gameLogic.Player;

public class Card_BrokenLeg implements Card
{
    // Gracz podczas kolejnego ruchu rzuca tylko jedna koscia
    public void takeAction(Player player)
    {
        player.setThrowTwoDices(false);
    }
}
