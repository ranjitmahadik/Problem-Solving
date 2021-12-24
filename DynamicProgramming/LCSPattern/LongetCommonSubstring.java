package DynamicProgramming.LCSPattern;

import util.Util;

public class LongetCommonSubstring {

    private static int longestCommonSubstringTopDown(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }

        Util.showTable(dp);

        return ans;
    }

    private static int longestCommonSubstring(String s1, int i, String s2, int j, int count) {
        if (i == 0 || j == 0) return count;

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            count = longestCommonSubstring(s1, i - 1, s2, j - 1, count + 1);

        int opt1 = longestCommonSubstring(s1, i - 1, s2, j, 0);
        int opt2 = longestCommonSubstring(s1, i, s2, j - 1, 0);


        return Math.max(Math.max(count, opt1), opt2);
    }

    public static void main(String[] args) {
        String s1 = "abcdefgi";
        String s2 = "ancdefgh";
        System.out.println("longestCommonSubstringTopDown(s1, s2) = " + longestCommonSubstringTopDown(s1, s2));
        System.out.println("longestCommonSubstring(s1,s1.length(),s2,s2.length()) = " + longestCommonSubstring(s1, s1.length(), s2, s2.length(), 0));
    }
}
