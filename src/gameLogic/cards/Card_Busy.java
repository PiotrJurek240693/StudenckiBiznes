package gameLogic.cards;

import gameLogic.Player;
import gameLogic.Property;

public class Card_Busy implements Card
{
    // karta ma niszczyc aule gracza
    public void takeAction(Player player)
    {
        for(Property property : player.ownedProperties())
            if(property.hasAuditorium())
            {
                property.destroyAuditorium();
                break;
            }
    }
}
