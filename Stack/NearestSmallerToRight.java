package Stack;

import java.util.Stack;

public class NearestSmallerToRight {
    private static void nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);
        ans[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            int currElement = arr[i];
            while (!st.isEmpty() && st.peek() >= currElement) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(currElement);
        }

        for (int i : ans) System.out.print(i + " ");

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        nearestSmallerToRight(arr);
    }
}
