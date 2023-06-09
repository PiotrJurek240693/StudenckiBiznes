package gameLogic.cards;

import gameLogic.Player;

public class Card_PP2 implements Card
{
    private final static String name = "Card_PP2";

    // Karta wysyla gracza na robienie dante (wiezienie) na 2 turyy
    public void takeAction(Player player)
    {
        player.setDanteDuration(DANTE_ROUNDS);
    }

    @Override
    public String getName() {
        return name;
    }
}
