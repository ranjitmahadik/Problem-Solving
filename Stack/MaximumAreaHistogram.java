package Stack;

import java.util.Stack;

public class MaximumAreaHistogram {

    private static int[] nearestSmallerToLeft(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ans[0] = -1;
        for (int i = 1; i < n; i++) {
            int currElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= currElement) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    private static int[] nearestSmallerToRight(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[n - 1] = n;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int currElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= currElement) st.pop();
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    private static void show(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    private static int maxAreaHistogram(int[] arr, int n) {
        int[] left = nearestSmallerToLeft(arr, n);
        int[] right = nearestSmallerToRight(arr, n);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int leftItem = left[i];
            int rightItem = right[i];
            int blockWidth = rightItem - leftItem - 1;
            maxArea = Math.max(maxArea, blockWidth * arr[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        System.out.println(maxAreaHistogram(arr, n));
    }
}
