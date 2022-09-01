import java.util.*;
import java.lang.Math;

public class Powerset {
	public static List<List<Integer>> powerset(List<Integer> array) {
    int n = array.size();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.add(new ArrayList<Integer>());
    int i=1;
    while (i<Math.pow(2, n)) {
    	String binary = Integer.toString(i, 2);
    	List<Integer> newSet = new ArrayList<>();
    	for (int j=binary.length()-1;j>=0;j--) {
    		if (binary.charAt(j)== '1') newSet.add(array.get(binary.length()-j-1));
    	};
    	result.add(newSet);
    	i++;
    }
    return result;
  }

	public static void main(String[] args) {
		System.out.println("PowerSet");
		List<Integer> example = new ArrayList<Integer>(Arrays.asList(1, 8, 3));
		List<List<Integer>> result = powerset(example);
		System.out.println(result);
	}
}