package DynamicProgramming.UnBoundedKnapsackPattern;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * similar to min coins required to make x sum.
 */
public class PerfectSquares {

    private static int getNumberCount(int n) {
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE - 1;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + getNumberCount(n - i * i));
        }
        return ans;
    }

    private static int getNumberCount(int n, int currentNumber) {
        if (n == 0) return 0;
        else if (currentNumber * currentNumber > n) return Integer.MAX_VALUE - 1;

        int doNotChange = Integer.MAX_VALUE - 1;
        if (currentNumber * currentNumber <= n) {
            doNotChange = 1 + getNumberCount(n - currentNumber * currentNumber, currentNumber);
        }
        int change = getNumberCount(n, currentNumber + 1);

        return Math.min(change, doNotChange);
    }


    private static int numberCountBFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                int val = q.poll();
                for (int i = 1; i * i <= val; i++) {
                    if (i * i <= val) {
                        q.offer((val - (i * i)));
                    }
                }
            }
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println(getNumberCount(54) + " " + getNumberCount(54, 1));
    }
}
