package DynamicProgramming.LCSPattern;

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
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdefgi";
        String s2 = "ancdefgh";
        System.out.println("longestCommonSubstringTopDown(s1, s2) = " + longestCommonSubstringTopDown(s1, s2));
    }
}
