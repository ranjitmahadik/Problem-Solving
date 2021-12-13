package DynamicProgramming.LCSPattern;

public class LongestPalindromingSubstring {
    /**
     * Approach 1 using reverse string approach won't work in this case. if strings reverse version present in string itself.
     */

    private static String ans = "";

    private static String longestPalindromicSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return ans;
    }

    private static void expandAroundCenter(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        /***            0 1 2 3 4 5 6
         *              * * a b a * *
         *                              l = 1 h = 5  = h -l     = 5 - 1 - 1 = 3
         *
         * */
        if (ans.length() < hi - lo - 1) {
            ans = s.substring(lo + 1, hi);
        }
    }

    /**
     * time => o(3^n)
     */
    private static int lpSubstring(String s, int i, int j, int count) {
        if (i > j) {
            return count;
        } else if (i == j) {
            return count + 1;
        }

        int left = lpSubstring(s, i + 1, j, 0);
        int right = lpSubstring(s, i, j - 1, 0);
        int mid = 0;
        if (s.charAt(i) == s.charAt(j)) {
            mid = lpSubstring(s, i + 1, j - 1, count + 2);
        }
        return Math.max(Math.max(left, right), mid);
    }


    public static void main(String[] args) {
        String a = "abacdfgdcaba";
        System.out.println("longestPalindromicSubstring(\"abacdfgdcaba\") = " + longestPalindromicSubstring(a));
        System.out.println("lpSubstring(\"abacdfgdcaba\",0) = " + lpSubstring(a, 0, a.length() - 1, 0));
    }
}
