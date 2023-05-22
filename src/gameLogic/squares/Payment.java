package gameLogic.squares;

import gameLogic.Action;
import gameLogic.Square;

public class Payment implements Square {
    private int payment;
    public Payment(int payment) {
        this.payment=payment;
    }

    public Action doAction()
    {
        return new Action('a',1);
    }
}
