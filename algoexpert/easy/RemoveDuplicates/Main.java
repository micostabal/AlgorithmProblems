import java.util.*;


public class Main {
  
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    if (linkedList.next== null) return linkedList;
    HashSet<Integer> values = new HashSet<>();
    values.add(linkedList.value);
    LinkedList currentElement = linkedList;
    while (true) {
      if (values.contains(currentElement.next.value)) {
        currentElement.next = currentElement.next.next;
      } else {
        values.add(currentElement.next.value);
        currentElement = currentElement.next;
      }
      if (currentElement.next == null) break;
    }
    
    return linkedList;
  }

  public static void main(String[] args) {
    int[] exampleArray = {1, 1, 3, 3, 4, 5, 5, 5, 5, 5, 6};
    LinkedList exampleLinkedList = new LinkedList(exampleArray[0]);
    LinkedList prev = exampleLinkedList;
    for (int i=1;i<exampleArray.length;i++) {
      prev.next = new LinkedList(exampleArray[i]);
      prev = prev.next;
    }
    
    LinkedList result = removeDuplicatesFromLinkedList(exampleLinkedList);
    LinkedList current = result;
    while (current != null) {
      System.out.print(current.value+" ");
      current = current.next;
    }
    
  }
}