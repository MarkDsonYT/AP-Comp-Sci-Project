//Michael Chen
//Bill Kong

import javax.swing.*;
import java.util.Scanner;

public class Runner {
 JFrame frame = new JFrame("Input Dialog");
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
  * Normal : 1/2 (Did not specify on the assignment sheet so I assume that the landings for losing and winning are the same.)
  * 
  * 
  * I don't know if the players have starting money, so I'd just tell them how much money they win/lose
  */
 public static int statbuck = 0;    //The money gained/lost for each player
 private static int players = 0;    //Number of players
 private static int rounds = 0;     //Number of rounds 
 private static String[] playerSet; //List of players
 private static int[] playerMoney;  //Money Account for the players
 private static int reset;          //Detects whether to restart the game or not
 
 public static int checkType() { //sets the specific type of spin they want to test the probability out for
  JFrame frame = new JFrame("Input Dialog");
  return Integer.parseInt(JOptionPane.showInputDialog(frame, "If you want to test out your probability for a specific type of special spin, type 1\nif you want to test out your probability for each special spin, type 2\nIf you just want to play the game, type 3\n "));
 }

 public static void main(String[] args) { //MAIN METHOD
  JFrame frame = new JFrame("Input Dialog");

  //This just explains how the game works.
  JOptionPane.showMessageDialog(frame, "Welcome! Get ready to play a game with a Spinner! Here's how to play::\nYou can decide either to make a Normal Spin, or a Special Spin.\nFor a normal spin, you get a 2:1 payout if you win. \nFor a special spin, you can decide either to do a Rogue Spin, a Double Doubler Brown, Double Doubler Yellow, or Triple Tripler");
  JOptionPane.showMessageDialog(frame, "A Rogue Spin will give you a 14:1 payout\nA Double Doubler will give you a 17:1 payout\nA Triple Tripler will give you a 34:1 payout.\nThe chance of winning for a normal spin is 1/2\nThe chance of winning for a Double Doubler is 1/18\nThe chance of winning for a Rogue bet is 17/240\nThe chance of winning for a Triple Tripler is 1/36");
  JOptionPane.showMessageDialog(frame, "A player can only bet 10,20,30,40,or 50 dollars. If you lose on the spinner, you lose the ammount of money you bet.\n");

  do { //The Do-While loop is for the number of times the user wants to play the game, or test out the probability over and over
   int type;
   int check = 0;

   do { //The second Do-While loop is just a checker for the right inputs
    if (check > 0) {
     JOptionPane.showMessageDialog(frame, "Please only type in 1, 2, or 3");
    }
    type = checkType();
    check++;
   } while (!(type == 1 || type == 2 || type == 3));

   if (type == 1) { //This is for if they want to test out the probability for a specific type of special spin
     
    int answerType = Integer.parseInt(JOptionPane.showInputDialog(frame, "\nWhat kind of spin do you want to do?\nType 1 for a rogue spin\nType 2 for a Double Doubler Yellow\nType 3 for a Double Doubler Brown\nType 4 for a Triple Tripler"));
    int answerRound = Integer.parseInt(JOptionPane.showInputDialog(frame, "How many rounds would you like to do?"));
    for (int i = 1; i <= answerRound; i++) {
     System.out.print("Round: " + i + "/" + answerRound + " ");
     Spinner c = new Spinner(answerType);
    }
    JOptionPane.showMessageDialog(frame, "Wins: " + Spinner.wins + "\nLoses: " + Spinner.loses);
    reset = Integer.parseInt(JOptionPane.showInputDialog(frame, "Do you want to play again? Press 1 for yes."));
    Spinner.wins = 0;
    Spinner.loses = 0;

   } else if (type == 2) { //This is if they want to test out the probability for a random selection.
     
    int answerRound = Integer.parseInt(JOptionPane.showInputDialog(frame, "\nHow many rounds do you want to play?"));
    for (int i = 1; i <= answerRound; i++) { //random spintype selector
     System.out.print("Round " + i + "/" + answerRound + " ");
     int selection = (int) Math.round(Math.random() * 4);
     Spinner d = new Spinner(selection, 0);
    }
    JOptionPane.showMessageDialog(frame, "Normal Spin Wins: " + Spinner.normal + "\nNormal Spin Loses: " + Spinner.Lnormal + "\nRogue Spin Wins: " + Spinner.rogue + "\nRogue Spin Loses: " + Spinner.Lrogue + "\nDouble Doubler Yellow Spin Wins: " + Spinner.doubleYellow + "\nDouble Doubler Yellow Spin Loses: " + Spinner.LdoubleYellow + "\nDouble Doubler Brown Spin Wins: " + Spinner.doubleBrown + "\nDouble Doubler Brown Spin Loses: " + Spinner.LdoubleBrown + "\nTriple Tripler Spin Wins: " + Spinner.tripleTripler + "\nTriple Tripler Spin Loses: " + Spinner.LtripleTripler);
    reset = Integer.parseInt(JOptionPane.showInputDialog(frame, "\nDo you want to play again? Press 1 for yes."));
    Spinner.wins = 0;
    Spinner.loses = 0;
    
   } else if (type == 3) {
     
    //This is if they want to PLAY the game
    players = Integer.parseInt(JOptionPane.showInputDialog(frame, "\nLet's play! Enter the number of players :: "));
    playerSet = new String[players]; //Makes an array of the players' names
    playerMoney = new int[players]; //The total money loss/gain for each player
    for (int i = 1; i <= players; i++) { //Sets the names of the players
     playerSet[i - 1] = JOptionPane.showInputDialog(frame, "Enter player " + i + "'s name:: ");
    }
    //number of rounds for each player, 
    rounds = Integer.parseInt(JOptionPane.showInputDialog(frame, "How many rounds do you want to play?"));
    for (int i = 0; i < players; i++) { //this loop starts the game for each player
     JOptionPane.showMessageDialog(frame, playerSet[i] + "'s turn.");
     for (int j = 1; j <= rounds; j++) { //this loop is for each round
      Spinner b = new Spinner();
      playerMoney[i] += Spinner.statbuck; //adds up the money lost/gained from the round into the player's account
     }
    }
    for (int t = 0; t < players; t++) { //If it's in game mode (3), then it will say which player won the most money
     JOptionPane.showMessageDialog(frame, playerSet[t] + " has " + playerMoney[t] + " dollars");
    }
    reset = Integer.parseInt(JOptionPane.showInputDialog(frame, "Do you want to play again? Press 1 for yes."));
   }
  } while (reset == 1);
 }

}
