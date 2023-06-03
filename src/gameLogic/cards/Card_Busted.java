package gameLogic.cards;

import gameLogic.Game;
import gameLogic.Player;

import java.util.ArrayList;

public class Card_Busted implements Card
{
    // Gracz ktory dobral te karte moze wyslac innego gracza do dante (wiezienia) na jedna kolejke
    public void takeAction(Player player)
    {
        Player sendToDante;
        ArrayList<Player> toChooseFrom = new ArrayList<>();
        for(Player current : Game.getPlayers())
            if(current!=player)
                toChooseFrom.add(current);
        sendToDante = Game.choosePlayer(toChooseFrom);
        sendToDante.setDanteDuration(BUSTED_ROUNDS);
    }
}
