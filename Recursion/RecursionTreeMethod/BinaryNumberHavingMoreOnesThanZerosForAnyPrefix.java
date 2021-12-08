package Recursion.RecursionTreeMethod;

public class BinaryNumberHavingMoreOnesThanZerosForAnyPrefix {

    private static void generateBinaryNumbersHavingMoreOnesThanZerosForAnyPrefix(int n, int oneCount, int zeroCount, String output) {
        if (n == 0) {
            System.out.println(output);
            return;
        }

        generateBinaryNumbersHavingMoreOnesThanZerosForAnyPrefix(n - 1, oneCount + 1, zeroCount, output + '1');
        if (zeroCount < oneCount)
            generateBinaryNumbersHavingMoreOnesThanZerosForAnyPrefix(n - 1, oneCount, zeroCount + 1, output + '0');
    }

    public static void main(String[] args) {
        generateBinaryNumbersHavingMoreOnesThanZerosForAnyPrefix(2, 1, 0, "1");
    }
}
