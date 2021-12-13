package DynamicProgramming.LCSPattern;

public class LongestPalindromicSubsequence {

    private static int longestPalindromicSubsequence(String s1, int i, String s2, int j) {
        if (i == 0 || j == 0) return 0;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) return 1 + longestPalindromicSubsequence(s1, i - 1, s2, j - 1);
        return Math.max(longestPalindromicSubsequence(s1, i - 1, s2, j), longestPalindromicSubsequence(s1, i, s2, j - 1));
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("bbbab");
        System.out.println("longestPalindromicSubsequence(sb.toString(), sb.length(), sb.reverse().toString(), sb.length()) = " + longestPalindromicSubsequence(sb.toString(), sb.length(), sb.reverse().toString(), sb.length()));
    }
}
