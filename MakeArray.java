public class MakeArray
{
  
  public static int[] randomArr(int k)
  {
  int[] list = new int[k];
  for(int i = 0; i < list.length; i++)
  {
    int val = (int)(Math.random()*(10000)-5000);
    list[i] = val;
  }
  return list;
  }
}
