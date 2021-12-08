package BinarySearch;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold {
    public static boolean isPossible(int[] arr, int div, int thresh) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.ceil((double) arr[i] / div);
        }
        return res <= thresh;
    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int lo = 1, hi = Arrays.stream(arr).max().getAsInt();
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isPossible(arr, mid, threshold)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi + 1;
    }


    public static void main(String[] args) {
        int res = smallestDivisor(new int[]{1, 2, 5, 9}, 6);
        System.out.println(res);
    }
}
