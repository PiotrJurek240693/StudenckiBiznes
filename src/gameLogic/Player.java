package gameLogic;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int playerIndex = Game.getPlayers().size();
    private final Pawn pawn = new Pawn();
    private int moneyAmount = GameInfo.START_VALUE;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private boolean isCardChance = false;

    public boolean hasRecentlyGetCardChance() {
        return hasRecentlyGetCardChance;
    }

    public void setRecentlyGetCardChance(boolean hasRecentlyGetCardChance) {
        this.hasRecentlyGetCardChance = hasRecentlyGetCardChance;
    }

    private boolean hasRecentlyGetCardChance = false;
    private boolean hasErasmus = false;
    private boolean hasElectricDeficiency = false;
    private int howManyDicesToThrow = GameInfo.INITIAL_NUMBER_OF_DICES;





    public int valueOfProperties(List<Property> properties)
    {
        int suma = GameInfo.NONE;
        for(Property temp : properties)
            suma += temp.valueOfProperty();

        return suma;
    }


    public List<Property> ownedProperties()
    {
        List<Property> tempList = new ArrayList<>();
        for(Square square : Game.getBoard().getSquares())
            if(square instanceof Property temp && temp.getOwnerIndex()==playerIndex)
                tempList.add(temp);

        return tempList;
    }


    public void setPosition(int shift)
    {
        int value;
        value = pawn.move(shift);
        moneyAmount += value;
    }



    public int takeMoney(int amount)
    {
        if(!checkIfCanTakeMoney(amount))
        {
            for(Property property : ownedProperties())
                property.sellProperty();
            setInBankrupt();
            return moneyAmount;
        }

        Property property;

        while(amount>moneyAmount)
        {
            property = Game.chooseProperty( ownedProperties(), amount-moneyAmount );
            moneyAmount += property.sellProperty();
        }

        moneyAmount -= amount;

        return amount;
    }



    public void unconditionalMove(int squareNumber)
    {
        pawn.getToSquare(squareNumber);
    }


    public int getPlayerIndex()
    {
        return playerIndex;
    }

    public boolean checkIfCanTakeMoney(int amount)
    {
        return valueOfProperties( ownedProperties() ) + getMoneyAmount() < amount; // True jezeli mozna zabrac gotowke bez bankructwa
    }
    public int getDices()
    {
        return howManyDicesToThrow;
    }

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
        pawn.getToSquare(GameInfo.DANTE_SQUARE_INDEX);
        inDante += numberOfRounds;
    }

    public void setInBankrupt(){isBankrupt = true;}

    public void giveMoney(int amount)
    {
        moneyAmount += amount;
    }

    public boolean isCardChance()
    {
        return isCardChance;
    }

    public void setCardChance(boolean cardChance)
    {
        isCardChance = cardChance;
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

    public int getHowManyDicesToThrow()
    {
        return howManyDicesToThrow;
    }

    public void setHowManyDicesToThrow(int howManyDicesToThrow)
    {
        this.howManyDicesToThrow = howManyDicesToThrow;
    }
    public int getMoneyAmount()
    {
        return moneyAmount;
    }
}
