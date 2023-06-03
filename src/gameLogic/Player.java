package gameLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Player implements Serializable {
    private final Pawn pawn = new Pawn();
    private int moneyAmount = GameInfo.START_VALUE;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private boolean hasCardChance = false;
    private boolean isOnErasmus = false;
    private boolean hasElectricDeficiency = false;
    private int howManyDicesToThrow = GameInfo.INITIAL_NUMBER_OF_DICES;
    private static Random randomGenerator = new Random();
    private String nick;

    public String generateNick() {
        String tempNick = "Student ";
        int random = randomGenerator.nextInt(90) + 10;
        tempNick += random;
        return tempNick;
    }

    public Player() {
        nick = generateNick();
    }

    public Player(String nick) {
        if (nick == null || nick.equals("")) {
            nick = generateNick();
        }
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }


    public int valueOfProperties(ArrayList<Property> properties) {
        int suma = GameInfo.NONE;
        for (Property temp : properties)
            suma += temp.valueOfProperty();

        return suma;
    }


    public ArrayList<Property> ownedProperties() {
        ArrayList<Property> tempList = new ArrayList<>();
        for (Square square : Game.getBoard().getSquares())
            if (square instanceof Property temp && temp.getOwner() == this)
                tempList.add(temp);

        return tempList;
    }


    public void setPosition(int shift) {
        int value;
        value = pawn.move(shift);
        moneyAmount += value;
    }


    public int takeMoney(int amount) {
        if (!checkIfCanTakeMoney(amount)) {
            for (Property property : ownedProperties())
                property.sellProperty();
            setBankruptStatus();
            Game.removePlayerAndCleanProperties();
            return moneyAmount;
        }

        Property property;

        while (amount > moneyAmount) {
            // property = Game.chooseProperty( ownedProperties(), amount-moneyAmount );
            // moneyAmount += property.sellProperty();
        }

        moneyAmount -= amount;

        return amount;
    }


    public void unconditionalMove(int squareNumber) {
        pawn.getToSquare(squareNumber);
    }

    public boolean checkIfCanTakeMoney(int amount) {
        return valueOfProperties(ownedProperties()) + getMoneyAmount() < amount; // True jezeli mozna zabrac gotowke bez bankructwa
    }

    public int getDices() {
        return howManyDicesToThrow;
    }

    public int getPosition() {
        return pawn.getPosition();
    }

    public int getInDante() {
        return inDante;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setDanteDuration(int numberOfRounds) {
        pawn.getToSquare(GameInfo.DANTE_SQUARE_INDEX);
        inDante += numberOfRounds;
    }

    public void setBankruptStatus() {
        isBankrupt = true;
    }

    public void giveMoney(int amount) {
        moneyAmount += amount;
    }

    public boolean hasCardChance() {
        return hasCardChance;
    }

    public void setCardChanceStatus(boolean hasCardChance) {
        this.hasCardChance = hasCardChance;
    }

    public boolean isOnErasmus() {
        return isOnErasmus;
    }

    public void setOnErasmus(boolean onErasmus) {
        this.isOnErasmus = onErasmus;
    }

    public boolean hasElectricDeficiency() {
        return hasElectricDeficiency;
    }

    public void setElectricDeficiencyStatus(boolean hasElectricDeficiency) {
        this.hasElectricDeficiency = hasElectricDeficiency;
    }

    public int getHowManyDicesToThrow() {
        return howManyDicesToThrow;
    }

    public void setHowManyDicesToThrow(int howManyDicesToThrow) {
        this.howManyDicesToThrow = howManyDicesToThrow;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }
}
