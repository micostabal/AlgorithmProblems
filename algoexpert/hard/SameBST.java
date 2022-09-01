import java.util.*;

public class SameBTS {
	public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
		if (arrayOne.size()==0&&arrayTwo.size()==0) return true;
		if (arrayOne.size()!=arrayTwo.size()
		 || arrayOne.get(0)!= arrayTwo.get(0)) return false;
    int firstElement = arrayOne.get(0); 
    arrayOne.remove(0);
    arrayTwo.remove(0);
    int n = arrayOne.size();
    List<Integer> ArrayOneGreater= new ArrayList<>();
    List<Integer> ArrayOneSmaller= new ArrayList<>();
    List<Integer> ArrayTwoGreater= new ArrayList<>();
    List<Integer> ArrayTwoSmaller= new ArrayList<>();
    for (int i=0;i<n;i++) {
    	if (arrayOne.get(i)<firstElement) {
    		ArrayOneSmaller.add(arrayOne.get(i));
    	} else {
    		ArrayOneGreater.add(arrayOne.get(i));
    	};
    	if (arrayTwo.get(i)<firstElement) {
    		ArrayTwoSmaller.add(arrayTwo.get(i));
    	} else {
    		ArrayTwoGreater.add(arrayTwo.get(i));
    	};
    };
    boolean smallerIsBST= sameBsts(ArrayOneSmaller, ArrayTwoSmaller);
    if (!smallerIsBST) return false;
    boolean greaterIsBST= sameBsts(ArrayOneGreater, ArrayTwoGreater);
    if (!greaterIsBST) return false;
    return true;
  };

	public static void main(String[] args) {
		List<Integer> arrayOne =
		 new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
    List<Integer> arrayTwo =
     new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
    boolean same = sameBsts(arrayOne, arrayTwo);
    System.out.println(same);
	}
}