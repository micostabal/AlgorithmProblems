import java.util.*;


public class Main {
  
  public static void sortArray(int[] array, boolean ascending) {
    boolean sorted=false;
    while (true) {
      for (int i=0;i<array.length-1;i++) {
        if (array[i] > array[i+1] && ascending
         || array[i] < array[i+1] && !ascending) {
          int aux = array[i];
          array[i] = array[i+1];
          array[i+1] = aux;
        }
      }
      
      sorted=true;
      for (int i=0;i<array.length-1;i++) {
        if (array[i] > array[i+1] && ascending ||
         array[i] < array[i+1] && !ascending) {
          sorted=false;
          break;
        }
      }
      if (sorted) {
        break;
      }
    }
  };
  
  public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    sortArray(redShirtSpeeds, true);
    sortArray(blueShirtSpeeds, !fastest);
    
    int totalSpeed = 0;
    for (int i=0;i<redShirtSpeeds.length;i++) {
      totalSpeed += Integer.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
    }
    
    return totalSpeed;
  }
  
  public static void main(String[] args) {
    int[] redShirt = {5, 5, 3, 9, 2};
    int[] blueShirt = {3, 6, 7, 2, 1};
    
    System.out.println(tandemBicycle(redShirt, blueShirt, true));

  }
}