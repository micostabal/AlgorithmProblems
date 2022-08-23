public class LevenshteinDistance {
    public static int cost(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    public static int charInString(char c, String s) {
        return s.contains(Character.toString(c)) ? 1 : 0;
    }

    public static int levenshteinDistance(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == 0 || l2 == 0) {
            return Math.max(l1, l2);
        };
        int[][] ld = new int[l1][l2];
        ld[0][0] = cost(str1.charAt(0), str2.charAt(0));
        for (int j = 1; j < l2; j++) {
            ld[0][j] = j + 1 - charInString(str1.charAt(0), str2.substring(0, j + 1));
        }
        for (int i = 1; i < l1; i++) {
            ld[i][0] = i + 1 - charInString(str2.charAt(0), str1.substring(0, i + 1));
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                int this_value = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    ld[i][j] = Math.min(
                        this_value,
                        cost(str1.charAt(k), str2.charAt(j)) + ld[k - 1][j - 1] + i - k
                    );
                }
                ld[i][j] = Math.min(
                    ld[i][j],
                    ld[i][j - 1] + 1
                );

                for (int j2 = 0; j2 < l1; j2++) {
                    for (int j3 = 0; j3 < l2; j3++) {
                        System.out.print((ld[j2][j3])+" ");
                    }
                    System.out.println("");
                }
                System.out.println("");
            }
        }
        return ld[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        String p1 = "table";
        String p2 = "bal";
        System.out.println(
            levenshteinDistance(p1, p2)
        );
    }
}
