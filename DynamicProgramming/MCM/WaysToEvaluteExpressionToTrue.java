package DynamicProgramming.MCM;

public class WaysToEvaluteExpressionToTrue {
    private static int numWays(String s, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        else if (i == j) {
            if (isTrue) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }
        int ans = 0;
        for (int k = i + 1; k < j; k++) {
            int lTrue = numWays(s, i, k - 1, true);
            int lFalse = numWays(s, i, k - 1, false);
            int rTrue = numWays(s, k + 1, j, true);
            int rFalse = numWays(s, k + 1, j, false);
            int temp = 0;
            switch (s.charAt(k)) {
                case '|':
                    if (isTrue) {
                        temp = (lTrue * rTrue) + (lTrue * rFalse) + (rTrue * lFalse);
                    } else {
                        temp = (lFalse * rFalse);
                    }
                    break;
                case '&':
                    if (isTrue) {
                        temp = (lTrue * rTrue);
                    } else {
                        temp = (lTrue * rFalse) + (rTrue * lFalse);
                    }
                    break;
                case '^':
                    if (isTrue) {
                        temp = (lTrue * rFalse) + (rTrue * lFalse);
                    } else {
                        temp = (lFalse & rFalse) + (rTrue * lTrue);
                    }
                    break;
            }
            ans += temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "T|F&T";
        System.out.println(numWays(s, 0, s.length() - 1, true));
    }
}
