package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Emir Zeybek
// date: 01/10/25
public class Player
{
    // properties
    String name;
    public Cards hand;
    
    // constructors
    public Player( String name)
    {
        // ToDo
        this.name = name;
        this.hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
        hand.addTopCard(c);

    }
    
    public Card playCard()
    {
        
        return hand.getTopCard();
    }
    
} // end class Player
