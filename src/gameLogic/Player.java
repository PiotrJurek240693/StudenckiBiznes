package gameLogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Player implements Serializable {
    private final Pawn pawn;
    private int moneyAmount = GameInfo.START_VALUE;
    private int inDante = 0;
    private boolean isBankrupt = false;
    private boolean hasCardChance = false;
    private boolean isOnErasmus = false;
    private boolean hasElectricDeficiency = false;

    private ArrayList<Integer> dices = new ArrayList<Integer>(GameInfo.INITIAL_NUMBER_OF_DICES);
    private int numberOfDoublets = 0;
    private static Random randomGenerator = new Random();
    private String nick;

    public Player(String nick, PawnColor color) {
        if (nick == null || nick.equals("")) {
            nick = generateNick();
        }
        this.nick = nick;
        pawn = new Pawn(color);
    }

    public String generateNick() {
        String tempNick = "Student ";
        int random = randomGenerator.nextInt(90) + 10;
        tempNick += random;
        return tempNick;
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

    public  ArrayList<Integer> rollDices(){
        for(Integer dice : dices){
            dice = randomGenerator.nextInt() / 6 + 1;
        }
        if(checkDoubles()) {
            numberOfDoublets++;
            if(checkTooMuchDoubles()) {
                goToDante(3);
            }
        }
        return dices;
    }

    private boolean checkDoubles() {
        for(int i = 1; i < dices.size(); i++) {
            if(dices.get(i) != dices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTooMuchDoubles() {
        if(numberOfDoublets >= 3){
            return true;
        }
        return false;
    }

    private void goToDante(int time) {
        inDante += time;
        unconditionalMove(GameInfo.DANTE_SQUARE_INDEX);
    }

    public void unconditionalMove(int squareNumber) {
        pawn.getToSquare(squareNumber);
    }

    public boolean checkIfCanTakeMoney(int amount) {
        return valueOfProperties(ownedProperties()) + getMoneyAmount() < amount; // True jezeli mozna zabrac gotowke bez bankructwa
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
        return dices.size();
    }

    public void setHowManyDicesToThrow(int howManyDicesToThrow) {
        this.dices = new ArrayList<>(howManyDicesToThrow);
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public boolean isHasCardChance() {
        return hasCardChance;
    }

    public boolean isHasElectricDeficiency() {
        return hasElectricDeficiency;
    }

    public int getNumberOfDoublets() {
        return numberOfDoublets;
    }

    public ArrayList<Integer> getDices() {
        return dices;
    }
}
