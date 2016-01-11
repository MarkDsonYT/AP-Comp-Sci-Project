//Michael Chen
//Bill Kong


import java.util.Scanner;
import javax.swing.*;

public class Spinner {
 public static int statbuck = 0;         //Money gained/lost    
 private static int bet;                 //Bet Ammount
 private static int spinType;            //Spin Type
 private static boolean win;             //If they win or not
 public static int wins = 0;             //Number of Wins
 public static int loses = 0;            //Numer of Loses
 public static int normal = 0, rogue = 0, doubleYellow = 0, doubleBrown = 0, tripleTripler = 0;       //Number of wins for probability of random selections
 public static int Lnormal = 0, Lrogue = 0, LdoubleYellow = 0, LdoubleBrown = 0, LtripleTripler = 0;  //Number of loses for probability of random selections
 JFrame frame = new JFrame("Input Dialog");

 public Spinner() {
  setBet(); //asks for bet ammount
  setSpinType(); //asks for normal or special spin

  if (spinType == 1) { //does the spinning
   win = regularSpinner();
  } else {
   win = specialSpinner(spinType);
  }

  if (win) { //checks if they won or not
   JOptionPane.showMessageDialog(frame, "You won " + payout() + " dollars!\n");
   statbuck = payout();
  } else {
   JOptionPane.showMessageDialog(frame, "You lost " + bet + " dollars!\n");
   statbuck = -1 * bet;
  }
 }

 public Spinner(int specificSpinType) { //This is for probability measuring for a specific special spin.
  specificSpinType++;
  win = specialSpinner(specificSpinType);
  System.out.print("Spin Type: ");
  if (spinType == 1) {              //This is just to print out the process in the console
   System.out.print("Normal ");
  } else if (spinType == 2) {
   System.out.print("Rogue ");
  } else if (spinType == 3) {
   System.out.print("Double Doubler Brown ");
  } else if (spinType == 4) {
   System.out.print("Double Doubler Yellow ");
  } else {
   System.out.print("Triple Tripler ");
  }

  if (win) {     //If they win, then the win counter goes up, if they lose, then the lose counter goes up.
   wins++;
   System.out.println("Won");
  } else {
   loses++;
   System.out.println("Lost");
  }
 }

 public Spinner(int specificSpinType, int nothing) { //This is for probability measuring for random special spin
  specificSpinType++;
  System.out.print("Spin Type: ");
  if (specificSpinType > 1) {
   win = specialSpinner(specificSpinType);
  } else {
   win = regularSpinner();
  }

  if (specificSpinType == 1) {         //This is just to print out the process in the console
   System.out.print("Normal ");
   if (win) {
    normal++;
    System.out.println("Won");
   } else {
    Lnormal++;
    System.out.println("Lost");
   }
  } else if (specificSpinType == 2) {
   System.out.print("Rogue ");
   if (win) {
    rogue++;
    System.out.println("Won");
   } else {
    Lrogue++;
    System.out.println("Lost");
   }
  } else if (specificSpinType == 3) {
   System.out.print("Double Doubler Brown ");
   if (win) {
    doubleYellow++;
    System.out.println("Won");
   } else {
    LdoubleYellow++;
    System.out.println("Lost");
   }
  } else if (specificSpinType == 4) {
   System.out.print("Double Doubler Yellow ");
   if (win) {
    doubleBrown++;
    System.out.println("Won");
   } else {
    LdoubleBrown++;
    System.out.println("Lost");
   }
  } else if (specificSpinType == 5) {
   System.out.print("Triple Tripler ");
   if (win) {
    tripleTripler++;
    System.out.println("Won");
   } else {
    LtripleTripler++;
    System.out.println("Lost");
   }
  }
 }

 public int payout() { //if they win, then here's their reward
  if (spinType == 1) {
   return bet * 2; //normal bet
  } else if (spinType == 2) {
   return bet * 14; //rogue bet
  } else if (spinType == 3 || spinType == 4) {
   return bet * 17; //double doubler
  } else {
   return bet * 34; //triple tripler
  }
 }


 public void setSpinType() { //normal or special spin
  JFrame frame = new JFrame("Input Dialog");
  int a = Integer.parseInt(JOptionPane.showInputDialog(frame, "What kind of spin do you want to do? Type 1 for normal spin, 2 for rogue bet, 3 for double doubler yellow, 4 for double doubler brown or 5 for triple tripler"));
  if (!(a == 1 || a == 2 || a == 3 || a == 4 || a == 5)) {
   JOptionPane.showMessageDialog(frame, "Please only type in 1,2,3,4, or 5\n");
   setSpinType();
  } else {
   spinType = a;
  }
 }


 public static void checkBet(int a) { //check if the bet is okay
  JFrame frame = new JFrame("Input Dialog");
  if (!(bet == 10 || bet == 20 || bet == 30 || bet == 40 || bet == 50)) {
   JOptionPane.showMessageDialog(frame, "Please only type in 10,20,30,40, or 50.\n");
   setBet();
  }
 }


 public boolean specialSpinner(int a) { //special spin    
  if (a == 2) { //rogue bet, 17/240 chance  (0.07)
   if (Math.random() * 240 < 17) { // Since Math.random() is 0-0.9999, I made the symbol < instead of <= 
    return true;
   } else {
    return false;
   }
  } else if (a == 3 || a == 4) { //double doubler bet, 1/18 chance  (0.05)
   if (Math.random() * 18 < 1) {
    return true;
   } else {
    return false;
   }
  } else if (a == 5) { //triple tripler  (0.02)
   if (Math.random() * 36 < 1) {
    return true;
   } else {
    return false;
   }
  }
  return false;
 }

 public boolean regularSpinner() { //normal spin (0.5)
  if (Math.random() * 2 < 1) {
   return true;
  } else {
   return false;
  }
 }

 public static void setBet() { //sets the bet
  JFrame frame = new JFrame("Input Dialog");
  bet = Integer.parseInt(JOptionPane.showInputDialog(frame, "How much do you want to bet?"));
  checkBet(bet); //checks if the bet is okay
 }
}
