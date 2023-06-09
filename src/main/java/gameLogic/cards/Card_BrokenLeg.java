package gameLogic.cards;

import gameLogic.Player;

public class Card_BrokenLeg implements Card
{
    private final static String name = "Card_BrokenLeg";

    // Gracz podczas kolejnego ruchu rzuca tylko jedna koscia
    public void takeAction(Player player)
    {
        player.setHowManyDicesToThrow(ONE_DICE);
    }

    @Override
    public String getName() {
        return name;
    }
}
