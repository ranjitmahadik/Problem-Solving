package DynamicProgramming.LCSPattern;

import util.Util;

public class ShortestCommonSupersequence {
    /**
     * if s[i] == s[j]  then count only 1 time.
     * else 1 + min(f(i+1,j),f(i,j+1));
     */
    private static int shortestCommonSuperSequence(String s1, int i, String s2, int j) {
        if (i == 0 || j == 0) {
            return Math.max(i, j);
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // this will generate lcs.
            return 1 + shortestCommonSuperSequence(s1, i - 1, s2, j - 1);
        }
        int a = shortestCommonSuperSequence(s1, i - 1, s2, j);
        int b = shortestCommonSuperSequence(s1, i, s2, j - 1);
        return Math.min(a, b) + 1;
    }

    private static int shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = Math.max(i, j);
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    int opt1 = dp[i - 1][j];
                    int opt2 = dp[i][j - 1];
                    dp[i][j] = Math.min(opt1, opt2) + 1;
                }
            }
        }
        return dp[n][m];
    }



    public static void main(String[] args) {
        String a = "geek", b = "eke";
        System.out.println("shortestCommonSuperSequence(a,a.length(),b,b.length()) = " + shortestCommonSuperSequence(a, a.length(), b, b.length()));
        System.out.println("shortestCommonSuperSequence(a, b) = " + shortestCommonSuperSequence(a, b));
    }
}