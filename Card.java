package hw123;

import java.util.Arrays;

public class Card {
   private final String face; 
   private final String suit; 
   //construct 
   
   public Card(String cardFace, String cardSuit) {
      this.face = cardFace; 
      this.suit = cardSuit; 
   } 

   public String toString() {             
      return this.face + " of " + this.suit;        
   }    
   
   protected String getFace() {
	   return this.face;
   }
   
   protected String getSuit() {
	   return this.suit;
   }
   
   protected int getSuit_number() {
	   String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
	   int i;
	   for(i = 0 ; i < 4 ; i++)
	   {
		   if(suits[i] == suit)
		   {
			   break;
		   }
	   }
	   return i;
   }
   
   protected int getFace_number() {
	   String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
		         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"}; 
	   int i;
	   for(i = 0 ; i < 13 ; i++)
	   {
		   if(faces[i] == this.face)
		   {
			   break;
		   }
	   }
	   return i;
   }
   
  
   
} 
