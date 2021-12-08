package Recursion.RecursionTreeMethod;

public class LetterCasePermutation {

    private static void generateLetterCasePermutation(String s, int idx, String output) {
        if (idx >= s.length()) {
            System.out.print(output + " ");
            return;
        }

        char currentChar = s.charAt(idx);
        if (currentChar >= '0' && currentChar <= '9') {
            generateLetterCasePermutation(s, idx + 1, output + currentChar);
        } else {
            String currentCharStr = String.valueOf(currentChar);
            generateLetterCasePermutation(s, idx + 1, output + currentCharStr.toLowerCase());
            generateLetterCasePermutation(s, idx + 1, output + currentCharStr.toUpperCase());
        }
    }

    public static void main(String[] args) {
        generateLetterCasePermutation("a1b", 0, "");
    }
}
