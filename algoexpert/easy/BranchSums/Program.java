package BranchSums;
import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

	public static void propagateSum(BinaryTree tree) {
		if (tree.left != null) {
			tree.left.value += tree.value;
			propagateSum(tree.left);
		}
		if (tree.right != null) {
			tree.right.value += tree.value;
			propagateSum(tree.right);
		}
	}

  public static List<Integer> branchSums(BinaryTree root) {
		propagateSum(root);
		List<Integer> output = new LinkedList<>();
		LinkedList<BinaryTree> toVisitQueue = new LinkedList<BinaryTree>(Arrays.asList(root));
		while (toVisitQueue.size() > 0) {
			BinaryTree currentNode = toVisitQueue.pop();
			System.out.println(currentNode.value);
			if (currentNode.left != null) {
				toVisitQueue.push(currentNode.left);
			}
			if (currentNode.right != null) {
				toVisitQueue.push(currentNode.right);
			}
			if (currentNode.left == null && currentNode.right == null) {
				output.add(0, currentNode.value);
			}
		}
    return output;
  }

  public static void main(String[] args) {

		BinaryTree n1 = new BinaryTree(1);
		BinaryTree n2 = new BinaryTree(2);
		BinaryTree n3 = new BinaryTree(3);
		BinaryTree n4 = new BinaryTree(4);
		BinaryTree n5 = new BinaryTree(5);
		BinaryTree n6 = new BinaryTree(6);
		BinaryTree n7 = new BinaryTree(7);
		BinaryTree n8 = new BinaryTree(8);
		BinaryTree n9 = new BinaryTree(9);
		BinaryTree n10 = new BinaryTree(10);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.left = n10;
		System.out.println(branchSums(n1));
  }
}