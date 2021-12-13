package DynamicProgramming.KadanesPattern;

public class SmallestSumSubarray {
    private static int smallestSumSubarray(int[] arr) {
        int globalMinSum = arr[0];
        int runningMinSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningMinSum = Math.min(runningMinSum + arr[i], arr[i]);
            globalMinSum = Math.min(globalMinSum, runningMinSum);
        }
        return globalMinSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, -4, 2, -3, -1, 7, -5};
        System.out.println("smallestSumSubarray(arr) = " + smallestSumSubarray(arr));
    }
}
