package DynamicProgramming.KadanesPattern;

public class LargestSumContinuousSubarray {

    private static int getMaxSumSubarray(int[] arr) {
        int globalMaxSum = arr[0];
        int runningSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningSum = Math.max(runningSum + arr[i], arr[i]);
            globalMaxSum = Math.max(globalMaxSum,runningSum);
        }
        return globalMaxSum;
    }

    public static void main(String[] args) {

    }
}
