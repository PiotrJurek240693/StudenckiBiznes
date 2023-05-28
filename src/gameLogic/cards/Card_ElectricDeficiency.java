package gameLogic.cards;

import gameLogic.Player;

public class Card_ElectricDeficiency implements Card
{
    // Karta sprawia, ze przez jedna kolejke gracz nie pobiera oplat za swoje pola
    public void takeAction(Player player)
    {
        player.setHasElectricDeficiency(true);
    }
}
