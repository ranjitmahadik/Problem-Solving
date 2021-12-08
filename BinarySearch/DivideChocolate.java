package BinarySearch;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/divide-chocolate/
 */
public class DivideChocolate {

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
        int lo = Arrays.stream(arr).min().getAsInt();
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
    
}
