package DynamicProgramming.GridPattern;

import util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
public class UniquePathsII {

    private static int countPaths(int[][] paths, int i, int j) {
        if (i == (paths.length - 1) && j == (paths[0].length - 1) && paths[i][j] != 1) return 1;
        else if (i >= paths.length || j >= paths[0].length) return 0;

        int moveDown = 0, moveRight = 0;

        if (paths[i][j] != 1) {
            moveDown = countPaths(paths, i + 1, j);
            moveRight = countPaths(paths, i, j + 1);
        }

        return moveDown + moveRight;
    }

    private static int countPaths(int[][] paths) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        Set<Pair<Integer, Integer>> s = new HashSet<>();
        q.offer(new Pair<>(0, 0));
        int count = 0;
        final int targetRow = paths.length - 1;
        final int targetCol = paths[0].length - 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int rowIdx = (int) p.getFirst();
            int colIdx = (int) p.getSecond();

            if (s.contains(p)) continue;

            if (rowIdx == targetRow && colIdx == targetCol && paths[rowIdx][colIdx] != 1) count++;

            if (rowIdx<targetRow +1 && colIdx < targetCol + 1 && paths[rowIdx][colIdx] != 1){
                //1.move down
                if (rowIdx < targetRow + 1) {
                    s.add(new Pair<>(rowIdx + 1, colIdx));
                    q.offer(new Pair<>(rowIdx + 1, colIdx));
                }
                //2.move right side.
                if (colIdx < targetCol + 1) {
                    s.add(new Pair<>(rowIdx, colIdx + 1));
                    q.offer(new Pair<>(rowIdx, colIdx + 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] paths = {{0, 0}, {0, 1,}};
        System.out.println("countPaths(paths, 0, 0) = " + countPaths(paths, 0, 0));
    }
}
