
public class FindSuccessor {
	// This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree minNode() {
    	if (this.left!=null) {
    		return this.left.minNode();
    	};
    	return this;
    }
  }


  public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    if (node.right!=null) {
    	return node.right.minNode();
    };
    BinaryTree currNode = node;
    while (true) {
    	BinaryTree parent = currNode.parent;
    	if (parent==null) break;
    	if (parent.left!=null) {
    		if (parent.left.value==currNode.value) {
    			return parent;
    		}
    	}
    	if (parent.right!=null) {
    		if (parent.right.value==currNode.value) {
    			currNode = parent;
    		}
    	}
    }
    return null;
  }

	public static void main(String[] args) {
		BinaryTree example = new BinaryTree(1);
		example.left = new BinaryTree(2);
		example.left.parent=example;
		example.right = new BinaryTree(3);
		example.right.parent=example;
		example.left.left = new BinaryTree(4);
		example.left.left.parent=example.left;
		example.left.right = new BinaryTree(5);
		example.left.right.parent=example.left;
		example.left.left.left = new BinaryTree(6);
		example.left.left.left.parent=example.left.left;
		System.out.println(
			findSuccessor(example, example.right)
		);
	}
}