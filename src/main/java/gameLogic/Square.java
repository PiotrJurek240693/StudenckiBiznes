package gameLogic;

import java.io.Serializable;

import static gameLogic.TypesOfSqueres.*;

public class Square implements Serializable {

    protected TypesOfSqueres type;
    protected String name;
    protected int fee;



    public TypesOfSqueres getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getFee() {
        return fee;
    }

    public boolean isSpecial()
    {
        if(type==DANTE||type==LIBRARY||type==DANTE_AGAIN)
        {
            return true;
        }
        return false;
    }
    public boolean isProperty()
    {
        if(type==INSTITUTE||type==PARKING||type== SPORT_VENUE)
        {
            return true;
        }
        return false;
    }
    public boolean isCards()
    {
        if(type==CHANCE||type==STUDENT_CASH)
        {
            return true;
        }
        return false;
    }

    public Square(String name,TypesOfSqueres type,int fee)
    {
        this.name=name;
        this.type=type;
        this.fee=fee;
    }

    public void standOn(Player player) {
        if(this instanceof Property property){
            if(property.getOwner() == null){
                player.makeDecision(DecisionType.Buy);
            }
            else if(property.getOwner() != player){
                if(player.checkIfCanTakeMoneyWithoutBankrupt(property.getStopPrice())) {
                    player.makeDecision(DecisionType.PayForStop);
                }
                else {
                    property.getOwner().giveMoney(player.giveEverythingAndBankrupt());
                    player.makeDecision(DecisionType.Bankrupt);
                }
            }
            return;
        }
        switch (type) {
            case CHANCE, STUDENT_CASH -> player.makeDecision(DecisionType.DrawCard);
            case DANTE_AGAIN -> {
                player.setDanteDuration(3);
                player.makeDecision(DecisionType.GoToDante);
            }
            case FAILED_SUBIECT_FEE, STUDENT_CARD -> player.makeDecision(DecisionType.PayToBank);
            default -> Game.conditionalEndRound();
        }
    }
}
