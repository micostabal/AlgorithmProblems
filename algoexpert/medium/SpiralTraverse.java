import java.util.*;

public class SpiralTraverse {
    public static ArrayList<int[]> gen_rectangle(int rec_no, int n, int m) {
        ArrayList<int[]> res = new ArrayList<>();
        if (n == 1) {
            for (int j = 0; j < m; j++) {
                res.add(new int[] {rec_no, rec_no + j});
            }
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                res.add(new int[] {rec_no + i, rec_no});
            }
        } else {
            for (int j = 0; j < m; j++) {
                res.add(new int[] {rec_no, rec_no + j});
            }
            if (n >= 3) {
                for (int i = 1; i < n - 1; i++) {
                    res.add(new int[] {rec_no + i, rec_no + m - 1});
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                res.add(new int[] {rec_no + n - 1, rec_no + j});
            }
            if (n >= 3) {
                for (int i = n - 2; i >= 1; i--) {
                    res.add(new int[] {rec_no + i, rec_no});
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> spiralTraverse(int[][] array) {
		int n = array.length;
        int m = array[0].length;
        int ar = (int) Math.ceil((double) Math.min(n, m) / 2);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int current_rec = 0; current_rec < ar; current_rec++) {
            ArrayList<int[]> rectangle_coords = gen_rectangle(
                current_rec,
                n - 2 * current_rec,
                m - 2 * current_rec
            );
            for (int[] is : rectangle_coords) {
                result.add(array[is[0]][is[1]]);
            };
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1},
            {7}
        };
        ArrayList<Integer> res = spiralTraverse(arr);
        System.out.println(res);
    }
}
