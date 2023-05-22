package gameLogic;

public class Action {

    private char type;//p-player, b-board, c-cards,
    private int action;

    public Action(char type,int action)
    {
        this.action=action;
        this.type=type;
    }

    public char getType() {
        return type;
    }

    public int getAction() {
        return action;
    }
}
