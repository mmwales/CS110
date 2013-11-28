// First the Card class
/*
 * As asked many many times here is a Card class
 * and a Deck class
*/		
public class Card {
    // Constants     
    // suits
   public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // ranks
    // Cards 2 through 9 have face value
   public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    // instance variables
   private int suit;   // The suit of this card, one of the constants
                              // SPADES, HEARTS, DIAMONDS, CLUBS.
                              
   private int rank;  // The rank of this card, from 1 to 13.
                             
  
     	
	// constructor
   Card(int rank, int suit) {
      this.rank = rank;
      this.suit = suit;
   }
	
	
	// accessors
   int getSuit() {
      return suit;
            
   }
   int getValue() {
      return rank;
   }
	
	// returns the card definition
	//public String toString() {
	//	return "Card Value: " + rank + " Suit: " + suit;
   
	      
   
    /**
   * Returns a description of the suit of this card.
   * @return the suit value of the card as a string.
   */
   public String getSuitAsString() 
   {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
      switch ( suit ) {
         case 0:   
            return "Spades";
         case 1:   
            return "Hearts";
         case 2:  
            return "Diamonds";
         case 3:    
            return "Clubs";
         default:       
            return "Invalid";
      }
   }
   /**
   * Returns a description of the rank of this card.
   * @return the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
      switch ( rank ) {
         case 1:   
            return "Ace";
         case 2:   
            return "2";
         case 3:   
            return "3";
         case 4:   
            return "4";
         case 5:   
            return "5";
         case 6:   
            return "6";
         case 7:   
            return "7";
         case 8:   
            return "8";
         case 9:   
            return "9";
         case 10:  
            return "10";
         case 11:  
            return "Jack";
         case 12:  
            return "Queen";
         case 13:  
            return "King";
         default:  
            return "??";
      }
   }
   /**
   * Returns a description of this card.
   * @return the name of the card.
   */

   public String toString() 
   {
      return getRankAsString() + " of " + getSuitAsString();
   }
    
   /**
   * Compares two cards to determine if they have the same value.
   * @param card the other card
   * @return true if the two cards have the same rank and suitvalues,
   * falseotherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }
   
   
}