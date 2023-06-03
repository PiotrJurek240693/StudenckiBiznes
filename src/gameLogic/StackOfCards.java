package gameLogic;
import java.util.*;

import gameLogic.cards.*;

public class StackOfCards
{
    private List<Card> deck;
    private List<Card> usedCards;

    public void initStackOfCardsChance()
    {
        deck = new ArrayList<>();
        deck.add(new Card_PP2());
        deck.add(new Card_Condition());
        deck.add(new Card_ElectricDeficiency());
        deck.add(new Card_CrossingRedLight());
        deck.add(new Card_Busy());
        deck.add(new Card_BrokenLeg());
        deck.add(new Card_Renovation());
        deck.add(new Card_Lost());
        Collections.shuffle(deck);
    }

    public void initStackOfCardsStudentCash()
    {
        deck = new ArrayList<>();
        deck.add(new Card_Birthday());
        deck.add(new Card_Busted());
        deck.add(new Card_Connections());
        deck.add(new Card_Erasmus());
        deck.add(new Card_FoundMoney());
        deck.add(new Card_FreeFromDante());
        deck.add(new Card_GoodGrade());
        deck.add(new Card_OnlineSite());
        deck.add(new Card_Scholarship());
        Collections.shuffle(deck);
    }

    public Card drawCard()
    {
        if(deck.isEmpty())
        {
            deck.addAll(usedCards);
            usedCards.clear();
            Collections.shuffle(deck);
        }
        Card result;
        result = deck.get(deck.size()+GameInfo.SUB_INDEX);
        deck.remove(deck.size()+GameInfo.SUB_INDEX);
        return result;
    }

    public void returnCard(Card card)
    {
        usedCards.add(card);
    }
}
