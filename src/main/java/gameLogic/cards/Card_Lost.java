package gameLogic.cards;

import gameLogic.GameInfo;
import gameLogic.Player;

public class Card_Lost implements Card
{
    // Karta zabiera gracza na pole startowe i nie daje mu gotowki za jego przejscie
    public void takeAction(Player player)
    {
        player.unconditionalMove(GameInfo.START_SQUARE_INDEX);
    }
}
