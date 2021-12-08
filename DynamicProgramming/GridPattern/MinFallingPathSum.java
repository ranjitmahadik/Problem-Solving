package DynamicProgramming.GridPattern;

public class MinFallingPathSum {
    private static int minFallingPathSum(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || j < 0) return Integer.MAX_VALUE;
        else if (i == grid.length - 1) return grid[i][j];

        int moveDownWithLeft = minFallingPathSum(grid, i + 1, j - 1);
        int moveDown = minFallingPathSum(grid, i + 1, j);
        int moveDownWithRight = minFallingPathSum(grid, i + 1, j + 1);

        return Math.min(moveDown, Math.min(moveDownWithLeft, moveDownWithRight)) + grid[i][j];
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, minFallingPathSum(grid, 0, i));
        }
        System.out.println("ans = " + ans);
    }
}
