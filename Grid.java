/*Michael Chen
 * APCS
 * WP Game of Life
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
public class Grid{
  
  private String grid[][];  //Grid
  private int generation; //Generation number
  private static ArrayList<Integer> neighbors;
  
  public Grid(){ //Make new empty Grid
    neighbors = new ArrayList<Integer>(0);
    generation = 1;
    grid = new String[20][20];
    for(int r = 0; r<grid.length;r++){
      for(int c = 0; c<grid[0].length;c++){
         grid[r][c] = " _";
      }
    }
     try { 
       setGrid();     //instantiate the grid with values
     } catch(Exception e) {
     //  System.out.println("Oh Noes");
    }
  }
  
  public void printGrid(){         //prints out the grid
    System.out.println("\nGeneration: "+generation);
    for(int r = 0;r <grid.length;r++){
      for(int c = 0;c<grid[0].length;c++){
    System.out.print(grid[r][c]);
      }
      System.out.println();
    }
  }
  
  public void newGen(){  //new generation
   generation++;
   for(int r=0;r<grid.length;r++){
     for(int c=0;c<grid[0].length;c++){
       if(grid[r][c].equals(" X")){   //if cell is ALIVE   
         int count = getNeighbors(r,c);
         if(count<2||count>3){
         grid[r][c]=" _";
         }
       }else{  //if cell is empty
         int count = getNeighbors(r,c);
         neighbors.add(count);
    //     if(r==1&&c==5)System.out.println(count);
         if(count==3)
           grid[r][c]=" X"; //cell is alive if there are 3 neighbors
         }
       }
     }
   }
  
  
  public int getNeighbors(int r, int c){ //Counts number of neighbors
    int count = 0;
    if(r==0){  //if cell top border
      if(c==0){ //if cell is on top left corner
        if(grid[r+1][c+1].equals(" X"))
         count++;
        if(grid[r][c+1].equals(" X"))
         count++;
        if(grid[r+1][c].equals(" X"))
         count++;
        return count;
      } else if(c==grid.length-1){ //if cell is on top right corner
      if(grid[r+1][c].equals(" X"))
         count++;
        if(grid[r][c-1].equals(" X"))
         count++;
        if(grid[r+1][c-1].equals(" X"))
         count++;
        return count;
      } else {  //if cell is on top row not touching sides
         if(grid[r][c-1].equals(" X"))
         count++;
        if(grid[r][c+1].equals(" X"))
         count++;
        if(grid[r+1][c].equals(" X"))
         count++;
        if(grid[r+1][c-1].equals(" X"))
         count++;
        if(grid[r+1][c+1].equals(" X"))
         count++;
        return count;
      }
    }else if(r==grid.length-1){ //if cell is on bottom border
      if(c==0){ // if cell is on bottom left
        if(grid[r-1][c].equals(" X"))
         count++;
        if(grid[r-1][c+1].equals(" X"))
         count++;
        if(grid[r][c+1].equals(" X"))
         count++;
        return count;
      } else if (c==grid.length-1){  //if cell is on bottom right
        if(grid[r-1][c].equals(" X"))
         count++;
        if(grid[r][c-1].equals(" X"))
         count++;
        if(grid[r-1][c-1].equals(" X"))
         count++;
        return count;
      } else { // if cell is on bottom row not touching sides
        if(grid[r-1][c].equals(" X"))
         count++;
        if(grid[r-1][c-1].equals(" X"))
         count++;
        if(grid[r-1][c+1].equals(" X"))
         count++;
        if(grid[r][c-1].equals(" X"))
         count++;
        if(grid[r][c+1].equals(" X"))
         count++;
        return count;
      }
    } else if (c==0){//left side
      if(grid[r-1][c].equals(" X"))
         count++;
      if(grid[r+1][c].equals(" X"))
         count++;
      if(grid[r-1][c+1].equals(" X"))
         count++;
      if(grid[r+1][c+1].equals(" X"))
         count++;
      if(grid[r][c+1].equals(" X"))
         count++;
      return count;
    } else if (c==grid.length-1){ //right side
      if(grid[r-1][c].equals(" X"))
         count++;
      if(grid[r+1][c].equals(" X"))
         count++;
      if(grid[r-1][c-1].equals(" X"))
         count++;
      if(grid[r+1][c-1].equals(" X"))
         count++;
      if(grid[r][c-1].equals(" X"))
         count++;
      return count; 
    }else {  //if cell is not on the border
         if(grid[r+1][c+1].equals(" X"))
         count++;
         if(grid[r+1][c].equals(" X"))
         count++;
         if(grid[r+1][c-1].equals(" X"))
         count++;
         if(grid[r][c+1].equals(" X"))
         count++;
         if(grid[r][c-1].equals(" X"))
         count++;
         if(grid[r-1][c+1].equals(" X"))
         count++;
         if(grid[r-1][c].equals(" X"))
         count++;
         if(grid[r-1][c-1].equals(" X"))
         count++;
   return count;
    }
  }
  
  public void setGrid()throws FileNotFoundException{     //makes the values in grid
    Scanner k;
    File file = new File("life100.txt");
    k = new Scanner(file);
    int ammount = k.nextInt();
 //   System.out.println(ammount);
    int x[] = new int[ammount/2];
    int y[] = new int[ammount/2];
    int xCount = 0;
    int yCount = 0;
    for(int i=0;i<ammount;i++){
      if(i==0||i%2==0){
        x[xCount] = k.nextInt();
        xCount++;
      }else{
        y[yCount] = k.nextInt();
        yCount++;
      }
    }
    /*
    System.out.println(Arrays.toString(x));
    System.out.println(Arrays.toString(y));
   */
    for(int i=0;i<ammount/2;i++){
      int ax = x[i]-1;
      int ay = y[i]-1;
      grid[ax][ay] = " X";
    }
  }
  
  public static void main(String[] beef){
    Grid run = new Grid();
  run.printGrid();   //1st Generation
  run.newGen();
 /* for(int i=0;i<neighbors.size();i++)
    System.out.print(" "+i+":"+neighbors.get(i));
    */
  run.printGrid();   //2nd Generation
  run.newGen();
  run.printGrid();
  run.newGen();
  run.printGrid();
  run.newGen();
 run.printGrid();
  run.newGen();
 run.printGrid();
 run.newGen();
 run.printGrid();
 run.newGen();
 run.printGrid();
 
  }
}