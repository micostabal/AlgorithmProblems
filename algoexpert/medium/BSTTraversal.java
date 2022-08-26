import java.util.*;

public class BSTTraversal {

	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    if (tree.left!=null) {
    	inOrderTraverse(tree.left, array);
    };
    array.add(tree.value);
    if (tree.right!=null) {
    	inOrderTraverse(tree.right, array);
    };
    return array;
  }

  public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    array.add(tree.value);
    if (tree.left!=null) {
    	preOrderTraverse(tree.left, array);
    };
    if (tree.right!=null) {
    	preOrderTraverse(tree.right, array);
    };
    return array;
  }

  public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
    if (tree.left!=null) {
    	postOrderTraverse(tree.left, array);
    };
    if (tree.right!=null) {
    	postOrderTraverse(tree.right, array);
    };
    array.add(tree.value);
    return array;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

	public static void main(String[] args) {
		BST example = new BST(10);
		example.left= new BST(5);
		example.left.right= new BST(5);
		example.left.left= new BST(2);
		example.left.left.left= new BST(1);
		example.right= new BST(15);
		example.right.right= new BST(22);
		
		System.out.println("in-order");
		System.out.println(inOrderTraverse(
			example,
			new ArrayList<Integer>()
		));
		System.out.println("pre-order");
		System.out.println(preOrderTraverse(
			example,
			new ArrayList<Integer>()
		));
		System.out.println("post-order");
		System.out.println(postOrderTraverse(
			example,
			new ArrayList<Integer>()
		));
	}
}