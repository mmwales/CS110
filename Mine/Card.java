/**
	A Card class for the Card game.	
	@author Martha Wales 
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
                             
  /**
		Constructor to create Cards and shuffle them..
*/	      	
   Card(int rank, int suit)
    {
      this.rank = rank;
      this.suit = suit;
   }
	
   /**
    Returns card value.
    @return card rank as a value.
   */
   public int getSuit() 
   {
      return suit;
    }
    
   /**
    Returns card value.
    @return card rank as a value.
   */   public int getValue() 
   {
      return rank;
   }
  
    /**
    Returns a description of the suit of this card.
    @return the suit value of the card as a string.
   */
   public String getSuitAsString() 
   {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
      switch ( suit ) {
         case 0:   
            return "s";
         case 1:   
            return "h";
         case 2:  
            return "d";
         case 3:    
            return "c";
         default:       
            return "Invalid";
      }
   }
   /**
    Returns a description of the rank of this card.
    @return rank the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
      switch ( rank ) {
         case 1:   
            return "ace";
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
            return "jack";
         case 12:  
            return "queen";
         case 13:  
            return "king";
         default:  
            return "??";
      }
      
   }
         
      

   /**
   * Returns a description of this card.
   * @return name the name of the card.
   */

   public String toString() 
   {
      return getRankAsString() + " of " + getSuitAsString();
   }
  
  
   /**
   * Returns a description of this card.
   * @return filename of image of the card.
   */

   public String toName() 
   {
      return getRankAsString()+ getSuitAsString()+".jpg";
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
