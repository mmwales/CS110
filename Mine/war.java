// import needed classes and packages
//Fixed GAme
import java.util.Scanner;
import java.io.IOException;

public class war
{
   public static void main(String[] args) throws IOException
   {
   //Declare Variables
      
      int countingPlays = 0;
      boolean newWar = false;
   
      Scanner keyboard = new Scanner(System.in); //Allows Input
   
   //creates the cardPile array called DeckOfCards
      Deck cardDeck = new Deck();
      
          
   //prints out the deck of Cards
      System.out.println("Deck Of Cards: " + cardDeck);
   
   //shuffles the cards
      cardDeck.shuffle();
   
   //Prints out the deck of cards after they are shuffled
      System.out.println("Deck of Cards after shuffled: " + cardDeck);
   
   
   //Creates Player1's Card Pile
      Deck p1Cards = new Deck();
      //then clears it..
      p1Cards.clear();
   
   //Creates Player2's Card Pile
      Deck p2Cards  = new Deck();
      p2Cards.clear();
   
   //Checking the size of the Deck
      System.out.println("" + cardDeck.size());
   
   //Takes the cardDeck and splits them up into 2 piles for Player1 and Player2
      for(int i = 0; i < 26; i++)
      {
         p1Cards.add(cardDeck.getTopCard());
         p2Cards.add(cardDeck.getTopCard());
      }
   
   //Prints out the deck of Cards and then the player 1's pile and player 2's pile
      System.out.println("Deck of Cards after removing cards into two piles: " + cardDeck);
      System.out.println("Player 1's Cards: " + p1Cards);
      System.out.println("Player 2's Cards: " + p2Cards);
   
   //checking the size of each players Pile
      System.out.println("" + p1Cards.size());
      System.out.println("" + p2Cards.size());
   
   //Prints the header for the game
      System.out.println("Game of War");
           
       
   //Starts the game of War
     try
      {	//do while the sizes of the player piles are greater than 0.

  	//do while the sizes of the player piles are greater than 0.
      do
       {
         //gets the top cards of each players Pile
            Card p1TopCard = p1Cards.getTopCard();
            Card p2TopCard = p2Cards.getTopCard();
           
         //Compares the 2 cards to test which is bigger. 
         //If player 1's card is smaller than player 2 is the winner
        
           if (p1TopCard.getValue() < (p2TopCard.getValue())) 
           
            {
               System.out.println("Player 1: " + p1TopCard + " Player 2: " + p2TopCard);
               System.out.println("Player 2 is the Winner");
               p2Cards.add(p1TopCard);
               p2Cards.add(p2TopCard);
               System.out.println("Player 1 has: " + p1Cards.size() + " cards left.");
               System.out.println("Player 2 has:" + p2Cards.size() + " cards left.");
               System.out.println("\n");
               keyboard.nextLine();
            }
            //Compares the 2 cards to test which is bigger. 
            //If player 2's card is smaller than player 1 is the winner.

            else if (p1TopCard.getValue() > (p2TopCard.getValue()))          
            {
               System.out.println("Player 1: " + p1TopCard + " Player 2: " + p2TopCard);
               System.out.println("Player 1 is the Winner");
               p1Cards.add(p1TopCard);
               p1Cards.add(p2TopCard);
               System.out.println("Player 1 has: " + p1Cards.size() + " cards left.");
               System.out.println("Player 2 has:" + p2Cards.size() + " cards left.");
               System.out.println("\n");
               keyboard.nextLine();
            }
            //Else it is a war
            else
            {         
             
              do 
               {
               System.out.println("Player 1: " + p1TopCard + " Player 2: " + p2TopCard);
               System.out.println("2 Card WAR!!!!!!!");
               System.out.println(p1Cards.size() + " " + p2Cards.size());
               
               if(p1Cards.size() > 2 || p2Cards.size() > 2 )
                  {  
                   Card p1FDCard = p1Cards.getTopCard();
               
                   Card p2FDCard = p2Cards.getTopCard();
                   Card p1UPCard = p1Cards.getTopCard();
               
                   Card p2UPCard = p2Cards.getTopCard();

                   System.out.println("Player1's face down card: " + p1FDCard + " Player2's face down card: " + p2FDCard);
                   System.out.println("Player1's face up card: " + p1UPCard + " Player2's face up card: " + p2UPCard);
                  
                
                     if (p1UPCard.getValue() > (p2UPCard.getValue()))          
         
                     {
                        System.out.println("Player 1 is the winner of the War! ");
                        p1Cards.add(p1TopCard);
                        p1Cards.add(p1FDCard);
                        p1Cards.add(p1UPCard);
                        p1Cards.add(p2TopCard);
                        p1Cards.add(p2FDCard);
                        p1Cards.add(p2UPCard);

                        System.out.println("Player 1 has: " + p1Cards.size() + " cards left.");
                        System.out.println("Player 2 has: " + p2Cards.size() + " cards left.");
                        System.out.println("\n");
                        keyboard.nextLine();
                        
                        p1Cards.shuffle();
                        p2Cards.shuffle();
                     }
                
                    else if (p1UPCard.getValue() < (p2UPCard.getValue()) )         
         
                     {
                        System.out.println("Player 2 is the winner of the War! ");
                        p2Cards.add(p1TopCard);
                        p2Cards.add(p1FDCard);
                        p2Cards.add(p1UPCard);
                        p2Cards.add(p2TopCard);
                        p2Cards.add(p2FDCard);
                        p2Cards.add(p2UPCard);
                     

                        System.out.println("Player 1 has: " + p1Cards.size() + " cards left.");
                        System.out.println("Player 2 has: " + p2Cards.size() + " cards left.");
                        System.out.println("\n");
                        keyboard.nextLine();
                         
                        p1Cards.shuffle();
                        p2Cards.shuffle();

                     }
                  
                 else
                   
                   newWar = true;
                    }
                 } while (newWar = false);
                   
               }                          
           //end of outer while   
          } while(p1Cards.size() > 0 || p2Cards.size() > 0);
       }
      
      //Catches the Array 0 error and prints out who is the winner based on who has zero cards.
      catch (IndexOutOfBoundsException theException)  //tries to catch this type...
      {
         if(p1Cards.size() == 0)
         {
            System.out.println("Player 2 Wins!" );
         }
         else
          System.out.println("Player1 Wins!" );
  
      }
  }
}