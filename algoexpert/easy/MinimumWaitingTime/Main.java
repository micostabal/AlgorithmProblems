
public class Main {
  
  public static void sortArray(int[] array) {
    while (true) {
      for (int i=0;i<array.length-1;i++) {
        if (array[i] > array[i+1]) {
          int aux = array[i];
          array[i] = array[i+1];
          array[i+1] = aux;
        }
      }
      
      boolean sorted=true;
      for (int i =0;i<array.length-1;i++) {
        if (array[i] > array[i+1]) {
          sorted=false;
          break;
        }
      }
      if (sorted) {
        break;
      }
    }
  }
  
  public static int minimumWaitingTime(int[] queries) {
    if (queries.length == 1) return 0;
    sortArray(queries);
    int MWT = 0;
    for (int i=0;i<queries.length;i++) {
      MWT += (queries.length - i - 1) * queries[i];
    }
    return MWT;
  }
  
  public static void main(String[] args) {
    int[] queries = {3, 2, 1, 2, 6};
    System.out.println(
      minimumWaitingTime(queries)
    );
  }
}