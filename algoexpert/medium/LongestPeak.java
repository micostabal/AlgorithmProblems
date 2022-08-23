import java.util.*;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int max_peak = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i + 1] < array[i]) {
                int first_index = i - 1;
                int last_index = i + 1;
                for (int j = i; j >= 1; j--) {
                    if (array[j - 1] >= array[j]) {
                        break;
                    } else {
                        first_index = j - 1;
                    }
                }
                for (int j = i; j < array.length - 1; j++) {
                    if (array[j + 1] >= array[j]) {
                        break;
                    } else {
                        last_index = j + 1;
                    }
                }
                System.out.println(new ArrayList<>( Arrays.asList(i, max_peak, last_index, first_index) ));
                max_peak = Math.max(max_peak, last_index - first_index + 1);
            }
        }
        return max_peak;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 99, 1};
        int res = longestPeak(arr);
        System.out.println(res);
    }
}
