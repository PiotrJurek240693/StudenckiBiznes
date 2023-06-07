package gui;

import gameLogic.DecisionType;
import gameLogic.Game;
import gameLogic.GameInfo;
import gameLogic.Player;

public class DecisionButtonsController {
    public static void onStartGameButtonClick() {
        Game.start();
        PlayersInfoShower.showPlayersInfo();
        ActivePlayerInfoShower.showActivePlayerInfo();
        PawnsShower.showPawns();
        Game.getActivePlayer().makeDecision(DecisionType.RoundStart);
    }

    public static void onDicesButtonClick() {
        Player player = Game.getActivePlayer();
        player.rollDices();
        player.conditionalMove();
        DicesShower.showDices(player.getDices());
        PawnsShower.showPawns();
        ActivePlayerInfoShower.showActivePlayerInfo();
        PlayersInfoShower.showPlayersInfo();
        Game.evaluateActivePlayerPosition();
    }

    public static void onBuyButtonClick() {
        Game.activePlayerBuyProperty();
        Game.conditionalEndRound();
        PlayersInfoShower.showPlayersInfo();
        PropertyIconsShower.showPropertyIcons();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }

    public static void onSkipBuyingButtonClick() {
        Game.conditionalEndRound();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }

    public static void onGoToDanteOkButtonClick() {
        Game.getActivePlayer().unconditionalMove(GameInfo.DANTE_SQUARE_INDEX);;
        Game.conditionalNextRound();
        PawnsShower.showPawns();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }

    public static void onDicesInDanteButtonClick() {
        Player player = Game.getActivePlayer();
        player.rollDices();
        DicesShower.showDices(player.getDices());
        if(player.checkDoubles()){
            player.setDanteDuration(0);
            player.makeDecision(DecisionType.RoundStart);
        }
        else{
            player.setDanteDuration(player.getInDante() - 1);
            player.makeDecision(DecisionType.EndRound);
        }
    }

    public static void onPayInDanteButtonClick() {
        Player player = Game.getActivePlayer();
        player.takeMoney(GameInfo.LEAVE_DANTE_PAY);
        player.setDanteDuration(0);
        PlayersInfoShower.showPlayersInfo();
        player.makeDecision(DecisionType.RoundStart);
    }

    public static void onUseCardInDanteButtonClick() {
        Player player = Game.getActivePlayer();
        player.setCardChanceStatus(false);
        player.setDanteDuration(0);
        player.makeDecision(DecisionType.RoundStart);
    }

    public static void onEndTurnOkButtonClick() {
        Game.conditionalNextRound();
        ActivePlayerInfoShower.showActivePlayerInfo();
    }
}
