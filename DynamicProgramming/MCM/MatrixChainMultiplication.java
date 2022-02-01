package DynamicProgramming.MCM;

/**
 *  always think about finding final ans.
 *  arr[i - 1] * arr[k] * arr[j];
 * */
public class MatrixChainMultiplication {

    private static int minOperations(int[] arr, int i, int j) {
        if (i >= j) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = minOperations(arr, i, k) + minOperations(arr, k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(temp, ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 30};
        System.out.println(minOperations(arr, 1, arr.length - 1));
    }
}
