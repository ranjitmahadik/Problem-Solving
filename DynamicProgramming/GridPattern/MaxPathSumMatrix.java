package DynamicProgramming.GridPattern;

public class MaxPathSumMatrix {
    private static int maxPathSum(int[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || col < 0) return 0;
        if (row == grid.length - 1) return grid[row][col];

        int moveDown = maxPathSum(grid, row + 1, col);
        int moveLeftWithDown = maxPathSum(grid, row + 1, col - 1);
        int moveRightWithDown = maxPathSum(grid, row + 1, col + 1);

        return grid[row][col] + Math.max(moveDown, Math.max(moveRightWithDown, moveLeftWithDown));
    }

    public static void main(String[] args) {
        int[][] grid = {{348, 391}, {618, 193}};
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.max(ans, maxPathSum(grid, 0, i ));
        }
        System.out.println("ans = " + ans);
    }
}
