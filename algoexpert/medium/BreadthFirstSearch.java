import java.util.*;

public class BreadthFirstSearch {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public static List<Node> BFS(Node start) {
      ArrayList<Node> result = new ArrayList<>();
      LinkedList<Node> toVisit = new LinkedList<>(Arrays.asList(start));
      while (toVisit.size() > 0) {
        Node currentNode = toVisit.poll();
        result.add(currentNode);
        for (Node child: currentNode.children) {
          toVisit.addLast(child);
        }
      }
      return result;
    }
    
    public List<String> breadthFirstSearch(List<String> array) {
      for (Node traversedNode: BFS(this) ) {
        array.add(traversedNode.name);
      };
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }

  public static void main(String[] args) {
    Node a = new Node("A");
    a.addChild("B");
    a.addChild("C");
    a.addChild("D");
    a.children.get(0).addChild("E");
    a.children.get(0).addChild("F");
    
    System.out.println(a.breadthFirstSearch(new ArrayList<>()));
  }
}