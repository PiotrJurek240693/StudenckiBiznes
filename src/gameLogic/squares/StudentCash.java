package gameLogic.squares;

import gameLogic.Action;
import gameLogic.Square;

public class StudentCash implements Square {
    public Action doAction()
    {
        return new Action('a',1);
    }
}
