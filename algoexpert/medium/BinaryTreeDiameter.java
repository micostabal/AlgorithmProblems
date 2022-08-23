import java.util.*;

public class BinaryTreeDiameter {
    // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public static int binaryTreeDiameter(BinaryTree tree) {
    if (tree.left == null && tree.right == null) {
        return 0;
    }

    HashSet<BinaryTree> visited_nodes = new HashSet<>();
    HashMap<HashSet<Integer>, Integer> distances = new HashMap<>();
	LinkedList<BinaryTree> to_visit = new LinkedList<>();
    HashMap<Integer, Integer> parents = new HashMap<>();
    BinaryTree current_node;
    int diameter = 1;
    to_visit.add(tree);
    parents.put(tree.value, null);

	while (true) {
        if (to_visit.size() == 0) {
            break;
        }
        current_node = to_visit.pop();
        
        /*
        System.out.println("---------------");
        System.out.println("Current Node: "+current_node.value);
        */

        for (BinaryTree child : new LinkedList<BinaryTree>(
            Arrays.asList(current_node.left, current_node.right)
            )) {
            if (child != null) {
                distances.put(
                    new HashSet<>(Arrays.asList(current_node.value, child.value)),
                    1
                );
                visited_nodes.add(child);
                to_visit.add(child);
            }
        }

        for (BinaryTree child : new LinkedList<BinaryTree>(
            Arrays.asList(current_node.left, current_node.right)
            )) {
            if (child != null) {
                parents.put(child.value, current_node.value);
                //System.out.println("Child: "+child.value);
                for (BinaryTree visited_node : visited_nodes) {
                    //System.out.println("Visited Node: "+visited_node.value);
                    //System.out.println(current_node.value+" "+visited_node.value);
                    int new_distance;

                    if (child.value != visited_node.value) {
                        new_distance = distances.get(
                            new HashSet<>(Arrays.asList(current_node.value, visited_node.value))
                        ) + 1;
                    } else {
                        new_distance = 0;
                    }
                    
                    distances.put(
                        new HashSet<>(Arrays.asList(child.value, visited_node.value)),
                        new_distance
                    );
                    diameter = Math.max(diameter, new_distance);
                }
            }
        }
        visited_nodes.add(current_node);

        /*
        System.out.println("Distances:");
        for (HashSet<Integer> key : distances.keySet()) {
            System.out.println(
                key + " " + distances.get(key)
            );
        }

        System.out.println("Visited Nodes:");
        for (BinaryTree visited_node: visited_nodes) {
            System.out.print(visited_node.value+" ");
        }
        System.out.println("");

        System.out.println("To Visit Nodes:");
        for (BinaryTree tv_visit: to_visit) {
            System.out.print(tv_visit.value+" ");
        }
        System.out.println("");
        */
    }
    return diameter;
  }

  public static void main(String[] args) {
    BinaryTree n1 = new BinaryTree(1);
    BinaryTree n2 = new BinaryTree(2);
    /*
    BinaryTree n3 = new BinaryTree(3);
    BinaryTree n4 = new BinaryTree(4);
    BinaryTree n5 = new BinaryTree(5);
    BinaryTree n6 = new BinaryTree(6);
    BinaryTree n7 = new BinaryTree(7);
    BinaryTree n8 = new BinaryTree(8);
    BinaryTree n9 = new BinaryTree(9);
    */


    n1.left = n2;

    /*
    n1.left = n3;
    n3.right = n4;
    n4.right = n5;
    n5.right = n6;

    n3.left = n7;
    n7.left = n8;
    n8.left = n9;
    */

    System.out.println(binaryTreeDiameter(n1));
  }
}
