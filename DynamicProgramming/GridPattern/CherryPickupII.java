package DynamicProgramming.GridPattern;

public class CherryPickupII {

    private static int[] dy = {-1, 0, 1};

    private static int maxCherries(int[][] mat, int n, int m, int r, int c1, int c2) {
        if (r == n) return 0;


        int ans = 0;
        for (int i = 0; i < dy.length; i++) {
            for (int j = 0; j < dy.length; j++) {
                int newC1 = c1 + dy[i];
                int newC2 = c2 + dy[j];
                if (newC1 >= 0 && newC1 < m && newC2 < m && newC2 >= 0) {
                    ans = Math.max(ans, maxCherries(mat, n, m, r + 1, newC1, newC2));
                }
            }
        }

        int cherryPick = c1 == c2 ? mat[r][c1] : mat[r][c1] + mat[r][c2];

        return ans + cherryPick;
    }


    public static void main(String[] args) {
//        int[][] mat = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
//        System.out.println(maxCherries(mat, 4, 3, 0, 0, 2));


    }


}
