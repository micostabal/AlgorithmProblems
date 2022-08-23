import java.util.*;

public class ArrayOfProducts {
    public static int prodOfElements(LinkedList<Integer> list) {
        int result = 1;
        for (int i = 0; i < list.size();i++) {
            result = result * list.get(i);
        }
        return result;
    }

    public static int[] arrayOfProducts(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        LinkedList<Integer> number_q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            number_q.addLast(array[i]);
        }
        for (int i = 0; i < n; i++) {
            result[i] = prodOfElements(number_q);
            number_q.pollFirst();
            number_q.addLast(array[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] ex = new int[] {5, 1, 4, 2};
        int[] result = arrayOfProducts(ex);
        for (int i = 0;i<ex.length;i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println("");
    }
}
