package DynamicProgramming.LCSPattern;

public class ShortestCommonSupersequence {
    private static int shortestCommonSuperSequence(String s1, int i, String s2, int j) {
        if (i == 0 || j == 0) {
            return Math.max(i, j);
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // this will generate lcs.
            return 1 + shortestCommonSuperSequence(s1, i - 1, s2, j - 1);
        }
        int a = shortestCommonSuperSequence(s1, i - 1, s2, j);
        int b = shortestCommonSuperSequence(s1, i, s2, j - 1);
        return Math.min(a, b) + 1;
    }


    private static int getPowerfulNumber(int n) {
        if(n <= 3)  return 1 << n;
        int modOfN = n % 6;
        switch (modOfN){
            case 0: return 1;
            case 1: return 2;
            case 2: return 4;
            case 3: return 8;
            case 4: return 7;
            case 5: return 5;
        }
        return -1;
    }


    public static void main(String[] args) {
//        String a = "aaaa", b = "aaa";
        System.out.println("getPowerfulNumber(3) = " + getPowerfulNumber(3));
    }
}
