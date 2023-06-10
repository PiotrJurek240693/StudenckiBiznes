package gameLogic.cards;

import gameLogic.GameInfo;
import gameLogic.Player;

public class Card_Connections implements Card
{
    private final static String name = "Card_Connections";
    private final static boolean decisionNeeded = false;

    // Karta zmniejsza kolejny pobyt w dante (wiezieniu) o jedna ture
    @Override
    public void takeAction(Player player)
    {
        player.changeDanteDuration(DANTE_RELIEF);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDecisionNeeded() {
        return decisionNeeded;
    }
}
