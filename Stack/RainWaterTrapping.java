package Stack;

public class RainWaterTrapping {
    private static int[] maxFromLeft(int[] arr, int n) {
        int[] ans = new int[n];
        ans[0] = arr[0];
        for (int i = 1; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], arr[i]);
        }
        return ans;
    }

    private static int[] maxFromRight(int[] arr, int n) {
        int[] ans = new int[n];
        ans[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], arr[i]);
        }
        return ans;
    }

    private static int rainWaterTrapping(int[] arr) {
        int n = arr.length;
        int[] left = maxFromLeft(arr, n);
        int[] right = maxFromRight(arr, n);
        int[] actual = new int[n];
        for (int i = 0; i < n; i++) {
            actual[i] = Math.min(left[i], right[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (actual[i] - arr[i]);
        }
        return sum;
    }

    /***
     *          5_______9
     *
     * */
    private static int rainWaterTrappingOptimal(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;
        while (lo < hi) {
            if (arr[lo] < arr[hi]) {
                if (leftMax >= arr[lo]) {
                    sum += leftMax - arr[lo];
                } else {
                    leftMax = Math.max(leftMax, arr[lo]);
                }
                lo++;
            } else {
                if (rightMax >= arr[hi]) {
                    sum += rightMax - arr[hi];
                } else {
                    rightMax = Math.max(rightMax, arr[hi]);
                }
                hi--;
            }
        }
        return sum;
    }

    private static int rainWaterTrappingMostOptimal(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (leftMax >= arr[lo]) {
                    ans += (leftMax - arr[lo]);
                }
                leftMax = Math.max(leftMax, arr[lo]);
                lo++;
            } else {
                if (rightMax >= arr[hi]) {
                    ans += (rightMax - arr[hi]);
                }
                rightMax = Math.max(rightMax, arr[hi]);
                hi--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(rainWaterTrapping(arr));
        System.out.println(rainWaterTrappingOptimal(arr));
    }
}
