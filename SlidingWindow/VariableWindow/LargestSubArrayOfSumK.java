package SlidingWindow.VariableWindow;

public class LargestSubArrayOfSumK {
    private static void largestSubArrayOfSumK(int[] arr, final int K) {
        int i = 0, j = 0, runningSum = 0, maxLen = Integer.MIN_VALUE;
        while (j < arr.length) {
            runningSum += arr[j];
            if (runningSum == K) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (runningSum > K) {
                runningSum -= arr[i++];
            }
            j++;
        }
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        largestSubArrayOfSumK(arr, k);
    }
}
