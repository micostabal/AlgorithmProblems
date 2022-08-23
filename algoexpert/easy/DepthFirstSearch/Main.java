import java.util.*;

class Main {
  // Do not edit the class below except
  // for the depthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();
    
    public Node(String name) {
      this.name = name;
    }
    
    public List<String> depthFirstSearch(List<String> array) {
      array.add(this.name);
      for (Node child : this.children) {
        for (String visited: child.depthFirstSearch(new LinkedList<String>() )) {
          array.add(visited);
        }
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
    a.children.get(0).addChild("E");
    a.addChild("C");
    a.addChild("D");
    
    System.out.println(
      a.depthFirstSearch(new LinkedList<String>())
    );

  }
}