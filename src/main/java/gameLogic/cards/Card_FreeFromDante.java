package gameLogic.cards;

import gameLogic.Player;

public class Card_FreeFromDante implements Card
{
    private final static String name = "Card_FreeFromDante";

    // Karta pozwala wyjsc z dante (wiezienia) po tym jak gracz tam trafi
    public void takeAction(Player player)
    {
        player.setCardChanceStatus(true);
    }

    @Override
    public String getName() {
        return name;
    }
}
