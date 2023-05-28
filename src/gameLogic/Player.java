package gameLogic;

public class Player {
    private int moneyAmount = GameInfo.START_VALUE;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private final Pawn pawn = new Pawn();
    private boolean isCardChance = false;
    private boolean isCardKasaStudencka = false;
    private boolean hasErasmus = false;
    private boolean hasElectricDeficiency = false;
    private boolean throwTwoDices = true;



    public int setPosition(int shift)
    {
        int value;
        value = pawn.move(shift);
        if(value==0)
            return 0;
        moneyAmount += value;
        return 1;
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
        inDante += numberOfRounds;
    }

    public void setInBankrupt(){isBankrupt = true;}

    public void giveMoney(int amount)
    {
        moneyAmount += amount;
    }

    public void takeMoney(int amount)
    {
        // TODO: rozwiązanie konfliktu z Property
    }

    public boolean isCardChance()
    {
        return isCardChance;
    }

    public void setCardChance(boolean cardChance)
    {
        isCardChance = cardChance;
    }

    public boolean isCardKasaStudencka()
    {
        return isCardKasaStudencka;
    }

    public void setCardKasaStudencka(boolean cardKasaStudencka)
    {
        isCardKasaStudencka = cardKasaStudencka;
    }

    public boolean isHasErasmus()
    {
        return hasErasmus;
    }

    public void setHasErasmus(boolean hasErasmus)
    {
        this.hasErasmus = hasErasmus;
    }

    public boolean isHasElectricDeficiency()
    {
        return hasElectricDeficiency;
    }

    public void setHasElectricDeficiency(boolean hasElectricDeficiency)
    {
        this.hasElectricDeficiency = hasElectricDeficiency;
    }

    public boolean isThrowTwoDices()
    {
        return throwTwoDices;
    }

    public void setThrowTwoDices(boolean throwTwoDices)
    {
        this.throwTwoDices = throwTwoDices;
    }
}
