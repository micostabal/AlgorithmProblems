package NodeDepth;
import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    int depthSum=0;
		root.depth=0;
    LinkedList<BinaryTree> toVisit = new LinkedList<BinaryTree>(Arrays.asList(root));
    while (toVisit.size() > 0) {
        BinaryTree currentNode = toVisit.pop();
				depthSum+=currentNode.depth;
        if (currentNode.left != null) {
					currentNode.left.depth = currentNode.depth+1;
          toVisit.add(currentNode.left);
        }
				if (currentNode.right != null) {
					currentNode.right.depth = currentNode.depth+1;
          toVisit.add(currentNode.right);
        }
    }
    return depthSum;
  }

  static class BinaryTree {
    int value;
		int depth;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
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
    System.out.println(nodeDepths(n1));
  }
}