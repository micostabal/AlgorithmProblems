import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    int n = array.length;
    int aux;
    while (true) {
        boolean swapped=false;
        for (int i=0;i<n-1;i++) {
            if (array[i] > array[i+1]) {
                aux = array[i];
                array[i] = array[i+1];
                array[i+1] = aux;
                swapped=true;
            }
        }
        if (!swapped) {
            break;
        }
    }

    return array;
  }

  public static void main(String[] args) {
      int[] myArray = {5, 4, 6, 3, 2, 1};

      bubbleSort(myArray);
      for (int i=0;i<6;i++) {
          System.out.println(myArray[i]);
      }
  }
}
