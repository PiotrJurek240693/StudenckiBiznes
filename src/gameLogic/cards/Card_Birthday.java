package gameLogic.cards;

import gameLogic.Game;
import gameLogic.GameInfo;
import gameLogic.Player;


public class Card_Birthday implements Card
{
    // Wszyscy gracze idą na pole DARMOWA HERBATA W BIBLIOTECE
    // i każdy ze studentów daje po 20m$. Nie otrzymują pieniędzy za przejście przez start
    public void takeAction(Player player)
    {
        int money = GameInfo.NONE;
        for(Player current : Game.getPlayers())
        {
            current.unconditionalMove(LIBRARY_TEA_SQUARE);
            if(current!=player)
                money += current.takeMoney(LIBRARY_TEA_SQUARE_VALUE);
        }
        player.giveMoney(money);
    }
}
