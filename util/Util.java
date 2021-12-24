package util;

public class Util {
    public static int convertBoolToInt(boolean isTrue) {
        return isTrue == true ? 1 : 0;
    }


    public static int getMax(int... arr) {
        int ans = 0;
        for (int i : arr) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public static double getMax(double... arr) {
        double ans = 0;
        for (double i : arr) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    public static void showTable(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
