import java.util.*;

public class Main {

  public static boolean classPhotos(
      ArrayList<Integer> redShirtHeights,
      ArrayList<Integer> blueShirtHeights
  ) {
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);
    
    boolean redTaller = true;
    boolean blueTaller = true;
    for (int i=0;i<redShirtHeights.size();i++) {
      if (redShirtHeights.get(i) > blueShirtHeights.get(i)) {
        blueTaller=false;
      } else if (blueShirtHeights.get(i) > redShirtHeights.get(i)) {
        redTaller=false;
      } else {
        return false;
      }
    }
    return blueTaller || redTaller;
  }

  public static void main(String[] args) {
    
    ArrayList<Integer> red = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4, 9));
    ArrayList<Integer> blue = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5, 1));
    System.out.println(classPhotos(red, blue));
  }
}
