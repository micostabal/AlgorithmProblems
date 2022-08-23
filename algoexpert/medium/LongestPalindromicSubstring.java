import java.util.*;
import java.lang.Math.*;

public class LongestPalindromicSubstring {

	public static String longestPalindromicSubstring(String str) {
    int n=str.length();
    int LPSL = 1;
    String LPSS = str.substring(1);
    if (n==1) return (new Character(str.charAt(0))).toString();
    for (int i=0;i<n;i++) {
  		for (int delta=0;delta<2;delta++) {
  			int indexBegin = i;
    		int indexEnd = i+delta;
    		while (indexBegin>=0 && indexEnd<=n-1) {
    			Character charBegin = str.charAt(indexBegin);
    			Character charEnd = str.charAt(indexEnd);
    			if (!charBegin.equals(charEnd)) {
    				break;
    			};
    			if (indexEnd-indexBegin+1 > LPSL) {
    				LPSL=indexEnd-indexBegin+1;
    				LPSS = str.substring(indexBegin, indexEnd+1);
    			}
    			indexBegin--;
    			indexEnd++;
    		}
  		}
    }
    return LPSS;
  }

	public static void main(String[] args) {
		String example = "abaa";
		String res = longestPalindromicSubstring(example);
		System.out.println(res);
	}
}