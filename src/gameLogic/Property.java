package gameLogic;

public class Property extends Square {
    public static final int NO_ONE = -1;
    private int price;
    private int upgradePrice;
    private int ownerIndex;
    private boolean mortgaged;
    private int upgrades;
    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
        calculateNewFee();
    }

    public int mortgagePrice()
    {
        return (int) 0.5 * price;
    }
    public int mortgageFee()
    {
        return (int) 0.55 * price;
    }

    public int getUpgrades() {
        return upgrades;
    }

    public void upgrade() {
        upgrades++;
        calculateNewFee();
    }

    public int getUpgradePrice() {
        return upgradePrice;
    }

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

    public Property(String name,TypesOfSqueres type, int price, int upgradePrice)
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
        if(mortgaged) {
            fee=0;
        } else if (ownerIndex==NO_ONE) {
            fee=0;
        } else if (upgrades==0) {
            fee=(int) 0.1 * price;
        } else {
            fee=upgrades*price;
        }

    }


}
