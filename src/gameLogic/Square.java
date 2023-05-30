package gameLogic;

public class Square {

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
        if(type==TypesOfSqueres.DANTE||type==TypesOfSqueres.LIBRARY||type==TypesOfSqueres.DANTE_AGAIN)
        {
            return true;
        }
        return false;
    }
    public boolean isProperty()
    {
        if(type==TypesOfSqueres.INSTITUTE||type==TypesOfSqueres.PARKING||type==TypesOfSqueres.CATHEDRAL||type==TypesOfSqueres.SPORT_VANUE)
        {
            return true;
        }
        return false;
    }
    public boolean isCards()
    {
        if(type==TypesOfSqueres.CHANCE||type==TypesOfSqueres.STUDENT_CASH)
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
