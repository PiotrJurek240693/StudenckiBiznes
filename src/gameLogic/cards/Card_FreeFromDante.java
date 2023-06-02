package gameLogic.cards;

import gameLogic.Player;

public class Card_FreeFromDante implements Card
{
    // Karta pozwala wyjsc z dante (wiezienia) po tym jak gracz tam trafi
    public void takeAction(Player player)
    {
        player.setCardChanceStatus(true);
        player.setRecentlyGetCardChance(true);
    }
}
