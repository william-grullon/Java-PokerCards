import java.awt.*;
import javax.swing.*;

public class PokerHand extends DeckOfCard
	{
		public String toString()
		{
			
			String [] suits = {"Spade", "Heart", "Diamond", "Clubs"};
			String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
			String card = "";
			

			for(int i = 0; i < 5; i++)
			{
				String suit = suits[this.deckOfCard[i] /13];
				String rank = ranks[this.deckOfCard[i] % 13];
				System.out.println(this.deckOfCard[i]);
							
				card += suit + ":" + rank + "\n";
			}
			
			return (card);
		}
		
		
	}