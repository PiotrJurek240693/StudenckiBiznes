package gameLogic.squares;

import gameLogic.Action;
import gameLogic.Square;

public class GoToDante implements Square {
    public Action doAction()
    {
        return new Action('e',-1);
    }
}
