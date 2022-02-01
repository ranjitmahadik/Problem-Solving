package Stack;

import java.util.Stack;

public class NearestGreaterToLeft {
    private static void nearestGreaterToLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            int currElement = arr[i];
            while (!st.isEmpty() && currElement >= st.peek()) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(currElement);
        }

        for (int i : ans) System.out.print(i + " ");
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        nearestGreaterToLeft(arr);
    }
}
