

public class BST {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree tree) {
        
        BinaryTree bt_left = tree.left;
        BinaryTree bt_right = tree.right;
        tree.left = bt_right;
        tree.right = bt_left;
        if (tree.left != null) {
            invertBinaryTree(tree.left);
        }
        if (tree.right != null) {
            invertBinaryTree(tree.right);
        }
    }
    

    public static void main(String[] args) { {}
        
    }
}
