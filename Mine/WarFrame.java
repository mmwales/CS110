/**
  This class contains GUI Driver for the Card Game War.
  @author Martha Wales 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
public class WarFrame extends JFrame 
{
   private War game; // the guts
   private final int WINDOW_WIDTH = 1000;
   private final int WINDOW_HEIGHT = 800;
   private String strCard1, strCard2;
   private ImageIcon back, face1, face2;
   private JLabel p1pile, p2pile, p1Up, p1Down, p2Up, p2Down, p1First, p2First;
   private JLabel pile1Msg, pile2Msg, winnerMsg, infoMsg;
   private int count1, count2;
   private JButton play, deal;
   private boolean reset;
      
   public WarFrame(String s)
   {
   
      //Set the window frame properties
    super(s);
  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    //Set background to not ugly. 
    setBackground( new Color(150,50,40) );
    
    //Opening page
    
    infoMsg = new JLabel("WAR!");
    infoMsg.setVisible(true);
    infoMsg.setFont(new Font("Arial", Font.PLAIN, 20));

    
    //Start the game  
      game = new War();
 
   //Create deal button    
      deal = new JButton("New Game - Deal");
      deal.addActionListener(new Deal());
      deal.setPreferredSize(new Dimension(130,60));
       
   //Create play button    
      play = new JButton("play");
      play.addActionListener(new Play());
      //Set the play button size
       play.setPreferredSize(new Dimension(100,60));
      //Set the play button invisible until the hands are dealt
      play.setVisible(false);
      //add(button); 
              
       
    //Create a label for the card counts
    pile1Msg = new JLabel(" ");
    pile2Msg = new JLabel(" ");
    pile1Msg.setVisible(false);
    pile2Msg.setVisible(false);       
    //Create a label to display winner
    winnerMsg = new JLabel(" ");
    winnerMsg.setVisible(false);
    winnerMsg.setFont(new Font("Arial", Font.PLAIN, 25));
 
    //Create 2 panels
    JPanel bottomPanel = new JPanel();    
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    westPanel.setPreferredSize(new Dimension(300, 300));
    eastPanel.setPreferredSize(new Dimension(300, 300));
    northPanel.setPreferredSize(new Dimension(300, 300));
    centerPanel.setPreferredSize(new Dimension(300, 300));


    //Add the play and deal buttons to the bottom panel
    bottomPanel.add(play);
    bottomPanel.add(deal);
   
    
   //Create 2 cards piles, 2 first cards, 2 face down and 2 face Up cards for war
    
    back = new ImageIcon("back.jpg");
    p1pile = new JLabel(back);
    p2pile = new JLabel(back);
    p1Up = new JLabel(back);
    p1First = new JLabel(back);
    p2First = new JLabel(back);
    p2Up = new JLabel(back);
    p1Down = new JLabel(back);
    p2Down = new JLabel(back);
       
    // Add the cards to the panel. 
    westPanel.add(p1pile);
    westPanel.add(pile1Msg);
    eastPanel.add(p2pile);
    eastPanel.add(pile2Msg);
    northPanel.add(p1Up);
    centerPanel.add(p1Down);
    centerPanel.add(p2Down); 
    northPanel.add(p1First);
    northPanel.add(p2First);
    northPanel.add(p2Up);
    bottomPanel.add(winnerMsg);
    centerPanel.add(infoMsg);

    
    //Add the panels to the frame
    add(bottomPanel, BorderLayout.SOUTH);
    add(eastPanel, BorderLayout.EAST);
    add(westPanel, BorderLayout.WEST);    
    add(northPanel, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
   
    
    //Make all "cards" except the invisible until either dealt or flipped;
    p1pile.setVisible(false); 
    p2pile.setVisible(false);
    p1First.setVisible(false);
    p2First.setVisible(false); 
    p1Up.setVisible(false);
    p2Up.setVisible(false);
    p1Down.setVisible(false); 
    p2Down.setVisible(false);
       
    setVisible(true);
    }
  /** Play button Action Listener.
  */
    class Play implements ActionListener
   {
     public void actionPerformed(ActionEvent e)
      { //reset the reset flag on play
        reset = false;
      
      //set the war facedown cards invisible
        p1Down.setVisible(false); 
        p2Down.setVisible(false);
       //flip the top cards of the deck
        game.flip();  
        //set the player 1 card icons
        strCard1= game.getP1TopCard();
        face1 = new ImageIcon(strCard1);       
        p1First.setIcon(face1);
        //set the player 2 card icons 
        strCard2 = game.getP2TopCard();
        face2 = new ImageIcon(strCard2);       
        p2First.setIcon(face2);
        //set the card to display
        p1First.setVisible(true);
        p2First.setVisible(true);
        //Get the winner and display message
        game.winner();
        winnerMsg.setText(game.getWinnerMsg());
        winnerMsg.setVisible(true);
        //get the player deck sizes
       count1 = game.getP1Count();
       count2 = game.getP2Count();
        
       //GET GAME WINNER 
       if(count1 < 1 )
         {infoMsg.setText("PLAYER 2 WINS Game Over");
         infoMsg.setVisible(true);
         winnerMsg.setVisible(false); 
         p1pile.setVisible(false); 
         p2pile.setVisible(false);
         p1First.setVisible(false);
         p2First.setVisible(false); 
         p1Up.setVisible(false);
         p2Up.setVisible(false);
         p1Down.setVisible(false); 
         p2Down.setVisible(false);
         reset = true;
         play.setVisible(false);
         deal.setVisible(true);
        
               }
            
       else if(count2 < 1 )
       { infoMsg.setText("PLAYER 1 WINS Game Over");
         infoMsg.setVisible(true);
         winnerMsg.setVisible(false); 
         p1pile.setVisible(false); 
         p2pile.setVisible(false);

         p1First.setVisible(false);
         p2First.setVisible(false); 
         p1Up.setVisible(false);
         p2Up.setVisible(false);
         p1Down.setVisible(false); 
         p2Down.setVisible(false);
         reset = true;
         play.setVisible(false);
         deal.setVisible(true);
         }         
       else
         infoMsg.setVisible(false);
   
       pile1Msg.setText("Player 1 Card Count: " + count1);
       pile2Msg.setText("Player 2 Card Count: " + count2);
       if (count1 > 0 || count2 > 0)           
        if(game.getWarFlag())
          {
             game.cardWar();          
             strCard1= game.getP1UPCard();
             face1 = new ImageIcon(strCard1);       
             p1Up.setIcon(face1);
             strCard2 = game.getP2UPCard();
             face2 = new ImageIcon(strCard2);       
             p2Up.setIcon(face2);
             p1Up.setVisible(true);
             p2Up.setVisible(true);
             p1Down.setVisible(true); 
             p2Down.setVisible(true);
           }
        else
         {  
          p1Down.setVisible(false); 
          p2Down.setVisible(false);
          p1Up.setVisible(false);
          p2Up.setVisible(false);       
          }
       else if(count2 < count1)    
         {infoMsg.setText("PLAYER 1 WINS Game Over");
          infoMsg.setVisible(true);}
       else 
          {infoMsg.setText("PLAYER 2 WINS Game Over");
          infoMsg.setVisible(true);}
       
        pile1Msg.setText("Player 1 Card Count: " + count1);
        pile2Msg.setText("Player 2 Card Count: " + count2);
        winnerMsg.setText(game.getWinnerMsg());
        winnerMsg.setVisible(true);       
        }       
        
     }  
     /** Deal - New Game button Action Listener.
    */ 
     
    class Deal implements ActionListener
   {
    public void actionPerformed(ActionEvent f)
     { 
      if(reset)
      { winnerMsg.setVisible(false);
        game = new War();
        game.deal();}
      else
       game.deal();
       
       count1 = game.getP1Count();
       count2 = game.getP2Count();
       pile1Msg.setText("Player 1 Card Count: " + count1);
       pile2Msg.setText("Player 2 Card Count: " + count2);
       pile1Msg.setVisible(true);
       pile2Msg.setVisible(true);       
       p1pile.setVisible(true);
       p2pile.setVisible(true);
       
       deal.setVisible(false);
       play.setVisible(true);
       infoMsg.setVisible(false);
       }
    }               
  
   public static void main(String [] args)
   {
      WarFrame game = new WarFrame("Martha's War Card Game");
   } 
       
}

    
    
   