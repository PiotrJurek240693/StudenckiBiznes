package gameLogic;

public class Player {
    private int moneyAmount = 1600;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private final Pawn pawn = new Pawn();



    public void setPosition(int shift)
    {
        moneyAmount += pawn.move(shift);
    }
    public int getDices(){return 2;}
    public int getPosition(){return pawn.getPosition();}
    public int getInDante()
    {
        return inDante;
    }
    public boolean isBankrupt()
    {
        return isBankrupt;
    }
    public void setInDante(int numberOfRounds)
    {
        inDante = numberOfRounds;
    }
    public void setInBankrupt(){isBankrupt = true;}


}
