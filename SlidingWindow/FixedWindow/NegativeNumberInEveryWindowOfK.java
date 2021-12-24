package SlidingWindow.FixedWindow;

import java.util.Deque;
import java.util.LinkedList;

public class NegativeNumberInEveryWindowOfK {
    private static void printNegativeNumber(int[] arr, int windowSize) {
        int i = 0, j = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (j < arr.length) {
            if (arr[j] < 0) deque.offer(arr[j]);

            int currentWindowLength = j - i + 1;
            if (currentWindowLength < windowSize) {
                j++;
            } else if (currentWindowLength == windowSize) {
                System.out.println(deque.isEmpty() ? 0 : deque.peek());
                if (!deque.isEmpty() && arr[i] == deque.peek()) {
                    deque.pop();
                }
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 13, 28};
        int k = 3;
        printNegativeNumber(arr, k);
    }
}
