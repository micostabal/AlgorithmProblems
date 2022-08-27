import java.util.*;
import java.lang.Math;

public class Knapsack {

	public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    int n=items.length;
    int[][] K = new int[n][capacity+1];
    for (int c=0;c<capacity+1;c++) {
    	K[0][c] = c<items[0][1] ? 0 : items[0][0];
    };
    for (int i=1;i<n;i++) {
    	int currWeight = items[i][1];
    	int currValue = items[i][0];
    	for (int c=1;c<capacity+1;c++) {
	    	if (c>=items[i][1] && i>=1) {
	    		K[i][c] = Math.max(K[i-1][c], currValue+K[i-1][c-currWeight]);
	    	} else if (i>=1) {
	    		K[i][c] = K[i-1][c];
	    	} else {
	    		K[i][c] = 0;
	    	}
	    };
    }
    List<Integer> totalValue = Arrays.asList(K[n-1][capacity]);
    ArrayList<Integer> finalItems = new ArrayList<>();
    int indexCapacity = capacity;
    for (int i=n-1;i>=1;i--) {
    	if (K[i][indexCapacity] != K[i-1][indexCapacity]) {
    		finalItems.add(0, i);
    		indexCapacity-=items[i][1];
    	}
    }
    if (K[0][indexCapacity]>0) {
  		finalItems.add(0, 0);
  	} 
    var result = new ArrayList<List<Integer>>();
    result.add(totalValue);
    result.add(finalItems);
    return result;
  }

	public static void main(String[] args) {
		int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 9}};
		int capacity = 11;
		System.out.println(knapsackProblem(input, capacity));
	}
}