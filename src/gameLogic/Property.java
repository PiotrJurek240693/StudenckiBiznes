package gameLogic;

public class Property extends Square {
    public static final int NO_ONE = -1;
    private int price;
    private int upgradePrice;
    private int ownerID;
    private int upgrades;


    public Property(String name,int type, int price, int upgradePrice)
    {
        super(name, type, 0);
        this.price=price;
        this.upgradePrice=upgradePrice;
        ownerID= NO_ONE;
        upgrades=0;
    }
    private void calculateNewPrice()
    {
        // TODO: zrobić wyliczenie ceny względem upgrades

        price=0;
    }


}
