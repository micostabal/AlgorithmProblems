import java.util.*;

public class ZigZagTraverse {
    public static ArrayList<Integer> zigzagTraverse(ArrayList<ArrayList<Integer>> array) {
        int n = array.size();
        int m = array.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int index=0;index<m+n-1;index++) {
            boolean up = index % 2 == 1 ? true : false;
            boolean first = up ? (index < n ? true: false) : (index < m ? true: false);
            int _x = up ? (first ? index : n-1) : (first ? 0 : index-m+1);
            int _y = up ? (first ? 0 : index-n+1) : (first ? index : m-1);
            int inc_x = up ? -1 : 1;
            int inc_y = up ? 1 : -1;
            while (_x>=0&&_y>=0&&_x<n&&_y<m) {
                result.add(array.get(_x).get(_y));
                _x=_x+inc_x;
                _y=_y+inc_y;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(Arrays.asList(
            new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)),
            new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)),
            new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)),
            new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16))
        ));
        System.out.println(
            zigzagTraverse(arr)
        );
    }
}
