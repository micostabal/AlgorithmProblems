import java.util.*;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int p = -1;
        int u = -1;
        int left = 0;
        int right = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            if (p < 0 && array[i] > array[i+1]) {
                p = i;
            } if (array[i] > array[i+1]) {
                u = i;
            }
        }
        if (p == -1 && u == -1) {
            return new int[] {-1, -1};
        }
        
        int max_box = array[p];
        int min_box = array[p];
        for (int i = p; i <= u + 1; i++) {
            max_box = Math.max(max_box, array[i]);
            min_box = Math.min(min_box, array[i]);
        }

        for (int i = array.length - 1; i >= u + 1; i--) {
            if (array[i] >= max_box && array[i - 1] < max_box) {
                right = i - 1;
                break;
            }
        }

        for (int i = 0; i < p; i++) {
            if (array[i] <= min_box && array[i + 1] > min_box) {
                left = i + 1;
                break;
            }
        }

        return new int[] {left, right};
    }

    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2};

        int[] result = subarraySort(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println("");
    }
}
