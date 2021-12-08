package DynamicProgramming.LCSPattern;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class MaximumLengthofRepeatedSubarray {

    private int ans = 0;

    private int findLength(int[] arr1, int[] arr2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        int length = 0;

        if (arr1[i - 1] == arr2[j - 1]) {
            length = findLength(arr1, arr2, i - 1, j - 1) + 1;
            //  remember you can not return here: why? see case: s1 = 1,2,3 s2=1,4,1,2,3
            ans = Math.max(ans, length);
        }

        findLength(arr1, arr2, i - 1, j);
        findLength(arr1, arr2, i, j - 1);

        return length;
    }


    private static int findLength(int[] arr1, int[] arr2) {
        int n = arr1.length + 1, m = arr2.length + 1, ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {3, 2, 1, 4, 7};

        System.out.println("findLength(arr1, arr2) = " + findLength(arr1, arr2));
    }
}
