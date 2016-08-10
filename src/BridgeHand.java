import java.awt.*;

import javax.swing.*;


public class BridgeHand extends DeckOfCard
{
	public String toString()
	{
		
		String [] suits = {"Spade", "Heart", "Diamond", "Clubs"};
		String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] hand = {"East", "North", "West", "South"};
		String card = "";
		
	    int[][] d2 = new int[4][13];
	    String [][] step2 = new String[4][0];
	    
	    int index = 0;
	    
	    for (int i = 0; i < 13; i++)
	        for (int j = 0; j < 4; j++) 
	        {
	            d2[j][i] = this.deckOfCard[index++];
	            
	        }
		
		//This are the players
		for(int i = 0; i < 4; i++)
			{
				
				card += hand[i]+"\n";	
				step2[i][0] += hand[i]+"\n";
				//suits
				for(int s = 0; s < 4; s++)
					{
					
					String suit = suits[s];
					card += suit + ":";
					//card
					for(int j = 0; j < 13; j++)
						{
							
							if (d2[i][j] /13 == s)
							{
							String rank = ranks[d2[i][j] % 13];
							card += rank+" ";
							step2[i][1]+= rank+" ";
							}
						}//end of card
					card +="\n";
					step2[i][1] += "\n";
					}//end of Suit
		
				card +="\n";
				step2[i][1] +="\n";
	
			}
		System.out.println(step2[1][1]);
		JOptionPane.showMessageDialog(null, card, "Dealed by William Grullon",JOptionPane.INFORMATION_MESSAGE);
		
		return card;
	}
	
	public void showCards()
	{		
		JLabel[] labels=loadImage();
		JFrame frame2 = new JFrame("GameTable"); // Create a frame
		setLayout( new BorderLayout(20, 500));
		
				
		//JPanels!
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT, -50, 100));
		for(int i=0;i<13;i++)
		p1.add(labels[this.deckOfCard[i]]);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 13));
		for(int i=13;i<26;i++)
		p2.add(labels[this.deckOfCard[i]]);

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER, -50, 100));
		for(int i=26;i<39;i++)
		p3.add(labels[this.deckOfCard[i]]);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER, -50, 0));
		for(int i=39;i<52;i++)
		p4.add(labels[this.deckOfCard[i]]);

		
			
		// Add buttons to the frame
		frame2.add(p1, BorderLayout.EAST);
		frame2.add(p2, BorderLayout.NORTH);
		frame2.add(p3, BorderLayout.WEST);
		frame2.add(p4, BorderLayout.SOUTH);
				
		//Settings
		frame2.setTitle("ShowHand-text");
		//frame2.setSize(800, 600);
		frame2.pack();
		frame2.setLocationRelativeTo(null); // Center the frame
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		
	}

	
}

	