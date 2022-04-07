package hw123;

import java.security.SecureRandom;

public class hw7_18 {
   private static final SecureRandom randomNumbers = new SecureRandom();

   private enum Status {CONTINUE, WON, LOST};                

   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;      
   private static final int SEVEN = 7;     
   private static final int YO_LEVEN = 11; 
   private static final int BOX_CARS = 12;
   private static final int ROLL_TIMES= 22;

   public static void main(String[] args) {
	  int[] won = new int[ROLL_TIMES];
	  int[] lost = new int[ROLL_TIMES];
	  int won_times = 0;
	  long total_length = 0;
	  for(int counter = 0 ; counter < 1_000_000 ; counter++) {
		  int myPoint = 0; 
	      int times = 1;
		  Status gameStatus; 
	      
	      int sumOfDice = rollDice(); 
	 
	      switch (sumOfDice) {
	         case SEVEN:    
	         case YO_LEVEN: 
	            gameStatus = Status.WON;
	            break;
	         case SNAKE_EYES: 
	         case TREY:   
	         case BOX_CARS: 
	            gameStatus = Status.LOST;
	            break;
	         default: 
	            gameStatus = Status.CONTINUE; 
	            myPoint = sumOfDice;      
	            break; 
	      }
	
	      while (gameStatus == Status.CONTINUE) { 
	         sumOfDice = rollDice(); 
	         times++;
	         if (sumOfDice == myPoint) { 
	            gameStatus = Status.WON;
	         } 
	         else { 
	            if (sumOfDice == SEVEN) {
	               gameStatus = Status.LOST;
	            } 
	         } 
	      } 
	
	      if (gameStatus == Status.WON) {
	    	  if(times <= 20)
	    		  won[times]++;
	    	  else
	    		  won[ROLL_TIMES - 1]++;
	    	  won_times++;
	      } 
	      else {
	    	  if(times <= 20)
	    		  lost[times]++;
	    	  else
	    		  lost[21]++;
	      }  
	      total_length += times;
	  }
	  System.out.printf("Game you wins:\n");
      for(int i = 1 ; i < ROLL_TIMES-1 ; i++) {
    	  System.out.printf("Won on %d roll games: %d\n",i,won[i]);
      }
      System.out.printf("Won on more than 20 games: %d\n\n", won[21]);
      System.out.printf("Game you losts:%n");
      for(int roll = 1 ; roll < ROLL_TIMES-1 ; roll++) {
    	  System.out.printf("Lost on %d roll games: %d\n",roll,lost[roll]);
      }
      System.out.printf("Lost on more than 20 games: %d\n\n", lost[21]);

      System.out.printf("the chances of winning at craps: %f\n",(double)won_times/1_000_000);
      //(7.18.4)
      
      System.out.printf("the average length of one crap game: %f\n\n",(double)total_length/1_000_000);
	  
      //(7.18.1)
      System.out.printf("Does chance of winning improve as length increase?:\n\n");
	  for(int i = 1 ; i < ROLL_TIMES ; i++) {
	    System.out.printf("Won on %d roll games: %f%n",i,(double)won[i]/(won[i]+lost[i]));
	  }
	  System.out.printf("No\n");
   } 

   public static int rollDice() {
      int die1 = 1 + randomNumbers.nextInt(6); 
      int die2 = 1 + randomNumbers.nextInt(6); 

      int sum = die1 + die2; 

      return sum; 
   } 
} 
