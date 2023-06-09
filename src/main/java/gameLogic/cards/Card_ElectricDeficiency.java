package gameLogic.cards;

import gameLogic.Player;

public class Card_ElectricDeficiency implements Card
{
    private final static String name = "Card_ElectricDeficiency";

    // Karta sprawia, ze przez jedna kolejke gracz nie pobiera oplat za swoje pola
    public void takeAction(Player player)
    {
        player.setElectricDeficiencyStatus(true);
    }

    @Override
    public String getName() {
        return name;
    }
}
