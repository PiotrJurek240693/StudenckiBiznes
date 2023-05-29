package gameLogic.cards;

import gameLogic.Game;
import gameLogic.GameInfo;
import gameLogic.Player;

import java.lang.reflect.Array;
import java.util.List;

public class Card_Birthday implements Card
{
    // Wszyscy gracze idą na pole DARMOWA HERBATA W BIBLIOTECE
    // i każdy ze studentów daje po 20m$. Nie otrzymują pieniędzy za przejście przez start
    public void takeAction(Player player)
    {
        int money = 0;
        for(Player current : Game.getPlayers())
        {
            current.setPosition(GameInfo.NUMBER_OF_SQUARES + LIBRARY_TEA_SQUARE - current.getPosition());
            current.takeMoney(GameInfo.START_SQUARE_ADDITION);   // Poniewaz gracz zawsze przechodzi przez pole startowe
            if(current!=player)
                money += current.takeMoney(LIBRARY_TEA_SQUARE_VALUE);
        }
        player.giveMoney(money);
    }
}
