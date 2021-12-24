package DynamicProgramming.GridPattern;

public class MaximalSquare {
    private static int getMaxSquare(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return 0;

        int opt1 = getMaxSquare(grid, row + 1, col);
        int opt2 = getMaxSquare(grid, row, col + 1);
        int opt3 = getMaxSquare(grid, row + 1, col + 1);

        return Math.min(Math.min(opt1, opt2), opt3) + 1;
    }


    /***
     *      1   1
     *      1   *
     *
     *      dp[1][1] = 1 + min({dp[0}[1],dp[1][0],dp[0][0])
     *      dp[1][1] = 1 + min(1,1,1)   => 1 + 1 => 2.
     *
     *
     *      dp[i][j] = states max square ending at (i,j)
     *
     * */
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1'}, {'1', '1'}};
        System.out.println("maxSquare(grid) = " + maximalSquare(grid));
    }
}
