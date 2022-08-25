import java.util.*;
import java.lang.Math;

public class ValidateBST {

  public static boolean validateBstRecursive(BST tree, Integer min, Integer max) {
    System.out.println("Call: "+tree.value+", min:"+min+", max: "+max);
    if (max!=null) {
      if (tree.value >= max) return false;
    } if (min!=null) {
      if (tree.value < min) return false;
    };
    boolean result = true;
    if (tree.left!=null) {
      result = result
       && tree.left.value < tree.value
       && validateBstRecursive(tree.left, min, tree.value);
    } if (tree.right!=null) {
      result = result
       && tree.right.value >= tree.value
       && validateBstRecursive(tree.right, tree.value, max);
    }
    return result;
  }

  public static boolean validateBst(BST tree) {
    return validateBstRecursive(tree, null, null);
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
      BST n10 = new BST(10);
      BST n5 = new BST(5);
      BST n15 = new BST(15);
      BST n2 = new BST(2);
      BST n52 = new BST(10);
      BST n13 = new BST(13);
      BST n22 = new BST(22);
      BST n1 = new BST(1);
      BST n14 = new BST(14);
      // BST n25 = new BST(25);

      n10.left =n5;
      n10.right = n15;
      n5.left = n2;
      n5.right = n52;
      n2.left = n1;
      n15.left = n13;
      n15.right = n22;
      n13.right = n14;
      // n14.right= n25;

      System.out.println(
          validateBst(n10)
      );
  }
}
