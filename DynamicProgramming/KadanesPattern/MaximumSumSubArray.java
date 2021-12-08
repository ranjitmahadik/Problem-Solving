package DynamicProgramming.KadanesPattern;

public class MaximumSumSubArray {


    private static int ans = Integer.MIN_VALUE;

    private static int maxSubArray(int[] arr, int idx) {
        if (idx >= arr.length) return 0;
        int incl = maxSubArray(arr, idx + 1);

        ans = Math.max(ans, Math.max(incl + arr[idx], arr[idx]));

        return Math.max(incl + arr[idx], arr[idx]);
    }

    private static int ans1 = Integer.MIN_VALUE;

    private static int maxSubarrayL(int[] arr, int idx) {
        if (idx <= 0) return 0;
        else if (idx == 1) return arr[idx - 1];

        int includeCurrentElementToMaxSubarray = arr[idx - 1] + maxSubArray(arr, idx - 1);
        ans1 = Math.max(ans1, Math.max(includeCurrentElementToMaxSubarray, arr[idx - 1]));
        return Math.max(includeCurrentElementToMaxSubarray, arr[idx - 1]);
    }

    /***
     *      [..........................i.............................]
     *      at i'th element I have two choices.
     *          1.to include i'th element in maxSubarray.
     *          2.to start new maxSumSubArray from i'th element.
     *
     *
     */
    private static int maxSubarray(int[] arr) {
        int globalMaxSum = arr[0];
        int runningMaxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningMaxSum = Math.max(arr[i], runningMaxSum + arr[i]);
            globalMaxSum = Math.max(runningMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{2, 3, -11, 4}));
    }
}
