package gameLogic;

public class Property extends Square {
    public static final int NO_ONE = -1;
    private int price;
    private int upgradePrice;
    private int ownerIndex;
    private boolean mortgaged;

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
        calculateNewFee();
    }

    // TODO: dodać metody liczące ceny zastawienia i odkupienia zastawienia

    public int getUpgrades() {
        return upgrades;
    }

    public void upgrade() {
        upgrades++;
        calculateNewFee();
    }

    private int upgrades;

    public int getOwnerIndex() {
        return ownerIndex;
    }

    public void setOwnerIndex(int ownerIndex) {
        this.ownerIndex = ownerIndex;
        if(ownerIndex==NO_ONE) {
            upgrades=0;
            mortgaged =false;
        }
        calculateNewFee();
    }

    public Property(String name,int type, int price, int upgradePrice)
    {
        super(name, type, 0);
        this.price=price;
        this.upgradePrice=upgradePrice;
        ownerIndex = NO_ONE;
        upgrades=0;
        mortgaged=false;
    }
    private void calculateNewFee()
    {
        // TODO: zrobić wyliczenie ceny względem upgrades

        price=0;
    }


}
