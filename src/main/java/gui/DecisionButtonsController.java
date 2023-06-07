package gui;

import gameLogic.Game;
import gameLogic.Player;

public class DecisionButtonsController {
    public static void onStartGameButtonClick() {
        Game.start();
        PlayersInfoShower.showPlayersInfo();
        DecisionButtonsShower.showRoundStartDecisionButtons();
        PawnsShower.showPawns();
    }

    public static void onDicesButtonClick() {
        Player player = Game.getActivePlayer();
        while(player.getInDante() > 0){
            Game.nextRound();
            player = Game.getActivePlayer();
        }
        player.rollDices();
        player.conditionalMove();
        DicesShower.showDices(player.getDices());
        PawnsShower.showPawns();
        PlayersInfoShower.showPlayersInfo();
        if(!player.checkDoubles() || player.getInDante() > 0) {
            Game.nextRound();
        }
    }
}
