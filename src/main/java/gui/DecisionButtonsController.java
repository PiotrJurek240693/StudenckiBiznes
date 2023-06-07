package gui;

import gameLogic.DecisionType;
import gameLogic.Game;
import gameLogic.Player;

public class DecisionButtonsController {
    public static void onStartGameButtonClick() {
        Game.start();
        PlayersInfoShower.showPlayersInfo();
        DecisionButtonsShower.showRoundStartDecisionButtons();
        ActivePlayerInfoShower.showActivePlayerInfo();
        PawnsShower.showPawns();
    }

    public static void onDicesButtonClick() {
        Player player = Game.getActivePlayer();
       /* while(player.getInDante() > 0){
            Game.nextRound();
            player = Game.getActivePlayer();
        }*/
        player.rollDices();
        player.conditionalMove();
        DicesShower.showDices(player.getDices());
        PawnsShower.showPawns();
        ActivePlayerInfoShower.showActivePlayerInfo();
        PlayersInfoShower.showPlayersInfo();
        Game.evaluateActivePlayerPosition();
        /*if(!player.checkDoubles() || player.getInDante() > 0) {
            Game.nextRound();
        }*/
    }

    public static void onBuyButtonClick() {
        Game.activePlayerBuyProperty();
        Player player = Game.getActivePlayer();
        Game.conditionalNextRound();
        PlayersInfoShower.showPlayersInfo();
        PropertyIconsShower.showPropertyIcons();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }

    public static void onSkipBuyingButtonClick() {
        Player player = Game.getActivePlayer();
        Game.conditionalNextRound();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }
}
