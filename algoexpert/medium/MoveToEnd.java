import java.util.*;

public class MoveToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int ocurrences = 0;
        for (int i = array.size() - 1; i >= 0 ; i--) {
            if ( array.get(i) == toMove) {
                ocurrences++;
                array.remove(i);
            }
        }
        for (int i = 0; i < ocurrences; i++) {
            array.add(toMove);
        }
        return array;
    }
    
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(
            Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2)
        );
        int toMove = 2;
        
        System.out.println(array);
        System.out.println(
            moveElementToEnd(array, toMove)
        );
    }
}
