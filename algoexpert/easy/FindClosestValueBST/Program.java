package FindClosestValueBST;
import java.util.*;

class Program {
  public boolean generateDocument(String characters, String document) {
    HashMap<Character,Integer> avaliableCharacters = new HashMap<Character,Integer>();
    for (int i=0;i<characters.length();i++) {
			if (!avaliableCharacters.containsKey(characters.charAt(i))) {
				avaliableCharacters.put(
					characters.charAt(i),
					1
				);
			} else {
				avaliableCharacters.put(
					characters.charAt(i),
					avaliableCharacters.get(characters.charAt(i)) + 1
				);
			}
    }
		for (int i=0;i<document.length();i++) {
			Character currentChar = document.charAt(i);
			if (!avaliableCharacters.containsKey(currentChar)) {
				return false;
			} else {
				int newValue = avaliableCharacters.get(currentChar) - 1;
				if (newValue < 0) {
					return false;
				}
				avaliableCharacters.put(
					currentChar,
					newValue
				);
			}
		}
    return true;
  }
}
