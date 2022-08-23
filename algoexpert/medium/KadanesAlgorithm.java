import java.util.*;

public class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int n = array.length;
        if (n==1) {return array[0];};
        int best = Math.max(Integer.MIN_VALUE, array[0]);
        int[] results = new int[n];
        results[0] = array[0];
        for (int i=1;i<n;i++) {
            int current_max = array[i];
            for (int k=i-1;k>=0;k--) {
                int sum=0;
                for (int j=k+1;j<=i;j++) {
                    sum+=array[j];
                }
                current_max = Math.max(current_max, results[k]+sum);
            }
            best = Math.max(best, current_max);
            results[i] = current_max;
        }
        return best;
    }

    public static void main(String[] args) {
        int[] example = new int[] {
            3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4
        };
        System.out.println(
            kadanesAlgorithm(example)
        );
    }
}
