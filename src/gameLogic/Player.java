package gameLogic;

public class Player {
    private int moneyAmount = 0;
    private Pawn pawn;
    // TODO: (gameLogic) zrobić klasę Player. Aktualną można usunąć lub przebudować
    public void setPosition(int shift)
    {
        moneyAmount += pawn.move(shift);
    }
    public int getDices(){return 2;}
    public int getPosition(){return 0;}
}
