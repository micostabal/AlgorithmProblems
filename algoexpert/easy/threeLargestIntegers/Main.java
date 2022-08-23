

public class Main {
  
  public static void sortArray(int[] array) {
    boolean sorted=false;
    while (true) {
      for (int i=0;i<array.length-1;i++) {
        if (array[i] > array[i+1]) {
          int aux = array[i];
          array[i] = array[i+1];
          array[i+1] = aux;
        }
      }
      
      sorted=true;
      for (int i=0;i<array.length-1;i++) {
        if (array[i] > array[i+1]) {
          sorted=false;
          break;
        }
      }
      if (sorted) {
        break;
      }
    }
  };
  
  public static int[] findThreeLargestNumbers(int[] array) {
    int[] largestNumbers = {array[0], array[1], array[2]};
    sortArray(largestNumbers);
    for (int i=3;i<array.length;i++) {
      if (array[i] > largestNumbers[0]) {
        largestNumbers[0] = array[i];
        sortArray(largestNumbers);
      };
    }
    return largestNumbers;
  }
  
  public static void main (String[] args) {
    int[] example = {1, 2, 3, 4, 5, 81, 6, 7, 8, 9};
    int[] lns = findThreeLargestNumbers(example);
    for (int i=0;i<3;i++) {
      System.out.print(lns[i]+", ");
    }
    System.out.println("");
  }
}