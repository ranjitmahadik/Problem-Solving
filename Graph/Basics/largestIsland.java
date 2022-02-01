package Graph.Basics;

public class largestIsland {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    /**
     * left = row,col++
     * right = row,col--
     * up = row-1,col
     * down= row+1,col
     */

    private static int dfs(int[][] graph, int row, int col, int n, int m, boolean[][] vis) {
        int area = 1;
        vis[row][col] = true;
        for (int i = 0; i < dx.length; i++) {

            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol] && graph[newRow][newCol] == 1) {
                area += dfs(graph, newRow, newCol, n, m, vis);
            }
        }

        return area;
    }

    private static void maxArea(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !vis[i][j]) {
                    int largestArea = dfs(graph, i, j, n, m, vis);
                    ans = Math.max(largestArea, ans);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        maxArea(graph);
    }
}
