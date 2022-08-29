import java.util.*;

public class MinHeightBST {

	static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void inOrderTraversal() {
    	if (this.left!=null) {
    		this.left.inOrderTraversal();
    	};
    	System.out.print(this.value+", ");
    	if (this.right!=null) {
    		this.right.inOrderTraversal();
    	};
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }

	public static BST minHeightBst(List<Integer> array) {
    int n=array.size();
    if (n==1) {
    	return new BST(array.get(0));
    } else if (n==2) {
    	BST central= new BST(array.get(1));
    	central.left = new BST(array.get(0));
    	return central;
    } else {
    	int centralIndex = (int)(n%2==0 ? n/2:(n-1)/2);
	    BST centralElement = new BST(array.get(centralIndex));
	    centralElement.left= minHeightBst(array.subList(0, centralIndex));
	    centralElement.right= minHeightBst(array.subList(centralIndex+1, n));
	    return centralElement;
    }
  }

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
		BST mh = minHeightBst(array);
		mh.inOrderTraversal();
	}
}