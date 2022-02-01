package DynamicProgramming.Misc;

public class MaxSumOfNotAdjacentElements {
    private static int maxSumOfNotAdjacentElements(int[] arr, int idx) {
        if (idx < 0) return 0;

        int pick = arr[idx] + maxSumOfNotAdjacentElements(arr, idx - 2);
        int notPick = maxSumOfNotAdjacentElements(arr, idx - 1);

        return Math.max(pick, notPick);
    }

    private static int maxSumBottomUp(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i <= 0) dp[i] = 0;
            else if (i == 1) dp[i] = arr[i - 1];
            else {
                int pick = arr[i - 1] + dp[i - 2];
                int notPick = dp[i - 1];
                dp[i] = Math.max(pick, notPick);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    private static int maxSumSpaceOptimized(int[] arr) {
        int n = arr.length;
        int incl = 0, excl = 0;
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i <= 0) incl = 0;
            else if (i == 1) excl = arr[i - 1];
            else {
                int pick = arr[i - 1] + incl;
                int notPick = excl;
                ans = Math.max(ans, Math.max(pick, notPick));
                incl = excl;
                excl = Math.max(pick, notPick);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(maxSumOfNotAdjacentElements(arr, arr.length - 1));
        System.out.println(maxSumBottomUp(arr));
        System.out.println(maxSumSpaceOptimized(arr));
    }
}
