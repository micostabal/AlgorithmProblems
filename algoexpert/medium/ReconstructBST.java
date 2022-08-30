import java.util.*;

public class ReconstructBST {
	// This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }

    public void inOrderTraversal() {
    	if (this.left!=null) {
    		this.left.inOrderTraversal();
    	};
    	System.out.println(this.value);
    	if (this.right!=null) {
    		this.right.inOrderTraversal();
    	};
    }
  }

  public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    int n = preOrderTraversalValues.size();
    if (n==0) return null;
    BST tree = new BST(preOrderTraversalValues.get(0));
    if (n==1) return tree;
    int firstIndexGreaterThanTree = -1;
    for(int i=1;i<n;i++) {
    	if(preOrderTraversalValues.get(i)>=tree.value) {
    		firstIndexGreaterThanTree= i;
    		break;
    	}
    };
    if (firstIndexGreaterThanTree==-1) {
    	tree.left=reconstructBst(
    		new ArrayList<Integer>(preOrderTraversalValues.subList(1, n))
    	);
    } else {
    	tree.left=reconstructBst(
    		new ArrayList<Integer>(preOrderTraversalValues.subList(
    		1,
    		firstIndexGreaterThanTree)
    	));
    	tree.right=reconstructBst(
    		new ArrayList<Integer>(preOrderTraversalValues.subList(
    		firstIndexGreaterThanTree,
    		n))
    	);
    }
    return tree;
  }

	public static void main(String[] args) {
		ArrayList<Integer> preOrderTraversalValues =
        new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 5, 5, 6, 5, 5, 9, 7, 17, 19, 18, 18, 19));
    BST tree = reconstructBst(preOrderTraversalValues);
    tree.inOrderTraversal();
	}
}

