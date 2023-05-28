package gameLogic;
import java.util.*;
import gameLogic.cards.Card;

public class stackOfCards
{
    private List<Card> deck;
    private List<Card> usedCards;

    public void initStackOfCardsChance()
    {
        // TODO: dowiedziec sie ktore karty to sa Kasa Studencka a ktore Szansa
        Collections.shuffle(deck);
    }

    public void initStackOfCardsKasaStudencka()
    {
        // TODO: dowiedziec sie ktore karty to sa Kasa Studencka a ktore Szansa
        Collections.shuffle(deck);
    }

    public Card drawCard()
    {
        Card result;
        result = deck.get(deck.size()+GameInfo.SUB_INDEX);
        deck.remove(deck.size()+GameInfo.SUB_INDEX);
        if(deck.isEmpty())
        {
            deck.addAll(usedCards);
            usedCards.clear();
            Collections.shuffle(deck);
        }
        return result;
    }

    public void returnCard(Card card)
    {
        usedCards.add(card);
    }
}
