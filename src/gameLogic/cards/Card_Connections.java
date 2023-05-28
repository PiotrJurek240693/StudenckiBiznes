package gameLogic.cards;

import gameLogic.Player;
import jdk.jfr.DataAmount;

public class Card_Connections implements Card
{
    // Karta zmniejsza kolejny pobyt w dante (wiezieniu) o jedna ture
    public void takeAction(Player player)
    {
        player.setInDante(DANTE_RELIEF);
    }
}
