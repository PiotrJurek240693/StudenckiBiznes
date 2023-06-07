package gameLogic;

import java.io.Serializable;

import static gameLogic.TypesOfSqueres.*;

public class Square implements Serializable {

    private TypesOfSqueres type;
    private String name;
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
        if(type==INSTITUTE||type==PARKING||type==CATHEDRAL||type==SPORT_VANUE)
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
                return;
            }
            else{
                //player.makeDecision(DecisionType.Pay);
            }
        }
        switch (type) {
            //case CHANCE, STUDENT_CASH -> player.makeDecision(DecisionType.DrawCard);
            case DANTE_AGAIN -> {
                player.setDanteDuration(3);
                player.makeDecision(DecisionType.GoToDante);
            }
            //case FAILED_SUBIECT_FEE, STUDENT_CARD -> player.makeDecision(DecisionType.PayToBank);
            default -> Game.conditionalEndRound();
        }
    }
}
