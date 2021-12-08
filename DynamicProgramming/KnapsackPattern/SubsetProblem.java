package DynamicProgramming.KnapsackPattern;

public class SubsetProblem {
    private static boolean hasSum(int[] arr, int targetSum, int idx) {
        if (targetSum == 0) return true;
        else if (idx <= 0) return false;
        else if (targetSum - arr[idx - 1] >= 0) {
            return hasSum(arr, targetSum - arr[idx - 1], idx - 1) || hasSum(arr, targetSum, idx - 1);
        }
        return hasSum(arr, targetSum, idx - 1);
    }

    /**
     *      0 1 2 3 4 5
     * 0    1 0 0 0 0 0
     * 1    1
     * 2    1
     * 3    1
     */

    private static boolean hasSum(int[] arr, int targetSum) {
        boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];
        for (int i = 0; i < targetSum + 1; i++) dp[0][i] = false;
        for (int j = 0; j < arr.length + 1; j++) dp[j][0] = true;

        dp[0][0] = true; // not required though but still added. when arr.length >=0 and targetSum = 0 then we always have subset for that.

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][targetSum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 8};
        int targetSum = 18;
        System.out.println("hasSum(arr, targetSum, arr.length) = " + hasSum(arr, targetSum, arr.length));
        System.out.println("hasSum(arr, targetSum) = " + hasSum(arr, targetSum));
    }
}
