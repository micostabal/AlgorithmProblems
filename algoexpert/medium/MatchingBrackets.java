import java.util.*;

public class MatchingBrackets {
    public static boolean balancedBrackets(String str) {
        HashSet<Character> closing_par = new HashSet<Character>(
            Arrays.asList(')', ']', '}')
        );
        HashSet<Character> opening_par = new HashSet<Character> (
            Arrays.asList('(', '[', '{')
        );
        HashMap<Character, Character> closing_par_map = new HashMap<>();
        closing_par_map.put('[', ']');
        closing_par_map.put('(', ')');
        closing_par_map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++) {
            char this_char = str.charAt(i);
            if (opening_par.contains(this_char)) {
                stack.add(this_char);
            } else if (closing_par.contains(this_char)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char open_par = stack.pop();
                char expected_closing_par = closing_par_map.get(open_par);
                if (this_char != expected_closing_par) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String input = "(([[{{}}}]]))";
        System.out.println(balancedBrackets(input));
    }
}
