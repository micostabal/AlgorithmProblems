import java.util.*;

public class ThreeNumberSort {

  public static void swap(int[] array, int i, int j) {
    int aux = array[i];
    array[i] = array[j];
    array[j] = aux;  
  }
  
  public static int[] threeNumberSort(int[] array, int[] order) {
    int[] result = Arrays.copyOf(array, array.length);
    int indexArray = 0;
    int indexOrder = 0;
    while (indexArray < result.length) {
      if (result[indexArray] == order[indexOrder]) {
        indexArray++;
        continue;
      }
      boolean exists = false;
      for (int i=indexArray+1;i<result.length;i++) {
        if (result[i] == order[indexOrder]) {
          swap(result, indexArray, i);
          indexArray++;
          exists=true;
          break;
        }
      }
      if (!exists) {
        indexOrder++;
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
    int[] order = {0, 1, -1};
    int[] tns = threeNumberSort(array, order);
    for (int i=0;i<tns.length;i++) {
      System.out.print(tns[i]+", ");
    }
  }
}
