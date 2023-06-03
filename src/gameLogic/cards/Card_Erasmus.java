package gameLogic.cards;

import gameLogic.Player;

public class Card_Erasmus implements Card
{
    // Gracz dzieki tej fladze nie bedzie musial placic innym graczom podczas pobytu na ich polu
    public void takeAction(Player player)
    {
        player.setOnErasmus(true);
    }
}
