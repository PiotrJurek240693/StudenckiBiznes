package gameLogic;

import java.util.Random;

import java.util.ArrayList;

public class Board {
    public static final int UNUPGRADABLE = -1;
    public static final int UPGRADE_PRICE_ROW_1 = 100;
    public static final int UPGRADE_PRICE_ROW_2 = 200;
    public static final int UPGRADE_PRICE_ROW_3 = 300;
    public static final int UPGRADE_PRICE_ROW_4 = 400;

    public static final int NO_ONE = -1;
    public static final int BANK = NO_ONE;
    public static final int RANDOMISE = -1;

    private static Random randomGenerator = new Random();

    private ArrayList<Square> squares=new ArrayList<Square>();
    private Player[] players;
    public Board(Player[] players)
    {
        this.players=players;
        initSquares();
        // TODO: dodać mieszanie kart na obu stosach
    }
    public void run()
    {
        boolean isRunning=true;
        int playerIndex=0;
        while(isRunning) {
            playerRound(playerIndex);

            playerIndex++;
            if(playerIndex==players.length)
            {
                playerIndex=0;
            }
        }
    }
    private void playerRound(int playerIndex)
    {
        // TODO: (gameLogic) sprawdzić czy gracz jest bankrutem, jeśli jest to return;
        // TODO: wysłać i wyświetlić kogo jest kolej
        boolean endedRound=false;
        int doubles=0;
        while(!endedRound) {
            // TODO: zaoferować ulepszenie budynków o ile jakiś ma i da się ulepszyć i/lub usunięcie zastawienia
            //      -aby móc dobudować, ulepszać student musi posiadać cały wydział
            //      -w jednym ruchu student może dobudować tylko 1 sale lub aule na jedno pole
            //      -wszystkie instytuty i katedry w danym wydziale mogą mieć różnice ilości sali maksymalnie o 1 między sobą
            //      -aula może być postawiona tylko wtedy, kiedy student posiada już 4 sale na danym polu, wtedy 4 sale są zamieniane na 1 aule
            // TODO: (gameLogic) sprawdzić czy gracz ma ustawione robienie dante i...
                // TODO: wyświetlić graczowi propozycje opłacenia ECTS w zależności od pozostałego czasu
            int[] dices=rollDices(players[playerIndex].getDices());
            // TODO: (gameLogic) zmniejszyć graczowi czas nietypowej liczby kostek (nie mniej niż 0) i obsłużyć przywrócenie 2 kostek
            // TODO: (gameLogic) sprawdzić czy gracz ma ustawione robienie dante i jeśli nie ma doubla if(!isDouble(dices)) break;
            doMove(playerIndex,howFar(dices));
            int position=players[playerIndex].getPosition();
            doAction(playerIndex);
            if(isDouble(dices))
            {
                if(doubles>=2) {
                    goToDante(playerIndex,3);
                    endedRound=true;
                } else {
                    endedRound=false;
                }
                doubles++;
            }
            else{
                endedRound=true;
            }
            if(position!=players[playerIndex].getPosition())
            {
                // TODO: ponownie wysłać i wyświetlić pozycję, gdyż uległa zmianie
            }
        }
    }
    private void goToDante(int playerIndex,int time)
    {
        if(time==RANDOMISE) {
            time = randomGenerator.nextInt(4);
            // TODO: wysłać i wyświetlić na co idzie gracz - 0-SO,1-PP1,2-PP2,3-SO2
        }
        // TODO: (gameLogic) sprawdzić czy gracz ma kartę wyjścia z dante
        {
            time=0;
            // TODO: wysłać i wyświetlić użycie karty wyjścia z dante
            // TODO: (gameLogic) usunąć graczowi kartę wyjścia z dante
            // TODO: dodać kartę wyjścia z dante na spód talii
        }
        players[playerIndex].setPosition(10);
        // TODO: (gameLogic) ustawić graczowi time kolejek w dante
    }
    private boolean isDouble(int[] dices)
    {
        boolean isDouble=false;
        for(int i=0;i<dices.length-1;i++){
            for(int j=i+1;j<dices.length;j++){
                if(dices[i]==dices[j]){
                    isDouble=true;
                }
            }
        }
        return isDouble;
    }
    private void doAction(int playerIndex)
    {
        int position=players[playerIndex].getPosition();
        Square square=squares.get(position);
        if(square.isCards()) {
            // TODO: (gameLogic - puźniej) dobrać karte i ją obsłużyć
            // TODO: wysłać i wyświetlić kartę
        } else if (square.isSpecial()) {
            handleSpecial(square,playerIndex);
        } else if (square.isProperty()) {
            handleProperty(playerIndex, (Property) square);
        } else {
            pay(playerIndex,BANK,square.getFee());
        }
    }

    private void handleSpecial(Square square,int playerIndex)
    {
        switch (square.getType())
        {
            case DANTE:
                // TODO: obsługa wyświetlenia gracza na polu odwiedzający
                break;
            case LIBRARY:
                // TODO: (gameLogic) obsługa pola - zmiana graczowi ilość kostek na 3 i czasu nietypowej ilości kostek na 1
                // TODO: wysłanie i wyświetlenie darmowej herbaty
                break;
            case DANTE_AGAIN:
                goToDante(playerIndex,RANDOMISE);
                break;
        }
    }

    private void handleProperty(int playerIndex, Property square)
    {
        if(square.isMortgaged()){
            return;
        }
        Property property= square;
        int ownerIndex=property.getOwnerIndex();
        if (ownerIndex==NO_ONE) {
            // TODO: zaoferować kupno posiadłości lub licytacje
        } else if (playerIndex!=ownerIndex){
            pay(playerIndex,ownerIndex,square.getFee());
        }
    }

    private void pay(int from,int to,int amount)
    {
        int moneyPaid=amount;
        if(from!=BANK)
        {
            // TODO: (gameLogic) zabrać graczowi o indexie [from] amount pieniędzy i obsłużyć bankructwo - wyliczyć ile zapłacił
            moneyPaid=amount;
        }
        if(to!=BANK)
        {
            // TODO: (gameLogic) dać graczowi o indeksie [to] moneyPaid pieniędzy
        }
        // TODO: wysłać i wyświetlić nowy stan gotówki
    }
    private void removePlayer(int playerIndex)
    {
        // TODO: (gameLogic) ustawić graczowi bankructwo
        for(int i=0;i<squares.size();i++)
        {
            Square square=squares.get(i);
            if(square.isProperty())
            {
                Property property=(Property)square;
                if(property.getOwnerIndex()==playerIndex)
                {
                    property.setOwnerIndex(NO_ONE);
                }
            }
        }
        // TODO: wysłać i wyświetlić pola z powrotem do kupienia, gracz wyszarzony
    }
    private int howFar(int[] dices)
    {
        int sum=0;
        for(int i=0;i<dices.length;i++) {
            sum+=dices[i];
        }
        return sum;
    }
    private int[] rollDices(int howMany)
    {
        int[] dices=new int[howMany];
        for(int i=0;i<howMany;i++) {
            dices[i]=randomGenerator.nextInt(6)+1;
        }
        // TODO: wysłać i wyświetlić wyrzucone kostki
        return dices;
    }
    public void doMove(int playerIndex,int move)
    {
        int position=players[playerIndex].getPosition();
        position+=move;
        if(position>squares.size()) {
            position-=squares.size();
            pay(BANK,playerIndex,200);
        }
        players[playerIndex].setPosition(position);
        // TODO: wysłać i wyświetlić przesunięcie gracza
    }
    private void initSquares() {
        squares.add(new Square("START", TypesOfSqueres.START,0));
        squares.add(new Property("INSTYTUT ZARZĄDZANIA", TypesOfSqueres.INSTITUTE,60,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("KASA STUDENCKA", TypesOfSqueres.STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT MARKETINGU I ZRÓWNOWAŻONEGO ROZWOJU",TypesOfSqueres.INSTITUTE,60,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("LEGITYMACJA",TypesOfSqueres.STUDENT_CARD,200));
        squares.add(new Property("PARKING KAMPUS A", TypesOfSqueres.PARKING,200,UNUPGRADABLE));
        squares.add(new Property("KATEDRA POJAZDÓW I PODSTAW BUDOWY MASZYN", TypesOfSqueres.CATHEDRAL,100,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("SZANSA", TypesOfSqueres.CHANCE,0));
        squares.add(new Property("INSTYTUT INŻYNIERII MATERIAŁOWEJ",TypesOfSqueres.INSTITUTE,100,UPGRADE_PRICE_ROW_1));
        squares.add(new Property("KATEDRA DYNAMIKI MASZYN",TypesOfSqueres.CATHEDRAL,120,UPGRADE_PRICE_ROW_1));
        squares.add(new Square("DANTE",TypesOfSqueres.DANTE,0));
        squares.add(new Property("INSTYTUT TECHNOLOGII POLIMERÓW I BARWNIKÓW",TypesOfSqueres.INSTITUTE,140, UPGRADE_PRICE_ROW_2));
        squares.add(new Property("ZATOKA SPORTU", TypesOfSqueres.SPORT_VANUE,150,UNUPGRADABLE));
        squares.add(new Property("INSTYTUT CHEMII OGÓLNEJ I EKOLOGICZNEJ",TypesOfSqueres.INSTITUTE,140,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("MIĘDZYRESORTOWY INSTYTUT TECHNIKI RADIACYJNEJ",TypesOfSqueres.INSTITUTE,160,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("PARKING KAMPUS B",TypesOfSqueres.PARKING,200,UNUPGRADABLE));
        squares.add(new Property("INSTYTUT MATERIAŁOZNAWSTWA TEKSTYLIÓW I KOMPOZYTÓW POLIMEROWYCH",TypesOfSqueres.INSTITUTE,180,UPGRADE_PRICE_ROW_2));
        squares.add(new Square("KASA STUDENCKA",TypesOfSqueres.STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY TEKSTYLIÓW",TypesOfSqueres.INSTITUTE,180,UPGRADE_PRICE_ROW_2));
        squares.add(new Property("KATEDRA TECHNOLOGII DZIEWIARSKICH I MASZYN WŁÓKIENNICZYCH",TypesOfSqueres.CATHEDRAL,200,UPGRADE_PRICE_ROW_2));
        squares.add(new Square("BIBLIOTEKA", TypesOfSqueres.LIBRARY,0));
        squares.add(new Property("INSTYTUT ARCHITEKTURY I URBANISTYKI",TypesOfSqueres.INSTITUTE,220,UPGRADE_PRICE_ROW_3));
        squares.add(new Square("SZANSA",TypesOfSqueres.CHANCE,0));
        squares.add(new Property("KATEDRA BUDOWNICTWA BETONOWEGO",TypesOfSqueres.CATHEDRAL,220,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("KATEDRA MECHANIKI KONSTRUKCJI",TypesOfSqueres.CATHEDRAL,240,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("PARKING KAMPUS C",TypesOfSqueres.PARKING,200,UNUPGRADABLE));
        squares.add(new Property("KATEDRA INŻYNIERII BIOPROCESOWEJ",TypesOfSqueres.CATHEDRAL,260,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("KATEDRA INŻYNIERII BEZPIECZEŃSTWA PRACY",TypesOfSqueres.CATHEDRAL,260,UPGRADE_PRICE_ROW_3));
        squares.add(new Property("CANTRUM SPORTU",TypesOfSqueres.SPORT_VANUE,150,UNUPGRADABLE));
        squares.add(new Property("KATEDRA INŻYNIERII MOLEKULARNEJ",TypesOfSqueres.CATHEDRAL,280,UPGRADE_PRICE_ROW_3));
        squares.add(new Square("PORA NA DANTE", TypesOfSqueres.DANTE_AGAIN,0));
        squares.add(new Property("INSTYTUT FIZYKI",TypesOfSqueres.INSTITUTE,300,UPGRADE_PRICE_ROW_4));
        squares.add(new Property("INSTYTUT INFORMATYKI",TypesOfSqueres.INSTITUTE,300,UPGRADE_PRICE_ROW_4));
        squares.add(new Square("KASA STUDENCKA",TypesOfSqueres.STUDENT_CASH,0));
        squares.add(new Property("INSTYTUT MATEMATYKI",TypesOfSqueres.INSTITUTE,320,UPGRADE_PRICE_ROW_4));
        squares.add(new Property("PARKING REKTORA",TypesOfSqueres.PARKING,200,UNUPGRADABLE));
        squares.add(new Square("SZANSA",TypesOfSqueres.CHANCE,0));
        squares.add(new Property("INSTYTUT MECHATRONIKI SYSTEMÓW INFORMATYCZNYCH",TypesOfSqueres.INSTITUTE,350,UPGRADE_PRICE_ROW_4));
        squares.add(new Square("WARUNEK", TypesOfSqueres.FAILED_SUBIECT_FEE,100));
        squares.add(new Property("KATEDRA MIKROELEKTRONIKI I TECHNIK INFORMATYCZNYCH",TypesOfSqueres.CATHEDRAL,400,UPGRADE_PRICE_ROW_4));
    }
    public ArrayList<Square> getSquares()
    {
        return squares;
    }

}
