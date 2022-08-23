import java.util.*;

public class Main {
  public static int[] selectionSort(int[] array) {
    if (array.length == 1) return array;
    int[] sorted = Arrays.copyOf(array, array.length);
    for (int i=0;i<sorted.length;i++) {
      int min = sorted[i];
      int index = i;
      for (int j=i+1;j<sorted.length;j++) {
        if (sorted[j] < min) {
          min = sorted[j];
          index = j;
        }
      }
      int aux = sorted[i];
      sorted[i] = sorted[index];
      sorted[index] = aux;
    }
    return sorted;
  }
  
  public static void main(String[] args) {
    int[] array = {3, 2, 5, 4, 6, 9, 7, 8, 1};
    int[] sorted = selectionSort(array);
    for (int i=0;i<sorted.length;i++) {
      System.out.print(sorted[i]+", ");
    }
  }
}
