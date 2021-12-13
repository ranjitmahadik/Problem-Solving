package DynamicProgramming.KnapsackPattern;

import java.util.Arrays;

public class CountSubsetsWithGivenDiff {


    private static int hasSum(int[] arr, int targetSum) {
        int[][] dp = new int[arr.length + 1][targetSum + 1];
        for (int i = 0; i < targetSum + 1; i++) dp[0][i] = 0;
        for (int j = 0; j < arr.length + 1; j++) dp[j][0] = 1;

        dp[0][0] = 1; // not required though but still added. when arr.length >=0 and targetSum = 0 then we always have subset for that.

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


    private static int countSubsetWithGivenDifference(int[] arr, int runningSum, int targetDiff, int idx) {
        if (idx <= 0) {
            return runningSum == targetDiff ? 1 : 0;
        }

        int addItem = countSubsetWithGivenDifference(arr, runningSum + arr[idx - 1], targetDiff, idx - 1);
        int minusItem = countSubsetWithGivenDifference(arr, runningSum - arr[idx - 1], targetDiff, idx - 1);
        return addItem + minusItem;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int requiredDiff = 1;
        int totalSum = Arrays.stream(arr).sum();

        /**
         * s1 - s2 = diff                           --- 1
         * s1 + s2 = wholeSum                       --- 2
         * ------------------------
         * 2s1 = diff + wholeSum                    --- adding eq 1 and eq 2
         * s1 = (diff + wholeSum)/2;
         */
        int sumToBeSearched = (requiredDiff + totalSum) / 2;
        System.out.println("hasSum(arr, sumToBeSearched) = " + hasSum(arr, sumToBeSearched));

    }
}

/****
 *      s1 - s2 = diff
 *
 *      s1 + s2 = wholeSum
 *      s2 = wholeSum - s1
 *
 *      s1 - s2 = diff
 *      s1 - (wholeSum - s1) = diff
 *      s1 - wholeSum + s1 = diff
 *      2(s1) - wholeSum = diff
 *      2(s1) = diff + wholeSum
 *      s1 = (diff+wholeSum)/2
 *
 */

