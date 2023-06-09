package gameLogic.cards;

import gameLogic.GameInfo;
import gameLogic.Player;
import gameLogic.Property;

public class Card_Renovation implements Card
{
    private final static String name = "Card_Renovation";

    // Karta ma obciazac gracza w zaleznosci od jego aktywow
    public void takeAction(Player player)
    {
        int amount = GameInfo.NONE;
        for(Property property : player.ownedProperties())
        {
            amount += property.getUpgrades()*ROOM_RENOVATION_PRICE;
            if(property.hasAuditorium())
                amount += AUDITORIUM_RENOVATION_PRICE;
        }
        player.takeMoney(amount);
        // Karta najpierw podlicza ile jest do zaplaty a dopiero potem proponuje sprzedaz; to nie ma zbyt duzego sensu
        // ale oplacenie jedynie wybranych moze przerastac moje mozliwosci
    }

    @Override
    public String getName() {
        return name;
    }
}
