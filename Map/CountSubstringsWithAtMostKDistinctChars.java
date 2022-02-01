package Map;

public class CountSubstringsWithAtMostKDistinctChars {
    private static int countAtMostKDistinctChars(String s, final int K) {
        int i = 0, j = 0, ans = 0, distinctChars = 0;
        int[] charCount = new int[26];
        while (j < s.length()) {
            char currChar = s.charAt(j);
            charCount[currChar - 'a']++;
            if (charCount[currChar - 'a'] == 1) distinctChars++;

            while (distinctChars > K) {
                char firstChar = s.charAt(i);
                charCount[firstChar - 'a']--;
                if (charCount[firstChar - 'a'] == 0) distinctChars--;
                i++;
            }
            j++;
            ans += j - i;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcbcdbca";
        int K = 2;
        System.out.println(countAtMostKDistinctChars(s, K));
    }
}
