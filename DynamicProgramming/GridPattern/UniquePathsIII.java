package DynamicProgramming.GridPattern;

public class UniquePathsIII {

    private static int countUniquePaths(int[][] grid, int row, int col, int zeroCount) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1 || grid[row][col] == -99 || zeroCount < 0)
            return 0;
        else if (grid[row][col] == 2 && zeroCount == 0) return 1;

        int restoreVal = grid[row][col];
        grid[row][col] = -99;

        int down = countUniquePaths(grid, row + 1, col, zeroCount - 1);
        int up = countUniquePaths(grid, row - 1, col, zeroCount - 1);
        int right = countUniquePaths(grid, row, col + 1, zeroCount - 1);
        int left = countUniquePaths(grid, row, col - 1, zeroCount - 1);

        grid[row][col] = restoreVal;

        return down + up + left + right;
    }

    /***
     *  1   0   0   0
     *  0   0   0   0
     *  0   0   2   -1
     *
     * */

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int zeroCount = 0;
        int startX = -1, startY = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) zeroCount++;
            }
        }

        System.out.println("countUniquePaths(grid, startX, startY, zeroCount) = " + countUniquePaths(grid, startX, startY, zeroCount + 1));

    }
}
