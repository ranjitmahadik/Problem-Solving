package Stack;

import java.util.Stack;

public class StockSpan {

    /**
     * for(int i=0;i<n;i++){
     * int count = 1;
     * for(int j=0;j<i;j++){
     * if(arr[j] <= arr[i])    count++;
     * }
     * cout<<count<<" ";
     * }
     */
    private static void stockSpan(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        ans[0] = 1;
        st.push(0);
        for (int i = 1; i < n; i++) {
            int currElement = arr[i];
            while (!st.isEmpty() && arr[st.peek()] <= currElement) st.pop();
            ans[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        for (int i : ans) System.out.print(i + " ");

    }

    public static void main(String[] args) {
        //            0   1   2   3   4   5   6
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int n = arr.length;
        stockSpan(arr, n);
    }
}
