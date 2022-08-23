import java.util.*;

public class ValidIPAddress {

    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> result = new ArrayList<String>();
        int length = string.length();
        for (int i = 1; i < 5; i++) {
            for (int j = i + 1; j <= Math.min(i + 3, length - 2) ; j++) {
                for (int k = j + 1; k <= Math.min(j + 3, length - 1) ; k++) {
                    String p1 = string.substring(0, i);
                    String p2 = string.substring(i, j);
                    String p3 = string.substring(j, k);
                    String p4 = string.substring(k, length);
                    boolean all_c1_c2 = true;
                    for (String part : new String[] {p1, p2, p3, p4}) {
                        int int_part = Integer.parseInt(part);
                        boolean c1 = int_part < 256;
                        boolean c2 = part.charAt(0) != '0' || part.length() == 1;
                        if (!c1 || !c2) {
                            all_c1_c2 = false;
                            break;
                        }
                    }
                    if (all_c1_c2) {
                        result.add(
                            String.format("%s.%s.%s.%s", p1, p2, p3, p4)
                        );
                    }
                }
            }
        }
        return result;
    }
    

    public static void main(String[] args) {
        
        String ex = "1921680";

        ArrayList<String> result = validIPAddresses(ex);
        for (String p : result) {
            System.out.println(p);
        }
    }
}
