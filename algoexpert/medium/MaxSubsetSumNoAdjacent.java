import java.util.*;
import java.lang.Math;

public class MaxSubsetSumNoAdjacent {
	public static int maxSubsetSumNoAdjacent(int[] array) {
    int n= array.length;
    if (n==0) return 0;
    int[] MSSNA = new int[n];
    MSSNA[0] = array[0];
    int bestObj = MSSNA[0];
    if (n==1) return bestObj;
    if (n==2) return Math.max(array[0], array[1]);
    if (n==3) return Math.max(array[1], array[0]+array[2]);
    MSSNA[1]= array[1];
    for (int i=2;i<n;i++) {
    	MSSNA[i] = array[i];
    	for (int j=0;j<i-1;j++) {
    		if (MSSNA[i] < MSSNA[j] + array[i]) {
    			MSSNA[i] = MSSNA[j] + array[i];
    		};
    	};
    	if (MSSNA[i]>bestObj) bestObj = MSSNA[i];
    };
    return bestObj;
  }

	public static void main(String[] args) {
		int[] input = {75, 105, 120, 75, 90, 135};
		System.out.println(maxSubsetSumNoAdjacent(input));
	}
}