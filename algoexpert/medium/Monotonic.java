import java.util.*;

public class Monotonic {
    public static boolean isMonotonic(int[] array) {
        boolean non_inc = true;
        boolean non_dec = true;
        if (array.length <=1) {
            return true;
        }
        for (int i = 0; i<array.length - 1; i++) {
            if (array[i]<array[i+1]){non_inc=false;};
            if (array[i]>array[i+1]){non_dec = false;};
        }
        return non_inc || non_dec;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 1, 4};
        System.out.println(
            isMonotonic(array)
        );
        

    }
}
