package hw123;

public class DeckTestOWO{
	   
	   public static void main(String[] args) {
	      DeckOfCard deck = new DeckOfCard();
	      deck.shuffle();
	      Card[] fiveCard = new Card[5];
	      for (int i = 0; i < 5; i++) {
	    	  fiveCard[i] = deck.dealCard();
	      } 
	 
	      System.out.printf("%-15s%-15s\n","Faces:","Suits:");
	      System.out.printf("---------------------\n");
	      for(int i = 0 ; i < 5 ; i++)
	      {
	    	  System.out.printf("%-15s%-15s%n",fiveCard[i].getFace() , fiveCard[i].getSuit());
	      }
	      System.out.printf("---------------------\n");

	      System.out.printf("These Cards have these combinations:\n");
	      
	      handCheck check = new handCheck();
	      check.handCheck(fiveCard);
	      
	      System.out.printf("\n\nwe have 2 players in next simulation\n");

	      //7.31
	      deck.shuffle();
	      Card[] p1 = new Card[5];
	      Card[] p2 = new Card[5];
	      for (int i = 0; i < 5; i++) {
	    	  p1[i] = deck.dealCard();
	      } 
	      for (int i = 0; i < 5; i++) {
	    	  p2[i] = deck.dealCard();
	      } 
	      
	      System.out.printf("p1:\n%-15s%-15s\n","Faces:","Suits:");
	      System.out.printf("---------------------\n");
	      for(int i = 0 ; i < 5 ; i++)
	      {
	    	  System.out.printf("%-15s%-15s%n",p1[i].getFace() , p1[i].getSuit());
	      }
	      System.out.printf("---------------------\n");
	      System.out.printf("\n");

	      System.out.printf("p2:\n%-15s%-15s\n","Faces:","Suits:");
	      System.out.printf("---------------------\n");
	      for(int i = 0 ; i < 5 ; i++)
	      {
	    	  System.out.printf("%-15s%-15s%n",p2[i].getFace() , p2[i].getSuit());
	      }
	      System.out.printf("---------------------\n");

	      System.out.printf("\n");
	      check.handsCheck(p1, p2);
	      
	      
	      //i have only tested their hand type , because I am lazy 
	      
	      
	      
	      
	      
	      
	      //you can test my method via unslashing texts below
//	      Card[] owocard = new Card[5];
//	      for(int i=0;i<5;i++) {
//	    	  owocard[i] = new Card("Eight","Heart");
//	    	  
//	    	  
//	      }
//	      System.out.printf("%-15s%-15s\n","Faces:","Suits:");
//	      System.out.printf("---------------------\n");
//	      for(int i = 0 ; i < 5 ; i++)
//	      {
//	    	  System.out.printf("%-15s%-15s%n",owocard[i].getFace() , owocard[i].getSuit());
//	      }
//	      System.out.printf("---------------------\n");
//
//	      System.out.printf("These Cards have these combinations:\n");
//	      deck.handCheck(owocard);
	   } 
	} 
