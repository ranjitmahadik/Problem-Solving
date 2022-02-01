package Graph;

import util.Pair;

import java.util.*;

//LC-490
public class TheMaze {

    private static boolean hasPath(int[][] mat, Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        vis[start.getFirst()][start.getSecond()] = true;
        q.add(start);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int row = q.peek().getFirst();
            int col = q.peek().getSecond();
            q.poll();

            if (row == end.getFirst() && col == end.getSecond()) return true;

            for (int i = 0; i < dirs.length; i++) {
                int newX = row;
                int newY = col;

                while (newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] == 0) {
                    newX += dirs[i][0];
                    newY += dirs[i][1];
                }
                newX -= dirs[i][0];
                newY -= dirs[i][1];
                if (!vis[newX][newY]) {
                    q.add(new Pair<>(newX, newY));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] mat = {
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        };
//        Pair<Integer, Integer> start = new Pair<>(0, 4);
//        Pair<Integer, Integer> end = new Pair<>(3, 2);
//        System.out.println("hasPath(mat, start, end) = " + hasPath(mat, start, end));

    }
}
