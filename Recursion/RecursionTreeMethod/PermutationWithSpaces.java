package Recursion.RecursionTreeMethod;

public class PermutationWithSpaces {
    private static void generatePermutationWithSpaces(String s, int idx, String output) {
        if (idx >= s.length()) {
            System.out.println(output + " ");
            return;
        }

        generatePermutationWithSpaces(s, idx + 1, output + "_" + s.charAt(idx));
        generatePermutationWithSpaces(s, idx + 1, output + s.charAt(idx));
    }

    public static void main(String[] args) {
        generatePermutationWithSpaces("ABC", 1, "A");
    }
}
