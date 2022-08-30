import java.util.*;

public class FindKthLargestValueInBST {
	static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public static void invertedOrderTraversal(BST tree, LinkedList<Integer> array, int k) {
  	if (array.size()<k) {
  		if (tree.right!=null) {
  			invertedOrderTraversal(tree.right, array, k);
  		};
  		array.push(tree.value);
  		if (tree.left!=null) {
  			invertedOrderTraversal(tree.left, array, k);
  		};
  	}
  }

  public static int findKthLargestValueInBst(BST tree, int k) {
  	LinkedList<Integer> visited = new LinkedList<Integer>();
  	invertedOrderTraversal(tree, visited, k);
  	return visited.get(visited.size() - k);
  }

	public static void main(String[] args) {
		BST root = new BST(15);
    root.left = new BST(5);
    root.left.left = new BST(2);
    root.left.left.left = new BST(1);
    root.left.left.right = new BST(3);
    root.left.right = new BST(5);
    root.right = new BST(20);
    root.right.left = new BST(17);
    root.right.right = new BST(22);
    int k=5;
    System.out.println(findKthLargestValueInBst(root, k));
	}
}