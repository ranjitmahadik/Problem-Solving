package DynamicProgramming.MCM;

public class BurstBallons {
    private static int maxCoins(int[] arr, int i, int j) {
        if (i > j) return 0;

        int ans = 0;
        for (int k = i; k <= j; k++) {
            int cost = arr[k];
            if (i - 1 >= 0) cost *= arr[i - 1];
            if (j + 1 < arr.length) cost *= arr[j + 1];
            int temp = maxCoins(arr, i, k - 1) + maxCoins(arr, k + 1, j) + cost;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    private static int maxCoins2(int[] arr, int i, int j) {
        if (i > j) return 0;
        else if (i == j) {
            return arr[i] * arr[i - 1] * arr[i + 1];
        }
        int ans = 0;
        for (int k = i; k <= j; k++) {
            // let's burst kth ballon last;
            int cost = arr[k] * arr[i - 1] * arr[j + 1];
            int temp = maxCoins2(arr, i, k - 1) + maxCoins2(arr, k + 1, j) + cost;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 1, 5, 8};
//        System.out.println(maxCoins(arr, 0, arr.length - 1));
        int[] arr = {1, 1, 5, 1};
        System.out.println(maxCoins2(arr, 1, arr.length - 2));
    }
}
