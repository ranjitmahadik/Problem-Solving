package DynamicProgramming.GridPattern;

import java.util.Arrays;

public class MinPathSum {
    private static int[][] dp;
    private static int minPathSum(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
        else if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        else if(dp[row][col] != -1) return dp[row][col];


        int moveRight = minPathSum(grid, row, col + 1);
        int moveDown = minPathSum(grid, row + 1, col);

        return dp[row][col] = Math.min(moveDown, moveRight) + grid[row][col];
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        dp = new int[grid.length+1][grid[0].length+1];
        for(int[] dpArr : dp)   Arrays.fill(dpArr,-1);
        System.out.println("minPathSum(grid,0,0) = " + minPathSum(grid, 0, 0));
    }
}
