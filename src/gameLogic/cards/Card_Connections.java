package gameLogic.cards;

import gameLogic.Player;

public class Card_Connections implements Card
{
    // Karta zmniejsza kolejny pobyt w dante (wiezieniu) o jedna ture
    public void takeAction(Player player)
    {
        player.setDanteDuration(DANTE_RELIEF);
    }
}
