package Map;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {
    /***
     *
     *  at ecah index i we are trying to check if it's possible have subarray of sum k.
     *          sum = sum + arr[i];
     *           int need = sum - k;    // check if it's possible to have subarray from i to some j (j < i).
     *  just think about prefix sums.
     *  K = pref[R] - pref[L-1];
     *  pref[R] - K = pref[L-1]
     *
     */
    private static void subarraySum(int[] arr, int K) {
        Map<Integer, Integer> countPref = new HashMap<>();
        countPref.put(0, 1);
        int runningSum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            int need = runningSum - K;
            ans += countPref.getOrDefault(need, 0);
            countPref.put(runningSum, countPref.getOrDefault(runningSum, 0) + 1);
        }
        System.out.println(ans);
    }

    private static int subarraySumEqualToK(int[] arr, int K) {
        int j = 0, ans = 0, prefSum = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        lookup.put(prefSum, 1);
        while (j < arr.length) {
            prefSum += arr[j];
            int neededAmount = prefSum - K;
            if (lookup.containsKey(neededAmount)) {
                ans += lookup.get(neededAmount);
            }
            lookup.put(prefSum, lookup.getOrDefault(prefSum, 0) + 1);
            j++;
        }
        return ans;
    }
}
