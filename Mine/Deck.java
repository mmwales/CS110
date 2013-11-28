import java.util.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This class contains the deck of cards that are aviablable
 * It cointains methods to shuffle (shuffle the deck)
 * and get an Array of randomly selected cards
 */
public class Deck
{

   private ArrayList<Card> deck;

   //private Random r = new Random();
  // private Card[] deck;
   //= new Card[52];

	/**
	 * 
	 */
    
   public Deck()
   {
     
      /**deck =  new ArrayList<Card>();
      for (int r = 1; r<=13 ;r++)
      {
         for (int s=0 ;s<= 3;s++)
         {
            deck.add(new Card(r,s));
         }
      }*/
      freshDeck();
    
   } 
   
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      //System.out.println(deck.size());
   
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck.add(new Card(r,s));
         }
      }
   }
   
   
   public void add(Card aCard)
   {
      deck.add(aCard);
   }

   public Card getTopCard()
   {
      return deck.remove(0);
   }   
    
    
   public String toString()
   {
      return deck.toString();
   }

 	//size - returns the size of the pile.  It just uses the ArrayList method
   public int size()
   {
      return deck.size();
   }
   
   public void clear()
   {
      deck.clear();
   }   
 
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }

 
	//shuffle - randomly reorders the pile.
   /**
   public void shuffle()
   {
      Random rand = new Random();
   
      for (int i=0; i <deck.size(); i++)	 //repeat 2000 times
      {
         if (size() > 0)			 //if there is anything here to shuffle, then...
         {
            Card topCard = deck.remove(0);   				 //take off the top card...
            int newPosition = rand.nextInt(deck.size());	 //...find a new spot for it in a random position
            deck.add(newPosition, topCard);					 //...and put it back there
         }
      }
       
   }*/
      
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
      
      
   /** 
   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.getTopCard().toString());
   
      //while (!(deck.isEmpty()))
         //System.out.println(i++ + " : " + deck.getTopCard().toString());
     
     
      //deck.clear();
      //int j = 0;
   
      //System.out.println(deck.size());
      //while (!(deck.isEmpty()))
         //System.out.println(j++ + " : " + deck.getTopCard().toString());
              
               
   
   }
*/
    
}
