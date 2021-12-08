package Recursion.InductionBaseHypothesis;

public class Powerset {

    private static void generatePowerset(String s, int idx, String generateSubset) {
        if (idx >= s.length()) {
            System.out.print(generateSubset + " ");
            return;
        }

        generatePowerset(s, idx + 1, generateSubset + s.charAt(idx));
        generatePowerset(s, idx + 1, generateSubset);
    }


    public static void main(String[] args) {
        generatePowerset("abc", 0, "");
    }
}

/***
 *              "ab"
 *        a             ""         i=1
 *  ab      a        b       ""       i=2
 *
 *
 *  1,7,8,9
 *
 * */
