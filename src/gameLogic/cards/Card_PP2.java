package gameLogic.cards;

import gameLogic.Player;

public class Card_PP2 implements Card
{
    // Karta wysyla gracza na robienie dante (wiezienie) na 2 turyy
    public void takeAction(Player player)
    {
        player.setInDante(DANTE_ROUNDS);
    }
}
