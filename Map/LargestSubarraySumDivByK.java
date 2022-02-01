package Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySumDivByK {
    private static int largestSubarraySumDivKBruteForce(int[] arr, int K) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int runningSum = 0;
            for (int j = i; j < arr.length; j++) {
                runningSum += arr[j];
                if (runningSum % K == 0) ans = Math.max(ans, j - i + 1);
            }
        }
        System.out.println(ans);
        return ans;
    }

    private static int largestSubarraySumDivK(int[] arr, int K) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int prefSum = 0, ans = 0;
        lookup.put(prefSum, -1);
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            prefSum = ((prefSum % K) + K) % K; // handling negative cases.
            if (lookup.containsKey(prefSum)) {
                ans = Math.max(ans, i - lookup.get(prefSum));
            } else {
                lookup.put(prefSum, i);
            }
        }
//        System.out.println(ans);
        return ans;
    }

    private static int countSubarrysDivByK(int[] arr, int K) {
        Map<Integer, Integer> lookup = new HashMap<>();
        lookup.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum = ((sum % K) + K) % K;
            count += lookup.getOrDefault(sum, 0);
            lookup.put(sum, lookup.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 2, -5, 12, -11, -1, 7};
        int K = 3;
        largestSubarraySumDivKBruteForce(arr, K);
        largestSubarraySumDivK(arr, K);
        countSubarrysDivByK(arr, K);
    }
}
