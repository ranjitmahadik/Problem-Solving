package DynamicProgramming.LIS;

//https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
public class MaximumSumIncreasingSubsequence {

    /**
     * {1, 101, 2, 3, 100, 4, 5}
     */
    private static int getMaximumSumIncreansingSubsequence(int[] arr, int idx, int prevSelectedIndex) {
        if (idx >= arr.length) return 0;

        int selectItem = 0;
        if (prevSelectedIndex == -1 || arr[prevSelectedIndex] < arr[idx]) {
            selectItem = arr[idx] + getMaximumSumIncreansingSubsequence(arr, idx + 1, idx);
        }
        int notSelect = getMaximumSumIncreansingSubsequence(arr, idx + 1, prevSelectedIndex);

        return Math.max(notSelect, selectItem);
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println("getMaximumSumIncreansingSubsequence(arr, 0, -1) = " + getMaximumSumIncreansingSubsequence(arr, 0, -1));
    }
}
