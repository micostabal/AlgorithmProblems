
public class Main {

  public static String runLengthEncoding(String string ) {
    String encoding = "";
    int currentCount = 0;
    for (int i=0;i<string.length();i++) {
      if (i == 0) {
        currentCount += 1;
      } else if (string.charAt(i-1) != string.charAt(i) || currentCount > 8) {
        encoding = encoding+currentCount+string.charAt(i-1);
        currentCount=1;
      } else {
        currentCount += 1;
      }
    }

    return encoding+currentCount+string.charAt(string.length()- 1);
  }

  public static void main(String[] args) {
    System.out.println(
      runLengthEncoding("AAAAAAAAAAAAABBCCCCDD")
    );
  }
}