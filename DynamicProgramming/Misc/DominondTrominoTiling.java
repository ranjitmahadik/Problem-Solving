package DynamicProgramming.Misc;

public class DominondTrominoTiling {
    private static int numTilings(int n) {
        if (n <= 1) return n;
        else if (n == 2) return 2;
        else if (n == 3) return 5;

        int twoFaceTile = numTilings(n - 2);
        int threeFaceTile = numTilings(n - 3);
        return twoFaceTile + threeFaceTile;
    }
}
