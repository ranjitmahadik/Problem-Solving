package Map;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarrays {
    private static void zeroSumSubarrays(int[] arr) {
        int prefSum = 0, ans = 0;
        Map<Integer, Integer> look = new HashMap<>();
        look.put(prefSum, 1);
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            if (look.containsKey(prefSum)) {
                ans += look.get(prefSum);
            }
            look.put(prefSum, look.getOrDefault(prefSum, 0) + 1);
        }
        System.out.println(ans);
    }

    private static int longestSubarrayWithSumZero(int[] arr) {
        int j = 0, sum = 0, ans = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        lookup.put(sum, -1);
        while (j < arr.length) {
            sum += arr[j];
            if (lookup.containsKey(sum)) {
                ans = Math.max(ans, j - lookup.get(sum));
            } else {
                lookup.put(sum, j);
            }
            j++;
        }
        return ans;
    }

    private static long countZeroSumSubArrays(int[] arr) {
        int j = 0, ans = 0, prefSum = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        lookup.put(prefSum, 1);
        while (j < arr.length) {
            prefSum += arr[j];
            if (lookup.containsKey(prefSum)) {
                ans += lookup.get(prefSum);
            }
            lookup.put(prefSum, lookup.getOrDefault(prefSum, 0) + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2,
                4, 6, -12, -7};
        zeroSumSubarrays(arr);
        int[] arr1 = {0, 1, 2, 3};
        System.out.println(longestSubarrayWithSumZero(arr1));
    }
}
