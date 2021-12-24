package SlidingWindow.FixedWindow;

public class MaxSumSubarrayWithKWindow {

    private static void maxSubarrayBrute(int[] arr, int k) {
        int globalSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int localSum = 0;
            for (int j = i; j < i + k; j++) {
                localSum += arr[j];
            }
            globalSum = Math.max(globalSum, localSum);
        }
        System.out.println(globalSum);
    }

    private static void maxSubarrayWithKSize(int[] arr, int K) {
        int globalSum = 0, localSum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            localSum += arr[j];
            int currentLen = j - i + 1;
            if (currentLen < K) j++;
            else if (currentLen == K) {
                globalSum = Math.max(globalSum, localSum);
                localSum -= arr[i++];
                j++;
            }
        }
        System.out.println(globalSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, 5};
        maxSubarrayBrute(arr, 3);
        maxSubarrayWithKSize(arr, 3);
    }
}
