package Recursion.RecursionTreeMethod;

public class PermutationWithCaseChange {
    private static void generatePermutationWithCaseChange(String s, int idx, String output) {
        if (idx >= s.length()) {
            System.out.println(output + " ");
            return;
        }

        generatePermutationWithCaseChange(s, idx + 1, output + s.charAt(idx));
        generatePermutationWithCaseChange(s, idx + 1, output + (char)(s.charAt(idx) - 32));

    }

    /**
     * 97                       97 - x = 65
     * 32                       97 - 65 = x
     * ----                         32 = x
     * 65
     */

    public static void main(String[] args) {
        generatePermutationWithCaseChange("ab", 0, "");
    }
}
