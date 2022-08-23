
public class Main {
  
  public static String caesarCypherEncryptor(String str, int key) {
    int initialCharacter = 97;
    int finalCharacter = 122;
    int n = finalCharacter - initialCharacter + 1;
    int toIncrease = key % n;
    String result = "";
    for (int i=0;i<str.length();i++) {
      int characterIndex = (int)str.charAt(i);
      Character transformedChar = (char)( characterIndex + toIncrease <= finalCharacter ?
       characterIndex + toIncrease :
       characterIndex + toIncrease - finalCharacter - 1 + initialCharacter );
      result += transformedChar;
    };
    return result;
  }
  
  public static void main(String[] args) {
    
    System.out.println(caesarCypherEncryptor("xyz", 2));
  }
}

