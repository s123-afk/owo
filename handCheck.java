package hw123;

import java.util.Arrays;

public class handCheck {
	 //used in handCheck
	   protected int num_of_pair;
	   protected boolean three_kind = false;
	   protected boolean four_kind = false;
	   protected boolean flush = true;
	   protected boolean straight = true;
	   protected boolean full_house = false;
	   protected int poker_strength = 0 ;
	   
	   public void handCheck(Card[] fiveCard) {

		   int[] val_of_face = new int[5];
		   num_of_pair = 0 ; //pair can be 2 ,so i use int
		   
		   
		   
		   for(int i=0;i<5;i++) {
			   val_of_face[i] = fiveCard[i].getFace_number();
		   }
		   Arrays.sort(val_of_face);
		   
		   //pairs
		   for(int i=0;i<4;i++) {
			   if(i==4) {
				   break;
			   }
			   if(val_of_face[i] == val_of_face[i+1]) {
				   num_of_pair++;
				   i+=1;
			   }
		   }
		   
		   //three kind
		   for(int i=0;i<3;i++) {
			   if(val_of_face[i]==val_of_face[i+1] && val_of_face[i+1]==val_of_face[i+2]) {
				   three_kind = true;
				   break;
			   }
		   }
		   
		   //four kind
		   for(int i=0;i<2;i++) {
			   if(val_of_face[i]==val_of_face[i+1] && val_of_face[i+1]==val_of_face[i+2] && val_of_face[i+2]==val_of_face[i+3]) {
				   four_kind = true;
				   break;
			   } 
		   }	   
		   
		   //flush
		   for(int i=0;i<4;i++) {
			   if(fiveCard[i].getSuit_number() != fiveCard[i+1].getSuit_number()) {
				   flush = false;
				   break;
			   }
		   }
		   
		   //straight
		   for(int i=0;i<4;i++) {
			   if(val_of_face[i] +1 != val_of_face[i+1] ) {
				   straight = false;
				   break;
			   }
			   
		   }
		   
		   //full house
		   if(val_of_face[0]==val_of_face[1] && val_of_face[2]==val_of_face[3] && val_of_face[3]==val_of_face[4]) {
			   full_house = true;
		   }
		   else if(val_of_face[0]==val_of_face[1] && val_of_face[1]==val_of_face[2] && val_of_face[3]==val_of_face[4]) {
			   full_house = true;
		   }
		   
		   //printing section
		   //pair
		   if(num_of_pair>0) {
			   System.out.printf("exist %d pairs\n", num_of_pair);
		   }
		   if(three_kind) {
			   System.out.printf("exists three kind\n");
			   poker_strength=1;
		   }
		   if(four_kind) {
			   System.out.printf("exists four kind\n");
			   poker_strength=5;
		   }
		   if(flush) {
			   System.out.printf("exists flush\n");
			   poker_strength=3;
		   }
		   if(straight) {
			   System.out.printf("exists straight\n");
			   poker_strength=2;
		   }
		   if(full_house) {
			   System.out.printf("exists full_house\n");
			   poker_strength=4;
		   }
		   if(straight && flush) {
			   System.out.printf("OMG, it's a straight flush!\n");
			   poker_strength=6;
		   }
		   
		   
	   }
	   
	   
	   
	    //7.31
	   public void handsCheck(Card[] p1,Card[] p2) {
		   poker_strength=0;
		   handCheck checkp1 = new handCheck();
		   handCheck checkp2 = new handCheck();
		   System.out.printf("p1 has these combinations:\n");
		   checkp1.handCheck(p1);
		   System.out.printf("p2 has these combinations:\n");
		   checkp2.handCheck(p2);
		   System.out.printf("\n\n");

		   if(checkp1.poker_strength > checkp2.poker_strength) {
			   System.out.printf("p1 has bigger hand\n");
		   }
		   else if(checkp2.poker_strength > checkp1.poker_strength) {
			   System.out.printf("p2 has bigger hand\n");
		   }
		   else {
			   if(checkp1.poker_strength>0) {
				   System.out.printf("p1 and p2 have equal hand\n");
			   }
			   else{
				   if(checkp1.num_of_pair>checkp2.num_of_pair) {
					   System.out.printf("p1 has bigger hand\n");
				   }
				   else if(checkp2.num_of_pair>checkp1.num_of_pair) {
					   System.out.printf("p2 has bigger hand\n");
				   }
				   else {
					   System.out.printf("p1 and p2 have equal hand\n");
				   }	
			   }
			   
		   }
	   }
}
