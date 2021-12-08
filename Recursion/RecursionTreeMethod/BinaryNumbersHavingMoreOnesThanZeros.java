package Recursion.RecursionTreeMethod;

public class BinaryNumbersHavingMoreOnesThanZeros {

    private static void generateBinaryNumberHavingMoreOnesThanZeros(int n, int zerosAllowed, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }

        generateBinaryNumberHavingMoreOnesThanZeros(n - 1, zerosAllowed, output + '1');
        if (zerosAllowed > 0)
            generateBinaryNumberHavingMoreOnesThanZeros(n - 1, zerosAllowed - 1, output + '0');
    }

    public static void main(String[] args) {
        int n = 3;
        int zerosAllowed = n / 2;
        generateBinaryNumberHavingMoreOnesThanZeros(n, zerosAllowed, "");
    }
}
/**
 * ___
 * 101
 * 110
 * 011
 * 111
 */
