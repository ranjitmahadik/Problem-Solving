package DynamicProgramming.KnapsackPattern;

import java.util.Arrays;

public class EqualSumPartition {

    private static boolean canPartition(int[] arr, int halfSum, int idx) {
        if (halfSum == 0) return true;
        else if (idx <= 0) return false;
        else if (halfSum - arr[idx - 1] >= 0) {
            return canPartition(arr, halfSum - arr[idx - 1], idx - 1) || canPartition(arr, halfSum, idx - 1);
        }
        return canPartition(arr, halfSum, idx - 1);
    }

    private static boolean canPartitionTopDown(int[] arr, int halfSum) {
        boolean[][] dp = new boolean[arr.length + 1][halfSum + 1];
        for (int i = 0; i < halfSum + 1; i++) dp[0][i] = false;
        for (int j = 0; j < arr.length + 1; j++) dp[j][0] = true;

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < halfSum + 1; j++) {
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[arr.length][halfSum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 11};
        int arrSum = Arrays.stream(arr).sum();
        if ((arrSum & 1) == 1) {
            System.out.println("Cannot partition array into two equal halfs.");
        } else {
            System.out.println("canPartition(arr,arrSum/2,arr.length) = " + canPartition(arr, arrSum / 2, arr.length));
            System.out.println("canPartitionTopDown(arr, arrSum / 2) = " + canPartitionTopDown(arr, arrSum / 2));
        }
    }
}

//{1,5,11,5} => 11  + 10 + 1 => 21 + 1 = 22/2 => 11
// {1,5,11} => 6 + 11 => 17 => 17/2 = 8
