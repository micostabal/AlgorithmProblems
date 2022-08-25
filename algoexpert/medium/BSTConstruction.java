import java.util.*;

class BSTConstruction {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public boolean isLeaf() {
      return this.left==null && this.right==null;
    }

    public BST removeChild(int value) {
      if (this.left!=null && value<this.value) {
        this.left=null;
      } else if (this.right!=null&&value>=this.value) {
        this.right=null;
      }
      return this;
    }

    public void printLeftRight() {
      if (this.left != null) {
        this.left.printLeftRight();
      }
      System.out.println(
        this.value
        +", isLeaf: "
        +this.isLeaf()
        +", left: "+(this.left!=null?this.left.value:null)
        +", right: "+(this.right!=null?this.right.value:null)
      );
      if (this.right != null) {
        this.right.printLeftRight();
      }
    }

    public BST insert(int value) {
      if (value < this.value) {
        if (this.left != null) {
          this.left.insert(value);
        } else {
          this.left = new BST(value);
        }
      } else {
        if (this.right != null) {
          this.right.insert(value);
        } else {
          this.right = new BST(value);
        }
      }
      return this;
    }

    public BST insertChild(BST child) {
      if (child.value<this.value) {
        this.left=child;
      } else {
        this.right=child;
      }
      return this;
    }

    public BST getNode(int value) {
      if (value == this.value) {
        return this;
      } else if (this.left != null && value < this.value) {
        return this.left.getNode(value);
      } else if (this.right != null && value >= this.value) {
        return this.right.getNode(value);
      }
      return null;
    }

    public boolean contains(int value) {
      if (value == this.value) {
        return true;
      } else if (value < this.value) {
        if (this.left != null) {
          return this.left.contains(value);
        } else {
          return false;
        }
      } else {
        if (this.right != null) {
          return this.right.contains(value);
        } else {
          return false;
        }
      }
    }

    public BST getParentOfFirst(int value) {
      BST currNode = this;
      if (this.value==value) return null;
      if (this.left!=null && value<this.value) {
        if (this.left.value==value) {
          return this;
        };
        return this.left.getParentOfFirst(value);
      } else if (this.right!=null && value>=this.value) {
        if (this.right.value==value) {
          return this;
        };
        return this.right.getParentOfFirst(value);
      } else {
        return null;
      }
    }

    public BST min() {
      if (this.left==null) {
        return this;
      } else {
        return this.left.min();
      }
    }

    public BST max() {
      if (this.right==null) {
        return this;
      } else {
        return this.right.min();
      }
    }    

    public BST remove(int value) {
      if (this.isLeaf()) return null;
      BST parent = this.getParentOfFirst(value);
      BST node;
      if (value==this.value) {
        node=this;
      } else {
        node = parent.getNode(value);
      }
      if (node==null) return null;
      if (node.isLeaf()) {
        parent.removeChild(node.value);
      } else if (node.left!=null ^ node.right!=null) {
        BST child = node.left!=null ? node.left : node.right;
        if (parent!=null) {
          node.removeChild(child.value);
          parent.removeChild(value);
          parent.insertChild(child);
        } else {
          node.value=child.value;
          node.left=child.left;
          node.right=child.right;
        }
      } else {
        int rightSideMax = node.right.min().value;
        if (node.right.isLeaf()) {
          node.removeChild(rightSideMax);
        } else {
          node.remove(rightSideMax);
        }
        node.value=rightSideMax;
      };
      return this;
    }
  }

  public static void main(String[] args) {
    BST example = new BST(10);
    example.left = new BST(5);
    example.right = new BST(15);
    example.left.left = new BST(2);
    example.left.right = new BST(5);
    example.left.left.left = new BST(1);
    example.right.left = new BST(13);
    example.right.right = new BST(22);
    example.right.left.right = new BST(14);
    
    example.printLeftRight();
    example.remove(5);
    example.remove(5);
    
    
    System.out.println("------- 0 --------");
    example.printLeftRight();
  }
}