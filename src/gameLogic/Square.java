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

}
