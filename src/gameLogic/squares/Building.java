package gameLogic.squares;

import gameLogic.Action;

public class Building extends Property {
    private int upgradePrice;
    public Building(int price, int upgradePrice) {
        this.price=price;
        this.upgradePrice=upgradePrice;
        this.payment=0;
    }

    public Action doAction()
    {
        return new Action('a',1);
    }
}
