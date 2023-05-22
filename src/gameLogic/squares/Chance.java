package gameLogic.squares;

import gameLogic.Action;
import gameLogic.Square;

public class Chance implements Square {
    public Action doAction()
    {
        return new Action('e',-1);
    }
}
