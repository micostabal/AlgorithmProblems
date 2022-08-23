import java.util.*;

public class Main {

    public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
        
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if ( array[i] + array[j] + array[k] == targetSum ) {
                        Integer[] triplet = {array[i], array[j], array[k]};
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        Iterator<Integer> it_1 = Arrays.stream(arrayOne).iterator();
        Iterator<Integer> it_2 = Arrays.stream(arrayTwo).iterator();

        int n = arrayOne.length;
        int m = arrayTwo.length;

        int min_1 = it_1.next();
        int min_2 = it_2.next();

        int[] array_tj = new int[m + n];
        boolean[] types_tj = new boolean[m + n];

        for (int i = 0; i < m + n; i++) {
            if (min_1 <= min_2) {
                array_tj[i] = min_1;
                types_tj[i] = true;
                if (it_1.hasNext()) {
                    min_1 = it_1.next();
                } else {
                    array_tj[i + 1] = min_2;
                    types_tj[i + 1] = false;

                    for (int j = i + 2; j < m + n - 2; j++) {
                        array_tj[j] = it_2.next();
                        types_tj[j] = false;
                    }
                    break;
                }
            } else {
                array_tj[i] = min_2;
                types_tj[i] = false;
                if (it_2.hasNext()) {
                    min_2 = it_2.next();
                } else {
                    array_tj[i + 1] = min_1;
                    types_tj[i + 1] = true;
                    for (int j = i + 2; j < m + n - 2; j++) {
                        array_tj[j] = it_1.next();
                        types_tj[j] = true;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < n + m; i++) {
            System.out.println( String.format("%s, %s", array_tj[i], types_tj[i]));
        }

        int current_min = 0;
        int current_1 = 0;
        int current_2 = 0;
        boolean _found = false;

        for (int i = 0; i < n + m - 1; i++) {
            if (types_tj[i] != types_tj[i + 1]) {

                if (!_found) {
                    current_min = Math.abs(array_tj[i] - array_tj[i + 1]);
                    System.out.println( String.format("%s, %s", array_tj[i], types_tj[i]));
                    if (types_tj[i]) {
                        current_1 = array_tj[i];
                        current_2 = array_tj[i + 1];
                    } else {
                        current_1 = array_tj[i + 1];
                        current_2 = array_tj[i];
                    }
                    _found = true;
                } else {
                    if (Math.abs( array_tj[i] - array_tj[i + 1] ) < current_min) {
                        current_min = Math.abs(array_tj[i] - array_tj[i + 1]);

                        if (types_tj[i]) {
                            current_1 = array_tj[i];
                            current_2 = array_tj[i + 1];
                        } else {
                            current_1 = array_tj[i + 1];
                            current_2 = array_tj[i];
                        }
                    }
                }
            }
        }

        return new int[]{current_1, current_2};
    }

    public static void main(String[] args) {
        
        /*
        ArrayList<Integer> si = new ArrayList<Integer>(
            Arrays.asList(12, 3, 1, 2, -6, 5, -8, 6)
        );
        */
        int[] arrayOne = new int[]{ 10, 0, 20, 25, 2200};
        int[] arrayTwo = new int[]{ 1005, 1006, 1014, 1032, 1031};

        int[] output = smallestDifference(arrayOne, arrayTwo);

        System.out.println(String.format("[%s, %s]", output[0], output[1]));
    }
}