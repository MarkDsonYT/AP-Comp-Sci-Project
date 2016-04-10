import java.util.Scanner;
import java.util.Arrays;
/**
 * When you enter the number of entries, make sure that it's a HIGH number. Low numbers will tend to have an elapsed time of 0.
 */
public class StopWatch {
 private static long elapsedTime;
 private long startTime;
 private boolean isRunning;

 public StopWatch() {
  reset();
 }

 public void start() {
  if (isRunning)
   return;
  isRunning = true;
  startTime = System.currentTimeMillis();
  //   System.out.println(startTime);
 }

 public void stop() {
  if (!isRunning)
   return;
  isRunning = false;
  long endTime = System.currentTimeMillis();
  // System.out.println(endTime);
  elapsedTime = elapsedTime + endTime - startTime;
 }

 public long getElapsedTime() {
  if (isRunning) {
   long endTime = System.currentTimeMillis();
   elapsedTime = elapsedTime + endTime - startTime;
   startTime = endTime;
  }
  return elapsedTime;
 }

 public void reset() {
  elapsedTime = 0;
  isRunning = false;
 }

 //Let's test it
 public static void main(String[] args) {

  StopWatch myWatch = new StopWatch();
  System.out.println("Enter number of entries"); // size of arrays
  Scanner keys = new Scanner(System.in);
  int size = keys.nextInt();
  System.out.println("Enter number of trials"); //number of times to run 
  int trials = keys.nextInt();

  //MERGE SORT
  long count1 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr1 = MakeArray.randomArr(size);
   int back = arr1.length - 1;
   myWatch.start();
   MergeSort.mergeSort(arr1, 0, back); //mergeSort has 3 values in the parameter
   myWatch.stop();
   long time1 = myWatch.getElapsedTime();
   count1 += time1;
  }
  System.out.println("Merge Total Time: " + count1);
  System.out.println("Merge Average = " + (double) count1 / trials);
  System.out.println();

  //INSERTION SORT
  myWatch.reset();
  long count2 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr2 = MakeArray.randomArr(size);
   myWatch.start();
   InsertionSort.insertionSort(arr2);
   myWatch.stop();
   long time2 = myWatch.getElapsedTime();
   count2 += time2;
  }
  System.out.println("Insertion Total Time: " + count2);
  System.out.println("Insertion Average = " + (double) count2 / trials);
  System.out.println();

  //BUBBLE SORT
  myWatch.reset();
  long count3 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr3 = MakeArray.randomArr(size);
   myWatch.start();
   BubbleSort.bubbleSort(arr3);
   myWatch.stop();
   long time3 = myWatch.getElapsedTime();
   count3 += time3;
  }
  System.out.println("Bubble Total Time: " + count3);
  System.out.println("Bubble Average = " + (double) count3 / trials);
  System.out.println();

  //SELECTION SORT
  myWatch.reset();
  long count5 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr5 = MakeArray.randomArr(size);
   myWatch.start();
   SelectionSort.selectionSort(arr5);
   myWatch.stop();
   long time5 = myWatch.getElapsedTime();
   count5 += time5;
  }
  System.out.println("Total Time: " + count5);
  System.out.println("Selection Average = " + (double) count5 / trials);
  System.out.println();

  //LINEAR SEARCH
  myWatch.reset();
  long count6 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr6 = MakeArray.randomArr(size);
   Arrays.sort(arr6);
   int val = (int)(Math.random() * (10000) - 5000);
   myWatch.start();
   LinearSearch.search(arr6, val);
   myWatch.stop();
   long time6 = myWatch.getElapsedTime();
   count6 += time6;
  }
  System.out.println("Linear Total Time: " + count6);
  System.out.println("Linear Search Average = " + (double) count6 / trials);
  System.out.println();

  //BINARY SEARCH
  myWatch.reset();
  long count7 = 0;
  for (int i = 1; i < trials; i++) {
   myWatch.reset();
   int[] arr7 = MakeArray.randomArr(size);
   Arrays.sort(arr7);
   int val = (int)(Math.random() * (10000) - 5000);
   myWatch.start();
   BinarySearch.findVal(arr7, val);
   myWatch.stop();
   long time7 = myWatch.getElapsedTime();
   count7 += time7;
  }
  System.out.println("Binary Total Time: " + count7);
  System.out.println("Binary Search Average = " + (double) count7 / trials);
  System.out.println();
	 
  keys.close();
 }
}
