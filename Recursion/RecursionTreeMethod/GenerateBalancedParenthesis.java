package Recursion.RecursionTreeMethod;

public class GenerateBalancedParenthesis {

    private static void generateParenthesis(int openCount, int closeCount, String validOutput) {
        if (openCount == 0 && closeCount == 0) {
            System.out.print(validOutput + " ");
            return;
        }

        if (openCount > 0) {
            generateParenthesis(openCount - 1, closeCount, validOutput + "(");
        }
        if (openCount < closeCount) {
            generateParenthesis(openCount, closeCount - 1, validOutput + ")");
        }
    }

    public static void main(String[] args) {
        generateParenthesis(1, 2, "(");
    }
}
