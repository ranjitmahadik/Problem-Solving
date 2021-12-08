package Graph;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static int minTimeToRotten(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) q.add(new Pair<>(i, j));
                else if (grid[i][j] == 1) freshOranges++;
            }
        }

        if (freshOranges == 0) return freshOranges;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            while (size > 0) {
                size--;

                int currentRow = q.peek().getFirst();
                int currentCol = q.peek().getSecond();

                q.poll();

                for (int i = 0; i < dirs.length; i++) {
                    int row = currentRow + dirs[i][0];
                    int col = currentCol + dirs[i][1];

                    if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshOranges--;
                        q.add(new Pair<>(row, col));
                    }
                }
            }
        }
        return freshOranges == 0 ? time - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};
        System.out.println(" = " + minTimeToRotten(grid));
    }
}
