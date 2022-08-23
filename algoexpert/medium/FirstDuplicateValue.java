import java.util.*;

public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        Set<Integer> values = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!values.contains(array[i])) {
                values.add(array[i]);
            } else {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int[] array = new int[] {1, 2, 3, 4, 5, 6};
        
        System.out.println(
            firstDuplicateValue(array)
        );
    }
}
