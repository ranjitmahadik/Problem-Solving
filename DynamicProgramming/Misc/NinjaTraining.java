package DynamicProgramming.Misc;

public class NinjaTraining {
    // days * 3; => days;
    private static int maxPoints(int[][] arr, int day, int prevTaken) {
        if (day < 0) return 0;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            if (i == prevTaken) continue;
            ans = Math.max(ans, arr[day][i] + maxPoints(arr, day - 1, i));
        }

        return ans;
    }

//    private static int maxPointBottomUp(int[][] arr) {
//        int days = arr.length;
//        int skills = arr[0].length;
//        int[][] dp = new int[days + 1][skills + 1];
//    }
//



    public static void main(String[] args) {
        int[][] arr = {{10, 50, 1}, {5, 100, 11}};
        System.out.println(maxPoints(arr, 1, -1));
    }
}
