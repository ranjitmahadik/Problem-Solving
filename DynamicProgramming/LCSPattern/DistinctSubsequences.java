package DynamicProgramming.LCSPattern;

public class DistinctSubsequences {
    private static int numDistinct(String s1, int i, String s2, int j) {
        if (j == 0) return 1;
        else if (i <= 0) return 0;
        int count = 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            count += numDistinct(s1, i - 1, s2, j - 1);
        }
        count += numDistinct(s1, i - 1, s2, j);
        return count;
    }

    public static void main(String[] args) {
        String a = "babgbag", b = "bag";
        System.out.println("numDistinct(a, a.length(), b, b.length()) = " + numDistinct(a, a.length(), b, b.length()));
    }
}
