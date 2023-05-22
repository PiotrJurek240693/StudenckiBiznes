package gameLogic.squares;

import gameLogic.Action;

public class SportsVenue extends Property{
    public SportsVenue(int price) {
        this.price=price;
        this.payment=0;
    }

    public Action doAction()
    {
        return new Action('e',-1);
    }
}
