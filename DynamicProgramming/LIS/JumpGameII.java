package DynamicProgramming.LIS;

import java.util.Arrays;

public class JumpGameII {

    private static int minJumps(int[] arr, int idx) {
        if (idx >= arr.length - 1) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= arr[idx]; i++) {
            int jumpIdx = i + idx;
            int temp = minJumps(arr, jumpIdx);
            if (temp == ans) continue;   // it means it's not possible to reach last index using i + idx;
            ans = Math.min(ans, temp + 1);
        }
        return ans;
    }

    private static int[] dp;

    private static int minJumpsMemo(int[] arr, int idx) {
        if (idx >= arr.length - 1) return 0;
        else if (dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE - 1;

        for (int i = 1; i <= arr[idx]; i++) {
            int temp = 1 + minJumpsMemo(arr, i + idx);
            ans = Math.min(ans, temp);
        }
        return dp[idx] = ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};

        int ans1 = minJumps(arr, 0);
        dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        int ans2 = minJumpsMemo(arr, 0);

        System.out.println(ans1 + " : " + ans2);
    }
}
