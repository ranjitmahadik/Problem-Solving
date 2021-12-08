package DynamicProgramming.LCSPattern;

public class LongestCommonSubsequence {

    private static String finalOutput = "";
    private static int[][] dp;

    private static int LCSRecursive(String s1, String s2, int idx1, int idx2) {
        if (idx1 <= 0 || idx2 <= 0) return 0;
        else if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
        else if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + LCSRecursive(s1, s2, idx1 - 1, idx2 - 1);
        }
        int opt1 = LCSRecursive(s1, s2, idx1 - 1, idx2);
        int opt2 = LCSRecursive(s1, s2, idx1, idx2 - 1);
        return dp[idx1][idx2] = Math.max(opt1, opt2);
    }

    private static int LCSRecursive(String s1, String s2, int idx1, int idx2, String output) {
        if (idx1 == 0 && idx2 == 0) {
            if (finalOutput.length() < output.length()) finalOutput = output;
            return 0;
        } else if (idx1 <= 0 || idx2 <= 0) return 0;
        else if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return 1 + LCSRecursive(s1, s2, idx1 - 1, idx2 - 1, s1.charAt(idx1 - 1) + output);
        }
        int opt1 = LCSRecursive(s1, s2, idx1 - 1, idx2, output);
        int opt2 = LCSRecursive(s1, s2, idx1, idx2 - 1, output);
        return Math.max(opt1, opt2);
    }

    private static int LCSTopDown(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        StringBuilder possibleOutPut = new StringBuilder("");
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) dp[i][j] = 0;
                else if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    possibleOutPut.append(s1.charAt(i - 1));
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println("possibleOutPut = " + possibleOutPut);
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";           //abdh
        String s2 = "abedfr";
        System.out.println("LCSRecursive(s1, s2, s1.length(), s2.length()) = " + LCSRecursive(s1, s2, s1.length(), s2.length(), ""));
        System.out.println("finalOutput = " + finalOutput);

        System.out.println("LCSTopDown(s1, s2) = " + LCSTopDown(s1, s2));
    }
}

/***
    Other DP+String combiantion problems  with similar pattern or involving LCS as intermediate step -

        edit distance - https://leetcode.com/problems/edit-distance/
        regex matching - https://leetcode.com/problems/regular-expression-matching/
        wildcard matching - https://leetcode.com/problems/wildcard-matching/
        shortest common supersequence (solution involves a LCS step) - https://leetcode.com/problems/shortest-common-supersequence
        Longest Palindrome Subsequence (could be solved using LCS) - https://leetcode.com/problems/longest-palindromic-subsequence/

 **/