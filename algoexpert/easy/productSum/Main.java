import java.util.*;

public class Main {
  
  public static int recursiveProductSum(List<Object> array, int depth) {
    int result = 0;
    for (Object element : array) {
      if (element instanceof ArrayList) {
        result += (depth + 1) * recursiveProductSum((List<Object>)element, depth+1);
      } else {
        result += (int)element;
      }
    }
    return result;
  }
  
  public static int productSum(List<Object> array) {
    return recursiveProductSum(array, 1);
  }

  public static void main(String[] args) {
    System.out.println("");
  }
}