package DynamicProgramming.LCSPattern;

public class EditDistance {
    private static int minOperations(String s1, int i, String s2, int j) {
        if (i == 0 || j == 0) return Math.max(i, j);
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            //1 if both chars are same then we don't need to change anything.
            return minOperations(s1, i - 1, s2, j - 1);
        }
        int replaced = minOperations(s1, i - 1, s2, j - 1);
        int inserted = minOperations(s1, i, s2, j - 1);
        int deleted = minOperations(s1, i - 1, s2, j);

        return 1 + Math.min(Math.min(replaced, inserted), deleted);
    }

    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";

        System.out.println("minOperations(a,a.length(),b,b.length()) = " + minOperations(a, a.length(), b, b.length()));
    }
}
