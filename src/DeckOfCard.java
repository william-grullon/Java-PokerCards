import java.awt.*;

import javax.swing.*;

public class DeckOfCard extends JFrame
{

	//Vars
	public int[] deckOfCard = new int[52];
	public JLabel[] cardImage = new JLabel[52];
	public ImageIcon icon;

	
	//Contractor
	public DeckOfCard()
	{
		for (int i = 0; i < deckOfCard.length; i++)
		{
			this.deckOfCard[i] = i;
		}	
		
		
	}	
	
	//Shuffle
	public void Shuffle()
	{
		// Shuffle the cards
        for (int i = 0; i < this.deckOfCard.length; i++) 
        {
            // Generate an index randomly
            int index = (int)(Math.random() * this.deckOfCard.length);
            int temp = this.deckOfCard[i];
            this.deckOfCard[i] = this.deckOfCard[index];
            this.deckOfCard[index] = temp;
        }		
	}
	
	//toString
	public String toString()
	{	
	      String s = "";
	      int k;

	      k = 0;
	      for ( int i = 0; i < 4; i++ )
	      {
	         for ( int j = 1; j <= 13; j++ )
	             s += String.format( "%4d", deckOfCard[k++] );                

	         s += "\n";   // Add NEWLINE after 13 cards
	      }
	      
	      return ( s );
	}
	    
	
	public JLabel[] loadImage()
	{		
		for(int i = 0; i< 52; i++)
		{
			String fid = "card/"+ i + ".gif";
			icon = new ImageIcon(fid);
			cardImage[i] = new JLabel(icon);
		}
		return cardImage;		
	}	
	
	public void showCards()
	{		
		JFrame frame = new JFrame("RowofCards"); // Create a frame	
		JLabel[] labels=loadImage();
		frame.setLayout(new GridLayout(1, 5));
		
		
		frame.add(labels[this.deckOfCard[0]]);
		frame.add(labels[this.deckOfCard[1]]);
		frame.add(labels[this.deckOfCard[2]]);
		frame.add(labels[this.deckOfCard[3]]);
		frame.add(labels[this.deckOfCard[4]]);

		
		frame.setSize(400, 300); // Set the frame size
		//frame.pack();
		frame.setLocationRelativeTo(null);// Center a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // Display the frame
	}
	
	public void showHands()
	{
		
		String [] suits = {"Spade", "Heart", "Diamond", "Clubs"};
		String [] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] hand = {"East", "North", "West", "South"};
		
		
		String ecard = "";
		String ncard = "";
		String wcard = "";
		String scard = "";
		
		
	    int[][] d2 = new int[4][13];
	    
	    int index = 0;
	    
	    for (int i = 0; i < 13; i++)
	        for (int j = 0; j < 4; j++) 
	        {
	            d2[j][i] = this.deckOfCard[index++];
	            
	        }
		
		//This are the players
		for(int i = 0; i < 4; i++)
			{
			
				//EAST
				if (i ==0)
				{
					ecard += hand[i]+"\n";
					//suits								
					for(int s = 0; s < 4; s++)
						{					
							String suit = suits[s];
							ecard += suit + ":";
					
							//card
							for(int j = 0; j < 13; j++)
								{
							
									if (d2[i][j] /13 == s)
										{								
											String rank = ranks[d2[i][j] % 13];
											ecard += rank+" ";							
										}
								}//end of card
							ecard +="\n";
						}//end of Suit
					ecard +="\n";
				}
				//North
				if (i ==1)
				{
					ncard += hand[i]+"\n";
					//suits								
					for(int s = 0; s < 4; s++)
						{					
							String suit = suits[s];
							ncard += suit + ":";
					
							//card
							for(int j = 0; j < 13; j++)
								{
							
									if (d2[i][j] /13 == s)
										{								
											String rank = ranks[d2[i][j] % 13];
											ncard += rank+" ";							
										}
								}//end of card
							ncard +="\n";
						}//end of Suit
					ncard +="\n";
				}
				//West
				if (i ==2)
				{
					wcard += hand[i]+"\n";
					//suits								
					for(int s = 0; s < 4; s++)
						{					
							String suit = suits[s];
							wcard += suit + ":";
					
							//card
							for(int j = 0; j < 13; j++)
								{
							
									if (d2[i][j] /13 == s)
										{								
											String rank = ranks[d2[i][j] % 13];
											wcard += rank+" ";							
										}
								}//end of card
							wcard +="\n";
						}//end of Suit
					wcard +="\n";
				}
				//South
				if (i ==3)
				{
					scard += hand[i]+"\n";
					//suits								
					for(int s = 0; s < 4; s++)
						{					
							String suit = suits[s];
							scard += suit + ":";
					
							//card
							for(int j = 0; j < 13; j++)
								{
							
									if (d2[i][j] /13 == s)
										{								
											String rank = ranks[d2[i][j] % 13];
											scard += rank+" ";							
										}
								}//end of card
							scard +="\n";
						}//end of Suit
					scard +="\n";
				}
				
			}
		
		//System.out.println(ecard+ncard+wcard+scard);
		
		JFrame frame2 = new JFrame("GameTable"); // Create a frame
		setLayout( new BorderLayout(20, 500));
		
		//JLabels
		JLabel east = new JLabel(ecard);
		JLabel north = new JLabel(ncard);
		JLabel west = new JLabel(wcard);
		JLabel south = new JLabel(scard);
		
		//JPanels!
		JPanel p1 = new JPanel();
		p1.add(east);
		
		JPanel p2 = new JPanel();
		p2.add(north);

		JPanel p3 = new JPanel();
		p3.add(west);
		
		JPanel p4 = new JPanel();
		p4.add(south);
		
		// Add buttons to the frame
		frame2.add(east, BorderLayout.EAST);
		frame2.add(p2, BorderLayout.NORTH);
		frame2.add(west, BorderLayout.WEST);
		frame2.add(p4, BorderLayout.SOUTH);
				
		//Settings
		frame2.setTitle("ShowHand-text");
		frame2.setSize(800, 600);
		frame2.setLocationRelativeTo(null); // Center the frame
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}
	

}
