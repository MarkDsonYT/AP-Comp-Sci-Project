import java.util.Scanner;


public class Spinner{
  
    public static int statbuck = 0;             
  private static int betAmmount = 0;
  private static int players = 0;
  private static int rounds = 0;
  private static int bet;
  private static int spinType;
  private static boolean win;
  private static String[] playerSet;
  private static int[] playerMoney;
  public static int wins = 0;
  public static int loses = 0;
  public static int normal = 0, rogue = 0, doubleYellow = 0, doubleBrown = 0, tripleTripler = 0;
  
   Scanner k = new Scanner(System.in);

   public Spinner(){
   setBet();     //asks for bet ammount
    setSpinType();   //asks for normal or special spin

    if(spinType==1){                //does the spinning
     win = regularSpinner();
    } else {
    win = specialSpinner(spinType);
    }
    
    if(win){      //checks if they won or not
      System.out.println("You won "+payout()+" dollars!\n");
      statbuck = payout();
    } else {
      System.out.println("You lost "+bet+" dollars!\n");
      statbuck = -1 * bet;
    }
   }

   public Spinner(int specificSpinType){  //This is for probability measuring for a specific special spin.
   specificSpinType++;
   win = specialSpinner(specificSpinType);
   if(win){
   wins++;
   }else{
   loses++;
   }
   }

   public Spinner(int specificSpinType, int nothing){//This is for probability measuring for random special spin
    win = specialSpinner(specificSpinType);
    if(specificSpinType==1){
      if(win){
      normal++;
      }
    } else if(specificSpinType==2){
      if(win){
      rogue++;
      }
    } else if(specificSpinType==3){
      if(win){
        doubleYellow++;
      }
    } else if(specificSpinType==4){
      if(win){
        doubleBrown++;
      }
    }else if(specificSpinType==5){
      if(win){
      tripleTripler++;
      }
    }
   }

  public int payout(){   //if they win, then here's their reward
    if(spinType==1){
    return bet*2;   //normal bet
    } else if(spinType==2){
    return bet*14;   //rogue bet
    } else if(spinType==3||spinType==4){
    return bet*17;  //double doubler
    } else {
    return bet*34;  //triple tripler
    }
  }
  
  
  public void setSpinType(){     //normal or special spin
   Scanner k = new Scanner(System.in);
    System.out.println("What kind of spin do you want to do? Type 1 for normal spin, 2 for rogue bet, 3 for double doubler yellow, 4 for double doubler brown or 5 for triple tripler");
    int a = k.nextInt();
    if(!(a==1||a==2||a==3||a==4||a==5)){
    System.out.println("Please only type in 1,2,3,4, or 5\n");
    setSpinType();
    } else {
    spinType = a;
    }
  }
  

  public static void checkBet(int a){      //check if the bet is okay
        if(!(bet==10||bet==20||bet==30||bet==40||bet==50)){
         System.out.println("Please only type in 10,20,30,40, or 50.\n");
         setBet();
      }
  }
  
  
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
  
    public boolean regularSpinner(){     //normal spin (0.5)
      if(Math.random()*2 < 1){
        return true;
      } else {
    return false;
      }
  }
  
    public static void setBet(){        //sets the bet
      Scanner k = new Scanner(System.in);
      System.out.println("How much do you want to bet?");
      bet = k.nextInt();
      checkBet(bet);   //checks if the bet is okay
    }




}
