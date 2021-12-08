package DynamicProgramming.GridPattern;

public class MaximalSquare {
    private static int getMaxSquare(char[][] grid, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return 0;

        int moveDown = 1 + getMaxSquare(grid, row + 1, col);
        int moveRight = 1 + getMaxSquare(grid, row, col + 1);
        int moveDownRight = 1 + getMaxSquare(grid, row + 1, col + 1);

        return Math.min(moveDown, Math.min(moveRight, moveDownRight));

    }

    private static int maxSquare(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int temp = getMaxSquare(grid, i, j);
                    ans = Math.max(ans, temp * temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1'}, {'0', '1'}};
        System.out.println("maxSquare(grid) = " + maxSquare(grid));
    }
}
