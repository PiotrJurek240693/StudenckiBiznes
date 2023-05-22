package gameLogic.squares;

import gameLogic.Square;

public abstract class Property implements Square {
    protected int price;
    protected int payment;

    public int getPrice() {
        return price;
    }

    public int getPayment() {
        return payment;
    }


}
