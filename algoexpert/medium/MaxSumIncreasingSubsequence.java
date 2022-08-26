import java.util.*;

public class MaxSumIncreasingSubsequence {
	public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    List<List<Integer>> result =  new ArrayList<List<Integer>>();
    if (array.length==0) {
    	result.add(new ArrayList<Integer>(Arrays.asList(array[0])));
    	result.add(new ArrayList<Integer>(Arrays.asList(array[0])));
    	return result;
    };
    int n= array.length;
    int[] MSIS= new int[n];
    MSIS[0]=array[0];
    int bestObj = MSIS[0];
    ArrayList<Integer> bestSol = new ArrayList<>(Arrays.asList(array[0]));
    ArrayList<ArrayList<Integer>> bestSols= new ArrayList<ArrayList<Integer>>();
    bestSols.add(new ArrayList<Integer>(Arrays.asList(array[0])));
    for(int i=1;i<n;i++) {
    	MSIS[i] = array[i];
    	ArrayList<Integer> sol = new ArrayList<Integer>(Arrays.asList(array[i]));
    	for(int j=0;j<i;j++) {
    		if (array[j]<array[i] && MSIS[j]+array[i]>=MSIS[i]) {
    			MSIS[i] = MSIS[j]+array[i];
    			sol = new ArrayList<Integer>(bestSols.get(j));
    			sol.add(array[i]);
    		}
    	}
    	bestSols.add(sol);
    	bestObj = MSIS[i]>=bestObj ? MSIS[i] : bestObj;
    	bestSol = MSIS[i]>=bestObj ? sol : bestSol;
    }
    result.add(new ArrayList<Integer>(Arrays.asList(bestObj)));
    result.add(bestSol);
    return (List<List<Integer>>)result;
  }

	public static void main(String[] args) {
		int[] input = {10, 70, 20, 30, 50, 11, 30};
		System.out.println(maxSumIncreasingSubsequence(input));
	}
}