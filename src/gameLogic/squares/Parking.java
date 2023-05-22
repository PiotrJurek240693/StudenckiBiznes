package gameLogic.squares;

import gameLogic.Action;

public class Parking extends Property {
    public Parking(int price) {
        this.price=price;
        this.payment=0;
    }

    public Action doAction()
    {
        return new Action('a',1);
    }
}
