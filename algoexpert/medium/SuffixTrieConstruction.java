import java.util.*;

public class SuffixTrieConstruction {
  
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }
  
  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';
    
    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      for (int i=0;i<str.length();i++) {
        TrieNode currentNode = this.root;
        for (int j=i;j<str.length();j++) {
          char currentChar = str.charAt(j);
          if (currentNode.children.containsKey(currentChar)) {
            currentNode = currentNode.children.get(currentChar);
          } else {
            if (currentNode.children.containsKey(this.endSymbol)) {
              currentNode.children.remove(this.endSymbol);
            }
            TrieNode endNode = new TrieNode();
            endNode.children.put(this.endSymbol, null);
            currentNode.children.put(currentChar, endNode);
            currentNode = currentNode.children.get(currentChar);
          }
        }
        if (!currentNode.children.containsKey(this.endSymbol)) {
          currentNode.children.put(this.endSymbol, null);
        }
      }
    }

    public boolean contains(String str) {
      TrieNode currentNode = this.root;
      for (int i=0;i<str.length();i++) {
        char character = str.charAt(i);
        if (currentNode.children.containsKey(character)) {
          currentNode = currentNode.children.get(character);
        } else {
          return false;
        }
      }
      if (currentNode.children.containsKey(this.endSymbol)) {
        return true;
      }
      return false;
    }
  }

  public static void main(String[] args) {
    String example = "test";
    SuffixTrie st = new SuffixTrie(example);
    System.out.println(st.contains("tes"));
  }
}