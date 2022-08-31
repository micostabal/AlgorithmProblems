import java.util.*;

public class LongestIncreasingSubsequence {

	public static List<Integer> longestIncreasingSubsequence(int[] array) {
    int n = array.length;
    if (n==1) return new ArrayList<>(Arrays.asList(array[0]));
    int[] LIS = new int[n];
    int[] pred = new int[n];
    int bestObj = 1;
    int bestObjIndex = 0;
    LIS[0]= 1;
    pred[0]= -1;
    for (int i=1;i<n;i++) {
    	LIS[i] = 1;
    	pred[i] = -1;
    	for (int j=0;j<i;j++) {
    		if (array[j]<array[i] && LIS[j]+1>LIS[i]) {
    			LIS[i] = LIS[j]+1;
    			pred[i] = j;
    		}
    	}
    	if (LIS[i]>bestObj) {
    		bestObj=LIS[i];
    		bestObjIndex=i;
    	}
    };
    ArrayList<Integer> solution = new ArrayList<Integer>();
    int solutionIndex=bestObjIndex;
    while(true) {
    	solution.add(0, array[solutionIndex]);
    	if (pred[solutionIndex]==-1) {
    		break;
    	};
    	solutionIndex= pred[solutionIndex];
    }
    return solution;
  }

	public static void main(String[] args) {
		int[] example = {4, 5};

		System.out.println(longestIncreasingSubsequence(example));
	}
}