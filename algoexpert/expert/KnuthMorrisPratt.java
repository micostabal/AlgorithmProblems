import java.util.*;

public class KnuthMorrisPratt {

	public static int[] kpmTable(String W) {
		int lengthW = W.length();
		int[] T = new int[lengthW+1];
		int pos=1;
		int cnd=0;
		T[0]= -1;
		while (pos<lengthW) {
			Character wPos = new Character(W.charAt(pos));
			Character wCnd = new Character(W.charAt(cnd));
			if (wPos.equals(wCnd)) {
				T[pos] = T[cnd];
			} else {
				T[pos] = cnd;
				while (cnd>=0&&!wPos.equals(wCnd)) {
					cnd = T[cnd];
				}
			};
			pos++;
			cnd++;
		}
		T[pos]=cnd;
		return T;
	}

	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    int j=0;
    int k=0;
    int[] T = kpmTable(substring);
    int nP=0;

    while ( j<string.length() ) {
    	Character substringK = new Character(substring.charAt(k));
    	Character stringJ = string.charAt(j);
    	if (substringK.equals(stringJ)) {
    		j++;
    		k++;
    		if (k==substring.length()) {
    			return true;
    		}
    	} else {
    		k=T[k];
    		if (k<0) {
    			j++;
    			k++;
    		}
    	}
    }
    return false;
  }

	public static void main(String[] args) {
		String word= "aefoaefcdaefcdaed";
		String pattern="aefcdaed";
		System.out.println(knuthMorrisPrattAlgorithm(word, pattern));
	}
}