package BinarySearch;


public class NthMagicalNumber {
    /**
     * if you have to tell how many numbers less than X are divisible N then you do X/N to calculate.
     * eg. if  10/2 = 5 {2,4,6,8,10};
     * <p>
     * <p>
     * eg. X = 25 N1 = 3 N2 = 4
     * X/N1 = (25/3) => 8 {3,6,9,12,15,18,21,24};
     * X/N2 = (25/4) => 6 {4,8,12,16,20,24}
     * <p>
     * if we add those then 8 + 6 = 14 but number 12 and 24 repeated twice.
     * ans these are multiples of LCM(3,4) so we need to subtract common multiples.
     * <p>
     * X/N1 + X/N2 - X/LCM(N1,N2)
     * 8    +   6  -  2      => 12.
     *
     * 1st magical number  => min(a,b)
     * 2nd magical number  => 2 * min(a,b)
     * 3rd magical number  => 3 * min(a,b)
     *
     * nth magical number  => n * min(a,b)
     *
     */

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private static long findNthMagicalNumber(int n, int a, int b) {
        long A = a, B = b, N = n;
        long lcm = (A * B) / gcd(A, B);

        long lo = Math.min(A, B);
        long hi = Math.min(A, B) * N;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long possibleAns = (mid / A) + (mid / B) - (mid / lcm);
            if (possibleAns < N) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (hi + 1);
    }

    public static void main(String[] args) {
        System.out.println("findNthMagicalNumber(1,2,3) = " + findNthMagicalNumber(4, 2, 3));
    }
}
