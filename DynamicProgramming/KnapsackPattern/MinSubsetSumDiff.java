package DynamicProgramming.KnapsackPattern;

import java.util.Arrays;

public class MinSubsetSumDiff {

    /**
     * s1 + s2 = wholeSum                          s1 - s2 = ?
     * s2 = wholeSum - s1;
     */
    private static int minSubsetSumDifference(int[] arr, int idx, int currentSum, int totalSum) {
        if (idx <= 0) {
            int remainingSum = totalSum - currentSum;
            return Math.abs(currentSum - remainingSum);
//            return Math.abs((2 * currentSum) - totalSum);
        }

        return Math.min(minSubsetSumDifference(arr, idx - 1, currentSum + arr[idx - 1], totalSum),
                minSubsetSumDifference(arr, idx - 1, currentSum, totalSum));
    }

    public static void main(String[] args) {
//        int[] arr = {1, 6, 11, 5};
        int[] arr = {1,2,7};
        int arrSum = Arrays.stream(arr).sum();
        System.out.println("minSubsetSumDifference = " + minSubsetSumDifference(arr, arr.length, 0, arrSum));
    }
}
/**
 * {1,6,11,5} => {5,6} | {1,11}        => 11 - 12 = 1
 * =>  11 + 12 = 23 => (11*2) - 23
 */


