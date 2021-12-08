package DynamicProgramming.UnBoundedKnapsackPattern;

//https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1
public class CountNumberOfWaysToReachGivenScore {

    // we want to count distinct ways = {3,5} and {5,3} is considered as same hence this solution will not work.
    private static int countWays(int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;

        int a, b, c;
        a = b = c = 0;

        if (n - 3 >= 0) a = countWays(n - 3);
        if (n - 5 >= 0) b = countWays(n - 5);
        if (n - 10 >= 0) c = countWays(n - 10);

        return a + b + c;
    }

    private static int countDistinctWays(int n, int[] arr, int idx) {
        if (n == 0) return 1;
        else if (idx >= arr.length) return 0;

        int a = 0;
        if (n - arr[idx] >= 0) {
            a += countDistinctWays(n - arr[idx], arr, idx);
        }
        int b = countDistinctWays(n, arr, idx + 1);
        return a + b;
    }

    /**
     * = 8
     * 3 5
     * 5 3
     */

    public static void main(String[] args) {
        System.out.println("countWays(20) = " + countWays(20) + " : " + countDistinctWays(8, new int[]{3, 5, 10}, 0));
    }
}
