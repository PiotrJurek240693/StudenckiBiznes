package gameLogic.squares;

import gameLogic.Action;
import gameLogic.Square;

public class Start implements Square {
    public Action doAction()
    {
        return new Action('e',-1);
    }
}
