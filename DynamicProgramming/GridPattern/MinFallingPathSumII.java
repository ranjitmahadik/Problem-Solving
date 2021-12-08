package DynamicProgramming.GridPattern;

public class MinFallingPathSumII {
    private static int minFallingPathSum(int[][] grid, int row, int col) {
        if (row > grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
        else if (row == grid.length - 1) return grid[row][col];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            if (col == i) continue; // following constraint.
            int temp = minFallingPathSum(grid, row + 1, i);
            if (temp == Integer.MAX_VALUE) continue;
            ans = Math.min(ans, temp + grid[row][col]);
        }
        return ans;
    }

    /**
     * 1   2   3
     * 4   5   6
     * 7   8   9
     */
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("minFallingPathSum(grid,0,0) = " + minFallingPathSum(grid, 0, 0));
    }

}
/***
 *          -   *   -
 *          -   -   -
 *          -   -   -
 *
 *
 */

