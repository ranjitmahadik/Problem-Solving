package Recursion.InductionBaseHypothesis;

public class TowerOfHonoi {

    private static void towerOfHonoi(int source, int helper, int destination, int plates) {
        if (plates == 1) {
            System.out.println("Moving plate " + plates + " from " + getSource(source) + " to " + getSource(destination));
            return;
        }

        towerOfHonoi(source, destination, helper, plates - 1);
        System.out.println("Moving plate " + plates + " from " + getSource(source) + " to " + getSource(destination));
        towerOfHonoi(helper, source, destination, plates - 1);

    }

    private static String getSource(int source) {
        switch (source){
            case 1: return "Source";
            case 2: return "Helper";
            default:    return "Destination";
        }
    }

    public static void main(String[] args) {
        towerOfHonoi(1, 2, 3, 3);
    }
}

/**
 *
 *
 *      =
 *     ===
 *    =====                      ===       =
 *
 * */
