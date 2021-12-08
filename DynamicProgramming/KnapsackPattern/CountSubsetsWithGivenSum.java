package DynamicProgramming.KnapsackPattern;

public class CountSubsetsWithGivenSum {

    private static int countSubsetsWithGivenSum(int[] arr, int target, int idx) {
        if (target == 0) return 1;
        else if (idx <= 0) return 0;
        else if (target - arr[idx - 1] >= 0) {
            return countSubsetsWithGivenSum(arr, target - arr[idx - 1], idx - 1) + countSubsetsWithGivenSum(arr, target, idx - 1);
        }
        return countSubsetsWithGivenSum(arr, target, idx - 1);
    }

    private static int countSubsetsWithGivenSumTopDown(int[] arr, int targetSum) {
        int[][] dp = new int[arr.length + 1][targetSum + 1];
        for (int i = 0; i < targetSum + 1; i++) dp[0][i] = 0;
        for (int j = 0; j < arr.length + 1; j++) dp[j][0] = 1;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[arr.length][targetSum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;

        System.out.println("countSubsetsWithGivenSum(arr, target, arr.length) = " + countSubsetsWithGivenSum(arr, target, arr.length));
        System.out.println("countSubsetsWithGivenSumTopDown(arr, target) = " + countSubsetsWithGivenSumTopDown(arr, target));
    }
}
/**
 * {10},{8,2},{5,3,2}
 */
