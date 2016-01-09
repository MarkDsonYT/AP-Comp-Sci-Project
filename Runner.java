//Michael Chen
//Bill Kong

import java.util.Scanner;


public class Runner{
  Scanner k = new Scanner(System.in);
  /*
   *  
   * 
   * Bet 10-50 dollars, 
   * 
   * Normal Spin: 2x
   * 
   * Special Spins:
   * Double Doubler Yellow/Brown: 17x
   * Triple Tripler: 35x
   * Rogue Bet: 14x
   * 
   * Chance of Winning: 
   * Double Doubler Yellow/Brown: 1/18
   * Rogue: 17/240
   * Triple Tripler: 1/36
   * Normal : 1/2
   * 
   * 
   * I don't know if the players have starting money, so I'd just tell them how much money they win/lose
   */
  public static int statbuck = 0;             

  private static int players = 0;
  private static int rounds = 0;
  private static int bet;

  private static String[] playerSet;
  private static int[] playerMoney;
  private static int reset;
  
  public Runner(){
  }


  public static void checkBet(int a){      //check if the bet is okay
        if(!(bet==10||bet==20||bet==30||bet==40||bet==50)){
         System.out.println("Please only type in 10,20,30,40, or 50.\n");
         setBet();
      }
  }
 
  

    public static void setBet(){        //sets the bet
      Scanner k = new Scanner(System.in);
      System.out.println("How much do you want to bet?");
      bet = k.nextInt();
      checkBet(bet);   
    }
    
    public static int checkType(){
      Scanner k = new Scanner(System.in);
      System.out.println("If you want to test out your probability for a specific type of special spin, type 1\nif you want to test out your probability for each special spin, type 2\nIf you just want to play the game, type 3\n ");
      return k.nextInt();
    }
    
  public static void main(String[] args){
    Scanner k = new Scanner(System.in);
    
    //This just explains how the game works.
    System.out.println("Welcome! Get ready to play a game with a Spinner! Here's how to play::\nYou can decide either to make a Normal Spin, or a Special Spin.\nFor a normal spin, you a 2:1 payout if you win. \nFor a special spin, you can decide either to do a Rogue Spin, a Double Doubler, or Triple Tripler");
    System.out.println("A Rogue Spin will give you a 14:1 payout\nA Double Doubler will give you a 17:1 payout\nA Triple Tripler will give you a 34:1 payout.\nThe chance of winning for a normal spin is 1/2");
    System.out.println("The chance of winning for a Double Doubler is 1/18\nThe chance of winning for a Rogue bet is 17/240\nThe chance of winning for a Triple Tripler is 1/36");
    System.out.println("A player can only bet 10,20,30,40,or 50 dollars. If you lose on the spinner, you lose the ammount of money you bet.\n");
    
    int type;  
    int check = 0;
    do{             //Asks whether to do probability (random or specific), or to play for fun.
      if(check>0){
      System.out.println("Please only type in 1, 2, or 3");   
      }
    type = checkType();
     check++;
    }while(!(type==1||type==2||type==3));
    
    
    if(type==1){  //This is if they want to test out the probability for a specific type of special spin
     System.out.println("\nWhat kind of spin do you want to do?\nType 1 for a rogue spin\nType 2 for a Double Doubler Yellow\nType 3 for a Double Doubler Brown\nType 4 for a Triple Tripler");
     int  answerType = k.nextInt();
     System.out.println("How many rounds would you like to do?");
     int answerRound = k.nextInt();
      /*
         
  public boolean specialSpinner(int a){    //special spin    
    if(a==2){     //rogue bet, 17/240 chance  (0.07)
      if(Math.random()*240 < 17){      // Since Math.random() is 0-0.9999, I made the symbol < instead of <= 
      return true;
      } else {
      return false;
      }
    } else if(a==3||a==4){   //double doubler bet, 1/18 chance  (0.05)
      if(Math.random()*18 < 1){
      return true;
      } else {
      return false;
      } 
    } else if(a==5){   //triple tripler  (0.02)
      if(Math.random()*36 < 1){
      return true;
      } else {
      return false;
      }
    }  
    return false;
  }  
  
  */
      
    } else if(type==2){

      
      /*
       
         public boolean specialSpinner(int a){    //special spin    
    if(a==2){     //rogue bet, 17/240 chance  (0.07)
      if(Math.random()*240 < 17){      // Since Math.random() is 0-0.9999, I made the symbol < instead of <= 
      return true;
      } else {
      return false;
      }
    } else if(a==3||a==4){   //double doubler bet, 1/18 chance  (0.05)
      if(Math.random()*18 < 1){
      return true;
      } else {
      return false;
      } 
    } else if(a==5){   //triple tripler  (0.02)
      if(Math.random()*36 < 1){
      return true;
      } else {
      return false;
      }
    }  
    return false;
  }  
       
       */
      
      
    }  
     else if(type==3){
    
    do{  //This is if they want to PLAY the game
    System.out.println("\nLet's play! Enter the number of players :: ");    //For recreational purposes
    players = k.nextInt();
    playerSet = new String[players];  //Makes an array of the players' names
    playerMoney = new int[players];   //The total money loss/gain for each player
   
    String useless = k.nextLine();  //I don't know why but the first .nextLine() doens't work intially, so if you delete this, then you can't put in player 1's name.
    for(int i = 1; i<=players; i++){     //Sets the names of the players
      System.out.println("Enter player "+i+"'s name:: ");
      playerSet[i-1] = k.nextLine();
    }

    System.out.println("How many rounds do you want to play?");        //number of rounds for each player, 
    rounds = k.nextInt();
    
    for(int i=0; i<players; i++){     //this loop starts the game for each player
      System.out.println(playerSet[i]+"'s turn.");    
      
    /***/for(int j = 1; j <= rounds; j++){   //this loop is for each round
      System.out.println("Round "+j+" :: ");
      Spinner b = new Spinner();  
      playerMoney[i] += Spinner.statbuck;  //adds up the money lost/gained from the round into the player's account
    }/***/
  }

    for(int t=0; t<players; t++){
    System.out.println(playerSet[t]+" has "+playerMoney[t]+" dollars");
    }
    System.out.println("Do you want to play again? Press 1 for yes.");
    reset = k.nextInt();
  }while(reset==1);
  
    }
  
  }
  
}
