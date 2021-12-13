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

    private static int util(int[] nums, int n, int index, int t) {
        if (index == n) return t;
        String key = "" + index + t;
        if (dp.containsKey(key)) return dp.get(key);

        // choice 1
        int x = util(nums, n, index + 1, t * nums[index]);
        // choice 2
        int y = util(nums, n, index + 1, nums[index]);

        // keep the t (previous cal. value) and compare -> choice 3
        int ans = Math.max(t, Math.max(x, y));
        dp.put(key, ans);
        return ans;
    }

    private static int maxProduct(int[] arr) {
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * arr[i], minProduct * arr[i]), arr[i]);
            minProduct = Math.min(Math.min(minProduct * arr[i], temp * arr[i]), arr[i]);
            if (maxProduct > ans) {
                ans = maxProduct;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 2, 3, -4};
        System.out.println("ut = " + util(arr, arr.length, 1, arr[0]));
    }

}
