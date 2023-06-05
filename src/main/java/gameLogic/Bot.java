package gameLogic;

import java.io.Serializable;

public class Bot extends Player implements Serializable {

    public Bot(String nick, PawnColor color) {
        super(nick, color);
    }
}
