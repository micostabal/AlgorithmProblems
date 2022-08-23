import java.util.*;

public class ReverseWordsInString {

    public static String reverseWordsInString(String string) {
        int current_index = 0;
        int writing_index = string.length() - 1;
        char[] result_array = new char[string.length()];
        LinkedList<Character> word_q = new LinkedList<>();
        while (current_index<string.length()) {
            char current_char = string.charAt(current_index);
            if (current_char == ' ') {
                if (word_q.size() > 0) {
                    while (word_q.size() > 0) {
                        char new_char = word_q.pollFirst();
                        result_array[writing_index] = new_char;
                        writing_index--;
                    }
                }
                result_array[writing_index] = ' ';
                writing_index--;
            } else {
                word_q.addFirst(current_char);
            }
            current_index++;
        }
        if (word_q.size() > 0) {
            while (word_q.size() > 0) {
                char new_char = word_q.pollFirst();
                result_array[writing_index] = new_char;
                writing_index--;
            }
        }
        return new String(result_array);
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("Ola ke ase"));
    }
}
