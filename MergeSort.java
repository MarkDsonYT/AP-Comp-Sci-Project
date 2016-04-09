public class MergeSort{
  public static void mergeSort(int arr[], int front, int back){
   int mid=(front+back)/2;
 if(mid==front) return;
 mergeSort(arr,front,mid);
 mergeSort(arr,mid,back);
 merge(arr,front,back);
  }
  public static void merge(int[] arr,int front, int back){
   int[] temp = new int[back-front];
   int i = front, j = (front+back)/2, k = 0, mid=j;
   while(i<mid&&j<back){     
    if(arr[i]<arr[j]){ //Original Code: arr[i].compareTo(arr[j])<0    
     temp[k++]=arr[i++];
    }else{
     temp[k++]=arr[j++];
    }
   }
   while(i<mid)
    temp[k++]=arr[i++];
   while(j<back)
    temp[k++]=arr[j++];
    for(i=0;i<back-front;++i)
     arr[front+i]=temp[i];
  }
}
