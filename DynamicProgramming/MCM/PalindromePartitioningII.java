package DynamicProgramming.MCM;

public class PalindromePartitioningII {
    private static boolean isPalin(String sb, int lo, int hi) {
        if (lo >= hi) return true;
        while (lo <= hi) {
            if (sb.charAt(lo) != sb.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }

    private static int minCuts(String s, int start, int end) {
        if (start >= end) return 0;
        else if (isPalin(s, start, end)) return 0;

        int ans = Integer.MAX_VALUE - 1;
        for (int i = start; i < end; i++) {
            if (isPalin(s, start, i)) {
                int temp = 1 + minCuts(s, i + 1, end);
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }

    private static int minCutsForPalindrome(String s, int i, int j) {
        if (i >= j) return 0;
        else if (isPalin(s, i, j)) return 0;
        int ans = Integer.MAX_VALUE - 1;
        for (int k = i; k < j; k++) {
            if (isPalin(s, i, k)) {
                int temp = 1 + minCutsForPalindrome(s, k + 1, j);
                ans = Math.min(temp, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minCutsForPalindrome("dgk", 0, 2) + 1);
        System.out.println(minCutsForPalindrome("baaa", 0, 3) + 1);
        System.out.println(minCutsForPalindrome("abbba", 0, 4) + 1);
    }
}

/**
 * "c|dd"       0,2
 */