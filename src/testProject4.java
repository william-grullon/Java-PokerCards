import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * William Grullon
 * 
 */

public class testProject4 extends JFrame
{
	public static void main(String[] args) 
	{
		DeckOfCard card1 = new DeckOfCard();
		System.out.println("DeckOfCard toString Output:\n" + card1.toString());
		
		card1.Shuffle();
		System.out.println("After Suffle--DeckOfCard toString Output:\n" + card1.toString());
		
		PokerHand card2 = new PokerHand();
		
		card2.Shuffle();
		System.out.println("PokerHand toString Output:\n" + card2);		
		
		//card2.showCards();	
		
		BridgeHand card3 = new BridgeHand();
		
		card3.Shuffle();
		
		//System.out.println(card3);
		
		//Text Cards
		//card3.showHands();
		card3.showCards();
		
	}	
}
