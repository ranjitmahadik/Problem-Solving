package Stack;

import java.util.Stack;

public class NearestSmallerToLeft {
    private static void nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        ans[0] = -1;
        for (int i = 1; i < n; i++) {
            int currElement = arr[i];
            while (!st.isEmpty() && st.peek() >= currElement) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(currElement);
        }

        for (int i : ans) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        nearestSmallerToLeft(arr);
    }
}
