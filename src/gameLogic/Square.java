package gameLogic;

public class Square {

    private int type;
    private String name;
    protected int fee;

    public Square(String name,int type,int fee)
    {
        this.name=name;
        this.type=type;
        this.fee=fee;
    }
}
