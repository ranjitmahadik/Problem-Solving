package Map;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {
    /***
     *
     *  at ecah index i we are trying to check if it's possible have subarray of sum k.
     *          sum = sum + arr[i];
     *           int need = sum - k;    // check if it's possible to have subarray from i to some j (j < i).
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
}
