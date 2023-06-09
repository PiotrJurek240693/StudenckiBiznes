package gui;

import connection.InfoSender;
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
        InfoSender.sendInfo();
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
        InfoSender.sendInfo();
    }

    public static void onBuyButtonClick() {
        Game.activePlayerBuyProperty();
        Game.conditionalEndRound();
        PlayersInfoShower.showPlayersInfo();
        PropertyIconsShower.showPropertyIcons();
        ActivePlayerInfoShower.showActivePlayerInfo();
        InfoSender.sendInfo();
    }

    public static void onSkipBuyingButtonClick() {
        Game.conditionalEndRound();
        ActivePlayerInfoShower.showActivePlayerInfo();
        InfoSender.sendInfo();
    }

    public static void onGoToDanteOkButtonClick() {
        Game.getActivePlayer().unconditionalMove(GameInfo.DANTE_SQUARE_INDEX);;
        Game.conditionalNextRound();
        PawnsShower.showPawns();
        ActivePlayerInfoShower.showActivePlayerInfo();
        InfoSender.sendInfo();
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
        InfoSender.sendInfo();
    }

    public static void onPayInDanteButtonClick() {
        Player player = Game.getActivePlayer();
        player.takeMoney(GameInfo.LEAVE_DANTE_PAY);
        player.setDanteDuration(0);
        PlayersInfoShower.showPlayersInfo();
        player.makeDecision(DecisionType.RoundStart);
        InfoSender.sendInfo();
    }

    public static void onUseCardInDanteButtonClick() {
        Player player = Game.getActivePlayer();
        player.setCardChanceStatus(false);
        player.setDanteDuration(0);
        player.makeDecision(DecisionType.RoundStart);
        InfoSender.sendInfo();
    }

    public static void onEndTurnOkButtonClick() {
        DecisionButtonsShower.removeDecisionButtons();
        Game.conditionalNextRound();
        ActivePlayerInfoShower.showActivePlayerInfo();
        InfoSender.sendInfo();
    }

    public static void onActivateSellModeButtonClick() {
        BoardShower.setMode(BoardMode.Sell);
        DecisionButtonsShower.showBackToInfoModeButton();
    }

    public static void onActivateUpgradeModeButtonClick() {
        BoardShower.setMode(BoardMode.Upgrade);
        DecisionButtonsShower.showBackToInfoModeButton();
    }

    public static void onBackToInfoModeButtonClick() {
        BoardShower.setMode(BoardMode.Info);
        DecisionButtonsShower.removeBackToInfoModeButton();
    }

    public static void onActivateNeedToSellModeButtonClick(Player payer, Player receiver, int amount) {
        BoardShower.setMode(BoardMode.Sell);
        DecisionButtonsShower.showBackToPaymentButton(payer, receiver, amount);
    }

    public static void onBackToPaymentButtonClick(Player payer, Player receiver, int amount) {
        BoardShower.setMode(BoardMode.Info);
        DecisionButtonsShower.showPayDecisionButtons(payer, receiver, amount);
        DecisionButtonsShower.removeBackToInfoModeButton();
    }

    public static void onPayToPlayerButtonClick(Player payer, Player receiver, int amount) {
        Game.pay(payer, receiver, amount);
        PlayersInfoShower.showPlayersInfo();
        Game.conditionalEndRound();
        InfoSender.sendInfo();
    }

    public static void onBankruptOkButtonClick() {
        PlayersInfoShower.showPlayersInfo();
        PropertyIconsShower.showPropertyIcons();
        PawnsShower.showPawns();
        Player winner = Game.checkWinner();
        if(winner != null){
            winner.makeDecision(DecisionType.Win);
        }
        else{
            Game.conditionalNextRound();
        }
        ActivePlayerInfoShower.showActivePlayerInfo();
        InfoSender.sendInfo();
    }

    public static void onEndGameButtonClick() {
        MenuShower.showMainMenu();
    }
}
