/*
 * SYST17796 - Fundamentals of Software Design and Development
 * Course Project - Deliverable 3
 */
package finalprojectsoftdes;

/**
 * @author ManuelMartinez 
 * @author KaloyanPalazov 
 * @author StephenPaton 
 * @author AhmadAyoub
 */
import java.util.Scanner;

/**
 * Handles all Player specific operations
 */
public class Player extends Person 
{

    Scanner input = new Scanner(System.in);

    //Create a new Player
    public Player() 
    {
        super.setName("Player");

    }

    //Allow the player to make decisions
    public void makeDecision(Deck deck, Deck discard) 
    {

       int  decision = 0;
       boolean getNum = true;

       while(getNum)
       {

           try
           {
               System.out.println("Would you like to: 1) Hit or 2) Stand");
               decision = input.nextInt();
               getNum = false;

           }
           catch(Exception e)
           {
               System.out.println("Invalid");
               input.next();
           }
           //we don't close the scanner, because we will need it later.
       }

       //if they decide to hit
       if (decision == 1) 
       {
           //hit the deck using the deck and discard deck
           this.hit(deck, discard);
           
           //return (exit the method) if they have blackjack or busted
           if(this.getHand().calculatedValue()>20)
           {
               return;
           }
           
           //if they didnt bust or get 21, allow them to decide to hit or stand again by going back to this same method
           else
           {
               this.makeDecision(deck, discard);
           }

           //if they type any number other than 1, we'll assume they're standing
       } 
       else 
       {
           System.out.println("You stand.");
       }
   }
}
