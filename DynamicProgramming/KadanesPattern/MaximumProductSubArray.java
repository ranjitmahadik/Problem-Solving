package DynamicProgramming.KadanesPattern;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductSubArray {
    private static Map<String, Integer> dp = new HashMap<>();

    private static int getMaxProductSubArray(int[] arr, int idx, int prod) {
        if (idx >= arr.length) return prod;
        String key = idx + " " + prod;
        if (dp.containsKey(key)) return dp.get(key);

        //1.include current element in previous max prod subarray.
        int opt1 = getMaxProductSubArray(arr, idx + 1, prod * arr[idx]);
        //2.start max prod subarray from current element
        int opt2 = getMaxProductSubArray(arr, idx + 1, arr[idx]);

        if (idx == 0) prod = arr[0];

        //3.if subarray ends at this idx. so take that in account.
        int ans = Math.max(Math.max(opt1, opt2), prod);
        dp.put(key, ans);
        return ans;
    }

    private static int maxProduct(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int runningMaxProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            runningMaxProduct = Math.max(arr[i], runningMaxProduct * arr[i]);
            maxProduct = Math.max(runningMaxProduct, maxProduct);
        }
        return maxProduct;
    }

}
