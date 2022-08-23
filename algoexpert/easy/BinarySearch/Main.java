
public class Main {

  public static int binarySearch(int[] array, int target) {
    if (array.length == 1) return array[0] == target ? 0 : -1;
    int li = 0;
    int lf = array.length-1;
    if (array[0] > target || array[lf] < target) return -1;
    while (true) {
      int mid = (int)((li+lf)/2);
      System.out.println(li+", "+lf+", "+mid);
      if (array[li]<target && array[lf] > target && li+1==lf ) {
        break;
      }
      if (array[li] == target) {
        return li;
      } else if (array[lf] == target) {
        return lf;
      } else if (array[mid]<target) {
        li=mid;
      } else if (array[mid]>target) {
        lf=mid;
      } else {
        return mid;
      };
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
    int target = 0;
    int result = binarySearch(array, target);
    System.out.println(result);
  }
}