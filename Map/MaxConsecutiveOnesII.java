package Map;

import javax.swing.*;

public class MaxConsecutiveOnesII {


    private static int ans = 0;

    private static int countMaxOne(int[] arr, int i, int skip, int count) {
        ans = Math.max(ans, count);
        if (i >= arr.length) {
            return count;
        }

        int opt1 = 0, opt2 = 0;
        if (arr[i] == 0) {
            opt2 = countMaxOne(arr, i + 1, skip, 0);
            if (skip > 0) opt1 = countMaxOne(arr, i + 1, skip - 1, count + 1);
        } else {
            opt2 = countMaxOne(arr, i + 1, skip, count + 1);
        }

        return Math.max(opt1, opt2);
    }

    private static int countMaxOnes(int[] arr) {
        int i = 0, j = 0, maxOnes = 0, zeros = 0;
        final int maxZeros = 1;

        while (j < arr.length) {
            if (arr[j] == 0) zeros++;
            while (zeros > maxZeros) {
                if (arr[i] == 0) zeros--;
                i++;
            }
            maxOnes = Math.max(maxOnes, j - i + 1);
            j++;
        }

        return maxOnes;
    }

    private static int countMaxNumberOfOne(int[] arr) {
        int i = 0, j = 0, maxOne = 0, zeros = 0;
        final int MAX_ZEROS_ALLOWED = 1;
        while (j < arr.length) {
            if (arr[j] == 0) {
                zeros++;
            }
            while (zeros > MAX_ZEROS_ALLOWED) {
                if (arr[i] == 0) zeros--;
                i++;
            }
            maxOne = Math.max(maxOne, j - i + 1);
            j++;
        }
        return maxOne;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0};
//        System.out.println(countMaxOne(arr, 0, 1, 0));
//        System.out.println(ans);
        System.out.println(countMaxNumberOfOne(arr));
    }

}
