package Trees.BinaryTrees;

public class NoOfBinarySearchTrees {

    private static int getTotalCountOfBinarySearchTrees(int n) {
        if (n <= 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 5;

        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += (getTotalCountOfBinarySearchTrees(i - 1) * getTotalCountOfBinarySearchTrees(n - i));
        }
        return totalCount;
    }

    private static int getTotalCountOFBSTs(int n, int[] dp) {
        if (n <= 1) return 1;
        else if (n == 2) return dp[n] = 2;
        else if (n == 3) return dp[n] = 5;

        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += (getTotalCountOFBSTs(i - 1, dp) * getTotalCountOFBSTs(n - i, dp));
        }
        return dp[n] = totalCount;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        System.out.println("getTotalCountOfBinarySearchTrees(4) = " + getTotalCountOFBSTs(n,dp));
    }
}
