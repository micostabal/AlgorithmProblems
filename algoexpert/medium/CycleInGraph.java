import java.util.*;

public class CycleInGraph {

  public static boolean cycleInGraph(int[][] edges) {
    for (int i=0;i<edges.length;i++) {
      // System.out.println("i: "+i);
      ArrayList<Integer> reachables = new ArrayList<Integer>();
      LinkedList<Integer> toVisit = new LinkedList<Integer>(Arrays.asList(i));
      while (toVisit.size()>0) {
        int currentNode = toVisit.pop();
        // System.out.println("cn: "+currentNode);
        for (int child: edges[currentNode]) {
          if (!reachables.contains(child)) {
            reachables.add(child);
            toVisit.add(child);
          }
        }
      }
      // System.out.println("reachables: "+reachables);
      if (reachables.contains(i)) {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    // int[][] adjacencyList = {
    //   {1, 2},
    //   {2, 3, 4},
    //   {0},
    //   {},
    //   {2, 5},
    //   {}
    // };
    int[][] adjacencyList = {
      {1, 2},
      {2},
      {}
    };
    System.out.println(cycleInGraph(adjacencyList));
  }
}
