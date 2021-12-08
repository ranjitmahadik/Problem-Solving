package BinarySearch;


import java.util.Arrays;


/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {

    public static boolean isPossible(int[] arr, final int splitSum, int k) {
        int currentSum = 0, localK = 1;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > splitSum) {
                currentSum = arr[i];
                localK++;
            }
        }
        return localK <= k;
    }

    /**
     * min number of partitions can be 1 then answer would be sum of entire array.
     * max number of partitions can be n then answer would be max of array.
     */
    public static int splitArray(int[] arr, int k) {
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(arr, mid, k)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi + 1;
    }

    /**
     * searching the sum :
     * lo = 10, hi = 32;
     * mid = 42/2 = 21;
     * 7 2 5 | 10 8
     */
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        int res = splitArray(arr, k);
        System.out.println(res);
    }

    public static int splitArrayRecursive(int[] arr, int startPoint, int numberOfSplits) {
        if (startPoint == arr.length && numberOfSplits == 0) return 0;
        else if (startPoint == arr.length || numberOfSplits == 0) return Integer.MAX_VALUE;

        int currentSum = 0, res = Integer.MAX_VALUE;
        for (int i = startPoint; i < arr.length; i++) {
            currentSum += arr[i];
            int maxItemTillLast = splitArrayRecursive(arr, i + 1, numberOfSplits - 1);
            res = Math.min(res, Math.max(currentSum, maxItemTillLast));
        }
        return res;
    }

}


/**
 * /**
 * 7  | 2 5 10 8           => 7 | 25        => 25
 * 7 2 | 5 10 8            => 9 | 23        => 23
 * 7 2 5 | 10 8            => 14 | 18       => 18*
 * 7 2 5 10 | 8            => 24 | 8        => 24
 */