package Stack;

import java.util.Stack;

public class NearestGreaterToRight {
    private static void nearestGreaterToRightBruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxElement = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxElement = arr[j];
                    break;
                }
            }
            System.out.print(maxElement + " ");
        }
    }

    private static void nearestGreaterToRightOptimal(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            int currElement = arr[i];
            while (!st.isEmpty() && currElement >= st.peek()) st.pop();
            System.out.print(st.isEmpty() ? -1 + " " : st.peek() + " ");
            st.push(currElement);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,3,0,0,1,2,4};
        nearestGreaterToRightBruteForce(arr);
        System.out.println();
        nearestGreaterToRightOptimal(arr);
    }
}
