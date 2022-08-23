import java.util.*;

public class Main {
  public static int[] insertionSort(int[] array) {
    int[] sorted = Arrays.copyOf(array, array.length);
    for (int i=1;i<sorted.length;i++) {
      for (int j=i-1;j>=0;j--) {
        if (sorted[j] > sorted[j+1]) {
          int aux = sorted[j];
          sorted[j] = sorted[j+1];
          sorted[j+1] = aux;
        }
      }
    }
    return sorted;
  }
  
  public static void main(String[] args) {
    int[] array = {3, 2, 5, 4, 6, 9, 7, 8, 1};
    int[] sorted = insertionSort(array);
    for (int i=0;i<sorted.length;i++) {
      System.out.print(sorted[i]+", ");
    }
  }
}
