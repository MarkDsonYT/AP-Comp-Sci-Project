import java.util.Scanner;
/**
 * A stopwatch accumlates time when it is running.  You can
 * repeatedly start and stop the stopwatch.  You can use a
 * stopwatch to measure the running time of code.
 * 
 * @author (Cay Horstman) 
 * @version (a version number or a date)
 */
public class StopWatch
{
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    
    public StopWatch()
    {
        reset();
    }
    
    public void start()
    {
        if (isRunning)
            return;
        isRunning = true;
        startTime = System.currentTimeMillis();
        System.out.println(startTime);
    }

    public void stop()
    {
        if (!isRunning)
            return;
        isRunning = false;
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        elapsedTime = elapsedTime + endTime - startTime;
    }
    
    public long getElapsedTime()
    {
        if (isRunning)
        {
            long endTime = System.currentTimeMillis();
            elapsedTime = elapsedTime + endTime - startTime;
            startTime = endTime;
        }
        return elapsedTime;
    }
    
    public void reset()
    {
        elapsedTime = 0;
        isRunning = false;
    }
    
    //Let's test it
    public static void main(String[] args)
    {
        StopWatch myWatch = new StopWatch();
        System.out.println("Enter number of entries");
        Scanner keys = new Scanner(System.in);
        int size = keys.nextInt();
        System.out.println("Enter number of trials");
        int trials = keys.nextInt();
        long count1 = 0;
        for(int i = 1; i < trials; i++)
        {
        int[] arr1 = MakeArray.randomArr(size);
        myWatch.start();
        MergeSort.mergeSort(arr1);
        myWatch.stop();
        long time1 = myWatch.getElapsedTime();
        count1+= time1;
        }
        System.out.println("Merge Average = " + (double)count1/trials);
        System.out.println();
        long count2 = 0;
        for(int i = 1; i < trials; i++)
        {
        int[] arr2 = MakeArray.randomArr(size);
        myWatch.start();
        InsertionSort.insertionSort(arr2);
        myWatch.stop();
        long time2 = myWatch.getElapsedTime();
        count2+= time2;
        }
        System.out.println("Insertion Average = " + (double)count2/trials);
        }
    
}
