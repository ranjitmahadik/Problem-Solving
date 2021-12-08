package LinkedList;

public class MiddleOfLinkedList {
    /**
     * 1.count all nodes then return Math.ceil(n/2)'th node.
     */

    /**
     * 1    2    3    4    5
     * 1 => 2 => 3 => 4 => 5            5/2 => 2
     */
    private static int mid = -1;
    private static ListNode targetNode;

    private static void getMiddle(ListNode root, int count) {
        if (root.next == null) {
            // we have all node count
            mid = (int) Math.ceil((double) count / 2);
            if (count % 2 == 0) mid++;
            if (mid == count) {
                targetNode = root;
            }
            return;
        }
        getMiddle(root.next, count + 1);
        if (mid == count) {
            targetNode = root;
        }
    }

    /**
     * 7/2 => 3
     *
     *      *              *
     * 1 => 2 => 3 => 4 => 5 => 6
     *
     */
    private static ListNode optimalSolution(ListNode root) {
        ListNode slowPtr, fastPtr;
        slowPtr = fastPtr = root;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.getOddLengthList();
        getMiddle(root, 1);
        System.out.println(targetNode);
    }
}

