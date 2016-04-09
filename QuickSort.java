public class QuickSort{
  public static void quickSort(int[] arr,int low, int high){
    if(low<high){
    int spot=partition(arr,low,high);
    quickSort(arr,low,spot);
    quickSort(arr,spot+1,high);
    }
  }
  public static int partition(int[] arr, int low, int high){
  int pivot = arr[low];
  int bot = low-1;
  int top = high+1;
  while(bot<top){
    while(arr[--top]>pivot); //Original Code:  arr[--top].compareTo(pivot)>0
    while(arr[++bot]<pivot); //Original Code:  arr[++bot].compareTo(pivot)<0
    if(bot>=top)
      return top;
    int temp = arr[bot];
    arr[bot] = arr[top];
    arr[top] = temp;
  }
  return -1;  //To avoid compile error. This should be unreachable.
  }
}
  