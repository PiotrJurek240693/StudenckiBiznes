package gameLogic.cards;

import gameLogic.Player;

public class Card_Busted implements Card
{
    // Gracz ktory dobral te karte moze wyslac innego gracza do dante (wiezienia) na jedna kolejke
    public void takeAction(Player player)
    {
        Player toDante = null;
        // TODO: Wybieranie innego studenta
        toDante.setInDante(BUSTED_ROUNDS);
    }
}
