package DynamicProgramming.Misc;

import java.util.Arrays;

public class TribonacciNumber {

    private static int tribonacciNumber(int n) {
        if (n == 0) return 0;
        else if (n > 0 && n <= 2) return 1;

        int a = tribonacciNumber(n - 1);
        int b = tribonacciNumber(n - 2);
        int c = tribonacciNumber(n - 3);

        return a + b + c;
    }

    private static int tribonacciNumberMemo(int n, int[] dp) {
        if (n == 0) return 0;
        else if (n > 0 && n <= 2) return 1;
        else if (dp[n] != -1) return dp[n];

        int a = tribonacciNumberMemo(n - 1, dp);
        int b = tribonacciNumberMemo(n - 2, dp);
        int c = tribonacciNumberMemo(n - 3, dp);

        return dp[n] = a + b + c;
    }

    private static int tribonacciNumberTopDown(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) dp[i] = 0;
            else if (i <= 2) dp[i] = 1;
            else {
                int a = dp[i - 1];
                int b = dp[i - 2];
                int c = dp[i - 3];

                dp[i] = a + b + c;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = tribonacciNumber(10);
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        int ans2 = tribonacciNumberMemo(10, dp);
        int ans3 = tribonacciNumberTopDown(10);
        System.out.println(ans + " : " + ans2 + " : " + ans3);
    }
}
