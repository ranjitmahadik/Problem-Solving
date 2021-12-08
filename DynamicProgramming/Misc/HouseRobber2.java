package DynamicProgramming.Misc;

import java.util.Arrays;

public class HouseRobber2 {
    private static int houseRobber(int[] arr, int idx, int endPoint) {
        if (idx >= endPoint) return 0;

        int robb = arr[idx] + houseRobber(arr, idx + 2, endPoint);
        int notRobb = houseRobber(arr, idx + 1, endPoint);


        return Math.max(robb, notRobb);
    }

    private int[][] dp;
    private int houseRobberMemo(int[] arr, int idx, int endPoint) {
        if (idx >= endPoint) return 0;
        else if(dp[idx][arr.length - endPoint] != -1)   return dp[idx][arr.length - endPoint];


        int robb = arr[idx] + houseRobberMemo(arr, idx + 2, endPoint);
        int notRobb = houseRobberMemo(arr, idx + 1, endPoint);


        return dp[idx][arr.length - endPoint] = Math.max(robb, notRobb);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];

        dp = new int[nums.length+1][2];
        for(int[] dpArr : dp){
            Arrays.fill(dpArr,-1);
        }
        int ans1 = houseRobberMemo(nums,0,nums.length-1);
        int ans2 = houseRobberMemo(nums,1,nums.length);
        return Math.max(ans1,ans2);
    }

}
