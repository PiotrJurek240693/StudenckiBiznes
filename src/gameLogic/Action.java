package gameLogic;

public class Action {
//TODO: ustandaryzować co oznacza jaka akcja
    private char type;//p-player, b-board, c-cards, e-error
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
