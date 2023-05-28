package gameLogic;

public class Square {

    public static final int INSTITUTE = 1;
    public static final int STUDENT_CASH = 2;
    public static final int PARKING = 4;
    public static final int CATHEDRAL = 5;
    public static final int CHANCE = 6;
    public static final int DANTE = 7;
    public static final int SPORT_VANUE = 8;
    public static final int LIBRARY = 9;
    public static final int DANTE_AGAIN = 10;

    private int type;
    private String name;
    protected int fee;

    public int getType() {
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

    public Square(String name,int type,int fee)
    {
        this.name=name;
        this.type=type;
        this.fee=fee;
    }
}
