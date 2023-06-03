package gameLogic;

import java.io.Serializable;

public class Property extends Square implements Serializable {
    public static final int MAX_UPGRADE = 5;
    private int price;
    private int upgradePrice;
    private Player owner;
    private boolean mortgaged;
    private int upgrades;

    public boolean isMortgaged() {
        return mortgaged;
    }

    private int faculty;

    public int getFaculty() {
        return faculty;
    }

    // TODO: gra aktualnie obsługuje sprzedawanie pól a nie ich zastawianie. jak starczy czasu należy to zmienić
    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
        calculateNewFee();
    }

    public int mortgagePrice() {
        return (int) (0.5 * price);
    }

    public int mortgageFee() {
        return (int) (0.55 * price);
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
        if (owner == null) {
            upgrades = 0;
            mortgaged = false;
        }
        calculateNewFee();
    }

    public Property(String name, TypesOfSqueres type, int price, int upgradePrice, int faculty) {
        super(name, type, 0);
        this.price = price;
        this.upgradePrice = upgradePrice;
        owner = null;
        upgrades = 0;
        mortgaged = false;
        this.faculty = faculty;
    }

    private void calculateNewFee() {
        if (mortgaged) {
            fee = 0;
        } else if (owner == null) {
            fee = 0;
        } else if (upgrades == 0) {
            fee = (int) (0.1 * price);
        } else {
            fee = upgrades * price;
        }

    }

    public int valueOfProperty() {
        // TODO: upewnić się jak ma działać funkcja. aktualnie uwzględnia 50% wartość terenu+ulepszeń
        int sum = (upgradePrice * upgrades + price) / 2;
        return sum;
    }

    public void cleanProperty() {
        fee = 0;
        owner = null;
        upgrades = 0;
        mortgaged = false;
    }

    public int sellProperty() {
        int value = valueOfProperty();
        cleanProperty();
        return value;
    }

    public boolean hasAuditorium() {
        if (upgrades == MAX_UPGRADE)
            return true;
        return false;
    }

    public void destroyAuditorium() {
        if (upgrades == MAX_UPGRADE) {
            upgrades = 4;
        }
    }


}
